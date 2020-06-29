package cn.gameboys.simplebatis.frame.invoke;

import java.lang.reflect.InvocationTargetException;


/**
 * 
* @Description: 
* @author:www.gameboys.cn
* @date:2020年6月29日 下午3:19:40
 */
public interface Invoker {
	  Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException;

	  Class<?> getType();
}
