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

/**
 * @Desc 	
 * @author Revan Wang
 *
 * @Date Jul 3, 20193:50:09 PM
 */
@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final IRevanStudentDAO studentDAO = new RevanStudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1、获取请求参数，封装成对象
		String idString = req.getParameter("id");
		//2、处理业务
		studentDAO.delete(Long.valueOf(idString));
		//3、跳转界面
		resp.sendRedirect("/student/list");
	}

}
