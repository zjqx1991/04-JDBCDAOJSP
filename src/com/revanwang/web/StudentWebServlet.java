/**
 * 
 */
package com.revanwang.web;

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
 * @Date Jul 3, 20194:42:01 PM
 */
@WebServlet("/student/web")
public class StudentWebServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	IRevanStudentDAO studentDAO = new RevanStudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//1、获取请求参数
		String cmd = req.getParameter("cmd");
		System.out.println("web="+cmd);
		//2、分发处理业务
		if (cmd != null) {
			switch (cmd) {
			case "add":
				edit(req, resp);
				break;
				
			case "delete":
				delete(req, resp);
				break;
					
			case "edit":
				edit(req, resp);
				break;
			case "save":
				save(req, resp);
				break;
			default:
				list(req, resp);
				break;
			}
		}
		else {
			list(req, resp);
		}
	}
	
	protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取请求参数
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		System.out.println("id:"+id+"name:"+name+"age:"+age);
		
		//2、处理业务请求
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
		//3、跳转界面
		resp.sendRedirect("/student/web");
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取请求参数
		String id = req.getParameter("id");
		//2、处理业务
		studentDAO.delete(Long.valueOf(id));
		//3、跳转界面
		resp.sendRedirect("/student/web");
	}
	
	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取请求参数
		String idString = req.getParameter("id");
		//2、处理业务请求
		RevanStudent student = null;
		if (hasLength(idString)) {
			student = studentDAO.get(Long.valueOf(idString));
		}
		//3、跳转界面
		req.setAttribute("student", student);
		req.getRequestDispatcher("/WEB-INF/JSP/student/studentEdit.jsp").forward(req, resp);
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取请求参数
		//2、处理业务
		List<RevanStudent> list = studentDAO.getList();
		req.setAttribute("list", list);
		//3、跳转界面
		req.getRequestDispatcher("/WEB-INF/JSP/student/studentList.jsp").forward(req, resp);
	}


	private boolean hasLength(String string) {
		return string != null && string.length()>0;
	} 
}
