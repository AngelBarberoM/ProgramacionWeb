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
import GeneralDTO.EspectaculoTemporadaDTO;
import GeneralDTO.PaseDTO;
import javax.servlet.*;
import GeneralDAO.EspectaculoDAO;

@WebServlet(name="ModificarInicioFechaServlet", urlPatterns="/ModificarInicioFechaServlet")

public class ModificarInicioFechaServlet extends HttpServlet{

	private static final long serialVersionUID = -2680903184107626079L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO multDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		ArrayList<EspectaculoTemporadaDTO> temporadas= multDAO.SolicitarEspectaculoTemporadaInfo();
		
		int id = Integer.parseInt(request.getParameter("idEsp"));
		int idPase = Integer.parseInt(request.getParameter("idpase"));
		ArrayList<PaseDTO> pasesUpdate = new ArrayList<PaseDTO>();
		
		for(EspectaculoTemporadaDTO e : temporadas)
		{
			if(id == e.getId())
			{
				pasesUpdate = e.getPase();
			}
		}
				
		for(PaseDTO p : pasesUpdate)
		{
			if(p.getId() == idPase)
			{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");				
				String fechai = request.getParameter("fecha");
				fechai = fechai.replace('T', ' ');
				fechai = fechai+ ":00.0";
				LocalDateTime Fechai = LocalDateTime.parse(fechai, formatter);	
							
				LocalDateTime Fechaf = p.getFinalFecha();			
					
				String diaSemana = p.getDiaSemana();	
							
				PaseDTO updPase = new PaseDTO(idPase, Fechai, diaSemana, Fechaf);
				multDAO.ActualizarPase(updPase);
			}
		}		
		String ruta = request.getContextPath() + "/GetTodosEspectaculos"; 
		multDAO.desEspectaculoDAO();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Fecha editada correctamente.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");	
	}
}
