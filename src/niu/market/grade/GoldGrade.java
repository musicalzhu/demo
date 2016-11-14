package niu.market.grade;

import niu.user.User;

/**
 * Created by Tom on 2016/10/29.
 * 黄金级别
 */
public class GoldGrade extends Grade {
    public void promotionValidation(User user)
    {
        //用户累计按天合约满20个交易日（非免费体验），并且分享过一次合约战绩到朋友圈后授予
    }
    public void privilegeValidation(User user)
    {
        //享受白银级别基本权益，基础积分奖励加20%，合约管理费率打9折
    }
    public String toString() {
        return "GoldGrade";
    }
}
