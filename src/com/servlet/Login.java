package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("userName");
		String password=request.getParameter("password");

        try {
            if (LoginData.validate(username,password)) {
            	System.out.println("successfully logged in...");
            	request.getRequestDispatcher("welcome.jsp").forward(request, response);
            	
            } else {
            	System.out.println("username or passwprd incorrect");
            	request.getRequestDispatcher("login.jsp").include(request, response);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

}
	
		
	}

