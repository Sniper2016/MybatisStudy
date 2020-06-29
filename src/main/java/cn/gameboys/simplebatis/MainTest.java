package cn.gameboys.simplebatis;

import cn.gameboys.simplebatis.frame.Config;
import cn.gameboys.simplebatis.frame.MapperProxyFactory;
import cn.gameboys.simplebatis.frame.database.CodecUtil;
import cn.gameboys.simplebatis.frame.database.SimulateDatabase;

/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月29日 下午3:21:06
 */
public class MainTest {

	public static void main(String[] args) {

		// 先向数据库插入数据， 方便查，格式自己定义。
		String key = CodecUtil.getKey("select", TestBean.class.getName(), new String[] { "1" });
		SimulateDatabase.getIns().setData(key, "id:1-name:gameboys");

		String key2 = CodecUtil.getKey("select", Student.class.getName(), new String[] { "sniper" });
		SimulateDatabase.getIns().setData(key2, "name:sniper-studing:true");

		
		// 模拟初始化配置，由于懒得解析xml，这里直接使用json+注解搞定
		Config.getIns().init();
		Config.getIns().registConfig(TestBeanMapper.class);
		Config.getIns().registConfig(StudentMapper.class);
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("测试TestBean开始------------------------");
		TestBeanMapper mapper = new MapperProxyFactory<TestBeanMapper>(TestBeanMapper.class).newInstance();
		// 模拟查找
		TestBean bean = mapper.select(1);
		System.out.println("从数据库查询的结果为:"+bean);
		//测试object的默认方法是否OK
		System.out.println(mapper.hashCode());

		// 模拟插入
		mapper.insert(666, "i love gameboys");
		
		System.out.println("测试TestBean结束------------------------");
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("测试StudentMapper开始------------------------");
		//测试studentMapper
		StudentMapper studentMapper = new MapperProxyFactory<StudentMapper>(StudentMapper.class).newInstance();
		// 模拟查找
		Student student = studentMapper.select("sniper");
		System.out.println("从数据库查询的结果为:"+student);

		// 模拟插入
		studentMapper.insert("sniper2", false);

	}

}
