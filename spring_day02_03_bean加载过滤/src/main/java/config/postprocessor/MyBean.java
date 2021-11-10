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
        return bean;//bean过来之后最终还需要给它返回去
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean之后。。。。");
        return bean;//在初始化后
    }
}
