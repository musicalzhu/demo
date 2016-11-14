package niu.project; /***********************************************************************
 * Module:  niu.myProjects.CollectingState.java
 * Author:  Tom
 * Purpose: Defines the Class niu.myProjects.CollectingState
 ***********************************************************************/

import niu.contract.Contract;
import niu.user.User;


/** 募集中 状态
 * 
 * @pdOid e77aa053-3709-4856-9871-fd085439c19d */
public class CollectingState implements ProjectState {
   /** 用户合买
    * 
    * @param project 
    * @param user 
    * @param contractSubscribeAmount
	*/
	public Contract buy(Project project, User user, double contractSubscribeAmount) {
		//todo buy logic
		//判断是否超出项目最高认购金额
		//System.out.println("满额" + myProjects.getProjectHighestSubscribeAmount());
		if (project.getProjectHighestSubscribeAmount() > (project.getProjectRealSubscribedAmount() + contractSubscribeAmount) ){
			
			project.setProjectRealSubscribedAmount(project.getProjectRealSubscribedAmount() + contractSubscribeAmount);
			
			switch((int)Math.signum(project.getProjectRealSubscribedAmount() - project.getProjectLowestSubscribeAmount())) {
		      case 0:{
				   project.setState(project.getFullingState());
				   System.out.println(user.getUserName() + "满额" + contractSubscribeAmount);
				   break; 
		      }
		      case 1:{
				   project.setState(project.getOverringState());
				   System.out.println(user.getUserName() + "合买，超额中" + contractSubscribeAmount);
				   break; 
		      }
		      case -1:{
		    	   System.out.println(user.getUserName() + "合买" + contractSubscribeAmount);
				   break; 
		      }
		      default: 
		           System.out.println(user.getUserName() + "error..." );
		      } 
			
			Contract contract = new Contract(user, project, contractSubscribeAmount);
			project.addContract(contract);
			project.setProjectRealSubscribedAmount(project.getProjectRealSubscribedAmount() + contractSubscribeAmount);
			return contract;
		}
		else{
			System.out.println(user.getUserName() + "超出项目额度" + project.getProjectHighestSubscribeAmount()); 
		}
		return null;
	}
   
   /** 项目审核发布募集
    * 
    * @param project
    * @pdOid e8d30f36-557b-4e3a-81a5-2ac78e4de946 */
	public void audit(Project project) {
		//todo audit logic
		System.out.println("error");
	}
	
   /** 检查是否在募集期内没有完成募集目标
    * 
    * @param project
    * @pdOid dd22daaf-5790-4137-82f8-ff8c1121d264 */
   public void checkCollection(Project project) {
      // TODO: implement
   }
   
   /** 募集完成
    * 
    * @param project
    * @pdOid d3220490-40ae-435e-8444-859c04640542 */
   public void finishCollection(Project project) {
      // TODO: implement
   }
   
   /** MOM开始操盘
    * 
    * @param project
    * @pdOid f7080bc4-fc3d-48ba-b1ac-ef9ab550dae3 */
   public void beginTrade(Project project) {
      // TODO: implement
   }
   
   /** MOM延期项目结束时间
    * 
    * @param project
    * @pdOid 26d247a1-67ec-4595-bf17-d87175bf235a */
   public void postpone(Project project) {
      // TODO: implement
   }
   
   /** 结束操盘
    * 
    * @param project
    * @pdOid 5048fb95-7547-41e7-a7e6-06c63f8d0d66 */
   public void endTrade(Project project) {
      // TODO: implement
   }
   
   /** 停牌股票处理
    * 
    * @param project
    * @pdOid e4d3b492-a968-401b-a43c-f002ccb9f63a */
   public void delist(Project project) {
      // TODO: implement
   }
   
   /** 停牌股票处理结束
    * 
    * @param project
    * @pdOid 4ee77d62-76d7-466b-b92f-e87cf2a6683b */
   public void delistEnd(Project project) {
      // TODO: implement
   }
   
   /** 合约结算
    * 
    * @param project
    * @pdOid 76739cb5-0e6d-4141-8a5c-abbafda652df */
   public void settlement(Project project) {
      // TODO: implement
   }

	public String toString() {
		return "niu.myProjects.CollectingState";
	}
}