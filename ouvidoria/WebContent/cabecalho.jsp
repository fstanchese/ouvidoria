<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />
	<header>
		<div class="container-fluid cabecalho">
			<nav class="navbar navbar-default"> 
				<div class="container menu-topo">   
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
							<span class="sr-only">Menu de navegação</span>
							<span class="glyphicon glyphicon-menu-hamburger">
							</span>
						</button>
						<a class="navbar-brand" href="${path}/menu"></a>
					</div>
					<c:if test="${empty usuarioLogado}">
					<div class="collapse navbar-collapse" id="menu">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="${path}/cadastro">Cadastre-se <i class="glyphicon glyphicon-edit"></i></a></li>
							<li><a href="${path}/loginForm">Entrar <i class="glyphicon glyphicon-log-in"></i></a></li>
						</ul>
					</div>
					</c:if>
					<c:if test="${not empty usuarioLogado}">
						<ul class="nav navbar-nav navbar-right">
      						<li class="dropdown">
       						<a class="dropdown-toggle" data-toggle="dropdown">${usuarioLogado.login}<span class="caret"></span></a>
        					<ul class="dropdown-menu">
          						<li><a href="${path}/postagens">Minhas Postagens</a></li>
          						<li><a href="${path}/meusdados">Meus Dados</a></li>
          						<li><a href="${path}/logout">Sair</a></li>
        					</ul>
      						</li>						
						</ul>
					</c:if>	
				</div> 
			</nav>
		</div>
	</header>
