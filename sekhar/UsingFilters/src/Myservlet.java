import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Myservlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession hs=request.getSession();
		try{
			String session=hs.getAttribute("uname").toString();
			if(session!=null){
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
				out.print("</br><a href=\"./Logout\">Logout</a>");
				out.print("</body>");
				out.print("</html>");
			}

			else
			{
				out.print("Please login first");
				response.sendRedirect("./LoginPage");
			}
		}
		catch(NullPointerException e){
			out.print("Please login first or Session expire");
			response.sendRedirect("./LoginPage");
		}

	}

}
