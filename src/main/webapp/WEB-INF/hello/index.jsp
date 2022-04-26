<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/hello" method="post">
        <label>名前</label>
        <input type="text" name="name">
        <br>
        <label>パスワード</label>
        <input type="text" name="pass">
        <br>
        <button type="submit">送信</button>
    </form>
</body>
</html>
