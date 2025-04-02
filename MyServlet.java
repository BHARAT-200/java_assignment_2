import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		System.out.println("hi from web");
		String n1 = request.getParameter("n1");  // To get a value from HTML page, parameter is the name field in HTML
		String n2 = request.getParameter("n2");
		int a = Integer.parseInt(n1);  // Convert String into int using Integer class
		int b = Integer.parseInt(n2);
		int c = a+b;
		if(c>30) {
			response.sendRedirect("one.jsp");  // To redirect to another page
		}
		else {
			response.sendRedirect("index.html");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
