<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean  id="allEspsBean" scope="session" class="JavaBeans.TodosEspectaculosJavaBean"></jsp:useBean>
<%@ page import="JavaBeans.TodosUsuariosJavaBean"%>
<%@ page import="GeneralDTO.EspectaculoPuntualDTO"%>
<%@ page import="GeneralDTO.EspectaculoPaseMultipleDTO"%>
<%@ page import="GeneralDTO.EspectaculoTemporadaDTO"%>
<%@ page import="GeneralDTO.FechaDTO"%>
<%@ page import="GeneralDTO.PaseDTO"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDateTime"%>
<title>Busqueda de Espectaculos</title>
</head>
<body>
    <jsp:include page="../CabeceraNavegacion.jsp"></jsp:include>
<% 
request.getSession().getAttribute("allEspsBean");
if(allEspsBean.getAllPunt() == null)
{
	String redirectURL = "../../../CrearEspectaculoServlet";
	response.sendRedirect(redirectURL);
}
else
{
	if (allEspsBean != null) {
		%>
		<div class="container">
		<div class="sticky">
		<h1>Búsqueda de Espectáculos:</h1>
		<input type="text" placeholder="Título" id= "buscadorEspsTitulo">
		<input type="text" placeholder="Categoría" id = "buscadorEspsCategoria">
		</div>
		<%
			if (allEspsBean.getAllPunt().size() > 0){
				%>
			<hr class="b">
			<hr class="a">
			<h2>Espectaculos puntuales:</h2>
			<hr class="a">
			<hr class="b">
			<%
				for (EspectaculoPuntualDTO punt : allEspsBean.getAllPunt()){
		%>

		<div class="Espectaculo">
			<h3>Título : <%= punt.getNombre()%></h3>
			<p class="categoria">Categoría : <%= punt.getTipo()%></p>
			<p>Descripción :<%= punt.getContenido()%></p>
			<p>Localidades en Venta : <%= punt.getLocalidadesTotales()%></p>
			<p>Localidades Vendidas : <%= punt.getLocalidadesVendidas()%></p>
			<p>Fecha : <%= punt.getFechaToString()%></p>
			<hr class="b">
			</div>
			
			<%
				}
			%>
			<hr class="a">
			<%
			}
		%>

		<%
			if (allEspsBean.getAllMult().size() > 0){
				%>
				<h2>Espectaculos Multiples:</h2>
				<hr class="a">
				<hr class="b">
			<%
			for (EspectaculoPaseMultipleDTO mult : allEspsBean.getAllMult()){
		%>
			<div class="Espectaculo">
				<h3>Título : <%= mult.getNombre()%></h3>
					<p class="categoria">Categoría : <%= mult.getTipo()%></p>
					<p>Descripción :<%= mult.getContenido()%></p>
					<p>Localidades en Venta :<%= mult.getLocalidadesTotales()%></p>
					<p>Localidades Vendidas : <%= mult.getLocalidadesVendidas()%></p>
					<p>Fechas:</p>
				<div class="side">
				<%
				for(FechaDTO fechas : mult.getFecha()){
				%>			
				<a><%= fechas.getFechaString()%></a>
				<%
				}
				%>
				</div>
					<hr class="b">
			</div>
			<%
					}
			%>
			<hr class="a">	
			<%	
			}
			%>

		<%
			if (allEspsBean.getAllTemp().size() > 0){
				%>
				<h2>Espectáculos de Temporada:</h2>
				<hr class="a">
				<hr class="b">
			<%
			for (EspectaculoTemporadaDTO temp : allEspsBean.getAllTemp()){
		%>
		<div class="Espectaculo">
			<h3>Título : <%= temp.getNombre()%></h3>
			<p class="categoria">Categoría : <%= temp.getTipo()%></p>
			<p>Descripción : <%= temp.getContenido()%></p>
			<p>Localidades en Venta :<%= temp.getLocalidadesTotales()%></p>
			<p>Localidades Vendidas : <%= temp.getLocalidadesVendidas()%></p>
			<p>Pases:</p>
			<%
			for(PaseDTO pases : temp.getPase()){
			%>
			<div class="side2">
				<a>Fecha Inicio: <%=pases.getInicioFechaToString()%></a>
				<a>Fecha Final: <%=pases.getFinalFechaToString() %></a>
				<a>Dia de la semana: <%=pases.getDiaSemana()%></a>
			</div>
				
			<%
				}
			%>
			<hr class="b">
		</div>
			<%
			}
			%>
					<hr class="a">
		<%
			}
		%>
			</div>
		<%
		}
}
session.setAttribute("allEspsBean", null);
%>
<script src="../../JavaScript/FiltroTeclaEspectaculo.js"></script>
</body>
</html>