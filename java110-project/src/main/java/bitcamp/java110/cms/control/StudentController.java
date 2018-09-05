package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class StudentController {

    static Student[] students = new Student[100];
    static int studentIndex = 0;
    public static Scanner keyIn;

    static class Student extends Member {
        String school;
        boolean working;
        String tel;

        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
    }

    public static void serviceStudentMenu() {
        while (true) {
            System.out.println("�л� ����>");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printStudents();
            }else if (command.equals("add")) {
                inputStudents();
            }else if (command.equals("delete")) {
                deleteStudents();
            }else if (command.equals("detail")) {
                detailStudent();
            }else if (command.equals("quit")) {
                break;
            }else {
                System.out.println("��ȿ���� ���� ����Դϴ�");
            }                
        }
    }

    static void printStudents() {
        int count = 0;
        for (Student s : students) {
            if (count++==studentIndex)
                break;
            System.out.printf("%s, %s, %s\n"
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());
        }
        /*        for (int i = 0; i < index; i++)
        System.out.printf("%s, %s, %s\n",members[i].getName(),members[i].getEmail(),members[i].getPassword());
         */
    }

    static void inputStudents() {
        //2) ����ڷκ��� ȸ�� ���� �Է¹ޱ�
        while (true) {
            //members[index] = new Member();
            Student m = new Student();

            System.out.println("�̸�?");
            m.setName(keyIn.nextLine());

            System.out.println("�̸���?");
            m.setEmail(keyIn.nextLine());

            System.out.println("��ȣ?");
            m.setPassword(keyIn.nextLine());

            System.out.println("�����з�?");
            m.setSchool(keyIn.nextLine());

            System.out.println("��������?(true/false)");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));

            System.out.println("��ȭ��ȣ?");
            m.setTel(keyIn.nextLine());
            
            if (studentIndex == students.length) {
                Student[] newList = new Student[students.length+3];
                for (int i = 0; i<students.length;i++) {
                    newList[i] = students[i];
                }
                students = newList;
            }

            students[studentIndex++] = m;

            //index++;

            System.out.println("����Ͻðڽ��ϱ�? (y/n)");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
    }//inputStudent �޼���
    
    private static void deleteStudents() {
        System.out.print("������ ��ȣ?");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >=studentIndex) {
            System.out.println("��ȿ�� ��ȣ �Դϴ�.");
        }
        for (int i = no; i < studentIndex - 1; i++) {
            students[i] = students[i + 1];
        }
        studentIndex--;
        
        System.out.println("���� �Ͽ����ϴ�");
    }
    
    private static void detailStudent() {
        System.out.print("��ȸ�� ��ȣ?");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >=studentIndex) {
            System.out.println("��ȿ�� ��ȣ �Դϴ�.");
        }
        for (int i = no; i < studentIndex - 1; i++) {
            students[i] = students[i + 1];
        }
        System.out.printf("�̸�: %s\n",students[no].getName());
        System.out.printf("�̸���: %s\n",students[no].getEmail());
        System.out.printf("��ȣ: %s\n",students[no].getPassword());
        System.out.printf("�����з�: %s\n",students[no].getSchool());
        System.out.printf("��ȭ: %s\n",students[no].getTel());
        System.out.printf("��������: %s\n",students[no].isWorking());
    }
    
    static {
        Student s = new Student();
        s.setName("a");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("a");
        students[studentIndex++] = s;

        s = new Student();
        s.setName("a");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("a");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("a");
        students[studentIndex++] = s;
    }

}



































