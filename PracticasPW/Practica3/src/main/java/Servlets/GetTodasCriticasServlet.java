package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import GeneralDTO.*;
import GeneralDAO.CriticaDAO;
import JavaBeans.*;

@WebServlet(name="GetTodasCriticasServlet", urlPatterns="/GetTodasCriticasServlet")

public class GetTodasCriticasServlet extends HttpServlet{

	private static final long serialVersionUID = -331376202396170659L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ServletContext app = getServletContext();
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		int IDEsp = Integer.parseInt(request.getParameter("idEsp"));
		String title = request.getParameter("nombreEsp");
		HttpSession session = request.getSession();
		
		CriticaDAO critDAO = new CriticaDAO(urlBD, userBD, passBD);
		ArrayList<CriticaDTO> criticas = critDAO.SolicitarCriticasInfo();
		ArrayList<CriticaDTO> crits = new ArrayList<CriticaDTO>();
		
		TodasCriticasJavaBean allCritBean = new TodasCriticasJavaBean();

		for(CriticaDTO c : criticas)
		{
			if(c.getIdEspectaculo() == IDEsp)
			{
				CriticaDTO foundCrit = new CriticaDTO();
				foundCrit.setTitulo(c.getTitulo());
				foundCrit.setCorreo(c.getCorreo());
				foundCrit.setPuntuacion(c.getPuntuacion());
				foundCrit.setResena(c.getResena());
				foundCrit.setId(c.getId());
				foundCrit.setIdEspectaculo(c.getIdEspectaculo());
				foundCrit.setLike(c.getLike());
				foundCrit.setDislike(c.getDislike());
				foundCrit.setVotantes(critDAO.SolicitarVotantes(c.getId()));
				crits.add(foundCrit);
			}
		}
		
		allCritBean.setAllCrit(crits);
		allCritBean.setNumCrit(crits.size());
		session.setAttribute("allCritBean", allCritBean);
		
		String opc1 = request.getContextPath() + "/P3/Vistas/MenuCriticas/MostrarCriticasEspectaculo.jsp?nombreEsp="+title;
		critDAO.desCriticaDAO();
		response.sendRedirect(opc1); 

	}
}
