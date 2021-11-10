package base.cglib;

import com.itheima.UserService;
import com.sun.tracing.dtrace.ArgsAttributes;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 由字节码生成对象
 * @author sqh
 * @create 2021-05-22 15:34
 */
public class UserServiceCglibProxy {
    //创造一个动态的UserService实现类对象
    public static UserService creatUserServiceCglibProxy(Class clazz) {
        //先造一个字节码对象
        Enhancer enhancer = new Enhancer();//这是spring—core中的

        enhancer.setSuperclass(clazz);//设置字节码对象为这个类clazz的子类，这样后面才能可以使用泛型

        //对原始的类及其方法做调用（设置回调），完成增强
        enhancer.setCallback(new MethodInterceptor() {//设置回调
            /*
            public void setCallback(final Callback callback) {
            这里需要一个Callback，这是个接口，里面什么也没有，不可以使用这个
            需要借助MethodInterceptor，这是Callback接口的一个子接口
            使用其匿名内部类。
             */
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                /*
                Object o：这个是代理类
                Method method：被代理类对应的方法（原始调用方法）
                Object[] args：用到的参数
                MethodProxy methodProxy：代理的方法（这是你造出来的字节码中的方法）
                 */


//                System.out.println(method.getName());


                /*
                原因一：调父类的方法才可以增强，因为原始是个接口
                原因二：invoke中的参数o是代理类，所有这个方法类应该是代理类的方法类methodProxy
                 */
//                method.invoke(o,args);//原因二
//                methodProxy.invoke(o,args);//原因一

                Object ret = methodProxy.invokeSuper(o, args);
//                System.out.println(o.getClass());//class com.itheima.impl.UserServiceImpl$$EnhancerByCGLIB$$3bc735d9
                if(method.getName().equals("save")) {
                    //这个方法增强是对所有的方法做增强，所以我们用一个判断来锁定增强的方法
                    System.out.println("刮大白");
                    System.out.println("贴墙纸");
                }
                return ret;
            }
        });
        return (UserService) enhancer.create();
    }
}
