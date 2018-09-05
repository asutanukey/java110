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
        
    }//������ ������

    static void serviceManagerMenu() {
        while (true) {
            System.out.println("�޴��� ����>");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printManagers();
            }else if (command.equals("add")) {
                inputManagers();
            }else if (command.equals("quit")) {
                break;
            }else {
                System.out.println("��ȿ���� ���� ����Դϴ�");
            }                
        }
    }//�޴��� ���� �޴�

    static void inputManagers() {
        //2) ����ڷκ��� ȸ�� ���� �Է¹ޱ�
        while (true) {
            //members[index] = new Member();
            Manager m = new Manager();

            System.out.println("�̸�?");
            m.setName(keyIn.nextLine());

            System.out.println("�̸���?");
            m.setEmail(keyIn.nextLine());

            System.out.println("��ȣ?");
            m.setPassword(keyIn.nextLine());

            System.out.println("��ȭ��ȣ?");
            m.setTel(keyIn.nextLine());

            System.out.println("���ǰ���?(�� : Java,C,C++");
            m.setPosition(keyIn.nextLine());

            managers[managerIndex++] = m;

            //index++;

            System.out.println("����Ͻðڽ��ϱ�? (y/n)");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }//inputTeacher �޼���

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
