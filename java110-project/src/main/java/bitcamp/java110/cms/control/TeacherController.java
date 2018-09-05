package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class TeacherController {
    static Teacher[] teachers = new Teacher[100];
    static int teacherIndex = 0;
    public static Scanner keyIn;

    static class Teacher extends Member {
        protected String tel;
        protected int pay;
        protected String subject;


        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubject() {
            return subject;
        }
        public void setSubject(String subject) {
            this.subject = subject;
        }

    }//선생님 생성자

    public static void serviceTeacherMenu() {
        while (true) {
            System.out.println("강사 관리>");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printTeachers();
            }else if (command.equals("add")) {
                inputTeachers();
            }else if (command.equals("quit")) {
                break;
            }else {
                System.out.println("유효하지 않은 명령입니다");
            }                
        }
    }//선생님 서비스 메뉴

    public static void inputTeachers() {
        //2) 사용자로부터 회원 정보 입력받기
        while (true) {
            //members[index] = new Member();
            Teacher m = new Teacher();

            System.out.println("이름?");
            m.setName(keyIn.nextLine());

            System.out.println("이메일?");
            m.setEmail(keyIn.nextLine());

            System.out.println("암호?");
            m.setPassword(keyIn.nextLine());

            System.out.println("전화번호?");
            m.setTel(keyIn.nextLine());

            System.out.println("시급?");
            m.setPay(Integer.parseInt(keyIn.nextLine()));

            System.out.println("강의과목?(예 : Java,C,C++");
            m.setSubject(keyIn.nextLine());

            teachers[teacherIndex++] = m;

            //index++;

            System.out.println("계속하시겠습니까? (y/n)");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }//inputTeacher 메서드

    static void printTeachers() {
        int count = 0;
        for (Teacher s : teachers) {
            if (count++==teacherIndex)
                break;
            System.out.printf("%s, %s, %s\n"
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getTel()
                    ,s.getPay()
                    ,s.getSubject());
        }
    }

}
