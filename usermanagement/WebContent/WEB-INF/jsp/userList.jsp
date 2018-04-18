<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>ユーザ一覧</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/origin/userlist.css">
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
		     <h1>ユーザ一覧</h1>
		     <h2><a href="UserCreateServlet">新規登録</a></h2>
		</div>
	</div>
     
       <div class="search-form">
       <form action="UserListServlet" method="post">
       	<div class="form-group row">
       		<label for="code" class="col-sm-2 col-form-label">ログインID</label>
       		<div class="col-sm-10">
       		     <input type="text" name="loginId" id="loginId" class="form-control">
       		</div>
       	</div>
       	<div class="form-group row">
       		<label for="inputUserName" class="col-sm-2 col-form-label">ユーザ名</label>
       		<div class="col-sm-10">
       			<input type="text" name="name" id="name" class="form-control">
       		</div>
       	</div>
       	
       	
        <div class="form-inline">	
       		<div class="form-group row">
       			<label for="inputBirthday" class="col-sm-2 col-form-label">生年月日</label>
       			<div class="col-sm-10">
       				<input type="date" name="birthDateStart" id="date-start" class="form-control" >  ～  <input type="date" name="birthDateEnd" id="date-end"  class="form-control">
       			</div>
       		<div class="search-button">
       			<button type="submit" value="検索" class="btn btn-primary form-submit">検索</button>
       		</div>
       		</div>
       	</div>
       	</form>
       </div>
       <hr>
       	<div class="userlist-container">
       		<table class="table" align="center">
       			<thead>
       				<tr>
       					<th>ログインID</th>
       					<th>ユーザ名</th>
       					<th>生年月日</th>
       					<th></th>
       				</tr>
       			</thead>
       			<tbody>
       			 	<c:forEach var="user" items="${userList}" >
       					<tr>
	       					<td>${user.loginId}</td>
                     		<td>${user.name}</td>
                     		<td>${user.birthDate}</td>
                     		<!-- TODO 未実装；ログインボタンの表示制御を行う -->
                     		<td>
	                     		<a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">詳細</a>
			                    
			                    <c:if test ="${userInfo.loginId =='admin' || userInfo.loginId == user.loginId}">
			                    <a class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
			                    </c:if> 
			                    <c:if test ="${userInfo.loginId =='admin'}">
			                    <a class="btn btn-danger" href ="UserDeleteServlet?id=${user.id}">削除</a>
								</c:if>       
			                </td>
       					</tr>
       				</c:forEach>
       			</tbody>
       		</table>
		</div>  



</body>
</html>