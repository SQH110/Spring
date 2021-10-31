package config.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author sqh
 * @create 2021-05-16 13:55
 */
public class MyBean implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean之前。。。。");
        System.out.println(beanName);
        return bean;//在初始化前
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean之后。。。。");
        return bean;//在初始化后
    }
}
