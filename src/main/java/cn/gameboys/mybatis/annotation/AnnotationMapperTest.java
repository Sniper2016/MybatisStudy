package cn.gameboys.mybatis.annotation;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.gameboys.mybatis.utils.MyBatisUtils;

public class AnnotationMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      /*  List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }*/
      /*  User user = mapper.getUserByID(1, "狂神");
        System.out.println(user);*/
        mapper.addUser(new User(5,"Hello","123123"));
        mapper.updateUser(new User(5,"to","21231"));
       // mapper.deleteUser(5);
        User user =  mapper.getUserByID(5, "aaa");
        
        System.out.println(user);
        
        sqlSession.close();
    }
}
