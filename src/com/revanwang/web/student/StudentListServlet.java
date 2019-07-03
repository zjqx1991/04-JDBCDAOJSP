/**
 * 
 */
package com.revanwang.web.student;

import java.io.IOException;
import java.util.List;

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
 * @Date Jul 3, 20192:39:02 PM
 */
@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final IRevanStudentDAO studentDAO = new RevanStudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取请求参数，封装成对象
		//2、处理业务请求
		List<RevanStudent> list = this.studentDAO.getList();
		req.setAttribute("list", list);
		//3、跳转界面
		req.getRequestDispatcher("/WEB-INF/JSP/student/studentList.jsp").forward(req, resp);
	}

}
