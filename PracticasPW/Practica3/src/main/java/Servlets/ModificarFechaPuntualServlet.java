package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GeneralDTO.EspectaculoPuntualDTO;
import javax.servlet.*;
import GeneralDAO.EspectaculoDAO;

@WebServlet(name="ModificarFechaPuntualServlet", urlPatterns="/ModificarFechaPuntualServlet")

public class ModificarFechaPuntualServlet extends HttpServlet{

	private static final long serialVersionUID = -1044598430409669755L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO puntDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		ArrayList<EspectaculoPuntualDTO> puntuales = puntDAO.SolicitarEspectaculoPuntualInfo();
		
		int id = Integer.parseInt(request.getParameter("idEsp"));
		
		for(EspectaculoPuntualDTO e : puntuales)
		{
			if(id == e.getId())
			{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");				
				String fecha = request.getParameter("fecha");
				fecha = fecha.replace('T', ' ');
				fecha = fecha+ ":00.0";
				LocalDateTime Fecha = LocalDateTime.parse(fecha, formatter);	
				EspectaculoPuntualDTO newPunt = new EspectaculoPuntualDTO(id, e.getNombre(), e.getTipo() ,e.getContenido(), e.getLocalidadesTotales(), e.getLocalidadesVendidas(), Fecha);
				puntDAO.ActualizarEspectaculoPuntual(newPunt);
			}
		}
					
		String ruta = request.getContextPath() + "/GetTodosEspectaculos";
		puntDAO.desEspectaculoDAO();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Fecha editada correctamente.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");	
	}
}
