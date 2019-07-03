/**
 * 
 */
package com.revanwang.web.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revanwang.dao.IRevanStudentDAO;
import com.revanwang.dao.impl.RevanStudentDAOImpl;
import com.revanwang.domain.RevanStudent;

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 3, 20194:16:25 PM
 */
@WebServlet("/student/save")
public class StudentSaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IRevanStudentDAO studentDAO = new RevanStudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取请求参数
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");

		System.out.println("获取id信息==" + id);
		System.out.println("获取id信息==" + name);
		System.out.println("获取id信息==" + age);
		//2、处理业务
		RevanStudent student = new RevanStudent();
		if (hasLength(name)) {			
			student.setName(name);
		}
		if (hasLength(age)) {
			student.setAge(Integer.valueOf(age));			
		}
		if (hasLength(id)) {
			//编辑
			student.setId(Long.valueOf(id));
			studentDAO.update(student);
		}
		else {
			studentDAO.sava(student);
		}
		//3、跳转页面
		resp.sendRedirect("/student/list");
	}

	private boolean hasLength(String string) {
		return string != null && string.length()>0;
	} 
	
}
