package niu.user; /***********************************************************************
 * Module:  niu.user.User.java
 * Author:  Tom
 * Purpose: Defines the Class niu.user.User
 ***********************************************************************/

import niu.common.DisplayFollow;
import niu.common.Observer;
import niu.common.Subject;
import niu.contract.Contract;
import niu.market.Coupon;
import niu.market.Privilege;
import niu.market.grade.GoldGrade;
import niu.market.grade.Grade;
import niu.market.grade.PlatnumGrade;
import niu.market.grade.SiverGrade;
import niu.platform.MOMApplyDocument;
import niu.platform.Platform;
import niu.project.Project;
import niu.project.ProjectActivityType;


/** @pdOid 57baf3cb-5b68-4f55-917a-758d98c53a63 */
public abstract class User implements Observer, DisplayFollow {

   protected Platform platform;

    private Grade gradeState;
    private static SiverGrade siverGradeState;
    private static GoldGrade goldGradeState;
    private static PlatnumGrade platnumGradeState;

   public User(String userName) {
		super();
		// TODO Auto-generated constructor stub
		this.userName = userName;
        platform = Platform.getInstance();
       siverGradeState = new SiverGrade();
       goldGradeState = new GoldGrade();
       platnumGradeState = new PlatnumGrade();

       //用户创建后默认等级
       gradeState = siverGradeState;
	}
   
   public void follow(Subject subject) {
	   subject.registerObserver(this);
      if (subject instanceof Mom) {
         Mom mOM = (Mom)subject;
         System.out.println(this.userName + "关注股神" + mOM.getmOMName());
      }
      if (subject instanceof Project) {
         Project project = (Project)subject;
         System.out.println(this.userName + "关注项目" + project.getProjectName());
      }
	}  
   
	public void update(Subject subject,Object arg) {
		display(subject,arg);
	}

	@Override
	public void display(Subject subject, Object arg) {
		// TODO Auto-generated method stub
		if (subject instanceof Mom) {
			Mom mOM = (Mom)subject;
            String momActivityDescription =(String) arg;
			System.out.println(this.userName + "关注股神" + mOM.getmOMName() + ", 发生了事件：" + momActivityDescription);
		}
		if (subject instanceof Project) {
			Project project = (Project)subject;
            String projectActivityDescription =(String) arg;
			System.out.println(this.userName + "关注项目" + project.getProjectName()+ ", 发生了事件：" + projectActivityDescription);
		}
	}

/** 用户编号
    * 
    * @pdOid 47dcfaaf-2019-43d3-b1eb-f567ee1c9520 */
   private long userID;
   /** 用户名称
    * 
    * @pdOid fdf52c63-814f-4cdd-ac0a-3784f87f6ac1 */
   private java.lang.String userName;
   public java.lang.String getUserName() {
	return userName;
}

public void setUserName(java.lang.String userName) {
	this.userName = userName;
}

/** 用户昵称：目前只支持修改一次
    * 
    * @pdOid 421d6944-6ef2-4a4f-89f0-3c7e7ae9fb57 */
   private java.lang.String userNickname;
   /** 真实姓名
    * 
    * @pdOid 896892c8-7638-4ef5-8c5a-a2ea8dfe4a7f */
   private java.lang.String realName;
   /** 身份证号码
    * 
    * @pdOid 838f0013-c40f-4825-bad9-59e3cdaafb8b */
   private java.lang.String iDCardNumber;
   /** 电话号码
    * 
    * @pdOid b25d705c-b008-41b1-96ae-7d848b6552d3 */
   private java.lang.String telephoneNumber;
   /** @pdOid e49feca4-b8b6-4006-9bc3-ec39d18ff050 */
   private UserType userType;
   /** @pdOid b9e31f33-6257-426a-86c9-d79606fd2761 */
   private java.lang.String user头像;

   
   /** @pdRoleInfo migr=no name=niu.myContracts.Contract assc=用户合约 coll=java.util.Collection impl=java.util.ArrayList mult=0..* */
   public java.util.Collection<Contract> contract;
   /** @pdRoleInfo migr=no name=niu.platform.MOMApplyDocument assc=ApplyMOM mult=0..1 */
   public MOMApplyDocument mOMApplyDocument;
   /** @pdRoleInfo migr=no name=niu.market.Coupon assc=Association20 mult=0..* */
   public java.util.Collection<Coupon> coupon;
   
   /** 获得用户拥有的合约
    * 
    * @pdOid bffe08e7-d95e-4c46-b7b4-561b90dd3b11 */
   public int getContractList() {
      // TODO: implement
      return 0;
   }
   
   /** 获得用户投资的项目
    * 
    * @pdOid 1e094aff-593d-493d-984b-f64ce66c1a5e */
   public int getProjectList() {
      // TODO: implement
      return 0;
   }
   
   /** 获得用户的资金账户
    * 
    * @pdOid a4370496-fc7f-4a7e-aa4b-01f67ceb5780 */
   public int getAccount() {
      // TODO: implement
      return 0;
   }
   
   
   public void obtainCoupon(Coupon newCoupon){
	   this.coupon.add(newCoupon);
   }
   
   
   /** @pdOid ceb089dd-e187-4627-9ead-b6522c199afd */
   private void useCoupon() {
      // TODO: implement
   }
     
   
   /** 用户投资某一个项目 */
   public Contract buy(Project project, double userInvestmentAmount, Coupon coupon) {
      // TODO: implement
      // 合买前处理逻辑，比如优惠券处理
	   double totalInvestmentAmount = coupon.validate(project, userInvestmentAmount);
      // 委托给项目的合买方法产生合约
      Contract contract = this.buy(project,totalInvestmentAmount);
      // 合买成功后处理逻辑，比如优惠券处理
      contract.addCoupon(coupon);
      return contract;
   }

   /** 用户投资某一个项目 */
   public Contract buy(Project project, double userInvestmentAmount) {
      // TODO: implement
      // 委托给项目的合买方法产生合约
      Contract contract = project.buy(this,userInvestmentAmount);
      return contract;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Contract> getContract() {
      if (contract == null)
         contract = new java.util.ArrayList<Contract>();
      return contract;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorContract() {
      if (contract == null)
         contract = new java.util.ArrayList<Contract>();
      return contract.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newContract */
   public void setContract(java.util.Collection<Contract> newContract) {
      removeAllContract();
      for (java.util.Iterator iter = newContract.iterator(); iter.hasNext();)
         addContract((Contract)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newContract */
   public void addContract(Contract newContract) {
      if (newContract == null)
         return;
      if (this.contract == null)
         this.contract = new java.util.ArrayList<Contract>();
      if (!this.contract.contains(newContract))
      {
         this.contract.add(newContract);
         newContract.setUser(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldContract */
   public void removeContract(Contract oldContract) {
      if (oldContract == null)
         return;
      if (this.contract != null)
         if (this.contract.contains(oldContract))
         {
            this.contract.remove(oldContract);
            oldContract.setUser((User)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllContract() {
      if (contract != null)
      {
         Contract oldContract;
         for (java.util.Iterator iter = getIteratorContract(); iter.hasNext();)
         {
            oldContract = (Contract)iter.next();
            iter.remove();
            oldContract.setUser((User)null);
         }
      }
   }

   
   /** @pdGenerated default getter */
   public java.util.Collection<Coupon> getCoupon() {
      if (coupon == null)
         coupon = new java.util.HashSet<Coupon>();
      return coupon;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCoupon() {
      if (coupon == null)
         coupon = new java.util.HashSet<Coupon>();
      return coupon.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCoupon */
   public void setCoupon(java.util.Collection<Coupon> newCoupon) {
      removeAllCoupon();
      for (java.util.Iterator iter = newCoupon.iterator(); iter.hasNext();)
         addCoupon((Coupon)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCoupon */
   public void addCoupon(Coupon newCoupon) {
      if (newCoupon == null)
         return;
      if (this.coupon == null)
         this.coupon = new java.util.HashSet<Coupon>();
      if (!this.coupon.contains(newCoupon))
      {
         this.coupon.add(newCoupon);
         newCoupon.setUser(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldCoupon */
   public void removeCoupon(Coupon oldCoupon) {
      if (oldCoupon == null)
         return;
      if (this.coupon != null)
         if (this.coupon.contains(oldCoupon))
         {
            this.coupon.remove(oldCoupon);
            oldCoupon.setUser((User)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCoupon() {
      if (coupon != null)
      {
         Coupon oldCoupon;
         for (java.util.Iterator iter = getIteratorCoupon(); iter.hasNext();)
         {
            oldCoupon = (Coupon)iter.next();
            iter.remove();
            oldCoupon.setUser((User)null);
         }
      }
   }

    public User setState(Grade gradeState) {
        this.gradeState = gradeState;
        return this;
    }

    public Grade getState() {
        return gradeState;
    }

   public Grade getSiverGradeState() {
      return siverGradeState;
   }
   public Grade getGoldGradeState() {
      return goldGradeState;
   }
   public Grade getPlatnumGradeState() {
      return platnumGradeState;
   }

    public void promotionValidation()
    {
        gradeState.promotionValidation(this);
    }
    public void privilegeValidation()
    {
        gradeState.privilegeValidation(this);
    }
    public String toString(){return getUserName();}
}