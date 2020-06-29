package cn.gameboys.mybatis.xml.cache;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.gameboys.mybatis.utils.MyBatisUtils;

public class CacheTest {
    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();


        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);
        sqlSession2.close();


    }
}
