package niu.market; /***********************************************************************
 * Module:  niu.market.Coupon.java
 * Author:  Tom
 * Purpose: Defines the Class niu.market.Coupon
 ***********************************************************************/

import niu.contract.Contract;
import niu.project.Project;
import niu.user.User;

import java.math.BigDecimal;

/** @pdOid a31f4be3-1865-47c5-b0e9-6e14936c8b92 */
public class Coupon {
   /** @pdOid 58587ac3-d5b9-4416-90d3-c336c58f00f0 */
   private java.lang.Long couponID;
   /** @pdOid 661bd949-8808-47c1-bdf3-35f3c8a09718 */
   private boolean effective;
   /** @pdOid 9a9f893c-9729-4b4f-a502-9b0e919327c8 */
   private java.util.Date 有效DurationBeginTime;
   /** @pdOid a017f245-6053-49bf-8549-a47d013e205d */
   private java.util.Date 有效DurationStopTime;

   
   /** @pdRoleInfo migr=no name=niu.myContracts.Contract assc=Association25 mult=0..1 side=A */
   public Contract contract;
   /** @pdRoleInfo migr=no name=niu.user.User assc=Association20 mult=0..1 side=A */
   public User user;
   
   
   /** @pdGenerated default parent getter */
   public Contract getContract() {
      return contract;
   }
   
   /** @pdGenerated default parent setter
     * @param newContract */
   public void setContract(Contract newContract) {
      if (this.contract == null || !this.contract.equals(newContract))
      {
         if (this.contract != null)
         {
            Contract oldContract = this.contract;
            this.contract = null;
            oldContract.removeCoupon(this);
         }
         if (newContract != null)
         {
            this.contract = newContract;
            this.contract.addCoupon(this);
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
            oldUser.removeCoupon(this);
         }
         if (newUser != null)
         {
            this.user = newUser;
            this.user.addCoupon(this);
         }
      }
   }
   
   
   public double validate(Project project, double userInvestmentAmount) {
	      // TODO: implement
	   return 0;
	   }

}