package niu.market.activity;

import niu.project.Project;
import niu.user.User;

/**
 * Created by Tom on 2017/1/9.
 * 用户首次关注项目获得任务奖励
 */
public class FirstFollowActivity implements Command{
    private User user;
    private Project project;

    public FirstFollowActivity(User user, Project project) {
        this.user = user;
        this.project = project;
    }
    public void execute() {
        //TODO
        //判断这次用户关注行为是否是该用户的第一次关注
        System.out.println("完成首次关注，奖励100积分");
    }
}
