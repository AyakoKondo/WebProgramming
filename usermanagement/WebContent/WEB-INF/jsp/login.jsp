<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>ログイン画面</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/origin/signin.css">
	<!-- Jqeryの読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
    <!-- レイアウトカスタマイズ用個別CSS -->
	
</head>

<body class="text-center">



	<form class="form-signin" action="LoginServlet" method="post">
		<img class="mb-4" src="illust/magnifier_animal_neko.png" alt="" width=143 height=200>
		<h1 class="h3 mb-3 font-weight-normal">ログイン画面</h1>
		
			<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
		
		<!--<label for="inputId" class="sr-only">ID</label>-->
		<input type="text" name="loginId" id="inputLoginId" class="form-control" placeholder="ログインID" required autofocus>
		<!--<label for="inputPassword" class="sr-only">パスワード</label>-->
		<input type="password" name="password" id="inputPassword" class="form-control" placeholder="パスワード" required>

		<button class="btn btn-lg btn-primary btn-block" type="submit">ログイン</button>
	</form>
</body>
</html>