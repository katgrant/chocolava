

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ElectServ
 */
public class ElectServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			System.out.println("Service is called...");
			
			String tv = req.getParameter("tv");
			String video = req.getParameter("video");

			out.println("<HTML>");
			out.println("<H1> Electronic Purchase Status </H1>");
			
			HttpSession cart = req.getSession(true);

			if(tv!=null)
			{
				String tvqty = req.getParameter("tvqty");
				cart.setAttribute("tvqty",tvqty);
				out.println("TV purchased : "+tvqty+"<BR>");
			}
			else
				out.println("TV NOT purchased  <BR>");

			if(video!=null)
			{
				String videoqty = req.getParameter("videoqty");
				cart.setAttribute("videoqty",videoqty);
				out.println("VIDEO purchased : "+videoqty+"<BR>");
			}
			else
				out.println("VIDEO NOT purchased  <BR>");
		}
		catch(Exception e)
		{
			System.out.println("Problem is : "+e);
		}
	}//end of service
	}


