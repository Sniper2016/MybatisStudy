package cn.gameboys.simplebatis.frame.factory;

import java.util.List;


/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月29日 下午3:19:26
 */
public interface ObjectFactory {

	/**
	 * Creates a new object with default constructor.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param type
	 *            Object type
	 * @return the t
	 */
	<T> T create(Class<T> type);

	/**
	 * Creates a new object with the specified constructor and params.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param type
	 *            Object type
	 * @param constructorArgTypes
	 *            Constructor argument types
	 * @param constructorArgs
	 *            Constructor argument values
	 * @return the t
	 */
	<T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs);

	/**
	 * Returns true if this object can have a set of other objects. It's main
	 * purpose is to support non-java.util.Collection objects like Scala
	 * collections.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param type
	 *            Object type
	 * @return whether it is a collection or not
	 * @since 3.1.0
	 */
	<T> boolean isCollection(Class<T> type);
}
