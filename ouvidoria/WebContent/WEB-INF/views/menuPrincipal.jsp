<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<c:import url="cabecalho.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="resources/js/scripts.js"></script>
<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/assets/sksmatt-UItoTop-jQuery-Plugin/js/jquery.ui.totop.min.js"></script>
<script src="resources/assets/sksmatt-UItoTop-jQuery-Plugin/js/easing.js" ></script>
<script src="resources/assets/fancybox/jquery.fancybox.pack.js"></script>
</body>
</html>
