package com.cts.bo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.vo.Admin;

import co.cts.dao.AdminStaffDAOImple;


@WebServlet("/Admin")
public class AdminBO extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminBO() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
		String email=(String)(request.getParameter("email"));
		String password=request.getParameter("password");
		String loginType=request.getParameter("loginType");
		System.out.println(loginType);
		
		HttpSession s=request.getSession(true);
		Admin a=new Admin();
		a.setEmail(email);
		a.setPassword(password);
		a.setLoginType(loginType);
		AdminStaffDAOImple ado=new AdminStaffDAOImple();
		
		int result=0;
		
		if(loginType.equalsIgnoreCase("A")) {
			result=ado.adminValidation(a);
		}
		
		if(loginType.equalsIgnoreCase("S")) {
			result=ado.staffValidation(a);
		}

		
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if(result==1)
		{
			
			s.setAttribute("ref", email);
			System.out.println(new Date(s.getCreationTime()));

			RequestDispatcher rd=request.getRequestDispatcher("adminHome.jsp");
			rd.forward(request, response);
			
		}
		else if(result==2)
		{
			s.setAttribute("ref", email);
			System.out.println(new Date(s.getCreationTime()));

			RequestDispatcher rd=request.getRequestDispatcher("staffHome.jsp");
			rd.forward(request, response);
		}
		else if(result==11)
		{

			s.setAttribute("ref", email);
			System.out.println(new Date(s.getCreationTime()));

			out.println("Your Admin request is Rejected");
		}
		else if(result==22)
		{
			s.setAttribute("ref", email);
			System.out.println(new Date(s.getCreationTime()));
			
			out.println("Your Staff request is Rejected");
		}
		else if(result==111)
		{
			s.setAttribute("ref", email);
			System.out.println(new Date(s.getCreationTime()));

			out.println("Your Admin request is pending for approval from Super User");
		}
		else if(result==222)
		{
			s.setAttribute("ref", email);
			System.out.println(new Date(s.getCreationTime()));

			out.println("Your Staff request is pending for approval from Admin");
		}
		else {
			s.setAttribute("ref", email);
			System.out.println(new Date(s.getCreationTime()));

			out.println("Your login type/your credentials is wrong");
		}
		}
		catch(Exception ex)
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			ex.printStackTrace();
		}
		
	}

}
