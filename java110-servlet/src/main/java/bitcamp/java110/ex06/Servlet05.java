/* 서블릿 배치 정보 - 컨텍스트 초기화 파라미터
 *=>  컨택스트 초기화 파라미터는 모든 서블릿이 참조할 수 있다.
 *    즉 모든 서블릿이 공유해야 하는 정보를 컨텍스트가 초기화 파라미터로 선언하라
 *=>  활용
 *    DB연결정보, 파일 업로드 설정 정보 등
 */
package main.java.bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/ex06/servlet01")
public class Servlet05 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest req, 
            ServletResponse res) 
            throws ServletException, IOException {
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        //배치정보에서 서블릿 초기화 파라미터 값을 거내기
        out.printf("서블릿 초기화 파라미터 aaa=%s\n"
                , this.getInitParameter("aaa"));
        
        //배치정보에서 초기화 파라미터 값을 꺼내기
        out.printf("컨텍스트 초기화 파라미터 aaa=%s\n",
                this.getInitParameter("bbb"));
    }
}





























