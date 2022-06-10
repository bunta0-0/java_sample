<%--
  Created by IntelliJ IDEA.
  User: kamiyabunta
  Date: 2022/05/24
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新規登録ページ</title>
</head>
<body>
<h3>アカウント新規作成画面</h3>
<span class="label label-danger">${Error}</span>
<form action="/user/signup" method="post">
    <div class="form-group">
        <label for="title">氏名</label>
        <input type="text" class="form-control"  data-cke-saved-name="name" name="name"><br>
        <label for="title">メールアドレス</label>
        <input type="email" class="form-control"  data-cke-saved-name="email" name="email" id="title"><br>
        <label for="title">パスワード</label>
        <input type="text" class="form-control"  data-cke-saved-name="pass" name="pass">
    </div>
    <button type="submit">送信</button>
</form>
</body>
</html>
