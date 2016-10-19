<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style type="text/css">
	<c:set var="path" value="${pageContext.request.contextPath}" scope="request"/>
	@IMPORT url("${path}/resources/css/bootstrap.min.css");
	@IMPORT url("${path}/resources/css/bootstrap-theme.min.css");
	@IMPORT url("${path}/resources/css/custom.css");
	@IMPORT url("${path}/resources/css/style.css");
</style>
<script src="${path}/resources/js/jquery.min.js" 		type="text/javascript"></script>
<meta charset="UTF-8">
<title>Postagens</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
    .top-buffer { margin-top:15px; }
</style>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
<div class="container">
	<c:import url="..\cabecalho.jsp" />
	<form:form commandName="postagem" class="form-horizontal" action="${path}/postagem/crudPostagem" method="post" enctype="multipart/form-data">
	<form:input path="id" type="hidden" />
	<form:input path="imagem" type="hidden"  />
	
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="clearfix">
				<c:if test="${not empty postagem.id}">
 					<strong>Alterar</strong>
				</c:if>
				<c:if test="${empty postagem.id}">
 					<strong>Cadastrar</strong>
				</c:if>  					
			</div>
		</div>
  		<br>
  		<div class="panel-body">
  		
			<div class="row">
			<div class="col-sm-12">
				<label for="descricao">Descrição</label> 
				<form:textarea id="descricao" path="descricao"  class="form-control input-sm"  rows="10" autofocus="autofocus" value="${postagem.descricao}"/>
				<form:errors path="descricao" cssClass="error"/>
			</div>
			</div>

			<div class="row top-buffer">
			<div class="col-sm-5">
				<label for="fileName">Imagem</label> 
				<input name="fileName" type="file" class="form-control input-sm"/>
			</div>
			</div>

			<div class="row top-buffer">
			<div class="col-sm-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="${path}/pokeplaces" class="btn btn-default">Cancelar</a>
			</div>
			</div> 	
			</div> 	
  			<div class="panel-footing">
  				<div class="clearfix">
  					<h1 class="panel-title"></h1>
  				</div>
  			</div>			
	</div>	
	</form:form>
	<br>
</div>
</body>
</html>