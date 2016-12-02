<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../elements/localization.jspf" %>	<!-- localization -->
<!DOCTYPE html PUBLIC>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="shortcut icon" href="../images/web/logotype/game_store_title_logotype.png" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
</head>
<body>
	<!-- jumbotron  -->
	<%@include file="../elements/el_header_jumbotron.jspf" %>


<!-- Navigation bar -->
	<%@include file="../elements/el_header_nav.jspf" %>
	
<!-- container -->
	<div class="container">
		<%@include file="../elements/el_body_admin_edit_game.jspf" %>
	</div>
		
<!-- footer -->	
	<%@include file="../elements/el_footer.jspf" %>  


</body>
</html>