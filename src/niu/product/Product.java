package niu.product; /***********************************************************************
 * Module:  niu.product.Product.java
 * Author:  Tom
 * Purpose: Defines the Class niu.product.Product
 ***********************************************************************/

import niu.platform.FullRule;
import niu.product.ProductType;
import niu.platform.SelfOwnedCapitalControl;


import java.util.*;

/** 产品
 * 
 * @pdOid 33f79375-7135-4581-ba3b-fb751b04cfcf */
public abstract class Product {
   /** 产品编号
    * 
    * @pdOid 5c2c151a-c7cc-4fbc-8f17-a1b2e608e988 */
   private long productID;
   /** 产品名称
    * 
    * @pdOid 22d0e27f-4216-408c-b547-048560ff1103 */
   private java.lang.String productName;
   /** 产品类型代码：目前平台提供"稳健型"和"管理型"合买项目。稳健型：对投资人的认购本金提供保本机制。管理型：MOM承担超出止损值部分的超额损失。
    * 
    * @pdOid 8c4c1fb1-f49e-4090-8ff9-437ce96158af */
   private ProductType productType;
   public ProductType getProductType() {
	return productType;
}

public void setProductType(ProductType productType) {
	this.productType = productType;
}

/** 最低自有资金比例最高自有资金比例
    * 
    * @pdOid 04c6297a-bfdd-4b50-adb3-ea2fb98261bc */
   private int selfOwnedCapitalControlCode;
   /** 满标规则代码：规定时间内项目投资满额或者项目投资进度超过100%后“股神”可以自行选择下一交易日立刻开始操盘。若规定投资时间内，投资进度未达到最低成立金额即100%时，项目流标，则投资金额自动退还。
    * 
    * @pdOid ef3815bc-58cf-44df-8b33-6bafd3d4d190 */
   private FullRule fullRuleCode;
   /** 风险控制代码：止损机制，为了有效控制交易风险，风控部门将从投资范围、持仓集中度、禁止违规操作等多方面进行限制。“股神”开始操盘后风控部门将对项目进行实时监控，并根据项目对应的止损线及时采取相关风控措施。
    * 
    * @pdOid 574902d8-5a37-4c61-a045-9defc64519b2 */
   private short riskControlCode;
   /** 执行合伙人也可以在合伙期限届满之前3日内发布合伙延期任务，提出合伙需要延期的时限，经
    * 全体合伙人在任务中同意后，合伙任务期限即变更为新期限。但任务延期上限为原定期限的50%，次数
    * 最多不能超过两次。
    * 
    * @pdOid 59626b4c-677a-475d-81f4-2b2a4978c8e7 */
   private short postponeRuleCode;
   /** 收益分配规则代码：若项目到期后盈利，“股神”按照协议约定比例向投资人收取佣金，共享收益；若亏损，由双方共同承担。经纪人的佣金会在项目最后一次还款的时候进行结算。（若项目为股神承担超额止损的项目，则投资人只需承担止损值以内亏损，超过预设止损线部分由“股神”承担。)
    * 
    * @pdOid 53ee4d91-7b9d-4d7a-a6ba-9216aca5f391 */
   private short profitAssignmentRuleCode;
   /** 停牌处理规则代码：项目到期或提前结束时，若股票处于停牌状态，则该部分资产将会冻结，在股票复牌后再由“股神”负责择机卖出，之后再对剩余资产进行还款。
    * 
    * @pdOid f9434155-f4b5-45ec-8569-7318453436f4 */
   private short delistManageRuleCode;
   /** 认购金额控制代码：由最低项目成立金额和最高项目成立金额确定的一个区间比例。
    * 
    * @pdOid fd6dd565-e211-4df0-8b8f-7f95993bfe22 */
   private short subscribeAmountControlCode;
   /** 交易周期控制代码：即“股神”的操盘周期，以项目成立以后的第二个交易日起开始计算，列如T+20指21个交易日，其中T日为买入日。
    * 
    * @pdOid 4558933e-764d-4d9c-b244-93d3f1d07752 */
   private short tradeCycleControlCode;
   /** 佣金规则代码：即项目的盈利分成比例。若项目到期盈利，则“股神”按照约定提取盈利部分金额作为佣金。若到期未盈利，则不提佣金。
    * 
    * @pdOid 16a58444-b853-4a27-90b0-24996ba8dcef */
   private short commissionAmountRuleCode;
   /** 止损比例控制代码：当项目亏损到达该比例时触发止损指令，以尽力保证投资人投资损失不超过止损比例。当止损值为0，则为保本项目。
    * 
    * @pdOid 85277176-81dd-4410-a290-08524ae1b2d4 */
   private short stopLossPercentControlCode;
   /** 超额止损类型代码：股神承担超额止损
    * 
    * @pdOid e5b17be8-56d7-4c4b-99ac-f4302248d439 */
   private short overStopLossTypeCode;
   /** 营销类型代码：支持体验金
    * 
    * @pdOid 6d1760ce-d06f-403c-adb5-3e05436755f1 */
   private short promotionTypeCode;
   /** 起投控制代码：100元起投
    * 
    * @pdOid f9af6488-0374-4093-9d07-348326d5aa72 */
   private short initialControlCode;
   /** 发起人认购控制代码：股神最低出资比例限制
    * 
    * @pdOid 81515cf6-69c8-4844-a5a4-e666aefa7f06 */
   private short originatorSubscribeControlCode;
   /** 募集期规则代码：约定项目的募集期开始日期、结束日期的天数等信息
    * 
    * @pdOid fc781460-a7cc-4a1f-9fab-d18189d394b9 */
   private short collectDurationRuleCode;
   
   /** 收益分配
    * 
    * @pdOid fb059000-ec75-4c6c-8ee3-e79395002580 */
   public void profitAssignment() {
      // TODO: implement
   }
   
   /** 授信
    * 
    * @param starCode
    * @pdOid ff77832e-1f0c-43eb-bfad-ca2507f9d672 */
   public Map credit(short starCode) {
      // TODO: implement
	   Map properties;
	   if (starCode > 0)
	   {
		    properties = new HashMap();
		    properties.put("niu.product.ProductType", ProductType.robust);
		    properties.put(SelfOwnedCapitalControl.lowestSelfOwnedCapitalPercent, 0.1);
		    properties.put(SelfOwnedCapitalControl.highestSelfOwnedCapitalPercent, 0.2);
            properties.put(ProductProperties.productCeilingAmount, Double.valueOf(500));
		    properties.put(ProductProperties.projectCeilingAmount, Double.valueOf(100));
		    properties.put(ProductProperties.projectFloorAmount, Double.valueOf(200));
		    return properties;
	   }
	   return null;
   }

}