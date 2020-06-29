package cn.gameboys.mybatis.xml.typehandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.gameboys.mybatis.utils.IDUtils;
import cn.gameboys.mybatis.utils.MyBatisUtils;

public class TypeHandlerTest {

	@Test
	public void test() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		Blog blog = new Blog();
		blog.setId(IDUtils.getId());
		blog.setTitle("Mybatis如此简单");

		List<String> list = new ArrayList<String>();
		list.add("sniper");
		list.add("gameboys");
		blog.setAuthor(list);
		blog.setCreatTime(new Date());
		blog.setViews(666);

		mapper.addBlog(blog);

		sqlSession.commit();

		
		Blog blog2 = mapper.getBlogById(blog.getId());

		System.out.println("blog2:" + blog2.getAuthor());

		//这里需要将user表里面id==1的记录pwd改成[1,2,3]，否则会报错。
		User user = mapper.getUserById(1);

		System.out.println(user);

		sqlSession.close();
	}

}
