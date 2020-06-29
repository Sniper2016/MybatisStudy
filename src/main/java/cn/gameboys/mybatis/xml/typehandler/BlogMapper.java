package cn.gameboys.mybatis.xml.typehandler;



public interface BlogMapper {
	// 插入数据
	int addBlog(Blog blog);

	// 根据id查询用户
	Blog getBlogById(String id);

	
	
    User getUserById(int id);
}
