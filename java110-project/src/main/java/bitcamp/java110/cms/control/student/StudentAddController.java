package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.impl.DuplicationDaoException;
import bitcamp.java110.cms.dao.impl.MandatoryValueDaoException;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
        while (true) {
            Student m = new Student();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("최종학력? ");
            m.setSchool(keyIn.nextLine());
            
            System.out.print("재직여부?(true/false) ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());
             
            try {
                studentDao.insert(m);
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
