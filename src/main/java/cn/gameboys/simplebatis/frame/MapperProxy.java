package cn.gameboys.simplebatis.frame;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.ibatis.reflection.ExceptionUtil;


/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月29日 下午3:20:37
 */
public class MapperProxy<T> implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			if (Object.class.equals(method.getDeclaringClass())) {
				return method.invoke(this, args);
			} else {
				return new MapperMethod().execute(method, args);
			}
		} catch (Throwable t) {
			throw ExceptionUtil.unwrapThrowable(t);
		}
	}

}
