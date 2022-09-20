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

import GeneralDTO.EspectaculoTemporadaDTO;
import GeneralDTO.PaseDTO;
import javax.servlet.*;
import GeneralDAO.EspectaculoDAO;

@WebServlet(name="NuevoEspectaculoTemporadaServlet", urlPatterns="/NuevoEspectaculoTemporadaServlet")

public class NuevoEspectaculoTemporadaServlet extends HttpServlet{

	private static final long serialVersionUID = -1290846862882680952L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO tempDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		
		ArrayList<PaseDTO> pases = new ArrayList<PaseDTO>();
		
		int numPases = Integer.parseInt(request.getParameter("number"));
		int ID = tempDAO.GenerarIdEspectaculoTemporada();
		String title = request.getParameter("titulo");
		String desc = request.getParameter("descripcion");
		String local = request.getParameter("locVenta");
		String categ = request.getParameter("categoria");
		int Localidades = Integer.parseInt(local);
		int count = 0;

		for(int i = 1; i <= numPases; i++)
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			String fechai = request.getParameter("fechai"+i);
			fechai = fechai.replace('T', ' ');
			fechai = fechai + ":00.0";
			LocalDateTime FechaInicio = LocalDateTime.parse(fechai, formatter);			
			
			String fechaf = request.getParameter("fechaf"+i);
			fechaf = fechaf.replace('T', ' ');
			fechaf = fechaf + ":00.0";
			LocalDateTime FechaFinal = LocalDateTime.parse(fechaf, formatter);
			
			String diaSemana = request.getParameter("diasemana"+i);
			
			if(FechaInicio.isAfter(FechaFinal))
			{
				count ++;
			}
			else
			{
				int idp = tempDAO.generarIdPases();
				PaseDTO newPase = new PaseDTO(idp, FechaInicio, diaSemana ,FechaFinal);
				pases.add(newPase);
			}

		}
		
		EspectaculoTemporadaDTO newTemp = new EspectaculoTemporadaDTO(ID, title, categ, desc, Localidades, 0, pases);
		tempDAO.CrearEspectaculoTemporada(newTemp);
		
		for(PaseDTO p : pases)
		{
			tempDAO.CrearPase(p, ID);
		}
		System.out.println("CONTADOR : " + count);
		String ruta = request.getContextPath() + "/P3/Vistas/MenuEspectaculos/CrearEspectaculoAdmin.jsp";
		tempDAO.desEspectaculoDAO();
		if(count>0) 
		{
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Uno o más pases no se han creado. La fecha de inicio no puede ser posterior a la fecha de finalización');");
            out.println("window.location.href =" + "'" + ruta + "'" + ";" );
            out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Espectaculo creado correctamente.');");
            out.println("window.location.href =" + "'" + ruta + "'" + ";" );
            out.println("</script>");
		}
	}
}
