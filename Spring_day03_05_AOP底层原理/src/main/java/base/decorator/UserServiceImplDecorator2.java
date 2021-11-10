package base.decorator;

import com.itheima.UserService;

/**
 * 装饰者模式：在不影响原始设计的基础上，为其添加功能
 *
 * @author sqh
 * @create 2021-05-20 17:38
 */
public class UserServiceImplDecorator2 implements UserService {

    private  UserService userService;

    public UserServiceImplDecorator2(UserService userService) {//有参构造导入原始类
        this.userService = userService;
    }

    public void save() {
        userService.save();//把传入的userService导入
        System.out.println("贴壁纸");
    }
}
