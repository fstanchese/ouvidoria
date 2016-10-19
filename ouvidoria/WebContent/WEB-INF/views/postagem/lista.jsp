<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="pt-br"> 
<head>
	<link href="resources/assets/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" media="all">
	<link href="resources/css/styles.css?321" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="resources/assets/sksmatt-UItoTop-jQuery-Plugin/css/ui.totop.css?<?=rand();?>">
	<link rel="stylesheet" href="resources/assets/fancybox/jquery.fancybox.css">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>Projeto 4º semestre</title>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />
<script src="resources/js/jquery-1.11.2.min.js"></script>
<script src="resources/js/scripts.js"></script>
<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/assets/sksmatt-UItoTop-jQuery-Plugin/js/jquery.ui.totop.min.js"></script>
<script src="resources/assets/sksmatt-UItoTop-jQuery-Plugin/js/easing.js" ></script>
<script src="resources/assets/fancybox/jquery.fancybox.pack.js"></script>

<div class="container">
	<c:import url="..\cabecalho.jsp" />
		<div class="panel panel-group">
   		<div class="panel panel-primary">
   			<div class="panel-heading">
			<a href="${path}/postagem/novo" class="btn btn-info" role="button">Nova Postagem</a>
			<br>
			<br>
			<form class="form-horizontal">
				<label for="areaId">Selecione a Área</label> 
				<select id="areaId" name="area_id" class="js-example-diacritics form-control input-sm pokemon">
					<option value=""></option>
					<c:forEach var="area" items="${areas}">
							<option value="${area.id}"
								${area.id==areaFiltro.id ? 'selected' : ''}>${area.nome}					
							</option>
					</c:forEach>				
				</select>
			</form>
   			</div>
			<c:if test="${not empty pokeplaces}">
			<table class="table table-hover table-condensed table-striped table-bordered">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Cidade</th>
						<th>Latitude</th>
						<th>Longitude</th>
						<th>Tipo</th>
						<th width="06%">Imagem</th>
						<th width="12%">Acao</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pokeplace" items="${pokeplaces}">
						<tr id="row${pokeplace.id}">
							<td>&nbsp;${pokeplace.nome}</td>
							<td>&nbsp;${pokeplace.cidade.nome}</td>
							<td>&nbsp;${pokeplace.latitude}</td>
							<td>&nbsp;${pokeplace.longitude}</td>
							<td>&nbsp;${pokeplace.tipo.nome}</td>
							<td width="12%">
								<a href="#" class="btn btn-success btn-xs"  onclick="window.open('${pageContext.request.contextPath}/pokeplaces/imageDisplay?id=${pokeplace.id}', 'Pagina', 'STATUS=NO, TOOLBAR=NO, LOCATION=NO, DIRECTORIES=NO, RESISABLE=NO, SCROLLBARS=YES, TOP=100, LEFT=300, WIDTH=660, HEIGHT=400');" role="button">Exibir</a>								
							</td>
							<td width="12%">
								<a href="${path}/pokeplaces/edit/${pokeplace.id}" class="btn btn-warning btn-xs" role="button">Alterar</a>
								<a href="${path}/pokeplaces/delete/${pokeplace.id}" class="btn btn-danger btn-xs" role="button">Excluir</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</c:if>
		</div>
	</div>
</div>
<script src="${path}/resources/js/bootstrap.min.js" 	type="text/javascript"></script>
<script src="${path}/resources/js/zebra.dialog.js" 		type="text/javascript"></script>
<script src="${path}/resources/js/zebra.dialog.src.js" 	type="text/javascript"></script>
</body>
</html>