package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GeneralDTO.CriticaDTO;
import GeneralDTO.VotanteDTO;

import javax.servlet.*;
import GeneralDAO.CriticaDAO;

@WebServlet(name="LikeCriticaServlet", urlPatterns="/LikeCriticaServlet")

public class LikeCriticaServlet extends HttpServlet{

	private static final long serialVersionUID = -4468798356093461061L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");
		
		CriticaDAO critDAO = new CriticaDAO(urlBD, userBD, passBD);
		ArrayList<CriticaDTO> crits = critDAO.SolicitarCriticasInfo();
		
		String ID = request.getParameter("idCritica");
		String mailVot = request.getParameter("mailVot");
		int id = Integer.parseInt(ID);	
		String titulo=null, mail=null, resena = null;
		float punt =0;
		int like =0, dislike=0, idEsp = 0;
		for(CriticaDTO c : crits)
		{
			if(c.getId() == id)
			{
				titulo = c.getTitulo();
				mail = c.getCorreo();
				punt = c.getPuntuacion();
				resena = c.getResena();
				like = c.getLike()+1;
				dislike = c.getDislike();
				idEsp = c.getId();
				
				
				for(VotanteDTO cri : c.getVotantes())
				{
					if(cri.getPersonaVota().equals(mailVot) && cri.getVotoPersona().equals("dislike"))
					{
						dislike=dislike-1;
						critDAO.EliminarVotanteCritica(mailVot, id);
					}
				}
				critDAO.AnadirVotanteVotoCritica(mailVot, id, "like");
			}
		}
		CriticaDTO likeCrit = new CriticaDTO(titulo, punt, resena, id, mail, like, dislike, idEsp);
		critDAO.ActualizarCritica(likeCrit);
		critDAO.desCriticaDAO();
		String ruta = request.getContextPath() + "/GetTodosEspectaculosRealizadosServlet";
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Like añadido correctamente.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");	
	}
}
