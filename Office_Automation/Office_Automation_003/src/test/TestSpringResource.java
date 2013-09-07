package test;

import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import com.dolph.annotations.Oper;
import com.dolph.annotations.Res;

public class TestSpringResource extends TestCase {
	
	public void test1(){
		try {
			String path="com/dolph/web/**/*Action.class";
			ResourcePatternResolver reslver=new PathMatchingResourcePatternResolver();
			//得到所有Action资源集合
			Resource[] res=reslver.getResources(path);
			System.out.println(res.length);
			//MetadataReaderFactory和MetadataReader(传入一个Action资源)
			MetadataReaderFactory metaFactory=new CachingMetadataReaderFactory();
			MetadataReader metaReader=metaFactory.getMetadataReader(res[2]);
			//用metaReader分别得到classMetaData和annotationMetaData
			ClassMetadata classMetaData=metaReader.getClassMetadata();
			AnnotationMetadata annotationMetaData=metaReader.getAnnotationMetadata();
			
			System.out.println(classMetaData.getClassName());
			//得到注解类的属性值, 存放入Map中,<属性名,属性值>
			Map resAttrs=annotationMetaData.getAnnotationAttributes(Res.class.getName());
			System.out.println(resAttrs.size());
			//得到注解的方法
			Set<MethodMetadata> mmds=annotationMetaData.getAnnotatedMethods(Oper.class.getName());
			for(MethodMetadata m:mmds){
				System.out.println(m.getMethodName());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
