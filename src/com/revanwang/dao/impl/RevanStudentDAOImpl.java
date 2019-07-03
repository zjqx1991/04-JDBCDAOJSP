/**
 * 
 */
package com.revanwang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revanwang.dao.IRevanStudentDAO;
import com.revanwang.domain.RevanStudent;
import com.revanwang.jdbc.JdbcUtil;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 2, 20197:19:36 PM
 */
public class RevanStudentDAOImpl implements IRevanStudentDAO {

	@Override
	public void sava(RevanStudent student) {
		String sql = "INSERT INTO t_student (name, age) VALUES (?, ?)";
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
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			//4、执行SQL
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(connection, ps, null);
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_student WHERE id = ?";
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
			ps.setLong(1, id);
			//4、执行SQL
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(connection, ps, null);
		}
	}

	@Override
	public void update(RevanStudent student) {

		String sql = "UPDATE t_student SET name = ?, age = ? WHERE id = ?";
		//贾琏欲执事
		//获取连接对象
		Connection connection = null;
		//SQL语句对象
		PreparedStatement ps = null;
		
		try {
			//2、获取连接对象
			connection = JdbcUtil.getConnection();
			
			if (get(student.getId()) != null) {
				//3、获取执行SQL语句对象
				ps = connection.prepareStatement(sql);
				ps.setString(1, student.getName());
				ps.setInt(2, student.getAge());
				ps.setLong(3, student.getId());
				//4、执行SQL
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(connection, ps, null);
		}
	
	}

	@Override
	public RevanStudent get(Long id) {
		String sql = "SELECT * FROM t_student WHERE id = ?";
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
			ps.setLong(1, id);
			//4、执行SQL
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				RevanStudent student = new RevanStudent();
				student.setId(resultSet.getLong("id"));
				student.setName(resultSet.getString("name"));
				student.setAge(resultSet.getInt("age"));
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(connection, ps, resultSet);
		}
		return null;
	}

	/**
	 *
	 */
	@Override
	public List<RevanStudent> getList() {
		List<RevanStudent> list = new ArrayList<RevanStudent>();

		String sql = "SELECT * FROM t_student";
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
			//4、执行SQL
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				RevanStudent student = new RevanStudent();
				student.setId(resultSet.getLong("id"));
				student.setName(resultSet.getString("name"));
				student.setAge(resultSet.getInt("age"));
				list.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(connection, ps, resultSet);
		}
		return list;
	}

}
