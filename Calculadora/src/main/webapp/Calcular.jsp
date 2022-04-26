<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="">
<p>Numero 1:
<input type="number"  name="nmr1"  id="num1" required/>

<p>Numero 2:
<input type="number"  name="nmr2" id="num2" required />
	
<p></p>Numero 3:
<input type="number"  name="nmr3" id="num3" required/>
<br>
<br>
<br>

<input type="radio" Value="Somar" name="TipoCalculo" id="somar" >
<label for="somar">somar</label><br>
 
<input type="radio" Value="Subtrair" name="TipoCalculo" id="Subtrair">
<label for="Subtrair">subtrair</label><br>

<input type="radio" Value="Mutiplicar" name="TipoCalculo" id="Mutiplicar">
<label for="Mutiplicar">Multiplicar</label><br>

<input type="radio" Value="Dividir" name="TipoCalculo" id="Dividir">
<label for="Dividir">Dividir</label><br>

<input type=submit name="teste" value="Calcular">
 
   
   
<%! String nmr1 ="1";
	String nmr2 ="1";
	String nmr3 ="1";
	double resultado =0;
	String compara ="";
	double nr1 =0;
	double nr2 =0;
	double nr3 =0;
	String  teste = "Somar";%>
	
	<%
	
	
	compara = request.getParameter("TipoCalculo");
	if(compara == null){
		compara = "TESTE";
	}
	nmr1 = request.getParameter("nmr1");
	nmr2 = request.getParameter("nmr2");
	nmr3 = request.getParameter("nmr3");
	
	if(nmr1 ==null && nmr2 == null && nmr3 == null){
		nmr1 ="0";
		nmr2 ="0";
		nmr3 = "0";
	}%>
	
	
	
<p> O seu Escolhido foi</p>	<%out.println(compara);%>
	
	<p>Esse teste foi</p>
	
		<%
		if(compara.equals("Somar")){
		resultado =  Double.parseDouble(nmr1);
		resultado +=  Double.parseDouble(nmr2);
		resultado +=  Double.parseDouble(nmr3);
		out.println(resultado);
		out.println("Teste Realizado");
		}
		
		if(compara.equals("Subtrair")){
			resultado =  Double.parseDouble(nmr1);
			resultado -=  Double.parseDouble(nmr2);
			resultado -=  Double.parseDouble(nmr3);
			out.println(resultado);
			out.println("Teste Realizado");
			}
		
		if(compara.equals("Mutiplicar")){
			nr1 =  Double.parseDouble(nmr1);
			nr2 =  Double.parseDouble(nmr2);
			 nr3 =  Double.parseDouble(nmr3);
			resultado = (nr1*nr2)*nr3;
			out.println(resultado);
			out.println("Teste Realizado");
			}
		
		if(compara.equals("Dividir")){
			nr1 =  Double.parseDouble(nmr1);
			nr2 =  Double.parseDouble(nmr2);
			 nr3 =  Double.parseDouble(nmr3);
			resultado = (nr1/nr2)/nr3;
			out.println(resultado);
			out.println("Teste Realizado");
			}
		
		
	%>
	

	

</form>
</body>
</html>