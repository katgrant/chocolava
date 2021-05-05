

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckServ
 */
public class CheckServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try
		{
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			System.out.println("Service is called...");
			
			out.println("<HTML>");
			out.println("<H1> CLothes Purchase Status </H1>");
			HttpSession cart = req.getSession(true);
			int total=0;

			String tvqty = (String) cart.getAttribute("tvqty");
			String videoqty = (String) cart.getAttribute("videoqty");
			String shirtqty = (String) cart.getAttribute("shirtqty");
			String jeansqty = (String) cart.getAttribute("jeansqty");

			if (tvqty!=null)
			{
				out.println("TV purchased : "+tvqty +"<BR>");
				total += Integer.parseInt(tvqty);
			}
			
			if (videoqty!=null)
			{
				out.println("VIDEO purchased : "+videoqty +"<BR>");
				total += Integer.parseInt(videoqty);
			}
			
			if (shirtqty!=null)
			{
				out.println("SHIRT purchased : "+shirtqty +"<BR>");
				total += Integer.parseInt(shirtqty);
			}
			
			if (jeansqty!=null)
			{
				out.println("JEANS purchased : "+jeansqty +"<BR>");
				total += Integer.parseInt(jeansqty);
			}
			
			out.println("<h1> Total Items purchased : "+total+"</h1>");
			cart.invalidate(); //disconnect the cart from the session
		}
		catch(Exception e)
		{
			System.out.println("Problem is : "+e);
		}
	}//end of service
	
	}


