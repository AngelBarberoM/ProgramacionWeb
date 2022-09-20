<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:100,200,300,400,500);
</style>
<meta charset="UTF-8">
<jsp:useBean  id="allEspsBean" scope="session" class="JavaBeans.TodosEspectaculosJavaBean"></jsp:useBean>
<%@ page import="JavaBeans.TodosEspectaculosJavaBean"%>
<%@ page import="GeneralDTO.EspectaculoPuntualDTO"%>
<%@ page import="GeneralDTO.EspectaculoPaseMultipleDTO"%>
<%@ page import="GeneralDTO.EspectaculoTemporadaDTO"%>
<%@ page import="GeneralDTO.FechaDTO"%>
<%@ page import="GeneralDTO.PaseDTO"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDateTime"%>

<title>Añadir Fechas</title>
</head>
<body class = "hidden">
<div class ="centrado" id="onload">
	<div class="lds-roller">
		<div></div>
		<div></div>
		<div></div>
		<div></div>
		<div></div>
		<div></div>
		<div></div>
		<div></div>
	</div>
</div>
    <jsp:include page="../CabeceraNavegacionAdmin.jsp"></jsp:include>
<% 
request.getSession().getAttribute("allEspsBean");
if(allEspsBean.getAllMult() == null)
{
	String redirectURL = "../../../GetMultiplesTemporadaServlet";
	response.sendRedirect(redirectURL);
}
else
{
	if (allEspsBean != null) {
		%>
		<section>
		<h1>Añadir Fechas</h1>
		  <div class = "box">
			  	<select name="select" id="buscador" class="selectEsp">
					  <option value="Multiple" selected>Múltiple</option>
					  <option value="Temporada">Temporada</option>
				</select>
			</div>


		<div class ="critica">
			<h2>ESPECTÁCULOS MULTIPLES</h2>
			  <div class="tbl-header" id="1">	
			<table>
		      <thead>
		        <tr>
		          <th>Titulo</th>
		          <th>Fecha</th>
		        </tr>
		      </thead>
		    </table>
		  </div>
		    <div class="tbl-content">
		    <table>
		      <tbody>
			<%
			
				for (EspectaculoPaseMultipleDTO mult : allEspsBean.getAllMult()){
			%>
			<tr>
				<td><%= mult.getNombre()%></td>
				
				<td>
			        <table>
				<%
				for(FechaDTO fechas : mult.getFecha()){
				%>
							<tr>                
							<td><%= fechas.getFechaString()%></td>
							</tr>
				<%
				}
				%>
					</table>
				<form method="Post" action="../../../../Practica3/AnadirFechaMultiple">
				    <input type="datetime-local" name="fecha" class ="fecha" required>
				    <input type="submit" value="Añadir Fecha" class="button">
				    <input type="hidden" name="idesp" value= "<%=mult.getId() %>">
				</form>
				</td>
			</tr>
			<%
				}
			%>
				</tbody>
			</table>
			</div>
			</div>
			
		 <div class="critica" id="temp"> 
		  <h2>Espectaculos de temporada</h2>
		  <div class="tbl-header">
		    <table>
		      <thead>
		        <tr>
		          <th>Titulo</th>
		          <th>Fecha inicio</th>
		          <th>Fecha final</th>
		          <th>Dia</th>
		          <th>Añadir Pase</th>
		        </tr>
		      </thead>
		    </table>
		  </div>
		<div class="tbl-content">
		    <table>
		      <tbody>
			<%
				for (EspectaculoTemporadaDTO temp : allEspsBean.getAllTemp()){
			%>
			<tr>
				<td><%= temp.getNombre()%></td>
					<td>
			        <table>
				<%
				for(PaseDTO pases : temp.getPase()){
				%>
						<tr>
						<td><%=pases.getInicioFechaToString()%></td>
						</tr>
				<%
				}
				%>
					</table>
					</td>
					
					<td>
			        <table>
				<%
				for(PaseDTO pases : temp.getPase()){
				%>
						<tr>
						<td><%=pases.getFinalFechaToString()%></td>
						</tr>
				<%
				}
				%>
					</table>
					</td>
				
					<td>
			        <table>
				<%
				for(PaseDTO pases : temp.getPase()){
				%>
						<tr>
						<td><%=pases.getDiaSemana()%></td>
						</tr>
				<%
				}
				%>
					</table>
					</td>
					<td>
					<form method="Post" action="../../../../Practica3/AnadirPasesTemporada">
					<label for="fechainicio">Fecha de Inicio</label>
				    <input type="datetime-local" name="fechai" id="fechainicio" class ="fecha" required>
				    <label for="fechafinal">Fecha de Finalización</label>
				    <input type="datetime-local" name="fechaf" id="fechafinal" class ="fecha" required>
				    <label for="dia">Día</label>
					<select name="diasemana" id="dia">
						<option value="Lunes">Lunes</option>
						<option value="Martes">Martes</option>
						<option value="Miercoles">Miércoles</option>
						<option value="Jueves">Jueves</option>
						<option value="Viernes">Viernes</option>
						<option value="Sabado">Sábado</option>
						<option value="Domingo">Domingo</option>
					</select>
				    <input type="submit" value="Añadir Pase"class="button">
				    <input type="hidden" name="idesp" value= "<%=temp.getId() %>">
				</form>
				</td>
			</tr>
			<%
				}
			%>
			</tbody>
			</table>
			</div>
			</div>
			
		</section>
		<%
		}
}
session.setAttribute("allEspsBean", null);
%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"> </script>
<script src="../../JavaScript/FiltroFechasModificar.js"> </script>
<script src="../../JavaScript/CargarPagina.js"> </script>
<script src="../../JavaScript/ControladorFechas.js"></script>
</body>
</html>