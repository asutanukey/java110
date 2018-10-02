// 세션 사용 후 - HttpSession 보관소에 데이터 저장하기
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet21")
public class Servlet21 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
/*
 * 세션 얻기
요청 프로토콜의 쿠키 정보에서 세션 아이디를 검사한다.
있다면,
    -웹브라우저가 제사한 세션 아이디에 해당하는 셔션 객체를 찾는다.
    -있다면, 유효하다면,
    그 세션 객체를 리턴한다.
    웹 브라우저가 세션 아이디를 갖고 있기 때문에
    응답할 대 프로토콜에 쿠키로 다시 세션 아이디를 보내지 않는다.
    -있다면 그러나 timeout 되어 무효하다면, 
    없을때와 똑같이 처리한다.
없다면,
    -새로 HttpSession 객페를 생성하여 리턴한다.
    -응답할 때 응답 프로토콜의 쿠키 정보로 
    새로 생성한 세션객체의 세션 아이디를 보낸다.
    -웹 브라우저는 세버로 부터 받은 쿠키데이터인 세션ID를 
    서버에 요청할 대마다 보낼 것이다.
세션 ID를 응답 프로토콜로 보내는 예)
    -톰캣 서버에서는JSESSIONID라는 쿠키 이름으로 세션 아이디를 보낸다.
    -WAS마다
 */
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        session.setAttribute("name", "하이염");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>최종 페이지</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}













