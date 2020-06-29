package cn.gameboys.simplebatis.frame.database;

import java.util.HashMap;
import java.util.Map;

/**
 * 编解码工具
 * 
 * @Description:
 * @author: www.gameboys.cn
 * @date:2020年6月29日 上午10:56:32
 */
public class CodecUtil {

	public static String getKey(String handle, String returnObject, Object[] args) {
		String key = handle + "-" + returnObject;
		for (Object arg : args) {
			key = key + "-" + arg;
		}
		return key;
	}

	/**
	 * 将结果解析出来
	 * 
	 * @param value
	 * @return
	 */
	public static Map<String, String> decodeValue(String value) {
		Map<String, String> result = new HashMap<String, String>();
		String[] propertyArr = value.split("-");
		for (String string : propertyArr) {
			String[] arr = string.split(":");
			result.put(arr[0], arr[1]);	
		}
	//	System.out.println(result);
		// id:1-name:gameboys
		return result;
	}

}
