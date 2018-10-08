<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% 
private String b;
public m1(){
    return "m1()호출함"; }
%>

<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

<h1>선언부 (Declaration Element)</h1>

<pre>
- 자동으로 생성된 서블릿 클래스에 멤버를 추가할 때 사용한다.
    &lt;%! 멤버선언 %>
    
    선언부에 작성한 코드는 그래도 클래스 블록안에 복사될 것이기 때문에
    선언부를 작성하는 위치는 상관 없다.
    
-자바코드 :
    멤버 선언 코드는 그대로 클래스 블록 안에 복사된다.
  class test_jsp ... {
  
                    여기에 복사된다.
                    
         public void _jspService(){
                
             ...
         }
   }
   
   -멤버?
        - 클래스 필드 및 메서드 (스태틱 필드 및 메서드)
            static int a;
            static void m(){...}
        - 인스턴스 필드 및 메서드
            int a;
            void m(){...}
</pre>

</body>
<%
int c;
public void m2(){}


%>
</html>





