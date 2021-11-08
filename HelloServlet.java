import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
public class HelloServlet extends HttpServlet// 第一步：扩展HttpServlet抽象类
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse rps) 
        throws ServletException, IOException {
		rps.getWriter().write("123456789");
		System.out.println("98765432");
	}
}
