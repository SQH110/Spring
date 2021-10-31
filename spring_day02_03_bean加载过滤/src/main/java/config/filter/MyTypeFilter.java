package config.filter;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义组件过滤器
 *
 * @author sqh
 * @create 2021-05-14 16:56
 */
public class MyTypeFilter implements TypeFilter {

    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
//        return false;//true：所有的都被过滤，而false：所有的都不过滤（默认false）

        /*
        当条件满足时就被过滤，不满足时则无法通过
        形参中可以拿到元数据MetadataReader、MetadataReaderFactory
         */
        ClassMetadata classMetadata = metadataReader.getClassMetadata();//读取基础类的基本类元数据
        String className = classMetadata.getClassName();//返回基础类的名称
        System.out.println(className);
        if(className.equals("com.itheima.service.impl.UserServiceImpl")) {
            return true;
        }
        return  false;

    }
}
