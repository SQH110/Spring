package config.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.type.AnnotationMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 自定义导入器
 *
 * @author sqh
 * @create 2021-05-14 17:15
 */
public class MyImprotSelector implements ImportSelector {
    /*
    根据导入@ {@ link Configuration}类的{@link AnnotationMetadata}
    选择并返回要导入的类的名称
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //把String[]的元素合并到一个配置类中（通过properties文件导入需要的全类名）
        InputStream ras = MyImprotSelector.class.getClassLoader().getResourceAsStream("import.properties");

        Properties properties = new Properties();
        try {
            properties.load(ras);//加载到内存中
        } catch (IOException e) {
            e.printStackTrace();
        }
        String className = properties.getProperty("className");
//        return new String[]{className};//用于一个类的时候
        return className.split(",");//“,”作为分隔符

    }
}
