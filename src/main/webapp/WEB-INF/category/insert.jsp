<%--
  Created by IntelliJ IDEA.
  User: satohsoichiro
  Date: 2022/06/10
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>カテゴリー新規登録画面</title>
</head>
<body>
<h3>カテゴリー新規登録画面</h3>
<span class="label label-danger">${Error}</span>
<%--formタグ内で入力されたものがlocalhost:8888/category/insertにPOSTリクエストで送られる--%>
<form action="/category/insert" method="post">
    <div class="form-group">
        <label>カテゴリー名</label>
        <input type="text" class="form-control"  data-cke-saved-name="name" name="name"><br>
    </div>
    <button type="submit">送信</button>
</form>
</body>
</html>
