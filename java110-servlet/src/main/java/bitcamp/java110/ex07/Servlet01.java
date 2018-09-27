/* 서버측 객체 보관소
 *  서블릿이나 필터, 리스터를 실행하는 중에 필요한 값들을 보관소에 저장하고 꺼내 쓸 수 있다.
 * 
 * 보관소
 *      1) ServletContext 보관소
 *          - 생성시점 : 웹 애플리케이션이 시작될 대 각 웹앱플리케이션 마다 한개의 보관소가 생성됨
 *          - 소멸시점 : 웹애플리케이션이 종료될 때
 *          - 저장하는 대상
 *              - 서블릿들이 공유하는 객체를 주로 보관한다.
 *              - 예) 로그인 정보, 각 페이지의 입력값을 임시로 유지할 대 등
 *      2) HttpSession 보관소
 *          - 생성시점 : 각 클라이언트에 대해 세션을 시작할 때 마다.
 *          - 소멸시점 : 각 클라이언트에 대해 세션을 종료할 때 마다.
 *              - 클라이언트 전용 정보를 보관한다.
 *              - 예) 로그인 정보, 각 페이지의 입력밧을 입시로 유지할 때 등
 *      3) ServletRequest 보관소
 *          - 생성시점 : 요청이 들어올 대마다.
 *          - 소멸시점 : 응답을 완료할 때 마다.
 *          - 저장하는 대상 
 *              한 요청을 처리하는 서블릿듯링 공유하는 정보
 *      4) PageContext 보관소 
 *          - 생성시점 : JSP가 실생 될 때 마다.
 *          - 소멸시점 : JSP 실행을 마쳤을 때 마다.
 *          - 저장하는 대상
 *              JSP와 태그 핸들러가 공유하는 정보
 */
package main.java.bitcamp.java110.ex07;

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





























