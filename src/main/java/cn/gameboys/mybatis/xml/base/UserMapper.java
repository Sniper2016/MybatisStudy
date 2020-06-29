package cn.gameboys.mybatis.xml.base;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //万能Map
    int addUser2(Map<String,Object> map);

    //insert一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);
    

    //分页
    List<User> getUserByLimit(Map<String,Integer> map);
    //分页2
    List<User> getUserByRowBounds();
    
    
}
