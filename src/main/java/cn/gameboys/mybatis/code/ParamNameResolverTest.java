package cn.gameboys.mybatis.code;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.reflection.ParamNameResolver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

public class ParamNameResolverTest {
	@Test
	public void test() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
		Configuration config = new Configuration();
		config.setUseActualParamName(false);
		Method method = UserMapper.class.getMethod("select", Integer.class, String.class, RowBounds.class, User.class);
		ParamNameResolver resolver = new ParamNameResolver(config, method);
		Field field = resolver.getClass().getDeclaredField("names");
		field.setAccessible(true);
		// 通过反射获取 ParamNameResolver 私有成员变量 names
		Object names = field.get(resolver);
		System.out.println("names: " + names);
	}

	class UserMapper {
		public void select(@Param("id") Integer id, @Param("name") String author, RowBounds rb, User user) {
		}
	}
}
