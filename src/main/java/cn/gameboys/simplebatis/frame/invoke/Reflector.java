package cn.gameboys.simplebatis.frame.invoke;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * 
* @Description: 
* @author:www.gameboys.cn
* @date:2020年6月29日 下午3:20:01
 */
public class Reflector {

	
	private final Map<String, Invoker> setMethods = new HashMap<>();

	public Reflector(Class<?> clazz) {
		addSetMethods(clazz);
	}

	public Invoker getSetInvoker(String propertyName) {
		Invoker method = setMethods.get(propertyName);
		return method;
	}

	private void addSetMethods(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		// 这里检测是否是setter方法，如果是，装起来,暂时不检测各种异常
		for (Method method : methods) {
			if (PropertyNamer.isSetter(method.getName())) {
				String property = PropertyNamer.methodToProperty(method.getName());
				addSetMethod(property, method);
			}
		}
	}

	private void addSetMethod(String name, Method method) {
		MethodInvoker invoker = new MethodInvoker(method);
		setMethods.put(name, invoker);
	}

}
