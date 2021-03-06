package niu.project; /***********************************************************************
 * Module:  niu.myProjects.MomRepaymentState.java
 * Author:  Administrator
 * Purpose: Defines the Class niu.myProjects.MomRepaymentState
 ***********************************************************************/

import niu.contract.Contract;
import niu.user.User;


/** 操盘手结算中 状态
 *
 /** @pdOid 0374a4cd-c159-401e-b09d-95468f5476d0 */
public class MomRepaymentState implements ProjectState {
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
        System.out.println("操盘手项目结算...");
        //MOM结算
        //项目待结算金额扣除
        //MOM股神账户金额增加
        //合约最低收益保障、最大亏损保障等业务逻辑处理
        System.out.println(project.getMOM().getmOMName() + "佣金分成=（项目金额-自有资金）*项目收益率*佣金比...");
        System.out.println("操盘手项目结算完成！");

        //如果还有可结算资金，继续转给后续状态机结算
        if (project.getProjectCashAmount() > 0) {
            project.setState(project.getPlatformRepaymentState()).settlement();
        }
    }

    public short getStatusValue() {
        // TODO: implement
        return 0;
    }

    public String toString() {
        return "niu.myProjects.MomRepaymentState";
    }

}