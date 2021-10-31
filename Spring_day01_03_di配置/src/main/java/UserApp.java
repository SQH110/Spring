import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sqh
 * @create 2021-04-26 13:48
 */
public class UserApp {
    public static void main(String[] args) {
        //2.上一步是写配置文件，加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //3.获取资源
        UserService userService = (UserService) ctx.getBean("userService");//第三方资源

        userService.save();

    }
}
