package cn.gameboys.simplebatis;

import cn.gameboys.simplebatis.frame.SqlLogicAnno;

/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月29日 下午3:21:12
 */
public interface StudentMapper {

	@SqlLogicAnno(value = "select * from student where name='?';")
	Student select(String name);

	@SqlLogicAnno(value = "insert into user(name,studing) values('?','?');")
	void insert(String name, boolean isStuding);

}
