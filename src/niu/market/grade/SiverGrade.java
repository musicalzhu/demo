package niu.market.grade;

import niu.user.User;

/**
 * Created by Tom on 2016/10/29.
 * 白银级别
 */
public class SiverGrade extends Grade {
    public void promotionValidation(User user)
    {
        //用户发起一笔非免费体验合约后授予
        user.setState(user.getGoldGradeState());
        System.out.println("用户" + user + "升级成为" + user.getState());
    }
    public void privilegeValidation(User user)
    {
        //享受积分礼遇，定期发送折扣券
    }
    public String toString() {
        return "SiverGrade";
    }
}
