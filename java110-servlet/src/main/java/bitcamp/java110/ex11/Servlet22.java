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

@WebServlet("/ex11/servlet22")
public class Servlet22 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
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













