package niu.project; /***********************************************************************
 * Module:  niu.myProjects.FullingState.java
 * Author:  Administrator
 * Purpose: Defines the Class niu.myProjects.FullingState
 ***********************************************************************/

import niu.contract.Contract;
import niu.user.User;


/** 满标中 状态
 * 
 * @pdOid ba40e478-7955-47f8-bb1e-6616d375f64e */
public class FullingState implements ProjectState {
   /** 用户合买
    * 
    * @param project
    * @param user
    * @param contractSubscribeAmount
    * @pdOid c1db666b-feee-4c05-9ae0-5cb428b86769 */
   public Contract buy(Project project, User user, double contractSubscribeAmount) {
	return null;
      // TODO: implement
   }
   
   /** 项目审核发布募集
    * 
    * @param project
    * @pdOid 915fccec-3ffc-4feb-b940-74c398ec6202 */
   public void audit(Project project) {
      // TODO: implement
   }
   
   /** 检查是否在募集期内没有完成募集目标
    * 
    * @param project
    * @pdOid 122d189f-9171-4144-939a-b39ced2a5551 */
   public void checkCollection(Project project) {
      // TODO: implement
   }
   
   /** 募集完成
    * 
    * @param project
    * @pdOid ffc2b9fc-ea02-4b12-9f92-13f555ae04cc */
   public void finishCollection(Project project) {
      // TODO: implement
   }
   
   /** MOM开始操盘
    * 
    * @param project
    * @pdOid f06978e8-a3bf-4fde-bb0a-9f1f1f2c17fe */
   public void beginTrade(Project project) {
      // TODO: implement
   }
   
   /** MOM延期项目结束时间
    * 
    * @param project
    * @pdOid 96ea4f80-8690-41e7-8df3-89e9fff428dd */
   public void postpone(Project project) {
      // TODO: implement
   }
   
   /** 结束操盘
    * 
    * @param project
    * @pdOid 23f11ac4-b01c-4af7-ac9f-97740efaf21a */
   public void endTrade(Project project) {
      // TODO: implement
   }
   
   /** 停牌股票处理
    * 
    * @param project
    * @pdOid b5ccd2c5-2232-4b29-893d-4a3e5c87d5ce */
   public void delist(Project project) {
      // TODO: implement
   }
   
   /** 停牌股票处理结束
    * 
    * @param project
    * @pdOid 6cf68083-27d0-48a0-97c7-5bf1a8db1a8f */
   public void delistEnd(Project project) {
      // TODO: implement
   }
   
   /** 合约结算
    * 
    * @param project
    * @pdOid a2c84efe-7f92-474f-9994-31da40a23f45 */
   public void settlement(Project project) {
      // TODO: implement
   }
   
   /** @pdOid 6f0dfe33-3c1c-414e-a819-8bd90fa397a2 */
   public short getStatusValue() {
      // TODO: implement
      return 0;
   }

	public String toString() {
		return "niu.myProjects.FullingState";
	}
}