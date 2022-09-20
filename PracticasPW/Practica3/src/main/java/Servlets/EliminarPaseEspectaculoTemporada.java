package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GeneralDTO.EspectaculoTemporadaDTO;
import GeneralDTO.PaseDTO;
import javax.servlet.*;
import GeneralDAO.EspectaculoDAO;

@WebServlet(name="EliminarPaseEspectaculoTemporada", urlPatterns="/EliminarPaseEspectaculoTemporada")

public class EliminarPaseEspectaculoTemporada extends HttpServlet{

	private static final long serialVersionUID = -332681595328503926L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO multDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		ArrayList<EspectaculoTemporadaDTO> temporadas= multDAO.SolicitarEspectaculoTemporadaInfo();
		
		int id = Integer.parseInt(request.getParameter("idEsp"));
		int idPases = Integer.parseInt(request.getParameter("idpase"));
		ArrayList<PaseDTO> pasesUpdate = new ArrayList<PaseDTO>();
		for(EspectaculoTemporadaDTO e : temporadas)
		{
			if(id == e.getId())
			{
				pasesUpdate = e.getPase();
			}
		}
		
		for(PaseDTO p: pasesUpdate)
		{
			if(idPases == p.getId())
			{
				
				multDAO.EliminarPase(p);
			}
		}

		String ruta = request.getContextPath() + "/GetMultiplesTemporadaEliminarServlet"; //TODO: 
		multDAO.desEspectaculoDAO();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Pase eliminado correctamente.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");	
	}
}
