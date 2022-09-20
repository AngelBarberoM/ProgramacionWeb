<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
if(allEspsBean.getAllPunt() == null)
{
	String redirectURL = "../../../GetAllEsps";
	response.sendRedirect(redirectURL);
}
else
{
	if (allEspsBean != null) {
		%>
		<section>
		  <h1>Modificar espectáculos</h1>
		  <div class = "box">
			  	<select name="select" id="buscador" class="selectEsp">
					  <option value="Puntual" selected>Puntual</option>
					  <option value="Multiple">Múltiple</option>
					  <option value="Temporada">Temporada</option>
				</select>
			</div>
		  <div class="critica">
		    <h2>Espectaculos puntuales</h2>
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

			for (EspectaculoPuntualDTO punt : allEspsBean.getAllPunt()){
		%>
		    
		<tr>
			<td><%= punt.getNombre()%></td>
			<td><%= punt.getFechaToString()%>
			<form method="Post" action="../../../ModificarFechaPuntualServlet">
						 <input type="datetime-local" name="fecha" class="fecha" required >
			   			 <input type="submit" value="Editar Fecha" class="button">
			   			 <input type="hidden" name="idEsp" value= "<%=punt.getId() %>">
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
		 
		<div class="critica" id="mult">
		<h2>Espectaculos multiples</h2>
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
						<td><%= fechas.getFechaString()%>
						<form method="Post" action="../../../ModificarFechaMultiple">
						 <input type="datetime-local" name="fecha" class ="fecha" required>
			   			 <input type="submit" value="Editar Fecha"class="button">
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
		          <th>dia</th>
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
			<td>
			<%= temp.getNombre()%>
			</td>
			<td>
		        <table>
			        <%
					for(PaseDTO pases : temp.getPase()){
					%>
					<tr>
						<td><%=pases.getInicioFechaToString()%>
						<form method="Post" action="../../../ModificarInicioFechaServlet">
						 <input type="datetime-local" name="fecha" class ="fecha"required>
			   			 <input type="submit" value="Editar" class="button">
			   			 <input type="hidden" name="idEsp" value= "<%=temp.getId() %>">
			   			 <input type="hidden" name="idpase" value= "<%=pases.getId() %>">
						</form></td>
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
						<td><%=pases.getFinalFechaToString()%>
						<form method="Post" action="../../../ModificarFinalFechaServlet">
						 <input type="datetime-local" name="fecha" class ="fecha"required>
			   			 <input type="submit" value="Editar"class="button">
			   			 <input type="hidden" name="idEsp" value= "<%=temp.getId() %>">
			   			 <input type="hidden" name="idpase" value= "<%=pases.getId() %>">
						</form></td>
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
						<td><%=pases.getDiaSemana()%>
						<form method="Post" action="../../../ModificarDiaSemana">
						<select name="diasemana">
							<option value="Lunes">Lunes</option>
							<option value="Martes">Martes</option>
							<option value="Miércoles">Miércoles</option>
							<option value="Jueves">Jueves</option>
							<option value="Viernes">Viernes</option>
							<option value="Sábado">Sábado</option>
							<option value="Domingo">Domingo</option>
						</select>
			   			 <input type="submit" value="Editar" class="button">
			   			 <input type="hidden" name="idEsp" value= "<%=temp.getId() %>">
			   			 <input type="hidden" name="idpase" value= "<%=pases.getId() %>">
						</form></td>
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
<script src="../../JavaScript/ScrollTablaModificarFechas.js"></script>
<script src="../../JavaScript/ControladorFechas.js"></script>
</body>
</html>