<%@page import="java.util.List"%>
<%@page import="model.Usuario"%>
<%@page import="dao.UsuarioDAO"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Usuário usando JSTL</title>
</head>
<body>
	<!--  configurar com JSTL a conexao com BD -->
	<sql:setDataSource var="usuario" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/admusuario?serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true"
		user="root" password="root" />

	<!-- determinar uma query com JSTL para select -->
	<sql:query var="resultado" dataSource="${usuario}">
     select * from usuario order by nome;
</sql:query>

	<table border="1">
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Perfil</th>
			<th>Opção</th>
		</tr>
		<c:forEach var="row" items="${resultado.rows}">
			<tr>
				<td><c:out value="${row.nome}" /></td>
				<td><c:out value="${row.email}" /></td>
				<td><c:out value="${row.perfil}" /></td>
				<td><a href="../ServletUsuario">Excluir</a> <a
					href="../ServletUsuario">Alterar</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>