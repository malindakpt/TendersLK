package servlet; /**
 * Created by MalindaK on 2/21/2016.
 */
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class HelloWorldServlet extends HttpServlet
{
    public void doGet (HttpServletRequest req,
                       HttpServletResponse res)
            throws ServletException, IOException
    {
        PrintWriter out = res.getWriter();
        out.println("Hello, world Malinda Kumarsinghe");
        out.close();
    }
}
