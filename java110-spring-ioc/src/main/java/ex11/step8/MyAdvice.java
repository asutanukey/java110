package ex11.step8;

public class MyAdvice {

    public void before(String f) {
        System.out.println("MyAdvice.before(): " + f);
    }
    
    public void afterReturning(Object rt) {
        System.out.println("MyAdvice.afterReturning(): " + rt.toString());
    }
    
    public void afterThrowing(Exception err) {
        System.out.println("MyAdvice.afterThrowing(): " + err.getMessage());
    }
    
    
}
