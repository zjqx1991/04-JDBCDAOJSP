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
 * @Date Jul 3, 20194:02:08 PM
 */
@WebServlet("/student/edit")
public class StudentEditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IRevanStudentDAO studentDAO = new RevanStudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取参数
		String idString = req.getParameter("id");
		RevanStudent student = null;
		//2、处理业务请求
		if (idString != null) {
			student = studentDAO.get(Long.valueOf(idString));			
		}
		//3、跳转界面
		req.setAttribute("student", student);
		req.getRequestDispatcher("/WEB-INF/JSP/student/studentEdit.jsp").forward(req, resp);
	}

}
