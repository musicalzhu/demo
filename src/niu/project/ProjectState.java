package niu.project; /***********************************************************************
 * Module:  niu.myProjects.ProjectState.java
 * Author:  Tom
 * Purpose: Defines the Interface niu.myProjects.ProjectState
 ***********************************************************************/

import niu.contract.Contract;
import niu.user.User;

/** 项目状态
 * 1：申请中
 * 2：申请失败
 * 3：募集中
 * 4：超额中
 * 5：满标中
 * 6：募集结束，等待操盘中
 * 7：募集失败
 * 8：操盘中
 * 9：操盘结束等待结算中
 * 10：结算期间停牌中
 * 11：投资人结算中
 * 12：操盘手结算中
 * 13：平台结算中
 * 14：项目结束
 */
public interface ProjectState {

   /** 用户合买
    * 
    * @param project
    * @param user
    * @param contractSubscribeAmount
 * @return TODO*/
   Contract buy(Project project, User user, double contractSubscribeAmount);


   /** 项目审核发布募集
    * 
    * @param project
    */
   void audit(Project project);


   /** 检查是否在募集期内没有完成募集目标
    * 
    * @param project
    */
   void checkCollection(Project project);


   /** 募集完成
    * 
    * @param project
    */
   void finishCollection(Project project);


   /** MOM开始操盘
    * 
    * @param project
    */
   void beginTrade(Project project);


   /** MOM延期项目结束时间
    * 
    * @param project
    */
   void postpone(Project project);


   /** 结束操盘
    * 
    * @param project
    */
   void endTrade(Project project);


   /** 停牌股票处理
    * 
    * @param project
    */
   void delist(Project project);


   /** 停牌股票处理结束
    * 
    * @param project
    */
   void delistEnd(Project project);


   /** 合约结算
    * 
    * @param project
    */
   void settlement(Project project);

}