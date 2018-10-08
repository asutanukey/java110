<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h1>EL - List객체에서 값 꺼내기</h1>
<%
HashMap<String> map = new HashMap<>();
map.put("s01","김구");
map.put("s02","안중근");
map.put("s02","윤봉길");

pageContext.setAttribute("map", map);
%>

${map["s01"]}<br>
${map['s01']}<br>
${map.s01}<br>
</body>
</html>