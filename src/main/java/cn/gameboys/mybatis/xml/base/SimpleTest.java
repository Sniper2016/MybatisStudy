package cn.gameboys.mybatis.xml.base;

import cn.gameboys.mybatis.utils.MyBatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class SimpleTest {
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try{
            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            //方式二：
            //List<User> userList = sqlSession.selectList("cn.gameboys.mybatis.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }

        }
        finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    //曾删改需要提交事务
 //   @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4, "哈哈", "123333"));
        if (res>0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    //万能map
//    @Test
    public void addUser2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",4);
        map.put("userName","王五");
        map.put("password","23333");
        mapper.addUser2(map);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

//    @Test
    public void updateUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"呵呵","123123"));
        sqlSession.commit();
        sqlSession.close();
    }

 //   @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }
}
