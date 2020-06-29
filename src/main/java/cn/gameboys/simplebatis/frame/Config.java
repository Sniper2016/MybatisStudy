package cn.gameboys.simplebatis.frame;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.gameboys.simplebatis.frame.factory.DefaultObjectFactory;
import cn.gameboys.simplebatis.frame.factory.ObjectFactory;


/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月29日 下午3:20:10
 */
public class Config {

	// map<methodName,logic>
	private Map<String, String> sqlHandlerMap = new ConcurrentHashMap<String, String>();

	// 对象工厂
	private ObjectFactory objectFactory;

	private static Config _ins = new Config();

	private Config() {

	}

	public static Config getIns() {
		return _ins;
	}

	public void init() {
		// 这里初始化配置，暂时不需要
		objectFactory = new DefaultObjectFactory();
	}

	public void registConfig(Class<?> clazz) {
		Method[] methodArr = clazz.getDeclaredMethods();
		for (Method method : methodArr) {
			if (method.isAnnotationPresent(SqlLogicAnno.class)) {
				SqlLogicAnno an = method.getAnnotation(SqlLogicAnno.class);
				sqlHandlerMap.put(method.getName(), an.value());
			}
		}
	}

	public Map<String, String> getSqlHandlerMap() {
		return sqlHandlerMap;
	}

	public ObjectFactory getObjectFactory() {
		return objectFactory;
	}

}
