package niu.project; /***********************************************************************
 * Module:  niu.myProjects.OverringState.java
 * Author:  Tom
 * Purpose: Defines the Class niu.myProjects.OverringState
 ***********************************************************************/

/** 超额中 状态
 * 
 * @pdOid feb117e2-4acb-4735-8aec-1ab4aef6f1c7 */
public class OverringState extends CollectingState implements ProjectState {


   /** 项目审核发布募集
    * 
    * @param project
    * @pdOid 9676e895-b11d-4aed-a357-d06c30ea01e8 */
   public void audit(Project project) {
      // TODO: implement
   }
   
   /** 检查是否在募集期内没有完成募集目标
    * 
    * @param project
    * @pdOid 77b03933-283a-456b-ba2f-ba59135ff48c */
   public void checkCollection(Project project) {
      // TODO: implement
   }
   
   /** 募集完成
    * 
    * @param project
    * @pdOid bc981f6e-f0fc-4314-b43e-36b387e4ee0a */
   public void finishCollection(Project project) {
      // TODO: implement
   }
   
   /** MOM开始操盘
    * 
    * @param project
    * @pdOid b0970b86-4127-48a1-aba6-5b2a656619bd */
   public void beginTrade(Project project) {
      // TODO: implement
   }
   
   /** MOM延期项目结束时间
    * 
    * @param project
    * @pdOid beb13263-d5f3-45de-93ea-453ed5700c45 */
   public void postpone(Project project) {
      // TODO: implement
   }
   
   /** 结束操盘
    * 
    * @param project
    * @pdOid e87c5861-3893-475c-932b-5f21e94931e7 */
   public void endTrade(Project project) {
      // TODO: implement
   }
   
   /** 停牌股票处理
    * 
    * @param project
    * @pdOid c7d8e3db-1f53-486b-90d7-9c69911e6236 */
   public void delist(Project project) {
      // TODO: implement
   }
   
   /** 停牌股票处理结束
    * 
    * @param project
    * @pdOid 86120437-c923-44ca-a260-09e2e2081e30 */
   public void delistEnd(Project project) {
      // TODO: implement
   }
   
   /** 合约结算
    * 
    * @param project
    * @pdOid a951efd1-93df-4e85-8e00-416e3ff7e41d */
   public void settlement(Project project) {
      // TODO: implement
   }
   
	public String toString() {
		return "niu.myProjects.OverringState";
	}

}