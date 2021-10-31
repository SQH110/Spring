import com.itheima.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟表现层调用业务层
 *
 * @author sqh
 * @create 2021-04-26 13:48
 */
public class UserApp {
    public static void main(String[] args) {
        //2.上一步是写配置文件，这一步是加载配置文件
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //3.获取资源
        UserService userService = (UserService) ctx.getBean("userService");//name是自定义的id名称

        userService.save();

    }
}
