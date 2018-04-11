<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザ新規登録</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/origin/user-registration.css">
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
			<h1>ユーザ新規登録</h1>
		</div>
	</div>
	
	<form class="registration-container" action="UserCreateServlet" method="post">

		<div class="form-group row">
			<label for="example-text-input" class="col-4 col-form-label">ログインID</label>
			<div class="col-8">
				<input class="form-control" type="text" name="loginId" id="example-text-input" value="${loginId}">
			</div>
		</div>
		<div class="form-group row">
			<label for="example-password-input" class="col-4 col-form-label">パスワード</label>
	  		<div class="col-8">
	    		<input class="form-control" type="password" name="password" id="example-password-input">
			</div>
		</div>
		<div class="form-group row">
			<label for="example-password-input" class="col-4 col-form-label">パスワード（確認）</label>
	 		 <div class="col-8">
	    		<input class="form-control" type="password" name="password2" id="example-password-input">
			</div>
		</div>
		<div class="form-group row">
			<label for="example-text-input" class="col-4 col-form-label">ユーザ名</label>
			<div class="col-8">
				<input class="form-control" type="text" name="name" id="example-text-input" value="${name}">
			</div>
		</div>
		<div class="form-group row">
			 <label for="example-date-input" class="col-4 col-form-label">生年月日</label>
			 <div class="col-8">
			 	<input class="form-control" type="date" name="birthDate" id="example-date-input" value="${birthDate}">
	  		 </div>
		</div><%--now()でcreateDate,updateDate指定してあるのでhiddenで値を受け取る必要なし --%>
			
	

		<div class="registry-button">
       		<input type="submit" value="登録">
       </div>
	
	<br>
	<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
	
	
	</form>
	
       <div class="back">
       	<a href="UserListServlet">戻る</a>
       </div>
</body>
</html>
