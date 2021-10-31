package base.decorator;

import com.itheima.UserService;
import com.itheima.impl.UserServiceImpl;

import javax.activation.MailcapCommandMap;

/**
 * @author sqh
 * @create 2021-05-20 20:31
 */
public class APP {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        //装饰
        UserService userService1 = new UserServiceImplDecorator(userService);
        UserService userService2 = new UserServiceImplDecorator2(userService1);//多态的应用

//        userService1.save();//水泥墙...刮大白
        userService2.save();//水泥墙...刮大白
        //原始设备没动

    }
}
