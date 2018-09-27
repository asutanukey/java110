/* 서블릿 배치 정보 - 초기 파라미터
 * => 서블릿이 샐행하는 동안 사용할 값이 고정값이라면
 *    자바 코드로 그 값을 표현하기 보다는
 *    애노테이션이나 XML 태그로 표현하는 것이 관리하기 편하다.
 * 
 */
package main.java.bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value="/ex06/servlet02",
            initParams = {
                    @WebInitParam(name= "aaa", value="hello"),
                    @WebInitParam(name= "bbb", value="hello2"),
                    @WebInitParam(name= "ccc", value="hello3")
            })
public class Servlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet02() {
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
        
        //배치정보에서 초기화 파라미터 값을 꺼내기
        out.printf("aaa=%s\n", this.getInitParameter("aaa"));
        out.printf("bbb=%s\n", this.getInitParameter("bbb"));
        out.printf("ccc=%s\n", this.getInitParameter("ccc"));
    }
}




























