import com.itheima.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sqh
 * @create 2021-05-16 16:25
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
//        userService.save(666);

//        int update = userService.update();
//        System.out.println("app..." + update);

        userService.delete();
    }
}
