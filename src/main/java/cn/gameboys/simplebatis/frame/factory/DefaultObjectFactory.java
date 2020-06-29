package cn.gameboys.simplebatis.frame.factory;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.ibatis.reflection.ReflectionException;

/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月29日 下午3:19:17
 */
public class DefaultObjectFactory implements ObjectFactory, Serializable {

	private static final long serialVersionUID = -8855120656740914948L;

	@Override
	public <T> T create(Class<T> type) {
		return create(type, null, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		Class<?> classToCreate = resolveInterface(type);
		// we know types are assignable
		return (T) instantiateClass(classToCreate, constructorArgTypes, constructorArgs);
	}

	private <T> T instantiateClass(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		try {
			Constructor<T> constructor;
			if (constructorArgTypes == null || constructorArgs == null) {
				constructor = type.getDeclaredConstructor();
				try {
					return constructor.newInstance();
				} catch (IllegalAccessException e) {

					throw e;

				}
			}
			constructor = type.getDeclaredConstructor(constructorArgTypes.toArray(new Class[0]));
			try {
				return constructor.newInstance(constructorArgs.toArray(new Object[0]));
			} catch (IllegalAccessException e) {

				throw e;

			}
		} catch (Exception e) {

			throw new ReflectionException("Error instantiating Cause: " + e, e);
		}
	}

	protected Class<?> resolveInterface(Class<?> type) {
		Class<?> classToCreate;
		if (type == List.class || type == Collection.class || type == Iterable.class) {
			classToCreate = ArrayList.class;
		} else if (type == Map.class) {
			classToCreate = HashMap.class;
		} else if (type == SortedSet.class) { // issue #510 Collections Support
			classToCreate = TreeSet.class;
		} else if (type == Set.class) {
			classToCreate = HashSet.class;
		} else {
			classToCreate = type;
		}
		return classToCreate;
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		return Collection.class.isAssignableFrom(type);
	}
}
