/* 리다이랙트
 *  - 서버가 콘탠트를 보내지 않고, 즉 클라이언트가 뭔가를 출력하지 않고,
 *    즉시 지정된 URL을 호출하게 만드는 기술
 */
package bitcamp.java110.ex09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex09/servlet01")
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    @Override
    public void doGet(
            HttpServletRequest req, 
            HttpServletResponse res) 
            throws ServletException, IOException {

        //방법2)
        // - 응답 헤더에 리프래시 명령을 추가하기
        res.setHeader("Refresh", "2;url=http://daum.net");
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Insert title here</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>안녕하세요!</h1>");
        out.println("</body>");
        out.println("</html>");
        
        //클라이언트에게 즉시 다음 URL로 요청하게 명령한다.
        res.sendRedirect("http://google.com");
/*
빼기 연산을 수행하는 서블릿으로 작업을 위임한다.
주의!
 - 현제까지 출력한 내용을 버린다.
 
 어떻게 웹브라우저로 출력한 것을 취소할 수 있는가?
 - 아직 클라이언트로 출력하지 않았기 때문에 가능 하다.
 - out.println()과 같은 출력문을 호출하면 
     즉시 클라이언트로 출력하는 것이 아니라 버퍼로 출력한다.
 
 *주의 !
 *- '+'문자를 서버에 보낼때 주의해야 한다.
 *- URL에서 '+'문자는 공백을 의미한다.
 *  따라서 서버에서 값을 꺼내면 (getParameter()호출)공백이 리턴된다.
 *- '+' 문자를 서버에 보내려면 URL 인코딩 값을 보내야 한다.
 *  즉 '%2B'
 */
        
    }
}





























