package cn.gameboys.mybatis.annotation;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Select(value = "select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有的参数前面必须加上@Param注解
    @Select("select * from user where id = #{id} or name = #{name}")
    User getUserByID(@Param("id")int id,@Param("name")String name);

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    @Update("update user set name = #{name},pwd = #{pwd} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);
}
