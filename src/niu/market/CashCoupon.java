package niu.market; /**
 * 
 */

import niu.project.Project;


/**
 * @author Tom
 *
 */
public class CashCoupon extends Coupon {

	
	   public CashCoupon(double couponAmount, double lowestAmount) {
		super();
		this.couponAmount = couponAmount;
		this.lowestAmount = lowestAmount;
	}

    public CashCoupon(double couponAmount) {
         this(couponAmount, 1);
    }

	/** 现金券面值 */
	   private double couponAmount;
	   /** 最低本金 */
	   private double lowestAmount;
	   
	/**
	 * 
	 */
	public CashCoupon() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double validate(Project project, double userInvestmentAmount) {
		// TODO Auto-generated method stub
		super.validate(project, userInvestmentAmount);

		if (lowestAmount > userInvestmentAmount ){
			System.out.println("userInvestmentAmount less than lowestAmount!!!");
		}
		return userInvestmentAmount + couponAmount;
	}

	
}
