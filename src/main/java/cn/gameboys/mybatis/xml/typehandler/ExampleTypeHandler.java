package cn.gameboys.mybatis.xml.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.alibaba.fastjson.JSON;

/**
 * 注意：--》这里设置typeHanlder之后，所有的list转varchar和varchar转list的映射都走这个方法。
 * 
 * 查看包下 org.apache.ibatis.type 都是预先设定好的typeHandler
 * 
 * @Description:
 * @author: sniper(1084038709@qq.com)
 * @date:2020年6月24日 下午12:13:51
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(value = List.class)
public class ExampleTypeHandler extends BaseTypeHandler<List<String>> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
		// 通过fastJSON将list转换成string
		ps.setString(i, JSON.toJSONString(parameter));
	}

	@Override
	public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String oldStr = rs.getString(columnName);
		if (oldStr != null) {
			return JSON.parseArray(oldStr, String.class);
		}
		return null;
	}

	@Override
	public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String oldStr = rs.getString(columnIndex);
		if (oldStr != null) {
			return JSON.parseArray(oldStr, String.class);
		}
		return null;
	}

	@Override
	public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String oldStr = cs.getString(columnIndex);
		if (oldStr != null) {
			return JSON.parseArray(oldStr, String.class);
		}
		return null;
	}

}
