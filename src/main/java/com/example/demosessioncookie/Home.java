package com.example.demosessioncookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Home() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");
            if (account != null) {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                //chua dang nhap
                //kiem tra cookie
                Cookie[] cookies = request.getCookies();
                String username = null;
                String password = null;
                for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("username")) {
                        username = cooky.getValue();
                    }
                    if (cooky.getName().equals("password")) {
                        password = cooky.getValue();
                    }
                    if (username != null && password != null) {
                        break;
                    }
                }
                if (username != null && password != null && username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234")) {
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                    return;
                }
                response.sendRedirect("login");
            }
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
