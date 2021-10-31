package base.proxy;

import com.itheima.UserService;
import com.itheima.impl.UserServiceImpl;

/**
 * @author sqh
 * @create 2021-05-20 21:52
 */
public class APP {
    public static void main(String[] args) {
        //先建立原始代理对象
        UserService userService = new UserServiceImpl();
        UserService userService1 = UserServiceJDKProxy.createUserServiceJDKProxy(userService);
        userService1.save();
    }
}
