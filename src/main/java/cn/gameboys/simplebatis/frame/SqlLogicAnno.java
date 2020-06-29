package cn.gameboys.simplebatis.frame;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * 具体的逻辑，代替mybatis的xml配置
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月28日 下午5:48:41
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlLogicAnno {
	
	String value() default "{}";

}
