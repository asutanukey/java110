/* 리다이랙트
 *  - 서버가 콘탠트를 보내지 않고, 즉 클라이언트가 뭔가를 출력하지 않고,
 *    즉시 지정된 URL을 호출하게 만드는 기술
 */
package bitcamp.java110.ex08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex08/servlet02")
public class Servlet02 extends HttpServlet {
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
             질문1 지금까지 출력한 내용은 어덯게 되나요?
   - out.println() 등을 사용하여 출력한 내용은
                     실제 내부 버퍼에 보관되어 있다.
                     즉 아직 출력하지 않은 생태이다.
   - sendRedirect()를 호출하면 이 버퍼에 보관된 내용을 버려 버린다.
   - 응답할때도 웹 브라우저가 message-body를 출력하지 않는다.
   
   질문 2) 버퍼가 꽉 차면 어떻게 되나요?
- 그럼 자동으로 출력한다.
- 따라서 출력했기 대문에 sendRedirect()를 무시 된다.
 */
    }
}





























