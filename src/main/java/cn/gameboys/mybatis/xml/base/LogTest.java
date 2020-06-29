package cn.gameboys.mybatis.xml.base;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.gameboys.mybatis.utils.MyBatisUtils;

public class LogTest {
	static Logger logger = Logger.getLogger(SimpleTest.class);

	@Test
	public void getUserByRowBounds() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		// RowBounds实现
		RowBounds rowBounds = new RowBounds(1, 2);

		// 通过java代码层面实现分页
		List<User> userList = sqlSession.selectList("cn.gameboys.mybatis.xml.base.UserMapper.getUserByRowBounds", null, rowBounds);

		for (User user : userList) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void getUserByLimit() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("startIndex", 0);
		map.put("pageSize", 2);

		List<User> userList = mapper.getUserByLimit(map);
		for (User user : userList) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void test() {
		// 第一步：获得SqlSession对象
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		logger.info("测试，进入test方法成功");
		try {
			// 方式一：getMapper
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = mapper.getUserById(1);

			System.out.println(user);

		} finally {
			// 关闭SqlSession
			sqlSession.close();
		}
	}

	@Test
	public void testLog4j() {
		logger.info("info:进入了testLog4j方法");
		logger.debug("debug:进入了testLog4j");
		logger.error("error:进入了testLog4j");
	}
}
