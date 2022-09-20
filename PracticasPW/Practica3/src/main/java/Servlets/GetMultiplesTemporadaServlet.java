package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import GeneralDTO.*;
import GeneralDAO.EspectaculoDAO;
import JavaBeans.*;

@WebServlet(name="GetMultiplesTemporadaServlet", urlPatterns="/GetMultiplesTemporadaServlet")

public class GetMultiplesTemporadaServlet extends HttpServlet{

	private static final long serialVersionUID = 6229483247667863218L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		ServletContext app = getServletContext();
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
		
		ArrayList<EspectaculoPaseMultipleDTO> espMult = espDAO.SolicitarEspectaculoPaseMultipleInfo();
		ArrayList<EspectaculoTemporadaDTO> espTemp = espDAO.SolicitarEspectaculoTemporadaInfo();

		HttpSession session = request.getSession();
		TodosEspectaculosJavaBean allEspsBean = new TodosEspectaculosJavaBean();
		
		allEspsBean.setAllMult(espMult);
		allEspsBean.setNumMult(espMult.size());
		
		allEspsBean.setAllTemp(espTemp);
		allEspsBean.setNumTemp(espTemp.size());
		
		session.setAttribute("allEspsBean", allEspsBean);
		espDAO.desEspectaculoDAO();
		response.sendRedirect(request.getContextPath() + "/P3/Vistas/MenuEspectaculos/AnadirFechasAdmin.jsp"); 
	}
}
