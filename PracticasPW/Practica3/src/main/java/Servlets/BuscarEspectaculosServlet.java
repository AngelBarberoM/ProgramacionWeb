package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import GeneralDTO.*;
import GeneralDAO.EspectaculoDAO;
import JavaBeans.*;

@WebServlet(name="BuscarEspectaculosServlet", urlPatterns="/BuscarEspectaculosServlet")

public class BuscarEspectaculosServlet extends HttpServlet{

	private static final long serialVersionUID = 7313417310612984176L;

	/**
	 *
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ServletContext app = getServletContext();
		String title = null, category = null;
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");
		if(!"".equals(request.getParameter("titulo")))
		{
			title = request.getParameter("titulo");
		}
		else 
		{
			category = request.getParameter("categoria");
		}
		if(!"".equals(title) || !"".equals(category))
		{
			EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
			ArrayList<EspectaculoPuntualDTO> espPunt = espDAO.SolicitarEspectaculoPuntualInfo();
			ArrayList<EspectaculoPaseMultipleDTO> espMult = espDAO.SolicitarEspectaculoPaseMultipleInfo();
			ArrayList<EspectaculoTemporadaDTO> espTemp = espDAO.SolicitarEspectaculoTemporadaInfo();
	
			ArrayList<EspectaculoPuntualDTO> foundPunt = new ArrayList<EspectaculoPuntualDTO>();
			ArrayList<EspectaculoPaseMultipleDTO> foundMult = new ArrayList<EspectaculoPaseMultipleDTO>();
			ArrayList<EspectaculoTemporadaDTO> foundTemp = new ArrayList<EspectaculoTemporadaDTO>();
				
			for(EspectaculoPuntualDTO e : espPunt)
			{
				if(e.getTipo().equals(category) || e.getNombre().equals(title))
				{
					foundPunt.add(e);
				}
			}
				
			for(EspectaculoPaseMultipleDTO e : espMult)
			{
				if(e.getTipo().equals(category) || e.getNombre().equals(title))
				{System.out.println(e.getTipo());
					foundMult.add(e);
				}
			}
				
			for(EspectaculoTemporadaDTO e : espTemp)
			{
				if(e.getTipo().equals(category) || e.getNombre().equals(title))
				{System.out.println(e.getTipo());
					foundTemp.add(e);
				}
			}

			HttpSession session = request.getSession();
			TodosEspectaculosJavaBean allEspsBean = new TodosEspectaculosJavaBean();
			
			allEspsBean.setAllPunt(foundPunt);
			allEspsBean.setNumPunt(foundPunt.size());
			
			allEspsBean.setAllMult(foundMult);
			allEspsBean.setNumMult(foundMult.size());
			
			allEspsBean.setAllTemp(foundTemp);
			allEspsBean.setNumTemp(foundTemp.size());
			
			session.setAttribute("allEspsBean", allEspsBean);
			espDAO.desEspectaculoDAO();
			response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuEspectaculos/TodosEspectaculosVista.jsp"); 
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/P3/Error/ErrorTodasVistas.jsp"); //TODO: 

		}
	}
}
