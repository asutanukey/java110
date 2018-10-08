<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h1>EL 표기법</h1>
<pre>
-EL(Expression Language)은 콤마(.)와 대괄호([]) 등을 사용하여 객체의
 프로퍼티나, 리스트, 셋, 맵 객체의 값을 쉽게 꺼내고 설정하게 도와주는 문법이다.
 특히 값을 꺼낼때는 OGNL 표기법을 사용한다.
-OGNL(Object Graph Navigation Language)?
 객체의 포로퍼티 값을 가리는 문법이다.
 파일의 경로처럼 객체에 포함된 객체를 탐색하여 값을 쉽게 조회할 수 있다.
-문법
    ${ 객체명.프로퍼티명.프로퍼티명.프로퍼티명 }
    ${ 객체명["프로퍼티명"]["프로퍼티명"]["프로퍼티명"] }
-EL에서 사용할 수 있는 객체?
    pafeContext - JSP의 PageContext 객체
    servletContext - $ { pageContext.servletContext.프로퍼티명 }
    session - $ { pageContext.session.프로퍼티명 }
    request - $ { pageContext.request.프로퍼티명 }
    response
    param - $ { param.파라미터명 }
              => request.getParameter("파라미터명");
    paramValues - $ { paramValues.파라미터명 }
              => request.getParameterValues("파라미터명");
    header - $ { header.헤더명 }
              => request.getHeader("헤더명");
    headerValues - $ { headerValues.헤더명 }
              => request.getHeaders("헤더명");
    cookie - $ { cookie.쿠키명 }
    initParam -$ { initParam.파라미터명 }
    
    => 보관소에서 값을 거내는 문법
    pageScope - $ { pageScope.객체이름 }
</pre>

</body>
</html>