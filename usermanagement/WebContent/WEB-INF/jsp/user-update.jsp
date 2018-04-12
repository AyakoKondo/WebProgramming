<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザ情報更新</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/origin/user-update.css">
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
			<h1>ユーザ情報更新</h1>
		</div>
	</div>
	 
	<form class="update-container" action = "UserUpdateServlet" method = "post" >
		<div class="form-group row">
						
			<label class="col-sm-4 col-form-label">ログインID</label>
			<div class="col-sm-8">
				<p class="form-control-static">${userUpdate.loginId}</p>
			</div>
		</div>
				<div class="form-group row">
			<label for="example-password-input" class="col-sm-4 col-form-label">パスワード</label>
	  		<div class="col-sm-8">
	    		<input class="form-control" type="password" id="example-password-input" name ="password">
			</div>
		</div>
		<div class="form-group row">
			<label for="example-password-input" class="col-sm-4 col-form-label">パスワード（確認）</label>
	 		 <div class="col-sm-8">
	    		<input class="form-control" type="password" id="example-password-input" name = "password2">
			</div>
		</div>
		<div class="form-group row">
			<label for="example-text-input" class="col-sm-4 col-form-label">ユーザ名</label>
			<div class="col-sm-8">
				<input class="form-control" type="text" value="${userUpdate.name}" id="example-text-input" name = "name">
			</div>
		</div>
		<div class="form-group row">
			 <label for="example-date-input" class="col-sm-4 col-form-label">生年月日</label>
			 <div class="col-sm-8">
			 	<input class="form-control" type="date" value="${userUpdate.birthDate}" id="example-date-input" name = "birthDate">
	  		 </div>
		</div>
			<input type="hidden" name ="id" value = "${userUpdate.id}">

	<div class="update-button">
       	<input type="submit" value="更新">
    </div>

	</form>	
	 
	 <div class ="update-container">
	 <c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
	</div>
	 
	 
	 
	 <div class="back">
       	<a href="UserListServlet">戻る</a>
     </div>

</body>
</html>
