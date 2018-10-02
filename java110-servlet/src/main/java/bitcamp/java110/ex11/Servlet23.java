// 세션 타임아웃
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet23")
public class Servlet23 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
/*
 세션 타임아웃
  - 서블릿 컨테이너의 설정 파일에서 세션 타임아웃 시간을 설정할 수 있다.
  - 각각의 세션 객체에 대해 타임 아웃을 설정할 수 있다.
세션 얻기
 
 */
        
        
        HttpSession session = request.getSession();
        
        //다음과 같이 세션에 대해 타임아웃을 설정 할 수 있다.
        // - 10초 사이에 다시 요청이 들어오지 않으면,
        //   해당 세션은 무효화 된다.
        //session.setMaxInactiveInterval(30);//단위는 초(seconds)
        
        String name = (String)session.getAttribute("name");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>세션 데이터 꺼내기</h1>");
        out.printf("name=%s<br>\n",name);
        out.println("</body>");
        out.println("</html>");
    }
}













