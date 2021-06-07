<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-08">
<title>Adicionar Usuário</title>
</head>
<body>
    <form action="../ServletUsuario">
         <input type="email" id="email" name="email" 
                placeholder="E-mail">
         <input type="text" id="nome" name="nome"
                placeholder="Nome">                  
         <input type="password" id="senha" name="senha" 
                placeholder="Senha">
         <input type="password" id="rsenha" name="rsenha" 
                placeholder="Senha">
                
         <select id="perfil" name="perfil">
                <option>Convidado</option>
                <option>Administrador</option>
                <option>Usuário</option>
         </select>    
         
         <input type="submit" id="opcao" name="opcao" 
                value="Adicionar">
    </form>
    
    <%@include file="listagemusuario2.jsp"%>
</body>
</html>