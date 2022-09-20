<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<title>Eliminar Espectáculo</title>
</head>
<body>
<jsp:include page="../CabeceraNavegacionAdmin.jsp"></jsp:include>
<% 
request.getSession().getAttribute("allEspsBean");
if(allEspsBean.getAllPunt() == null)
{
	String redirectURL = "../../../GetTodoParaEliminar";
	response.sendRedirect(redirectURL);
}
else
{
	if (allEspsBean != null) {
		%>
		<div class="container">
		<div class="sticky">
		<h1>Eliminar Espectáculo</h1>
		<input type="text" id="buscador" placeholder="Título">
		</div>
				<%
					for (EspectaculoPuntualDTO punt : allEspsBean.getAllPunt()){
				%>
				<div class = "critica"> 
					<h2> <%= punt.getNombre()%> </h2>
					<form method="Post" action="../../../EliminarEspectaculo">
					    <button type="submit" value="Eliminar" class="button">Eliminar</button>
					    <input type="hidden" name="idEsp" value= "<%=punt.getId() %>">
					    <input type="hidden" name="tipo" value= "<%= "punt" %>">
					</form>
				</div>
				<%
					}
				%>
				
				<%
				for (EspectaculoPaseMultipleDTO mult : allEspsBean.getAllMult()){
				%>
				<div class = "critica"> 
					<h2 class = "titulo"> <%= mult.getNombre()%> </h2>
					<form method="Post" action="../../../EliminarEspectaculo">
					    <button type="submit" value="Eliminar" class="button">Eliminar</button>
					    <input type="hidden" name="idEsp" value= "<%=mult.getId() %>">
					    <input type="hidden" name="tipo" value= "<%= "mult" %>">
					</form>
				</div>
			<%
				}
			%>
			
			<%
			
				for (EspectaculoTemporadaDTO temp : allEspsBean.getAllTemp()){
			%>
				<div class = "critica"> 
					<h2 class = "titulo"><%= temp.getNombre()%></h2>
					<form method="Post" action="../../../EliminarEspectaculo">
					    <button type="submit" value="Eliminar" class="button">Eliminar</button>
					    <input type="hidden" name="idEsp" value= "<%=temp.getId() %>">
					    <input type="hidden" name="tipo" value= "<%= "temp" %>">
					</form>
				</div>
			
			<%
				}
			%>
		</div>
		<%
		}
}
session.setAttribute("allEspsBean", null);

%>
<script src="../../JavaScript/FiltroTecla.js"> </script>
</body>
</html>