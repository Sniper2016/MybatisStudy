package cn.gameboys.simplebatis.frame;

import java.lang.reflect.Method;
import java.util.Map;

import cn.gameboys.simplebatis.frame.database.CodecUtil;
import cn.gameboys.simplebatis.frame.database.SimulateDatabase;
import cn.gameboys.simplebatis.frame.invoke.Invoker;
import cn.gameboys.simplebatis.frame.invoke.Reflector;


/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月29日 下午3:20:21
 */
public class MapperMethod {

	public Object execute(Method method, Object[] args) throws Exception, IllegalAccessException {

		Object result = null;
		Class<?> returnType = method.getReturnType();
		String logicStr = Config.getIns().getSqlHandlerMap().get(method.getName());

		String realSql = logicStr;

		switch (method.getName()) {
		case "select":
			// 拼接sql：
			String key = CodecUtil.getKey("select", returnType.getName(), args);
			for (Object arg : args) {
				realSql = realSql.replaceFirst("\\?", String.valueOf(arg));
			}
			System.out.println("执行查询操作，sql为：" + realSql);
			String value = SimulateDatabase.getIns().getData(key);
			System.out.println("查询的key为：" + key + " 数据库返回的value:" + value);
			if (value == null) {
				System.err.println("SimulateDatabase 数据库未查询到数据，请设置。");
				return null;
			}
			// 创建返回对象，
			result = Config.getIns().getObjectFactory().create(returnType);
			
			// 使用对象的set方法将属性填充
			// 先解析数据库资源成为一个map方便下面方法调用填充
			Map<String, String> rspResult = CodecUtil.decodeValue(value);

			Reflector reflector = new Reflector(returnType);
			for (String propertyKey : rspResult.keySet()) {
				Invoker invoker = reflector.getSetInvoker(propertyKey);
				Object paramObj = null;
				switch (invoker.getType().getSimpleName()) {
				case "String":
					paramObj = rspResult.get(propertyKey);
					break;
				case "int":
					paramObj = Integer.valueOf(rspResult.get(propertyKey));
					break;
				case "boolean":
					paramObj = Boolean.valueOf(rspResult.get(propertyKey));
					break;	

				default:
					System.out.println("当前类型参数未知，请先注册。"+invoker.getType().getSimpleName());
					break;
				}
				invoker.invoke(result, new Object[] { paramObj });
			}
			break;
		case "insert":
			// insert操作暂时不处理，与mybatis无关。
			for (Object arg : args) {
				realSql = realSql.replaceFirst("\\?", String.valueOf(arg));
			}
			System.out.println("执行插入操作，sql为：" + realSql);
			result = true;
			break;
		default:
			break;
		}
		return result;
	}

}
