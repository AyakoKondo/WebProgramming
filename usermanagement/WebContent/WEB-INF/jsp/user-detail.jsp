<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザ情報詳細参照</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/origin/user-detail.css">
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
			<h1>ユーザ情報詳細参照</h1>
		</div>
	</div>
	 
	 <form class="detail-container">

		<div class="form-group row">
			<label class="col-sm-4 col-form-label">ログインID</label>
			<div class="col-sm-8">
				<p class="form-control-static">${userDetail.loginId}</p>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-4 col-form-label">ユーザ名</label>
	  		<div class="col-sm-8">
	    		<p class="form-control-static">${userDetail.name}</p>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-4 col-form-label">生年月日</label>
	 		 <div class="col-sm-8">
	    		<p class="form-control-static">${userDetail.birthDate}</p>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-4 col-form-label">登録日時</label>
			<div class="col-sm-8">
				<p class="form-control-static">${userDetail.createDate}</p>
			</div>
		</div>
		<div class="form-group row">
			 <label class="col-sm-4 col-form-label">更新日時</label>
			<div class="col-sm-8">
				<p class="form-control-static">${userDetail.updateDate}</p>
	  		 </div>
		</div>

	</form>	


	 <div class="back">
       	<a href="UserListServlet">戻る</a>
     </div>

</body>
</html>
