package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import GeneralDTO.*;
import GeneralDAO.EspectaculoDAO;
import JavaBeans.*;

@WebServlet(name="GetTodosEspectaculos", urlPatterns="/GetTodosEspectaculos")

public class GetTodosEspectaculos extends HttpServlet{

	private static final long serialVersionUID = -7611538657317024701L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ServletContext app = getServletContext();
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

			EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
			ArrayList<EspectaculoPuntualDTO> espPunt = espDAO.SolicitarEspectaculoPuntualInfo();
			ArrayList<EspectaculoPaseMultipleDTO> espMult = espDAO.SolicitarEspectaculoPaseMultipleInfo();
			ArrayList<EspectaculoTemporadaDTO> espTemp = espDAO.SolicitarEspectaculoTemporadaInfo();
	
			ArrayList<EspectaculoPuntualDTO> foundPunt = new ArrayList<EspectaculoPuntualDTO>();
			ArrayList<EspectaculoPaseMultipleDTO> foundMult = new ArrayList<EspectaculoPaseMultipleDTO>();
			ArrayList<EspectaculoTemporadaDTO> foundTemp = new ArrayList<EspectaculoTemporadaDTO>();
				
			for(EspectaculoPuntualDTO e : espPunt)
			{
					foundPunt.add(e);
			}
				
			for(EspectaculoPaseMultipleDTO e : espMult)
			{
					foundMult.add(e);
			}
				
			for(EspectaculoTemporadaDTO e : espTemp)
			{
					foundTemp.add(e);
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
			
			String opc1 = request.getContextPath() + "/P3/Vistas/MenuEspectaculos/ModificarFechasAdmin.jsp";
			response.sendRedirect(opc1);

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ServletContext app = getServletContext();
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

			EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
			ArrayList<EspectaculoPuntualDTO> espPunt = espDAO.SolicitarEspectaculoPuntualInfo();
			ArrayList<EspectaculoPaseMultipleDTO> espMult = espDAO.SolicitarEspectaculoPaseMultipleInfo();
			ArrayList<EspectaculoTemporadaDTO> espTemp = espDAO.SolicitarEspectaculoTemporadaInfo();
	
			ArrayList<EspectaculoPuntualDTO> foundPunt = new ArrayList<EspectaculoPuntualDTO>();
			ArrayList<EspectaculoPaseMultipleDTO> foundMult = new ArrayList<EspectaculoPaseMultipleDTO>();
			ArrayList<EspectaculoTemporadaDTO> foundTemp = new ArrayList<EspectaculoTemporadaDTO>();
				
			for(EspectaculoPuntualDTO e : espPunt)
			{
					foundPunt.add(e);
			}
				
			for(EspectaculoPaseMultipleDTO e : espMult)
			{
					foundMult.add(e);
			}
				
			for(EspectaculoTemporadaDTO e : espTemp)
			{
					foundTemp.add(e);
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
			
			String opc1 = request.getContextPath() + "/P3/Vistas/MenuEspectaculos/EliminarEspectaculo.jsp";
			response.sendRedirect(opc1);

	}
}
