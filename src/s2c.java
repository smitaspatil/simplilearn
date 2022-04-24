

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class s2c
 */
public class s2c extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s2c() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String c=request.getParameter("cl");
		String s=request.getParameter("sub");
		if(c.equals("select")&& s.equals("select"))
		{
			out.println("please select valid option");

		}
		else
		{
	    //out.println("u r selected:"+c);
	//	out.println("and" +s);
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/academy", "root", "root");
				Statement st=con.createStatement();

				if(con!=null) {
					//out.println("connection established");
					String sql="insert into class values('"+c+"','"+s+"')";
					int row=st.executeUpdate(sql);
					if(row>0){
						response.sendRedirect("success.html");
					}
					else {
						System.out.println("not inserted ");
					}
					
					con.close();

				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

}
