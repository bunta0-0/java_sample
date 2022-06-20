<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <title>TOP画面</title>
</head>
<body>
<h1>ログイン成功</h1>
<span class="label label-danger">${Error}</span>
<h2>${user.name}</h2>
<h3><a href="/user/logout">ログアウト</a></h3>
<h3><a href="/category/insert">カテゴリー登録 </a></h3>
<h3><a href="/task/insert">タスク登録 </a></h3>
</body>
</html>
