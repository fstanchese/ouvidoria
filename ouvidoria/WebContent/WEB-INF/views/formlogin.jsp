<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="pt-br">
<head>
<link href="resources/assets/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" media="all">
<link href="resources/css/styles.css?321" type="text/css" rel="stylesheet">
<link href="resources/assets/sksmatt-UItoTop-jQuery-Plugin/css/ui.totop.css?<?=rand();?>" rel="stylesheet" >
<link href="resources/assets/fancybox/jquery.fancybox.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta charset="utf-8">
<title>Acesso de Usuários</title>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />
<c:import url="cabecalho.jsp" />
	<div class="container formlogin">
	<div class="row">
		<div class="col-md-offset-5 col-md-4 login">
			<form name="acesso" action="${path}/efetuaLogin" method="post">
				<div class="form-group">
					<label for="login">Usuário</label> 
					<input class="form-control" id="login" name="login" placeholder="Seu login cadastrado"	maxlength="12"  type="text">
				</div>
				<div class="form-group">
					<label for="senha">Senha</label>
					<div class="input-group">
						<input class="form-control" id="senha" name="senha" placeholder="Sua senha pessoal"  autocomplete="off" type="password">
						<span class="input-group-btn">
							<button type="submit" class="btn btn-primary">Entrar</button>
						</span>
					</div>
				</div>
				<div class="form-group ajuda">
					<a href="" target="_parent" title="Cadastre-se no nosso site" 	class="btn btn-default">Quero me cadastrar</a> 
					<a href="" target="_parent" title="Recuperar senha de acesso"	class="btn btn-danger">Esqueci minha senha</a>
				</div>
			</form>
		</div>
	</div>
	</div>

	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="resources/js/scripts.js"></script>
	<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script	src="resources/assets/sksmatt-UItoTop-jQuery-Plugin/js/jquery.ui.totop.min.js"></script>
	<script src="resources/assets/sksmatt-UItoTop-jQuery-Plugin/js/easing.js"></script>
	<script src="resources/assets/fancybox/jquery.fancybox.pack.js"></script>
</body>
</html>