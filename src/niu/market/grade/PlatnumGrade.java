package niu.market.grade;

import niu.user.User;

/**
 * Created by Tom on 2016/10/29.
 * 铂金级别
 */
public class PlatnumGrade extends Grade {
    public void promotionValidation(User user)
    {

    }
    public void privilegeValidation(User user)
    {
        //享受黄金级别基本权益，基础积分奖励加50%，合约管理费率打8折
    }
    public String toString() {
        return "PlatnumGrade";
    }
}
