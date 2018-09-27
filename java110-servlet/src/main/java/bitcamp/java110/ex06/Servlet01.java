/* 서블릿 배치 정보 - loadOnStartUp 속성
 * => loadOnStartUp 속성의 값으 설정하지 않으면,
 *    클라이언트가 최초로 해당 서블릿의 실행을 요청했을 때 비로서 객체를 생성한다.
 * => loadOnStartUp 속성의 값을 설정하면,
 *    웹애플리케이션이 시작 될 때 해당 서블릿 객체를 자동으로 생성한다.
 *    물론 init()도 자동으로 호출한다.
 * => 사용법
 *      loadInStartup=샐행순서
 * => 활용
 *      서블릿을 샐행하기 전에 준비해야할 작업이 있다면,
 *      그리고 그 작업을 수행하는 데 시간이 걸린다면,
 *      서블릿을 샐행하기 전에 미리 서블릿 객체를 만들어 놓고,
 *      init()에서 필요한 자원을 미리 준비시키는 것이 좋다.
 *      모든 서블릿들이 공유하는 자원을 준비시킬 때도 응용할 수있다.
 * 
 */
package main.java.bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/ex06/servlet01")
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet01() {
        System.out.println("ex06.Servlet01...생성 호출됨!");
    }
    
    @Override
    public void init() throws ServletException{
        System.out.println();
    }
    
    @Override
    public void service(
            ServletRequest req, 
            ServletResponse res) 
            throws ServletException, IOException {
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        HttpServletRequest httpReq = (HttpServletRequest)req;
        String method = httpReq.getMethod();
        
        if (method.equals("GET")) {
            out.println("GET 요청입니다.");
        } else if (method.equals("POST")) {
            out.println("POST 요청입니다.");
        } else {
            out.println("기타 요청입니다.");
        }
    }
}





























