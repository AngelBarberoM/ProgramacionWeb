package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GeneralDTO.EspectaculoPuntualDTO;
import javax.servlet.*;
import GeneralDAO.EspectaculoDAO;

@WebServlet(name="NuevoEspectaculoPuntualServlet", urlPatterns="/NuevoEspectaculoPuntualServlet")

public class NuevoEspectaculoPuntualServlet extends HttpServlet{

	private static final long serialVersionUID = -1905442511795447120L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO puntDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		
		int ID = puntDAO.GenerarIdEspectaculoPuntual();
		String title = request.getParameter("titulo");
		String desc = request.getParameter("descripcion");
		String local = request.getParameter("locVenta");
		String categ = request.getParameter("categoria");
		String fecha = request.getParameter("fecha");
		
		int Localidades = Integer.parseInt(local);
		fecha = fecha.replace('T', ' ');
		fecha = fecha + ":00.0";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		LocalDateTime Fecha = LocalDateTime.parse(fecha, formatter);
		
		EspectaculoPuntualDTO newPunt = new EspectaculoPuntualDTO(ID, title, categ, desc, Localidades, 0, Fecha);
		puntDAO.CrearEspectaculoPuntual(newPunt);
		
		String ruta = request.getContextPath() + "/P3/Vistas/MenuEspectaculos/CrearEspectaculoAdmin.jsp";
		puntDAO.desEspectaculoDAO();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Espectaculo creado correctamente.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");
		
	}
}
