package base.proxy;

import com.itheima.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sqh
 * @create 2021-05-20 21:06
 */
public class UserServiceJDKProxy {
    public static UserService createUserServiceJDKProxy(final UserService userService) {//用final修饰实际上就是为了保护数据的一致性。
        //要求传入一个对象UserService（被代理对象）
        ClassLoader cl = userService.getClass().getClassLoader();//被代理对象的类加载器
        Class[] classes = userService.getClass().getInterfaces();//被代理对象实现的接口
        InvocationHandler ih = new InvocationHandler() {//拦截
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*
                Object proxy：代理的对象（这个是内部封装好的）
                Method method：拦截的方法
                Object[] args：方法的形参
                 */
                Object ret = method.invoke(userService,args);
                System.out.println("刮大白");//添加我们的操作
                System.out.println("贴壁纸");//添加我们的操作
                return ret;
            }
        };
        /*
        newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
            三个参数：①ClassLoader loader定义代理类的类加载器
                    ②Class<?>[] interfaces实现的所有接口
                    ③InvocationHandler h将方法调用分派到的调用处理程序
         */
        UserService service = (UserService) Proxy.newProxyInstance(cl,classes,ih);
        return service;
    }
}
