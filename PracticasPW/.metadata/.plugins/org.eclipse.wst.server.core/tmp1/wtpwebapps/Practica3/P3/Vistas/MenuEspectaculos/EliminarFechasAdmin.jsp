<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:100,200,300,400,500);
body {
 	background: #9aafc7;
	font-family: 'Roboto', sans-serif;
}

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

<title>Busqueda de Espectaculos</title>
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
	String redirectURL = "../../../GetMultiplesTemporadaEliminarServlet";
	response.sendRedirect(redirectURL);
}
else
{
	if (allEspsBean != null) {
		%>
		<h1>Cancelar sesiones</h1>

		<div class = "box">
			  	<select name="select" id="buscador">
					  <option value="Multiple" selected>Múltiple</option>
					  <option value="Temporada">Temporada</option>
				</select>
			</div>

		<div class = "critica">
			<h2>ESPECTÁCULOS MULTIPLES</h2>
			<table border="1">
			<tr>
				<td>TÍTULO</td><td>FECHAS</td>
			</tr>
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
							<td><%= fechas.getFechaString()%>
							<form method="Post" action="../../../EliminarFechaEspectaculoPaseMultiple">
				   			 <input type="submit" value="Cancelar fecha" class="button">
				   			 <input type="hidden" name="idEsp" value= "<%=mult.getId() %>">
				   			 <input type="hidden" name="idFecha" value= "<%=fechas.getId() %>">
							</form>
							</td>
							</tr>
				<%
				}
				%>
					</table>
				</td>
			</tr>
			<%
				}
			%>
			</table>
		</div>


		<div class = "critica">
			<h2>ESPECTÁCULOS DE TEMPORADA</h2>
			<table border="1">
			<tr>
				<td>TITULO</td><td>FECHA INICIO</td><td>FECHA FINAL</td><td>DÍA</td><td>BORRAR PASE</td>
			</tr>
			<%
			
				for (EspectaculoTemporadaDTO temp : allEspsBean.getAllTemp()){
			%>
			<tr>
				<td>
				<%= temp.getNombre()%>
				</td>
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
			        <table>
				        <%
						for(PaseDTO pases : temp.getPase()){
						%>
						<tr>
							<td>
							<form method="Post" action="../../../EliminarPaseEspectaculoTemporada">
				   			 <input type="submit" value="Borrar" class="button">
				   			 <input type="hidden" name="idEsp" value= "<%=temp.getId() %>">
				   			 <input type="hidden" name="idpase" value= "<%=pases.getId() %>">
							</form>
							</td>
						</tr>
						<%
						}
						%>
			        </table>
				</td>
				
			
			</tr>
			<%
				}
			%>
			</table>
		</div>
		<%
		}
}
session.setAttribute("allEspsBean", null);
%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"> </script>
<script src="../../JavaScript/FiltroFechasModificar.js"> </script>
<script src="../../JavaScript/CargarPagina.js"> </script>
</body>
</html>