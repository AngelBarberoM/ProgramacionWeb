package Servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import GeneralDAO.EspectaculoDAO;

@WebServlet(name="EliminarEspectaculo", urlPatterns="/EliminarEspectaculo")

public class EliminarEspectaculo extends HttpServlet{

	private static final long serialVersionUID = 4348751409631585512L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");
		
		EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
		
		String idEsp= request.getParameter("idEsp");
		int id = Integer.parseInt(idEsp);
		String tipo = request.getParameter("tipo");
		
		if(tipo.equals("punt"))
		{
			espDAO.EliminarEspectaculoPuntual(id);
		}
		else if(tipo.equals("mult"))
		{
			espDAO.EliminarEspectaculoPaseMultiple(id);
		}
		else
		{
			espDAO.EliminarEspectaculoTemporada(id);
		}
			
		String ruta = request.getContextPath() + "/P3/Vistas/MenuEspectaculos/HomeEspectaculosAdmin.jsp";
		espDAO.desEspectaculoDAO();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Espectáculo eliminado correctamente.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");	
	}
}
