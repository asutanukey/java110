<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

<h1>page 지시명령문</h1>

<pre>
language 속성
    - 기본 값 "java"
    - 스크립트릿, 표현식에 작성할 수 있는 프로그래밍 언어를 지정한다.
    -원래는 다양한 언어를 사용할 수 있게 규칙을 정했지만,
           현업에서는 "java"만 사용한다.
    -그리고 규칙상으로도 "java" 값만 가질 수 있다.

contentType 속성
    - 다음 자바 코드를 _jspService() 메서드안에  생성한다.
        response.setContextType(속성 값);
        
pageEncording 속성
    - JSP엔진에게 JSP 파일이 어떤 문자표를 사용하여 인코딩 했는지 알려준다.
    
import 속성
    - 서블릿 클래스에 import 코드를 추가한다.
        예) import 속성에 콤마를 사용하여 여러 import문장을 작성할 수 있다.
        
trimDirectiveWhitespaces 속성
    - true로 설정하면, 지시명령어 태그 뒤에 있는 줄바꿈 코드는 출력하지 않는다.
    
buffer 속성
    - 출럭 데이터를 임시 보관하는 버퍼의 크기를 설정한다.
    - 기본 값은 8KB이다.
    - 만약 버퍼크기를 초과하면 autoFlush의 설정에 다라 처리된다.
     autoFlush="true"
        - 버퍼를 초과하는 순간 클라이언트로 즉시 출력된다.
     autoFlush="false"
        - 버퍼를 초과하는 순간 예외가 발생한다.
        
autoFlush 속성
    - 버퍼가 꽉찼을 때 클라이언트로 내보낼지 여보를 설정한다.
    - 기본 값은 true이다. 
        true : 버퍼가 즉시 출력한다. 

</pre>

</body>
</html>





