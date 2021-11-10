import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) ctx.getBean("accountService");
//        accountService.transfer("Jock1","Jock2",100D);

        accountService.a();//调用a方法看一下事务协调员传播行为never时的情况（了解即可）
    }
}
