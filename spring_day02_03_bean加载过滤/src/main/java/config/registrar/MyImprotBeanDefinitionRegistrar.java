package config.registrar;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.cache.annotation.CacheAnnotationParser;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义bean定义注册器
 *
 * @author sqh
 * @create 2021-05-14 23:00
 */
public class MyImprotBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {//实现这个接口
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        /*
        第一步：需要做一个类路径下的扫描（用到一个类路径下的bean定义扫描器）
        用到两个参数：
            ①bean定义的注册器
            ②是否使用默认的过滤器（我们自己指定，不使用默认的，填false）
         */
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, false);
//        scanner.scan("com.itheima");//扫描这个basePackages相当于（@ComponentScan("com.itheima")）


        //下面自定义组件过滤器（排除和包含两种，这是两种角度）
//        scanner.addExcludeFilter();//等同于@ComponentScan.Filter

        scanner.addIncludeFilter(new TypeFilter() {//需要借助一个TypeFilter对象
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                //这个方法中制定规则（说明需要导入的类）
                return true;//true：表示都要
            }
        });

        scanner.scan("com.itheima");//扫描这个basePackages相当于（@ComponentScan("com.itheima")）
        //注意这个位置的摆布。。。（无语）
    }
}
