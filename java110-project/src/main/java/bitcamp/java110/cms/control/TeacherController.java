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

    }//������ ������

    public static void serviceTeacherMenu() {
        while (true) {
            System.out.println("���� ����>");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printTeachers();
            }else if (command.equals("add")) {
                inputTeachers();
            }else if (command.equals("quit")) {
                break;
            }else {
                System.out.println("��ȿ���� ���� ����Դϴ�");
            }                
        }
    }//������ ���� �޴�

    public static void inputTeachers() {
        //2) ����ڷκ��� ȸ�� ���� �Է¹ޱ�
        while (true) {
            //members[index] = new Member();
            Teacher m = new Teacher();

            System.out.println("�̸�?");
            m.setName(keyIn.nextLine());

            System.out.println("�̸���?");
            m.setEmail(keyIn.nextLine());

            System.out.println("��ȣ?");
            m.setPassword(keyIn.nextLine());

            System.out.println("��ȭ��ȣ?");
            m.setTel(keyIn.nextLine());

            System.out.println("�ñ�?");
            m.setPay(Integer.parseInt(keyIn.nextLine()));

            System.out.println("���ǰ���?(�� : Java,C,C++");
            m.setSubject(keyIn.nextLine());

            teachers[teacherIndex++] = m;

            //index++;

            System.out.println("����Ͻðڽ��ϱ�? (y/n)");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }//inputTeacher �޼���

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
