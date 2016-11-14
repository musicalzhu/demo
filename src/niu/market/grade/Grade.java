package niu.market.grade;

import niu.user.User;

/**
 * Created by Tom on 2016/10/20.
 */
public abstract class Grade {
    private java.lang.Long gradeID;
    private java.lang.String gradeName;
    //升级逻辑
    abstract public void promotionValidation(User user);
    //特权逻辑
    abstract public void privilegeValidation(User user);
    abstract public String toString();
}
