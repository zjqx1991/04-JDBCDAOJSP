/**
 * 
 */
package com.revanwang.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revanwang.jdbc.JdbcUtil;
import com.revanwang.template.resulthandle.IResultHandle;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 3, 201911:16:32 AM
 */
public class JdbcTemplate {

	//私有化构造器
	private JdbcTemplate() {
	}

	//DML查询语言
	public static int update(String sql, Object...params) {
		//贾琏欲执事
		//获取连接对象
		Connection connection = null;
		//SQL语句对象
		PreparedStatement ps = null;

		try {
			//2、获取连接对象
			connection = JdbcUtil.getConnection();
			//3、获取执行SQL语句对象
			ps = connection.prepareStatement(sql);
			//4、设置参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			//4、执行SQL
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, ps, null);
		}
		
		return 0;
	}
	
	public static <T>T query(String sql, IResultHandle<T> resHandle, Object...params) {
		//贾琏欲执事
		//获取连接对象
		Connection connection = null;
		//SQL语句对象
		PreparedStatement ps = null;
		//结果集
		ResultSet resultSet = null; 
		
		try {
			//2、获取连接对象
			connection = JdbcUtil.getConnection();
			//3、获取执行SQL语句对象
			ps = connection.prepareStatement(sql);
			//设置参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			//4、执行SQL
			resultSet = ps.executeQuery();
			//5、处理结果集
			return resHandle.resultHandle(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(connection, ps, resultSet);
		}
		return null;
	}
}
