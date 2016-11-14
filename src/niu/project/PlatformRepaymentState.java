package niu.project; /***********************************************************************
 * Module:  niu.myProjects.PlatformRepaymentState.java
 * Author:  Administrator
 * Purpose: Defines the Class niu.myProjects.PlatformRepaymentState
 ***********************************************************************/

import niu.contract.Contract;
import niu.user.User;


/** 平台结算中 状态
 *
 /** @pdOid 0374a4cd-c159-401e-b09d-95468f5476d0 */
public class PlatformRepaymentState implements ProjectState {
    /** 用户合买
     *
     * @param project
     * @param user
     * @param contractSubscribeAmount
     * @pdOid 08326cbd-e386-412f-b2e7-7683be067260 */
    public Contract buy(Project project, User user, double contractSubscribeAmount) {
        return null;
        // TODO: implement
    }

    /** 项目审核发布募集
     *
     * @param project
     * @pdOid 31fa2d2c-4333-48cb-9c6d-e60d7dab6257 */
    public void audit(Project project) {
        // TODO: implement
    }

    /** 检查是否在募集期内没有完成募集目标
     *
     * @param project
     * @pdOid c0bcb4e0-f56b-424f-b949-17d359a42db1 */
    public void checkCollection(Project project) {
        // TODO: implement
    }

    /** 募集完成
     *
     * @param project
     * @pdOid b5a5c57c-c6d5-4357-8731-e3d028a3e659 */
    public void finishCollection(Project project) {
        // TODO: implement
    }

    /** MOM开始操盘
     *
     * @param project
     * @pdOid 6a84a5e3-b611-49ce-b26e-83a4b3e3efc5 */
    public void beginTrade(Project project) {
        // TODO: implement
    }

    /** MOM延期项目结束时间
     *
     * @param project
     * @pdOid 88587575-79af-4630-b553-2b52d1d78e71 */
    public void postpone(Project project) {
        // TODO: implement
    }

    /** 结束操盘
     *
     * @param project
     * @pdOid 4262d2ae-27cf-4d57-a850-47de8803d83e */
    public void endTrade(Project project) {
        // TODO: implement
    }

    /** 停牌股票处理
     *
     * @param project
     * @pdOid f864c9f5-2a42-4849-8e53-2dc3c8136291 */
    public void delist(Project project) {
        // TODO: implement
    }

    /** 停牌股票处理结束
     *
     * @param project
     * @pdOid 2e240dcc-a058-49c6-89e0-469917e90f59 */
    public void delistEnd(Project project) {
        // TODO: implement
    }

    /** 合约结算
     *
     * @param project
     */
    public void settlement(Project project) {
        // TODO: implement
        System.out.println("平台项目结算...");
        //平台服务费 = 佣金分成*20% （管理型项目）
        //		或者 = 佣金分成*10% （稳健型项目）
        //项目待结算金额增加
        //MOM股神账户金额扣除
        System.out.println(project.getMOM().getmOMName() + "平台服务费...");
        //平台管理费 =（项目金额-自有资金）*0.005%*项目自然日交易周期
        //项目待结算金额增加
        //MOM股神账户金额扣除
        System.out.println(project.getMOM().getmOMName() + "平台管理费...");
        //平台结算
        //项目待结算金额扣除
        //平台账户金额增加
        System.out.println("平台服务费...");
        System.out.println("平台管理费...");

        //检查项目待结算金额是否结算分配完成，逻辑上是100%分配好了！！！
        System.out.println("平台项目结算完成！");

    }

    public short getStatusValue() {
        // TODO: implement
        return 0;
    }

    public String toString() {
        return "niu.myProjects.PlatformRepaymentState";
    }

}