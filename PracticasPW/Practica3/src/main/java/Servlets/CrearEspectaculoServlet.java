package Servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="CrearEspectaculoServlet", urlPatterns="/CrearEspectaculoServlet")

public class CrearEspectaculoServlet extends HttpServlet{

	private static final long serialVersionUID = 2261076027687745273L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("tipo").equals("Puntual"))
		{
			response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuEspectaculos/CrearEspectaculoPuntual.jsp"); 
		}
		else if(request.getParameter("tipo").equals("Multiple"))
		{
			String num = request.getParameter("opcion");
			response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuEspectaculos/CrearEspectaculoPaseMultiple.jsp?number="+num);
		}
		else
		{
			String num = request.getParameter("opcion");
			response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuEspectaculos/CrearEspectaculoTemporada.jsp?number="+num);	
		}
		
	}
}
