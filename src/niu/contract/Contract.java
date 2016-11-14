package niu.contract; /***********************************************************************
 * Module:  niu.myContracts.Contract.java
 * Author:  Tom
 * Purpose: Defines the Class niu.myContracts.Contract
 ***********************************************************************/

import niu.project.Project;
import niu.user.User;
import niu.market.Coupon;
import java.math.MathContext;

/** 合约
 * 
 * @pdOid 83d410e3-6aff-46d1-8fda-69ee788bb923 */
public class Contract {
   public Contract(User user,
                   Project project, double contractSubscribeAmount) {
		super();
		this.contractSubscribeAmount = contractSubscribeAmount;
		this.user = user;
		this.project = project;
	}

/** 合约编号
    * 
    * @pdOid 6e1a3d2e-3634-4e42-a015-99e021bfd410 */
   private long contractID;
   /** 合约投资日期
    * 
    * @pdOid fd75b736-5fa9-409a-8f5a-a3c4f9301673 */
   private java.util.Date contractInvestmentDate;
   /** 合约状态编号：投资中|操盘中|停牌中|已还款
    * 
    * @pdOid 28da2121-6a1e-4bf7-9eab-5d39af4146a6 */
   private short contractStatusID;
   /** 合约认购金额:：我的认购
    * 
    * @pdOid 4da0fc77-ae55-4b90-89c4-545ff58c5a34 */
   private double contractSubscribeAmount;
   public double getContractSubscribeAmount() {
	return contractSubscribeAmount;
}

public void setContractSubscribeAmount(
		double contractSubscribeAmount) {
	this.contractSubscribeAmount = contractSubscribeAmount;
}

/** 合约浮动收益金额：计算字段 --- 未扣除股神佣金的浮动收益总额
    * 
    * @pdOid 69ff86db-5726-45a6-8e28-8bfa3f65846a */
   private double contractFloatProfitAmount;
   /** 合约佣金：计算字段 --- 
    * 
    * @pdOid bb779064-27d7-41d0-aee6-63889b75d948 */
   private double contractCommissionAmount;
   
   /** @pdRoleInfo migr=no name=niu.myProjects.Project assc=Reference5 mult=0..1 side=A */
   public Project project;

   /** 合约基础结算
    *
    */
   public void primarySettlement() {
	   MathContext mc = new MathContext(8); // 8 precision
	   
	   //项目待结算金额扣除
	   //用户账户金额增加
	   //合约抵用券、体验金等业务逻辑抵扣处理
	   //合约最低收益保障、最大亏损保障等业务逻辑处理

       //合约的结算水位线
       double primarySettlementWaterMarkPercent = project.getSettlementWaterMarkPercent() > 1 ? 1 : project.getSettlementWaterMarkPercent();

	   System.out.println(user.getUserName() + "合约本金结算..." + this.getContractSubscribeAmount() * primarySettlementWaterMarkPercent);
       //项目可结算金额扣除
       project.setProjectCashAmount(project.getProjectCashAmount() - this.getContractSubscribeAmount() * primarySettlementWaterMarkPercent);
   }

   /** 合约浮动收益结算
    *
    */
   public void profitSettlement() {
      MathContext mc = new MathContext(8); // 8 precision

      if (project.getProjectFloatProfitRate() > 0){
        //投资收益，具体逻辑基于产品定义，目前是保本型逻辑，超过本金的作为收益基础
        System.out.println(user.getUserName() + "投资收益..." + this.getContractSubscribeAmount() * project.getProjectFloatProfitRate());
        //投资收益，具体逻辑基于产品定义，目前是保本型逻辑，超过本金的作为收益基础，餐盘手获得收益的70%佣金
        System.out.println(user.getUserName() +"佣金支出..." + this.getContractSubscribeAmount() * 0.7 * project.getProjectFloatProfitRate());
        //项目可结算金额扣除
        project.setProjectCashAmount(project.getProjectCashAmount() - this.getContractSubscribeAmount() * 0.3 * project.getProjectFloatProfitRate());
      }
   }
   
   /** @pdGenerated default parent getter */
   public Project getProject() {
      return project;
   }
   
   /** @pdGenerated default parent setter
     * @param newProject */
   public void setProject(Project newProject) {
      if (this.project == null || !this.project.equals(newProject))
      {
         if (this.project != null)
         {
            Project oldProject = this.project;
            this.project = null;
            oldProject.removeContract(this);
         }
         if (newProject != null)
         {
            this.project = newProject;
            this.project.addContract(this);
         }
      }
   }
   
   
   /** @pdRoleInfo migr=no name=niu.market.Coupon assc=Association25 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Coupon> coupon;
   /** @pdRoleInfo migr=no name=niu.user.User assc=用户合约 mult=0..1 side=A */
   public User user;
   
   
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
         newCoupon.setContract(this);      
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
            oldCoupon.setContract((Contract)null);
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
            oldCoupon.setContract((Contract)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public User getUser() {
      return user;
   }
   
   /** @pdGenerated default parent setter
     * @param newUser */
   public void setUser(User newUser) {
      if (this.user == null || !this.user.equals(newUser))
      {
         if (this.user != null)
         {
            User oldUser = this.user;
            this.user = null;
            oldUser.removeContract(this);
         }
         if (newUser != null)
         {
            this.user = newUser;
            this.user.addContract(this);
         }
      }
   }

}