/**
 * 
 */
package com.revanwang.dao;

import java.util.List;

import com.revanwang.domain.RevanStudent;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 2, 20197:19:07 PM
 */
public interface IRevanStudentDAO {

	/**
	 * @Desc 保存学生信息
	 * @param student 学生对象
	 * @auther Revan Wang
	 * @Date Jul 2, 20197:20:29 PM
	 */
	void sava(RevanStudent student);
	
	/**
	 * @Desc 删除学生
	 * @param id 被删除学生id
	 * @auther Revan Wang
	 * @Date Jul 2, 20197:21:04 PM
	 */
	void delete(Long id);
	
	/**
	 * @Desc 更新学生信息
	 * @param student
	 * @auther Revan Wang
	 * @Date Jul 2, 20197:23:25 PM
	 */
	void update(RevanStudent student);
	
	/**
	 * @Desc 获取指定id的学生信息
	 * @param id
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 2, 20197:24:33 PM
	 */
	RevanStudent get(Long id);
	
	/**
	 * @Desc 获取所有的学生
	 * @return
	 * @auther Revan Wang
	 * @Date Jul 2, 20197:25:11 PM
	 */
	List<RevanStudent> getList();
}
