<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Altera Contato</title>
</head>
<body>
	<head>
		<link rel="stylesheet" href="css/jquery-ui.css" />
        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
		<title>Insert title here</title>
	<body>
 	<h1>Altera Contato</h1>
 	
 	
		<form action="mvc" method="POST">
		    Id:
		    <input type="text" name="id" value="${param.id}" readonly/><br/>
		    Nome:
		    <input type="text" name="nome" value="${nome}"/><br/>
		    E-mail:
		    <input type="text" name="email" value="${email}"/><br/>
		    Endereço: <input type="text" name="endereco" value="${endereco}"/><br/>
		    Data de Nascimento: <input type="text" name="dataNascimento" value="${dataNascimento}"/>
		</form>
		<form>
			<input type="hidden" name="logica" value="AlteraContatoLogic"/>
			<input type="submit" value="Alterar"/>
		</form>
		<!-- <form action="mvc">
	
		<input type="hidden" name="id" value="${contato.id}">
		<input type="hidden" name="logica" value="AlteraContatoLogic">
	
		<strong>Este contato possui o ID ${contato.id}</strong><br/>
		Nome:  <input type="text" name="nome" value="${contato.nome}"><br/>
		Email:  <input type="text" name="email" maxlength="50" size="50" value="${contato.email}"><br/>
		Endereco:  <input type="text" name="endereco" value="${contato.endereco}"><br/>
		
		Data de Nascimento: <input type="text" name="dataNascimento" value="${dataNascimento}"/>
		<input type="hidden" name="logica" value="AlteraContatoLogic"/>
		<input type="hidden" name="paramAltera" value="altera"/><br><br>
		<input type="submit" value="Alterar"/>
		
	</form>  -->
		<c:import url="rodape.jsp" />
</body>
</html>




