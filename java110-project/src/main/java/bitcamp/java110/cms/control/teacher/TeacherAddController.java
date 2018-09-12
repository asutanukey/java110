package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.dao.impl.DuplicationDaoException;
import bitcamp.java110.cms.dao.impl.MandatoryValueDaoException;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherAddController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {
        while (true) {
            Teacher m = new Teacher();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("시급? ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.print("강의과목?(예: 자바,C,C++) ");
            m.setSubjects(keyIn.nextLine());
            
            try {
                teacherDao.insert(m);
                System.out.println("저장하였습니다.");                
            }catch(MandatoryValueDaoException e){
                System.out.println("필수 입력 사항이 누락되었습니다.");
            }catch(DuplicationDaoException e) {
                System.out.println("이미 존재하는 이메일입니다.");
            }
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
}
