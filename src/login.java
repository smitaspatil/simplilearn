

import java.io.IOException;
import java.io.PrintWriter;



//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	 String n=request.getParameter("nm");
	 String p=request.getParameter("pwd");
	 
	 
	 boolean isValid=false;
	 if(n.equals("admin")&& p.equals("admin123"))
	 {
		 HttpSession s=request.getSession();
		 s.setAttribute("userid", n);
		 isValid=true;
	 }
		 if(isValid==true)
			{
				response.sendRedirect("Dashboard.html");
			}else {
				out.println("please enter valid username and password");
			}

		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
