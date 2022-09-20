package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import GeneralDTO.*;
import GeneralDAO.EspectaculoDAO;
import JavaBeans.*;

@WebServlet(name="BuscarEspectaculosTemporadaServlet", urlPatterns="/BuscarEspectaculosTemporadaServlet")

public class BuscarEspectaculosTemporadaServlet extends HttpServlet{

	private static final long serialVersionUID = -9104506009763236615L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ServletContext app = getServletContext();
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
		
		ArrayList<EspectaculoTemporadaDTO> espTemp = espDAO.SolicitarEspectaculoTemporadaInfo();
		ArrayList<EspectaculoTemporadaDTO> foundTemp = new ArrayList<EspectaculoTemporadaDTO>();
		
		for(EspectaculoTemporadaDTO e : espTemp)
		{
			foundTemp.add(e);
		}

		HttpSession session = request.getSession();
		TodosEspectaculosJavaBean allEspsBean = new TodosEspectaculosJavaBean();
			
		allEspsBean.setAllTemp(foundTemp);
		allEspsBean.setNumTemp(foundTemp.size());	
			
		session.setAttribute("allEspsBean", allEspsBean);
		espDAO.desEspectaculoDAO();
		response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuEspectaculo/TodosEspectaculosVista.jsp"); 
	}	
}
