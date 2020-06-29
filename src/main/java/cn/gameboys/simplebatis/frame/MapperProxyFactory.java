package cn.gameboys.simplebatis.frame;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月29日 下午3:20:51
 */
public class MapperProxyFactory<T> {

	private final Class<T> mapperInterface;
	private final Map<Method, MapperMethodInvoker> methodCache = new ConcurrentHashMap<>();

	public MapperProxyFactory(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	public Class<T> getMapperInterface() {
		return mapperInterface;
	}

	public Map<Method, MapperMethodInvoker> getMethodCache() {
		return methodCache;
	}

	@SuppressWarnings("unchecked")
	protected T newInstance(MapperProxy<T> mapperProxy) {
		return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy);
	}

	public T newInstance() {
		final MapperProxy<T> mapperProxy = new MapperProxy<>();
		return newInstance(mapperProxy);
	}

}
