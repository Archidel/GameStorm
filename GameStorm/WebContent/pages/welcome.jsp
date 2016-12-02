<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../pages/localization.jsp" %>	<!-- localization -->
<!DOCTYPE html PUBLIC>

<html>
<head>
<head>
	
</head>
	<title>${title}</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="shortcut icon" href="imgaes/web/logotype/game_store_title_logotype.png" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	
	<style>
		body {
			background: url("http://wallpapermonkey.com/wp-content/uploads/2016/05/gaming-wallpapers-and-image.jpg") center center no-repeat;
			background-size: 100%
		}
	</style>

</head>
<body>

<div class="container">
	<div class="row text-center">
        <div class="col-sm-6 col-sm-offset-3">
         <h1 style="color: white;">Game Store</h1>
        <p style="font-size:20px; color: white;"></p>
        
        <form action="Controller" method="post">
        	<button type="submit" name="command" value="random_game" class="btn btn-success"> Sing in</button>
        </form>
        
    <br><br>
        </div>
        
	</div>
</div>

</body>
</html>