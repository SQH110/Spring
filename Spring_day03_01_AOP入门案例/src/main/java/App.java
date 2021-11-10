import com.itheima.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sqh
 * @create 2021-05-16 16:25
 */
public class App {
    public static void main(String[] args) {
        //导入配置
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取Service的对象
        UserService userService = (UserService) ctx.getBean("userService");
        //此对象执行方法
        userService.save();
    }
}
