<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>HEllo JSP</title>
</head>
<body>
<h2>Hello jsp</h2>
<%out.println("Corre do corno");%>
<%-- Uso do elemento expressão --%>
<p>Data: <%= new Date() %> </p>
<%! int contador=0; %>
<%! String Nome ;
	String Entrada = "";
	String Convertida ="";%>
<p> visitas:<%=contador++ %> </p>

<form action="">
  <input type="radio" id="html" name="fav_language" value="HTML">
  <label for="html">HTML</label><br>
  <input type="radio" id="css" name="fav_language" value="CSS">
  <label for="css">CSS</label><br>
  <input type="radio" id="javascript" name="fav_language" value="JavaScript">
  <label for="javascript">JavaScript</label><br><br>
  <input type=submit name="teste" value="Submit">
  <br>
  <br>
  
   <label>Coloque o nome</label>
  <input type="text" id="nome" name="nome" value="">
  <%Nome = request.getParameter("fav_language"); 
  Entrada = request.getParameter("nome");
		  
		  if(Entrada ==null ){
				Entrada = "Realize o teste";}

		  if(Nome == null){
			  Nome = "Coloque seu nome";
		  }
		  
		  for(int i = Entrada.length() - 1; i>=0; i--){
			  Convertida = Convertida + Character.toString(Entrada.charAt(i)); 
		  }
		  
		  out.println(Convertida); %>
		  
	 
		  
  
 
  
</form>
<p> O seu Escolhido foi</p> <% out.println(Nome); %>
</body>
</html>