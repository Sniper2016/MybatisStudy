package cn.gameboys.simplebatis.frame;

import java.lang.reflect.Method;


/**
 * 
* @Description: 
* @author:www.gameboys.cn
* @date:2020年6月29日 下午3:20:30
 */
public interface MapperMethodInvoker {
	Object invoke(Object proxy, Method method, Object[] args);
}
