package base.decorator;

import com.itheima.UserService;

/**
 * 装饰者模式：在不影响原始设计的基础上，为其添加功能
 *
 * 实现同一个接口
 * @author sqh
 * @create 2021-05-20 17:38
 */
public class UserServiceImplDecorator implements UserService {

    private  UserService userService;

    public UserServiceImplDecorator(UserService userService) {//有参构造
        this.userService = userService;
    }

    public void save() {
        userService.save();
        System.out.println("刮大白");
    }
}
