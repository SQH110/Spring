package base.cglib;

import com.itheima.UserService;
import com.itheima.impl.UserServiceImpl;

/**
 * @author sqh
 * @create 2021-05-22 17:12
 */
public class App {
    public static void main(String[] args) {
        UserService userService = UserServiceCglibProxy.creatUserServiceCglibProxy(UserServiceImpl.class);
        System.out.println(userService);//com.itheima.impl.UserServiceImpl$$EnhancerByCGLIB$$3bc735d9@2530c12
        userService.save();
    }
}
