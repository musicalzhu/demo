import niu.market.activity.FirstFollowActivity;
import niu.market.activity.FirstProjectActivity;
import niu.market.coupon.CashCoupon;
import niu.market.coupon.Coupon;
import niu.platform.Platform;
import niu.platform.ProjectTradeCycle;
import niu.product.ProductType;
import niu.project.Project;
import niu.user.Mom;
import niu.user.NormalUser;
import niu.user.SysUser;
import niu.user.User;

/**
 * @author Tom
 * 模拟业务场景
 */
public class PlatformTest {

	public static void main(String[] args) {
		//获得平台对象
		Platform platform = Platform.getInstance();

		//普通用户，只能进行投资
		User userA = new NormalUser("用户A");
		User userB = new NormalUser("用户B");
		User userC = new NormalUser("用户C");

		//赠送用户优惠券
		Coupon couponA = new CashCoupon(10);
		userA.addCoupon(couponA);

		//系统用户，充当平台水军，和普通用户类似，但无法提现
		User sysUserAAA = new SysUser("SYS用户AAA");

		//操盘手，拥有普通用户所有行为，还可以作为操盘手开立项目和操盘
		Mom momA = new Mom("牛菲特");
		Mom momB = new Mom("音乐风");

		//平台给操盘手授信后，操盘手就可以针对授信过的产品开立项目，进而进行操盘资金的募集和后续操作
		platform.credit(momA);
		platform.credit(momB);
		
		//用户关注某位操盘手
		userA.follow(momA);
		userB.follow(momA);

		//操盘手发布项目，申请募集资金
		Project project01 = momA.applyProject(
				ProductType.robust,
				"牛菲特1号", 
				10,
				ProjectTradeCycle.t20, 
				0.2, 
				0.1, 
				0.5, 
				"牛刀小试");

        //用户新手活动
        FirstProjectActivity firstProjectActivity = new FirstProjectActivity(momA, project01);
        firstProjectActivity.execute();

		//用户关注操盘手的某个项目
		userC.follow(project01);

        //用户新手活动
        FirstFollowActivity firstFollowActivity = new FirstFollowActivity(userC,project01);
        firstFollowActivity.execute();

		//项目审核通过后，可以开始在平台上募集资金
		project01.audit();

		//餐盘手可以自己投资自己的项目
		momA.buy(project01, 10);

		//用户投资，使用了优惠券，投资成功
		userA.buy(project01, 10, couponA);

		//用户投资，投资成功
		userB.buy(project01, 100);

		//用户投资，超出项目的上限额度，投资失败
		userC.buy(project01, 200);

		//省略一系列用户交易行为

		//改变项目状态为 结算期间停牌中 状态，开始项目部分结算
		project01.setState(project01.getDelistingRepaymentState());
		//设置项目可结算现金
		project01.setProjectCashAmount(50);
		//项目部分结算
		project01.settlement();

		//改变项目状态为 操盘结束等待结算中 状态，开始项目结算
		project01.setState(project01.getSettlingState());
		//设置项目可结算现金
		project01.setProjectCashAmount(200);
		//项目全部结算
		project01.settlement();

		//新项目
		Project project02 = momB.applyProject(
				ProductType.robust,
				"音乐风1号", 
				10,
				ProjectTradeCycle.t20,
				0.2, 
				0.1, 
				0.5, 
				"");
		
		//用户关注该项目
		userC.follow(project02);

		//项目状态变化，广播关注该项目的用户
		project02.audit();

		
		//普通用户可以提现
		NormalUser normalUserA = (NormalUser)userA;
		normalUserA.withdraw();

        /*
		//系统用户强制转换也无法提现
		try {
            NormalUser normalUserAAA = (NormalUser) sysUserAAA;
            normalUserAAA.withdraw();
        }
        finally {
            // TODO
        }*/

    }
}
