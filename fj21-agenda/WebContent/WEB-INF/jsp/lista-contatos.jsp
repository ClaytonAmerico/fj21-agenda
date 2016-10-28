<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos</title>
</head>
<body>
	<img src="<c:url value="/imagens/img.png"/>" />

	<table border="1">
		<caption>Lista de Contatos</caption>
		<!-- nome da tabela -->
		<tr>
			<!-- cabeçalho da tabela -->
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data Formatada</th>
			<th>Remove Contato</th>
			<th>Altera Contato</th>
		</tr>
		<!-- percorre contatos montando as linhas de tabela -->
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'cccccc' : 'ffffff' }">
				<td>${contato.nome}</td>
				<td><c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if> <c:if test="${empty contato.email}">
						E-mail não informado
				</c:if></td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
				<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
				<td><a href="mvc?logica=EditaContatoLogic&id=${contato.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<form action="mvc">
		<input type="hidden" name="logica" value="InserirContatoLogic">
		<input type="submit" value="Adicionar novo contato">
	</form>

	<c:import url="rodape.jsp" />
</body>
</html>