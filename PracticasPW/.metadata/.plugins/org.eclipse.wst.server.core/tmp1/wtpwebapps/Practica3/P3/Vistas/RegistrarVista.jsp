<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
			<meta charset="UTF-8">
			<title>Register</title>
</head>
<body>
<div class="bg"></div>
<div class="bg bg2"></div>
<div class="bg bg3"></div>
<div class="bg bg4"></div>
 
<div class="container">
		<h1>Registro de usuario</h1>
		
			<form method="post" action="../../../Practica3/RegistarServlet">
					<input type="email" name="Mail" placeholder="usermail@mail.com" required>
					<input type="password" name="Password" placeholder="Password" required>
					<input type="text" name="Name" placeholder="Name" required>
					<input type="text" name="Username" placeholder="Username" required>
              <div class="op"><div class="option">
    <input type="radio" name="rol" id="User" value="User" required>
    <label for="User">
      <span></span>
      Usuario
    </label>
  </div>
  <div class="option">
    <input type="radio" name="rol" id="Admin" value="Admin" required>
    <label for="Admin">
      <span></span>
      Admin
    </label>
  </div>
              </div>
              <br>
              <br/>
					<button type="submit" value="Register">Sign Up</button>
			</form>
<br/>
  <br/>
  <h2>Ya estas registrado?</h2>
		<br>
		<button type="button" value="Login"onClick = "window.location.href='/Practica3/index.jsp';">Login</button>
			</div>
</body>
</html>