import com.itheima.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sqh
 * @create 2021-04-26 13:48
 */
public class UserApp {
    public static void main(String[] args) {
        //2.上一步是写配置文件，加载配置文件
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //单例的情况下在创造spring容器的时候就加载了
        //3.获取资源
//        UserService userService1 = (UserService) ctx.getBean("userService3");
//        UserService userService2 = (UserService) ctx.getBean("userService3");
//        UserService userService3 = (UserService) ctx.getBean("userService3");
//
//        System.out.println(userService1);//com.itheima.service.impl.UserServiceImpl@91161c7
//        System.out.println(userService2);//com.itheima.service.impl.UserServiceImpl@91161c7
//        System.out.println(userService3);//com.itheima.service.impl.UserServiceImpl@91161c7
//        System.out.println(userService1 == userService2);//true
        //scope为singleton


//        userService.save();

//*******************************************************
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService1 = (UserService) ctx.getBean("userService3");
//        UserService userService2 = (UserService) ctx.getBean("userService3");
//        UserService userService3 = (UserService) ctx.getBean("userService3");
//        //单例时就执行一次init方法
//        //destroy方法在单例和非单例的情况下不同
//        ctx.close();

//*********************静态工厂************************************
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService1 = (UserService) ctx.getBean("userService4");
//        userService1.save();

//*******************实例工厂***************************
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService1 = (UserService) ctx.getBean("userService5");
        userService1.save();
    }
}
