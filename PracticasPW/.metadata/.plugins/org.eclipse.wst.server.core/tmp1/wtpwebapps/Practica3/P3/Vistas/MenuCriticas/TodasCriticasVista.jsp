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
<title>Menú de Críticas</title>
</head>
<body>
    <jsp:include page="../CabeceraNavegacion.jsp"></jsp:include>
<% 
request.getSession().getAttribute("allEspsBean");
if(allEspsBean.getAllPunt() == null)
{
	String redirectURL = "../../../GetTodosEspectaculosRealizadosServlet";
	response.sendRedirect(redirectURL);
}
else
{
	if (allEspsBean != null) {
		%>
		<div class="container">
		<div class="sticky">
		<h1>Menú de Críticas</h1>
		<input type="text" placeholder="Título" id="buscador">
		</div>
				<%
				
					for (EspectaculoPuntualDTO punt : allEspsBean.getAllPunt()){
				%>
				<div class = "critica"> 
					<h2> <%= punt.getNombre()%> </h2>
					<div class="side">
					<form method="Post" action="../../../P3/Vistas/MenuCriticas/NuevaCritica.jsp">
					    <button type="submit" value="Añadir Crítica">Añadir Critica</button>
					    <input type="hidden" name="nombreEsp" value= "<%=punt.getNombre() %>">
					    <input type="hidden" name="idEsp" value= "<%=punt.getId() %>">
					</form>
					<form method="Post" action="../../../GetTosdasCriticasServlet">
					    <button type="submit" value="Ver Críticas">Ver Criticas</button>
					    <input type="hidden" name="nombreEsp" value= "<%=punt.getNombre() %>">
					    <input type="hidden" name="idEsp" value= "<%=punt.getId() %>">
					</form>
					</div>
				</div>
				<%
					}
				%>
				
				<%
				for (EspectaculoPaseMultipleDTO mult : allEspsBean.getAllMult()){
				%>
				<div class = "critica"> 
					<h2 class = "titulo"> <%= mult.getNombre()%> </h2>
					<div class="side">
					<form method="Post" action="../../../P3/Vistas/MenuCriticas/NuevaCritica.jsp">
		   			    <button type="submit" value="Añadir Crítica">Añadir Critica</button>
					    <input type="hidden" name="idEsp" value= "<%=mult.getId() %>">
					    <input type="hidden" name="nombreEsp" value= "<%=mult.getNombre() %>">
					</form>
				
					<form method="Post" action="../../../GetTodasCriticasServlet">
		   			    <button type="submit" value="Ver Críticas">Ver Criticas</button>
					    <input type="hidden" name="nombreEsp" value= "<%=mult.getNombre() %>">
					    <input type="hidden" name="idEsp" value= "<%=mult.getId() %>">
					</form>
					</div>
				</div>
			<%
				}
			%>
			
			<%
			
				for (EspectaculoTemporadaDTO temp : allEspsBean.getAllTemp()){
			%>
				<div class = "critica"> 
					<h2 class = "titulo"><%= temp.getNombre()%></h2>
					<div class="side">
					<form method="Post" action="../../../P3/Vistas/MenuCriticas/NuevaCritica.jsp">
		   			    <button type="submit" value="Añadir Crítica">Añadir Critica</button>
					    <input type="hidden" name="nombreEsp" value= "<%=temp.getNombre() %>">
					    <input type="hidden" name="idEsp" value= "<%=temp.getId() %>">
					</form>
					<form method="Post" action="../../../GetTodasCriticasServlet">
		   			    <button type="submit" value="Ver Críticas">Ver Criticas</button>
					    <input type="hidden" name="nombreEsp" value= "<%=temp.getNombre() %>">
					    <input type="hidden" name="idEsp" value= "<%=temp.getId() %>">
					</form>
					</div>
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