package cn.gameboys.simplebatis.frame.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月29日 下午3:19:47
 */
public class MethodInvoker implements Invoker {

	private final Class<?> type;
	private final Method method;

	public MethodInvoker(Method method) {
		this.method = method;
		if (method.getParameterTypes().length == 1) {
			type = method.getParameterTypes()[0];
		} else {
			type = method.getReturnType();
		}
	}

	@Override
	public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
		try {
			return method.invoke(target, args);
		} catch (IllegalAccessException e) {

			throw e;

		}
	}

	@Override
	public Class<?> getType() {
		return type;
	}
}
