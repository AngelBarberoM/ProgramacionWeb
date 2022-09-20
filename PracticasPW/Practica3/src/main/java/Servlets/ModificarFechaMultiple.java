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
import GeneralDTO.EspectaculoPaseMultipleDTO;
import GeneralDTO.FechaDTO;
import javax.servlet.*;
import GeneralDAO.EspectaculoDAO;

@WebServlet(name="ModificarFechaMultiple", urlPatterns="/ModificarFechaMultiple")

public class ModificarFechaMultiple extends HttpServlet{

	private static final long serialVersionUID = -8238728246051471251L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO multDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		ArrayList<EspectaculoPaseMultipleDTO> multiples= multDAO.SolicitarEspectaculoPaseMultipleInfo();
		
		int id = Integer.parseInt(request.getParameter("idEsp"));
		ArrayList<FechaDTO> fechasUpdate = new ArrayList<FechaDTO>();
		int idFecha = Integer.parseInt(request.getParameter("idFecha"));
		
		for(EspectaculoPaseMultipleDTO e : multiples)
		{
			if(id == e.getId())
			{
				fechasUpdate = e.getFecha();
			}
		}
		
		for(FechaDTO f : fechasUpdate)
		{
			if(idFecha == f.getId())
			{
				String fechaStr = request.getParameter("fecha");
				fechaStr = fechaStr.replace('T', ' ');
				fechaStr = fechaStr + ":00.0";
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime Fecha = LocalDateTime.parse(fechaStr, formatter);
				
				FechaDTO newFecha = new FechaDTO(idFecha, Fecha);
				multDAO.ActualizarFecha(newFecha, id);
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
