package cn.gameboys.simplebatis;

import cn.gameboys.simplebatis.frame.SqlLogicAnno;

/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月29日 下午3:21:12
 */
public interface TestBeanMapper {

	@SqlLogicAnno(value = "select * from user where id=?;")
	TestBean select(int id);

	@SqlLogicAnno(value = "insert into user(id,name) values('?','?');")
	void insert(int id, String name);

}
