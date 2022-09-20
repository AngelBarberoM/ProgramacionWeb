package Servlets;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import GeneralDTO.*;
import GeneralDAO.CriticaDAO;
import GeneralDAO.EspectaculoDAO;
import JavaBeans.*;

@WebServlet(name="BuscarCriticaServlet", urlPatterns="/BuscarCriticaServlet")

public class BuscarCriticaServlet extends HttpServlet{

	private static final long serialVersionUID = -2204662920245626705L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ServletContext app = getServletContext();

		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");
		
		if(!"null".equals(request.getParameter("titulo")))
		{
			String title = request.getParameter("titulo");
			int idEsp = -1;
			CriticaDAO critDAO = new CriticaDAO(urlBD, userBD, passBD);
			EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
			
			ArrayList<EspectaculoPuntualDTO> punts = espDAO.SolicitarEspectaculoPuntualInfo();
			ArrayList<EspectaculoPaseMultipleDTO> mults = espDAO.SolicitarEspectaculoPaseMultipleInfo();
			ArrayList<EspectaculoTemporadaDTO> temps = espDAO.SolicitarEspectaculoTemporadaInfo();
			ArrayList<CriticaDTO> criticas = critDAO.SolicitarCriticasInfo();
			ArrayList<CriticaDTO> foundCriticas = new ArrayList<CriticaDTO>();
			
			for(EspectaculoPuntualDTO e : punts)
			{
				if(title.equals(e.getNombre()))
				{
					idEsp = e.getId();
				}
			}
			
			for(EspectaculoPaseMultipleDTO e : mults)
			{
				if(title.equals(e.getNombre()))
				{
					idEsp = e.getId();
				}
			}
			
			for(EspectaculoTemporadaDTO e : temps)
			{
				if(title.equals(e.getNombre()))
				{
					idEsp = e.getId();
				}
			}
			
			//TODO:
			for(CriticaDTO c : criticas)
			{
				if(c.getIdEspectaculo() == idEsp)
				{
					foundCriticas.add(c);
				}
			}
			
			HttpSession session = request.getSession();
			TodasCriticasJavaBean allCritBean = new TodasCriticasJavaBean();
			
			allCritBean.setAllCrit(foundCriticas);
			allCritBean.setNumCrit(foundCriticas.size());
			
			session.setAttribute("allCritBean", allCritBean);
			critDAO.desCriticaDAO();
			espDAO.desEspectaculoDAO();
			response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuCriticas/TodasCriticasVista.jsp");
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/P3/Error/ErrorCriticas.jsp"); //TODO:
		}
		
	}
}
