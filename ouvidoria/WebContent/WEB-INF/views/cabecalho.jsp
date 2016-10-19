<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />
<!-- Barra superior com os menus de navegação -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<button class="navbar-toggle" type="button" data-toggle="collapse"
			data-target=".bs-navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<nav class="collapse navbar-collapse bs-navbar-collapse"
			role="navigation">
			<c:if test="${empty usuarioLogado}">
				<div class="collapse navbar-collapse" id="menu">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${path}/cadastro">Cadastre-se <i
								class="glyphicon glyphicon-edit"></i></a></li>
						<li><a href="${path}/loginForm">Entrar <i
								class="glyphicon glyphicon-log-in"></i></a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${not empty usuarioLogado}">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown">${usuarioLogado.login}<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${path}/postagens">Minhas Postagens</a></li>
							<li><a href="${path}/meusdados">Meus Dados</a></li>
							<li><a href="${path}/logout">Sair</a></li>
						</ul></li>
				</ul>
			</c:if>
		</nav>
	</div>
</nav>