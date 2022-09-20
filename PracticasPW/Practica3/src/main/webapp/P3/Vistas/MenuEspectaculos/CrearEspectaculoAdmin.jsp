<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dar de alta espectaculo</title>
</head>
<body>
<jsp:include page="../CabeceraNavegacionAdmin.jsp"></jsp:include>
    <div class="container">
			<form id="myform" method="post" action="../../../CrearEspectaculoServlet">
				<fieldset>
					<legend>Crear Espect�culo</legend>
					<select id ="location"name="tipo">
						<option value="Puntual">Puntual</option>
						<option value="Temporada">Temporada</option>
						<option value="Multiple">M�ltiple</option>
					</select>
					<br><br>
					<div id="second"> 
					<label>N�mero de fechas/pases <input type="number" name="opcion" value="1" min=1 placeholder = "N�mero fechas/pases" required> <br><br></label> 
					</div>
					<button type="submit" value="Aceptar" class="button">Aceptar</button>
				</fieldset>
			</form>
			</div>
<script src="../../JavaScript/CrearEspectaculoAdmin.js"> </script>
<script src="../../JavaScript/CargarPagina.js"> </script>
</body>
</html>