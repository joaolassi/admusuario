<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Usuario</title>
</head>
<body>
	<%
		Usuario usuario = (Usuario) request.getAttribute("usuario");
	%>
	
	<form action="ServletUsuario">
		<input type="hidden" id="email" name="email" value="<%=usuario.getEmail()%>">
        
        <input type="text" id="nome" name="nome" value="<%=usuario.getNome()%>">
        
        <input type="password" id="senha" name="senha" value="<%=usuario.getSenha()%>">
        
        <input type="password" id="rsenha" name="rsenha" value="<%=usuario.getSenha()%>">

        <select id="perfil" name="perfil" >
        	<option <%=usuario.getPerfil()=="Usuário"?"selected":"" %>>Convidado</option>
            <option <%=usuario.getPerfil()=="Administrador"?"selected":"" %>>Administrador</option>
            <option <%=usuario.getPerfil()=="Usuário"?"selected":"" %>>Usuário</option>
        </select>
        
        <button type="submit" id="atualizar" name="opcao" value="Atualizar">Salvar</button>
        
	</form>
</body>
</html>