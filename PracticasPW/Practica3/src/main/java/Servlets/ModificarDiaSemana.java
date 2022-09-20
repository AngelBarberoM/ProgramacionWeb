package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GeneralDTO.EspectaculoTemporadaDTO;
import GeneralDTO.PaseDTO;
import javax.servlet.*;
import GeneralDAO.EspectaculoDAO;

@WebServlet(name="ModificarDiaSemana", urlPatterns="/ModificarDiaSemana")

public class ModificarDiaSemana extends HttpServlet{

	private static final long serialVersionUID = -8027247685850352153L;

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
				
				LocalDateTime Fechaf = p.getFinalFecha();			
				LocalDateTime Fechai = p.getInicioFecha();				
				String diaSemana = request.getParameter("diasemana");				
				PaseDTO updPase = new PaseDTO(idPase, Fechai, diaSemana, Fechaf);
				multDAO.ActualizarPase(updPase);
			}
		}		
		String ruta = request.getContextPath() + "/GetAllEsps"; //TODO: 
		multDAO.desEspectaculoDAO();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Día de la semana editado correctamente.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");	
	}
}
