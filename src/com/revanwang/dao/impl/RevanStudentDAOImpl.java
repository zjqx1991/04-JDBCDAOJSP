/**
 * 
 */
package com.revanwang.dao.impl;

import java.util.List;

import com.revanwang.dao.IRevanStudentDAO;
import com.revanwang.domain.RevanStudent;
import com.revanwang.template.JdbcTemplate;
import com.revanwang.template.resulthandle.impl.ListResultHandle;

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
		JdbcTemplate.update(sql, student.getName(), student.getAge());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_student WHERE id = ?";
		JdbcTemplate.update(sql, id);
	}

	@Override
	public void update(RevanStudent student) {

		String sql = "UPDATE t_student SET name = ?, age = ? WHERE id = ?";
		JdbcTemplate.update(sql, student.getName(), student.getAge(), student.getId());
	}

	@Override
	public RevanStudent get(Long id) {
		String sql = "SELECT * FROM t_student WHERE id = ?";
		List<RevanStudent> list = JdbcTemplate.query(sql, new ListResultHandle<>(RevanStudent.class), id);
		return list.size() == 1 ? list.get(0) : null;
	}

	/**
	 *
	 */
	@Override
	public List<RevanStudent> getList() {
		String sql = "SELECT * FROM t_student";
		return JdbcTemplate.query(sql, new ListResultHandle<>(RevanStudent.class));
	}

}
