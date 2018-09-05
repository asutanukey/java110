import java.util.Scanner;

public class ManagerController {
    static Manager[] managers = new Manager[100];
    static int managerIndex = 0;
    static Scanner keyIn;

    static class Manager extends Member {
        protected String tel;
        protected String position;
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
        
    }//선생님 생성자

    static void serviceManagerMenu() {
        while (true) {
            System.out.println("메니저 관리>");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printManagers();
            }else if (command.equals("add")) {
                inputManagers();
            }else if (command.equals("quit")) {
                break;
            }else {
                System.out.println("유효하지 않은 명령입니다");
            }                
        }
    }//메니저 서비스 메뉴

    static void inputManagers() {
        //2) 사용자로부터 회원 정보 입력받기
        while (true) {
            //members[index] = new Member();
            Manager m = new Manager();

            System.out.println("이름?");
            m.setName(keyIn.nextLine());

            System.out.println("이메일?");
            m.setEmail(keyIn.nextLine());

            System.out.println("암호?");
            m.setPassword(keyIn.nextLine());

            System.out.println("전화번호?");
            m.setTel(keyIn.nextLine());

            System.out.println("강의과목?(예 : Java,C,C++");
            m.setPosition(keyIn.nextLine());

            managers[managerIndex++] = m;

            //index++;

            System.out.println("계속하시겠습니까? (y/n)");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }//inputTeacher 메서드

    static void printManagers() {
        int count = 0;
        for (Manager s : managers) {
            if (count++==managerIndex)
                break;
            System.out.printf("%s, %s, %s\n"
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getTel()
                    ,s.getPosition());
        }
    }

}
