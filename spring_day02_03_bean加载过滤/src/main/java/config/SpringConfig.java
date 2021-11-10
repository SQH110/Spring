package config;

import config.filter.MyTypeFilter;
import config.postprocessor.MyBean;
import config.postprocessor.MyBeanFactory;
import config.registrar.CustomeImportBeanDefinitionRegistrar;
import config.registrar.MyImprotBeanDefinitionRegistrar;
import config.selector.CustomerImportSelector;
import config.selector.MyImprotSelector;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author sqh
 * @create 2021-05-14 15:20
 */

@Configuration
//***************************************************
@ComponentScan("com.itheima")//不设置过滤的情况（自定义注册器后可以不要，但是要也不影响）
//这个其实功能就是注册器的功能

//自定义bean注册器
@Import({MyImprotBeanDefinitionRegistrar.class,MyBeanFactory.class, MyBean.class})
//导入了自定义导入器MyImprotBeanDefinitionRegistrar.class

//@Import(CustomeImportBeanDefinitionRegistrar.class)
//将自定义注册器配置到springconfig

//************************使用组件扫描加载过滤器***************************
/*@ComponentScan(//每个属性各占一行
    value = "com.itheima",
    excludeFilters = @ComponentScan.Filter(
            //添加过滤的四个属性(告知过滤规则)
            type = FilterType.ANNOTATION,//按照注解过滤
            classes = Service.class//告知过滤哪个注解，这个就是说明屏蔽了注解所在的类
        )//这里是排除筛选器（使用方法注解中的注解）
    )*/
//*************************使用自定义的方式加载过滤器**************************
/*@ComponentScan(//每个属性各占一行
        value = "com.itheima",
        excludeFilters = @ComponentScan.Filter(
                //添加过滤的四个属性
                type = FilterType.CUSTOM,//按照自定义的方式过滤
                classes = MyTypeFilter.class//告知过滤规则
        )//这里是排除筛选器（使用方法注解中的注解）
)*/

//***************************************************
//@Import(MyImprotSelector.class)//自定义导入器
//@Import(CustomerImportSelector.class)//将自定义导入器配置到springconfig(一直有问题basePackages=null，后续处理)
//****************************************************

public class SpringConfig {
}
