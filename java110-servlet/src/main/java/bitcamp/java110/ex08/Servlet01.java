/* 리프래시
 * 클라이언트에서 자동으로 서버로 자동으로 요청하게 만드는 기술
 */
package bitcamp.java110.ex08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex08/servlet01")
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    @Override
    public void doGet(
            HttpServletRequest req, 
            HttpServletResponse res) 
            throws ServletException, IOException {

        //방법1)
        // - 응답 헤더에 리프래시 명령을 추가하기
        //res.setHeader("Refresh", "2;url=http://daum.net");
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        
        //방법2)
        // - HTML의 <meta>태그에 리프래시 명령을 실행할 수 있다.
        out.println("<meta http-equiv='Refresh' content='5:url=//www.naver.com'>");
        
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Insert title here</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>안녕하세요!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}





























