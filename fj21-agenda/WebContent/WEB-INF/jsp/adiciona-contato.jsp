<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<c:import url="cabecalho.jsp" />
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/jquery-ui.css" />
        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
		<title>Insert title here</title>
	<body>
 		<h1>Adiciona Contatos</h1>
		<hr />
		<form action="mvc" method="post">
		<input type="hidden" name="logica" value="AdicionaContatoLogic">
			<label for="nomeContato">Nome</label> 
			<input type="text" id="nomeContato" name="nome" /><br /> 
			E-mail: 
			<input type="text" name="email" /><br /> 
			Endereço: 
			<input type="text" name="endereco" /><br /> 
			Data Nascimento: 
			<caelum:campoData id="dataNascimento" /><br />
			<!-- Data Nascimento: <input type="text" name="dataNascimento" /><br />  --> 
			<input type="submit" value="Gravar">
		</form>
		<c:import url="rodape.jsp" />
	</body>
</html>