<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.*" %>
<%@ page import="java.sql.PreparedStatement" import="java.sql.ResultSet"  %>
<%@ page import="com.pasaBus.*" %>
<%@ page import="java.sql.SQLException" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>[PasaBUS]</title>
<link href="index.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
  
</head>
<body class="body1">
	<header>
<nav class="navbar bg-light" id="navimg" style="background-color: #e3f2fd;">
   <div class="container-fluid">
		<a class="navbar-brand" href="#">
		<img src="images/colec.png" width="80" height="80" class="img" class="d-inline-block align-text-top" alt= "PasaBus" >
		<span class="navbar-text">
		PasaBus
	    </span>
    	</a>
    	 <div class="div1">
  <form class="form" class="container-fluid justify-content-start">
  
	<button class="btn btn-outline-success me-2" type="button"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="22" fill="currentColor" class="bi bi-arrow-repeat" viewBox="0 0 16 16">
  <path d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z"/>
  <path fill-rule="evenodd" d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z"/>
</svg> DEVOLVER PASAJE</button>
    <button class="btn btn-outline-success me-3" type="button"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="22" fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
  <path d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576 6.636 10.07Zm6.787-8.201L1.591 6.602l4.339 2.76 7.494-7.493Z"/>
</svg> REENVIAR PASAJE</button>
    <a  href="#" >ayuda</a>
    </form>
  </div>
    </div>
   </nav>
</header>

<div class="divform">
<h4>Buscá tu Pasaje en Micro</h4>

<form action="prueba" method="get"class="col-sm-10" >
 <div class="dropdown">
  <select name="origen" id="locOrigen" class="form-select" aria-label="Default select example"> 

		<option>Elija la localidad origen</option>	
		
		<%
			PreparedStatement st= DbConnector.getInstancia().getConn().prepareStatement("Select * from localidades");
			//trae la tabla de localidades
			try	{
				
				ResultSet rs=st.executeQuery();
		
				while (rs.next()){	%>
					<option value=<%=rs.getInt("id")%>> <%=rs.getString("localidad")%></option>
		<% 
								}
				}catch (SQLException e){}%>
		
	</select>
  
</div>

  <div class="dropdown">
		<select name="llegada" class="form-select" aria-label="Default select example"> 
		<option> Elija la localidad destino</option>	
		
	<%
		try{
			ResultSet rs=st.executeQuery();
			
			while (rs.next()){ %>
				<option value=<%=rs.getInt("id")%>> <%=rs.getString("localidad")%></option>
		<%
							}
			}catch (SQLException e){}%>		
			
		</select>	
					
		<input type="text" name="nom_loc" id="miinput" disabled>
  </div>
     <input type="submit" value="enviar">
</form>
</div>
</body>
</html>