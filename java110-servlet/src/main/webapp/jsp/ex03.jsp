<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
int a;
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
a = 100;
int b = a++;
%>

<h1>스크립트릿(scriptlet)</h1>
<pre>
- JSP 파일의 안에 작성하는 자바코드이다.
    &li;%= 표현식 %>
- 자바 코드 : 
   스크립트릿 태그안에 작성한 자바코드는 _jspService() 안에 순서 그대로 복사된다.
</pre>

</body>
</html>