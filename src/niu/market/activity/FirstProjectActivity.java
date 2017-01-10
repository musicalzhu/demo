package niu.market.activity;

import niu.project.Project;
import niu.user.Mom;

/**
 * Created by Tom on 2017/1/9.
 * MOM首次发布项目获得任务奖励
 */
public class FirstProjectActivity implements Command{
    private Mom mom;
    private Project project;

    public FirstProjectActivity(Mom mom, Project project) {
        this.mom = mom;
        this.project = project;
    }
    public void execute() {
        //TODO
        //判断该项目是否是MOM的第一个已发布项目
        System.out.println("完成首个项目，奖励500积分");
    }
}
