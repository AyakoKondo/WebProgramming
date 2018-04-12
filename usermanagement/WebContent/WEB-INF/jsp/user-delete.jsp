<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザ削除確認</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/origin/user-delete.css">
	<!-- Jqeryの読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
    <!-- レイアウトカスタマイズ用個別CSS -->

</head>


<body>
	<header>
		<div class="container">
			<div class="header-out"><a href="LogoutServlet" class="logout">ログアウト</a>
			</div>
			<div class="header-user">${userInfo.name}さん
			</div>
		</div>
	</header>

	<div class="container">
		<div class="page-title">
			<h1>ユーザ削除確認</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="confirm">
			<p>ログインID: ${userDelete.loginId}<br>を本当に削除してよろしいでしょうか。</p>
		</div>
			
	<div class="check-container">	
	<a href = "UserListServlet"><input type="submit" value="キャンセル"></a>
	
	<form action = "UserDeleteServlet" method ="post">
		<input type="submit" value="OK">
		<input type="hidden" name ="id" value = "${userDelete.id}">
	</form>
	</div>
	
	</div>
</body>
</html>