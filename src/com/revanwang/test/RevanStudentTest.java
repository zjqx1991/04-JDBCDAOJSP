/**
 * 
 */
package com.revanwang.test;


import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.revanwang.dao.IRevanStudentDAO;
import com.revanwang.dao.impl.RevanStudentDAOImpl;
import com.revanwang.domain.RevanStudent;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 2, 20197:32:18 PM
 */
public class RevanStudentTest {

	IRevanStudentDAO studentDAO = new RevanStudentDAOImpl();
	
	@Test
	public void testSave() {
		RevanStudent student = new RevanStudent();
		student.setName("陈乔恩");
		student.setAge(33);
		studentDAO.sava(student);
	}
	
	@Test
	public void testDelete() {
		studentDAO.delete(38L);
	}
	
	@Test
	public void testUpdate() {
		RevanStudent student = new RevanStudent();
		student.setId(41L);
		student.setAge(40);
		student.setName("东方不败");
		studentDAO.update(student);
	}
	
	@Test
	public void testGet() {
		RevanStudent student = studentDAO.get(15L);
		System.out.println(student.toString());
	}
	
	@Test
	public void testGetList() {
		List<RevanStudent> list = studentDAO.getList();
		Iterator<RevanStudent> it= list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
