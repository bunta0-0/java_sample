<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@ include file="../common/common.jsp"%>
  <title>TOP画面</title>
</head>
<body>
<h2>${currentuser.name}</h2>
<%@ include file="../common/header.jsp"%>
<c:if test="${not empty tasks}">
  <form action = "/DidTask" method = post>
    <%@ include file="../common/task.jsp"%>
    <button>更新</button>
  </form>
</c:if>
</div>
</body>
</html>
