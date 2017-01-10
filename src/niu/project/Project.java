package niu.project; /***********************************************************************
 * Module:  niu.myProjects.Project.java
 * Author:  Tom
 * Purpose: Defines the Class niu.myProjects.Project
 ***********************************************************************/

import niu.common.Subject;
import niu.common.Observer;
import niu.contract.Contract;
import niu.platform.PositionDocument;
import niu.platform.ProjectTradeCycle;
import niu.platform.TransactionDocument;
import niu.product.ProductProperties;
import niu.product.ProductType;
import niu.user.Mom;
import niu.user.User;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/** 项目
 * 
 */
public class Project implements Subject {
   public Project(Mom mOM,
            ProductType productType,
            java.lang.String projectName,
            double originatorSubscribedAmount,
            ProjectTradeCycle projectTradeCycle,
            double projectStopLossPercent,
            double projectStopWinPercent,
            double projectCommissionBonusPercent,
            java.lang.String projectBuyDeclaration,
            Map properties
		   ) {
		//super();		
		this.mOM = mOM;
		this.productType = productType;
		this.projectName = projectName;
		this.originatorSubscribedAmount = originatorSubscribedAmount;
		this.projectTradeCycle = projectTradeCycle;
		this.projectStopLossPercent = projectStopLossPercent;
		this.projectStopWinPercent = projectStopWinPercent;
		this.projectCommissionBonusPercent = projectCommissionBonusPercent;
        this.projectBuyDeclaration = projectBuyDeclaration;
        
        this.properties = properties;
		
        applyingState = new ApplyingState();
        collectingState = new CollectingState();
        overringState = new OverringState();
        fullingState = new FullingState();
        investorRepaymentState = new InvestorRepaymentState();
        momRepaymentState = new MomRepaymentState();
        platformRepaymentState = new PlatformRepaymentState();
        delistingRepaymentState = new DelistingState();
        settlingState = new SettlingState();
		
		//项目创建后默认状态是申请中
		state = applyingState;

       //关注该项目的订阅者列表
		observers = new ArrayList<Observer>();
	}
   
    private List<Observer> observers;
   
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers(Object arg) {
		for (Observer observer : observers) {
			observer.update(this, arg);
		}
	}
	
	public void projectChanged(Object arg) {
		notifyObservers(arg);
	}

    private ProjectState state;
	private static ProjectState applyingState;
	private static ProjectState collectingState;
	private static ProjectState overringState;
	private static ProjectState fullingState;
	private static ProjectState investorRepaymentState;
    private static ProjectState momRepaymentState;
    private static ProjectState platformRepaymentState;
    private static ProjectState delistingRepaymentState;
    private static ProjectState settlingState;

    private Map properties;
    
   /** 项目编号
    * 
    */
   private long projectID;

   /** 项目名称
    * 
    */
   private java.lang.String projectName;

   public java.lang.String getProjectName() {
	return projectName;
}

    public void setProjectName(java.lang.String projectName) {
        this.projectName = projectName;
    }

    /** 项目起投金额
     */
   private double projectInitialAmount = 0;

   /** 项目最低认购金额：本次合买的金额区间，若投资达到最低成立金额，股神可随时终止投资，也可以等待合买达到最高成立金额或直至到达投资截止时间自动截止。
    */
   private double projectLowestSubscribeAmount = 0;

   /** 项目最高认购金额：本次合买的金额区间，若投资达到最低成立金额，股神可随时终止投资，也可以等待合买达到最高成立金额或直至到达投资截止时间自动截止。
    */
   private double projectHighestSubscribeAmount = 0;

   public double getProjectHighestSubscribeAmount() {
	//return projectHighestSubscribeAmount;
	return (double) getProperty(ProductProperties.projectFloorAmount);
}

    public void setProjectHighestSubscribeAmount(
            double projectHighestSubscribeAmount) {
        this.projectHighestSubscribeAmount = projectHighestSubscribeAmount;
    }

    /** 项目实际认购金额
    */
   private double projectRealSubscribedAmount = 0;

    public double getProjectRealSubscribedAmount() {
        return projectRealSubscribedAmount;
    }


    public void setProjectRealSubscribedAmount(double projectRealSubscribedAmount) {
        this.projectRealSubscribedAmount = projectRealSubscribedAmount;
    }

   /** 项目认购进度比例：计算字段 --- 基于最低认购金额的百分比
    */
   private double projectSubscribedProgressPercent = 0;

   /** 项目可投金额：计算字段 --- 项目最高认购金额 - 项目实际认购金额
    */
   private double projectAvailableAmount = 0;

    public double getProjectLowestSubscribeAmount() {
        //return projectLowestSubscribeAmount;
        return (double) getProperty(ProductProperties.projectCeilingAmount);
    }

   /** 项目浮动收益率
    */
   private double projectFloatProfitRate = 0;

   public double getProjectFloatProfitRate() {
	   //return projectFloatProfitRate;
	   //return (getProjectAssetsAmount().subtract(getProjectRealSubscribedAmount()).divide(getProjectRealSubscribedAmount(),2, double.ROUND_HALF_EVEN)).doubleValue();
       return (projectAssetsAmount - projectRealSubscribedAmount)/projectRealSubscribedAmount;
}

    public void setProjectFloatProfitRate(double projectFloatProfitRate) {
        this.projectFloatProfitRate = projectFloatProfitRate;
    }

    /** 项目交易周期：即“股神”的操盘周期，以项目成立以后的第二个交易日起开始计算，列如T+20指21个交易日，其中T日为买入日。
     */
   private ProjectTradeCycle projectTradeCycle;

   /** 项目佣金提成比例：即股神的佣金提成比例。若项目盈利，股神按协议约定比例提取盈利部分金额作为股神佣金；若未能盈利则不提取佣金。
    */
   private double projectCommissionBonusPercent = 0;

   public double getProjectCommissionBonusPercent() {
	return projectCommissionBonusPercent;
}

    public void setProjectCommissionBonusPercent(
            double projectCommissionBonusPercent) {
        this.projectCommissionBonusPercent = projectCommissionBonusPercent;
    }

    /** 项目止损比例：当项目亏损到达该比例时触发止损指令，以尽力保证投资人投资损失不超过止损比例。当止损值为0，则为保本项目。
    * 
    * @pdOid 9a316811-5ae7-4cf1-954a-074bdd75f831 */
   private double projectStopLossPercent = 0;

   /** 项目止盈比例
    * 
    * @pdOid c2856450-941e-4fe3-90f9-4f8fa626934f */
   private double projectStopWinPercent = 0;

   /** 项目起投日期
    * 
    * @pdOid 52521d02-ed14-47c2-85d1-7214f86d6d4f */
   private java.util.Date projectInitialDate;

   /** 项目投资截止日期
    * 
    * @pdOid f86dc63a-c349-4523-bef0-4a1a0cc660aa */
   private java.util.Date projectInvestmentStopDate;

   private java.util.Date projectFullingDate;

   /** 操盘开始日期：项目满标后的下一个交易日。
    * 
    * @pdOid e09ea921-150e-407e-bd13-125a2b7a78d8 */
   private java.util.Date tradeBeginDate;

   /** 操盘结束日期：操盘开始后的第n个交易日，n=项目预设周期。
    *
    * @pdOid 60e0764e-2538-45f5-a7fb-b00448977d86 */
   private java.util.Date tradeEndDate;

   /** 项目还款日期：操盘结束后的的下一个交易日。
    * 
    * @pdOid 07c50532-b09c-4a63-9167-4c4c89fd6afc */
   private java.util.Date projectRepaymentDate;

   /** 发起人已认购金额：计算字段--- 查看对应合约中发起人认购的合约
    * 
    * @pdOid c26f20e9-4735-4c82-9100-cf6462e13ee0 */
   private double originatorSubscribedAmount = 0;

   /** 项目现金和股票市值总和
    */
   private double projectAssetsAmount = 0;
   
   public double getProjectAssetsAmount() {
	return projectAssetsAmount;
}

    public void setProjectAssetsAmount(double projectAssetsAmount) {
        this.projectAssetsAmount = projectAssetsAmount;
    }

    /** 项目现金
     */
    private double projectCashAmount = 0;

    public double getProjectCashAmount() {
        return projectCashAmount;
    }

    public void setProjectCashAmount(double projectCashAmount) {
        this.projectCashAmount = projectCashAmount;
    }

    /** 结算水位线
     * 比如 0.5 代表本次可结算金额占项目本金的50%
     */
    private double settlementWaterMarkPercent = 0;

    public double getSettlementWaterMarkPercent() {
        return settlementWaterMarkPercent;
    }

    public void setSettlementWaterMarkPercent(double settlementWaterMarkPercent) {
        this.settlementWaterMarkPercent = settlementWaterMarkPercent;
    }



    /** 项目类型代码
    * 
    * @pdOid ebfe2dac-0a92-4167-afe6-757e2b79ab98 */
   protected ProductType productType;
   
   /** 项目合买宣言
    * 
    * @pdOid 59713153-757a-47bd-8aab-aa109768252f */
   private java.lang.String projectBuyDeclaration;   
   
   /** @pdRoleInfo migr=no name=niu.myContracts.Contract assc=Reference5 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Contract> myContracts;

   /** @pdRoleInfo migr=no name=niu.platform.TransactionDocument assc=Association3 mult=0..* */
   public TransactionDocument[] transactionDocument;

   /** @pdRoleInfo migr=no name=niu.platform.PositionDocument assc=Association4 mult=0..* */
   public PositionDocument[] positionDocument;

   /** @pdRoleInfo migr=no name=niu.user.Mom assc=Association13 mult=0..1 side=A */
   public Mom mOM;
   
   /** 项目审核
   */
   public void audit() {
      // TODO: implement
	   state.audit(this);
   }

    /** 用户合买
     */
	public Contract buy(User user, double userProjectLowestSubscribeAmount) {
		return state.buy(this, user, userProjectLowestSubscribeAmount);
	}   
   
   /** 检查是否在募集期内没有完成募集目标
    * 
    * @pdOid a4af33b2-f9ab-48fa-8cc5-5843a913d970 */
   public void collectCheck() {
      // TODO: implement
   }
   
   /** 募集完成
    * 
    * @pdOid be027f4d-f154-4153-b171-2248e7bcd1ef */
   public void collectFinish() {
      // TODO: implement
   }
   
   /** MOM开始操盘
    * 
    * @pdOid ec1882b1-50db-49fe-b15f-013a903ff5c9 */
   public void beginTrade() {
      // TODO: implement
   }
   
   /** MOM延期项目结束时间
    * 
    * @pdOid eaab7656-cf75-4816-acc3-f9a427c63f8e */
   public void postpone() {
      // TODO: implement
   }
   
   /** 结束操盘
    * 
    * @pdOid 662227d3-1deb-4c66-88fd-c3f0dc8e1b8d */
   public void endTrade() {
      // TODO: implement
   }
   
   /** 停牌股票处理
    * 
    * @pdOid 476c50ca-5b1d-4753-900e-e69fa7c16336 */
   public void delistManage() {
      // TODO: implement
   }
   
   /** 停牌股票处理结束
    * 
    * @pdOid 125be619-fbbf-4229-adc1-d5362bda824c */
   public void delistEnd() {
      // TODO: implement
   }
   
   /** 合约结算
    * 
    */
   public void settlement() {
      // TODO: implement
       MathContext mc = new MathContext(8); // 8 precision
       //水位线 用可结算资金/项目本金
       this.setSettlementWaterMarkPercent(projectCashAmount/projectRealSubscribedAmount);
	   state.settlement(this);
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Contract> getMyContracts() {
      if (myContracts == null)
         myContracts = new java.util.HashSet<Contract>();
      return myContracts;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorContract() {
      if (myContracts == null)
         myContracts = new java.util.HashSet<Contract>();
      return myContracts.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newContract */
   public void setMyContracts(java.util.Collection<Contract> newContract) {
      removeAllContract();
      for (java.util.Iterator iter = newContract.iterator(); iter.hasNext();)
         addContract((Contract)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newContract */
   public void addContract(Contract newContract) {
      if (newContract == null)
         return;
      if (this.myContracts == null)
         this.myContracts = new java.util.HashSet<Contract>();
      if (!this.myContracts.contains(newContract))
      {
         this.myContracts.add(newContract);
         newContract.setProject(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldContract */
   public void removeContract(Contract oldContract) {
      if (oldContract == null)
         return;
      if (this.myContracts != null)
         if (this.myContracts.contains(oldContract))
         {
            this.myContracts.remove(oldContract);
            oldContract.setProject(null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllContract() {
      if (myContracts != null)
      {
         Contract oldContract;
         for (java.util.Iterator iter = getIteratorContract(); iter.hasNext();)
         {
            oldContract = (Contract)iter.next();
            iter.remove();
            oldContract.setProject(null);
         }
      }
   }

   /** @pdGenerated default parent getter */
   public Mom getMOM() {
      return mOM;
   }

   /** @pdGenerated default parent setter
     * @param newMOM */
   public void setMOM(Mom newMOM) {
      if (this.mOM == null || !this.mOM.equals(newMOM))
      {
         if (this.mOM != null)
         {
            Mom oldMOM = this.mOM;
            this.mOM = null;
            oldMOM.removeProject(this);
         }
         if (newMOM != null)
         {
            this.mOM = newMOM;
            this.mOM.addProject(this);
         }
      }
   }

    public Project setState(ProjectState state) {
        this.state = state;
        return this;
    }

    public ProjectState getState() {
    return state;
    }

    public ProjectState getApplyingState() {
    return applyingState;
    }

    public ProjectState getCollectingState() {
    return collectingState;
    }

    public ProjectState getOverringState() {
    return overringState;
    }

    public ProjectState getFullingState() {
    return fullingState;
    }

    public ProjectState getInvestorRepaymentState() {
    return investorRepaymentState;
    }

    public ProjectState getMomRepaymentState() {
    return momRepaymentState;
    }

    public ProjectState getPlatformRepaymentState() {
    return platformRepaymentState;
    }

    public ProjectState getDelistingRepaymentState() {
        return delistingRepaymentState;
    }

    public ProjectState getSettlingState() {
        return settlingState;
    }

    public void setProperty(String property, Object value)
    {
      if (properties == null) {
          properties = new HashMap();
      }
      properties.put(property, value);
    }
  
    public Object getProperty(Object property) {
      if (properties == null) {
          throw new RuntimeException("No properties for this Unit.");
      }
      Object value = properties.get(property);
      if (value == null)
      {
          throw new RuntimeException("Request for non-existent property.");
      }
      else
      {
          return value;
      }
    }
  
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nniu.myProjects.Project "  + this.projectName);
		result.append("\n");
		result.append("Status is " + state + "\n");
		return result.toString();
	}

    /** 项目满标日期：达到项目成立条件的日期。
     *
     * @pdOid 551f4069-ca79-4c13-8bf3-5a29df71ef8d */
    public java.util.Date getProjectFullingDate() {
        return projectFullingDate;
    }

    public void setProjectFullingDate(java.util.Date projectFullingDate) {
        this.projectFullingDate = projectFullingDate;
    }
}

