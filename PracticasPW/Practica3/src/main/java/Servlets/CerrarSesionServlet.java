package Servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="CerrarSesionServlet", urlPatterns="/CerrarSesionServlet")

public class CerrarSesionServlet extends HttpServlet{
	
	private static final long serialVersionUID = -926245635153697382L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		session.setAttribute("customerBean", null);
		String ruta = request.getContextPath() + "/index.jsp";
		response.sendRedirect(ruta);
	}
}
