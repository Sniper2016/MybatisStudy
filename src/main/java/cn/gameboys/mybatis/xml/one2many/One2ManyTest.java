package cn.gameboys.mybatis.xml.one2many;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.gameboys.mybatis.utils.MyBatisUtils;

/**
 * 
* @Description: 一对多查询
* @author: (1084038709@qq.com)
* @date:2020年6月24日 上午10:50:23
 */
public class One2ManyTest {
	
    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        Teacher2 teacher = sqlSession.getMapper(TeacherMapper2.class).getTeacher(1);
        System.out.println(teacher);
        /*
        * Teacher
        * (id=1, name=秦老师,
        * students=[Student(id=1, name=小明, tid=1),
        * Student(id=2, name=小红, tid=1), Student(id=3, name=小张, tid=1),
        * Student(id=4, name=小李, tid=1), Student(id=5, name=小王, tid=1)])
         * */
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        Teacher2 teacher = sqlSession.getMapper(TeacherMapper2.class).getTeacher2(1);
        System.out.println(teacher);

        sqlSession.close();
    }
}
