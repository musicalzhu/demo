package niu.project; /***********************************************************************
 * Module:  niu.myProjects.ApplyingState.java
 * Author:  Tom
 * Purpose: Defines the Class niu.myProjects.ApplyingState
 ***********************************************************************/

import niu.contract.Contract;
import niu.user.User;


/** 申请中 状态
 * 
 */
public class ApplyingState implements ProjectState {

   /** 用户合买
    *  @param project
    * @param user
    * @param contractSubscribeAmount
    */
   public Contract buy(Project project, User user, double contractSubscribeAmount) {
	return null;
      // TODO: implement
   }
   
   /** 项目审核发布募集
    * 
    * @param project
    */
	public void audit(Project project) {
		//todo audit logic
		project.setState(project.getCollectingState());
		System.out.println("项目审核通过");

	   //通知订阅了该操盘手的订阅者
		project.mOM.mOMChanged(project.getProjectName() + ProjectActivityType.audit.toString());
        //通知订阅了该项目的订阅者
		project.projectChanged(ProjectActivityType.audit.toString());
	}


   /** 检查是否在募集期内没有完成募集目标
    * 
    * @param project
    * @pdOid fecec9c4-6146-472d-ab9b-37dd48d25fa8 */
   public void checkCollection(Project project) {
      // TODO: implement
   }
   
   /** 募集完成
    * 
    * @param project
    * @pdOid 409c8dfa-e317-44a2-afb5-3c0845469ef3 */
   public void finishCollection(Project project) {
      // TODO: implement
   }
   
   /** MOM开始操盘
    * 
    * @param project
    * @pdOid 58d3c1b2-1c18-453a-9210-777b66ba7f18 */
   public void beginTrade(Project project) {
      // TODO: implement
   }
   
   /** MOM延期项目结束时间
    * 
    * @param project
    * @pdOid 0d5b72a7-7bf8-4507-99aa-6d4fdacdbf58 */
   public void postpone(Project project) {
      // TODO: implement
   }
   
   /** 结束操盘
    * 
    * @param project
    * @pdOid 3707d617-4aa7-46ef-a7aa-3d404f3f157b */
   public void endTrade(Project project) {
      // TODO: implement
   }
   
   /** 停牌股票处理
    * 
    * @param project
    * @pdOid f912dc48-b703-4fde-b59f-44510a71d8aa */
   public void delist(Project project) {
      // TODO: implement
   }
   
   /** 停牌股票处理结束
    * 
    * @param project
    * @pdOid d4e94d94-d137-4847-ade2-91dd5899e4e1 */
   public void delistEnd(Project project) {
      // TODO: implement
   }
   
   /** 合约结算
    * 
    * @param project
    * @pdOid 85b905bb-aa3f-4520-b0d9-b4caaf0b0697 */
   public void settlement(Project project) {
      // TODO: implement
   }
   
	public String toString() {
		return "niu.myProjects.ApplyingState";
	}

}