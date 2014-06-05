

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Myservlet
 */
@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myservlet() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie ck[]=request.getCookies();
		if(ck!=null){
		 String name=ck[0].getValue();
		if(!name.equals("")||name!=null){
			String uname=request.getParameter("username");
			String pwd=request.getParameter("pwd");
			String sname=request.getParameter("sname");
			String aname=request.getParameter("names");
			String date=request.getParameter("dob");
			String email=request.getParameter("email");
			String phone=request.getParameter("tel");
			String addr=request.getParameter("addr");
			String pin=request.getParameter("pin");
			out.println("username:"+uname+"</br>");
			out.println("password:"+pwd+"</br>");
			out.println("surname:"+sname+"</br>");
			out.println("anothername:"+aname+"</br>");
			out.println("date:"+date+"</br>");
			out.println("email:"+email+"</br>");
			out.println("phone:"+phone+"</br>");
			out.println("address:"+addr+"</br>");
			out.println("pin:"+pin+"</br>");
			out.println("Gender:"+request.getParameter("sex")+"</br>");
			String string[]=request.getParameterValues("vehicle");
			out.println("vehiacals names:");
			for(String s:string){
				out.println(s+" ");
			}
		    out.print("<html>");
			out.print("<body>");
			out.print("</br><a href=\"logout.html\">Logout</a>");
			out.print("</body>");
			out.print("</html>");
		}
		}else{
			out.print("Please login first");
			response.sendRedirect("login.html");
		}
		
	}

}
