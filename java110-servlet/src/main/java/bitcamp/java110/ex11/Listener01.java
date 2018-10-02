package bitcamp.java110.ex11;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listener01 implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.printf("ex11.Listener01.sessionCreate():%s\n");
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // TODO Auto-generated method stub
        HttpSessionListener.super.sessionDestroyed(se);
    }
}
