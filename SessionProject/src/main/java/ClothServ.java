

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ClothServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try
		{
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			System.out.println("Service is called...");
			
			String shirt = req.getParameter("shirt"); //read checkbox
			String jeans = req.getParameter("jeans"); //read checkbox

			out.println("<HTML>");
			out.println("<H1> CLothes Purchase Status </H1>");
			
			HttpSession cart = req.getSession(true);//start a session if not started
							// if its already there, then join it

			if(shirt!=null)
			{
				String shirtqty = req.getParameter("shirtqty");
				cart.setAttribute("shirtqty",shirtqty);
				out.println("SHIRT purchased : "+shirtqty+"<BR>");
			}
			else
				out.println("SHIRT NOT purchased  <BR>");

			if(jeans!=null)
			{
				String jeansqty = req.getParameter("jeansqty");
				cart.setAttribute("jeansqty",jeansqty);
				out.println("JEANS purchased : "+jeansqty+"<BR>");
			}
			else
				out.println("JEANS NOT purchased  <BR>");
		}
		catch(Exception e)
		{
			System.out.println("Problem is : "+e);
		}
	}//end of service
	}


