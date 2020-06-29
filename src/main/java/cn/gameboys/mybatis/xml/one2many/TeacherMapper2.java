package cn.gameboys.mybatis.xml.one2many;

import org.apache.ibatis.annotations.Param;

public interface TeacherMapper2 {

	// 获取指定老师下的所有学生及老师的信息
	Teacher2 getTeacher(@Param("tid") int id);

	Teacher2 getTeacher2(@Param("tid") int id);
}
