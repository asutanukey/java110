package bitcamp.java110.cms.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.util.DataSource;

public class InitServlet extends HttpServlet{
    @Override
    public void init() throws ServletException{
        servletContext sc = this.getServletContext();
        
        try {
            // DAO가 사용할 DB 커낵션풀 객체준비
            DataSource dataSource = new DataSource();
            
        
        ManagerMysqlDao managerDao = new ManagerMysqlDao();
        managerDao.setDataSource(dataSource);
        
        StudentMysqlDao studentDao = new StudentMysqlDao();
        studentDao.setDataSource(dataSource);
        
        TeacherMysqlDao teacherDao = new TeacherMysqlDao();
        teacherDao.setDataSource(dataSource);
        
        // 서블릿에서 DAO를 이용할 수 있도록 ServletContext 보관소에 저장하기
        ServletContext sc = this.getServletContext();
        sc.setAttribute("managerDao", managerDao);
        sc.setAttribute("studentDao", studentDao);
        sc.setAttribute("teacherDao", teacherDao);
        }catch(Exception e) {
            throw new ServletException(e);
        }
        
    }
}
