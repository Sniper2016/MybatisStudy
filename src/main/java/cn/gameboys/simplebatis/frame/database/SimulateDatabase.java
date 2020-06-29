package cn.gameboys.simplebatis.frame.database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟数据库，通过key来返回字符串
 * 
 * @Description:
 * @author: www.gameboys.cn
 * @date:2020年6月29日 上午10:46:57
 */
public class SimulateDatabase {

	// map<key,value>
	private Map<String, String> data = new ConcurrentHashMap<String, String>();

	private static SimulateDatabase _ins = new SimulateDatabase();

	private SimulateDatabase() {
	}

	public static SimulateDatabase getIns() {
		return _ins;
	}

	public String getData(String key) {
		return data.get(key);
	}

	public void setData(String key, String value) {
		data.put(key, value);
	}

}
