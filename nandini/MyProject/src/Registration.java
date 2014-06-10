

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String uname=request.getParameter("t1");
		System.out.println(uname);
		
		String pw=request.getParameter("t2");
		System.out.println(pw);
		
		String db=request.getParameter("dob");
		System.out.println(db);
		
		String gen=request.getParameter("r1");
		System.out.println(gen);
		
		String contno=request.getParameter("t3");
		System.out.println(contno);
		
		String eid=request.getParameter("t4");
		System.out.println(eid);
		
		String add=request.getParameter("address");
		System.out.println(add);
		
		String pcode=request.getParameter("t5");
		System.out.println(pcode);
		
		String country=request.getParameter("countrylist");
		System.out.println(country);
		
		String state=request.getParameter("statelist");
		System.out.println(state);
		
		String city=request.getParameter("citylist");
		System.out.println(city);
		
		RequestDispatcher dis=request.getRequestDispatcher("Login.html");
		dis.forward(request, response);
	}

}
