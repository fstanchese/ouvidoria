<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Condominio - Login</title>
		<c:set var="path" value="${pageContext.request.contextPath}" scope="request"/>
		<style type="text/css">
			@IMPORT url("${path}/resources/css/bootstrap.min.css");
			@IMPORT url("${path}/resources/css/bootstrap-theme.min.css");
			#flogin{
				width: 400px;
				margin-left: auto;
				margin-right: auto;
				margin-top: 100px;
			}
			
			#btn-login{
				width: 100%;
			}
		</style>
	</head>
	<body>
	<c:import url="cabecalho.jsp" />
	
		<section id="flogin" class="panel panel-primary">
			
			<form action="${path}/efetuaLogin" method="post">
				<div class="panel-heading">
					Fala Cidadão - Login
				</div>
				
				<div class="panel-body">
					<label for="login">Login</label>
					<input id="login" name="login" size=50 class="form-control" required>
					
					<label for="senha">Senha</label>
					<input type="password" id="senha" name="senha" class="form-control" required>
				</div>
				
				<div class="panel-footer">
					<button id="btn-login" class="btn btn-primary">Entrar</button>
				</div>
			</form>
		</section>
	</body>
	<script src="${path}/resources/js/jquery.min.js" 		type="text/javascript"></script>
	<script src="${path}/resources/js/bootstrap.min.js" 	type="text/javascript"></script>
</html>