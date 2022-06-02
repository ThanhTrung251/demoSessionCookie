package com.example.demosessioncookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Boolean remember = Boolean.parseBoolean(request.getParameter("remember"));

		HttpSession session = request.getSession(); //lấy session trên server
		if (username.equals("admin") && password.equals("1234")) {//đăng nhập thành công
			
			session.setAttribute("account", new Account(username, password));//lưu vào session
			if(remember){
				//ghi cookie
				Cookie uCookie = new Cookie("username", username);//tạo đối tượng cookie
				uCookie.setMaxAge(20);//thời gian sống của cookie
				Cookie pCookie = new Cookie("password", password);
				pCookie.setMaxAge(20);
				response.addCookie(uCookie);//ghi cookie vao may client
				response.addCookie(pCookie);
			}
			response.sendRedirect("home");
		} else {//đăng nhập ko thành công
			request.setAttribute("err", "Login failed!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
