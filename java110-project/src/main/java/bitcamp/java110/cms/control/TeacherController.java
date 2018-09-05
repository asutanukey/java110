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
        protected String subjects;
        
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
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
    }
    
    public static void serviceTeacherMenu() {
        while (true) {
            System.out.print("���� ����> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printTeachers();
            } else if (command.equals("add")) {
                inputTeachers();
            } else if (command.equals("delete")) {
                deleteTeacher();
            } else if (command.equals("detail")) {
                detailTeacher();
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("��ȿ���� �ʴ� ����Դϴ�.");
            }
        }
    }
    
    private static void printTeachers() {
        int count = 0;
        for (Teacher s : teachers) {
            if (count++ == teacherIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %d, [%s]\n", 
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getTel(),
                    s.getPay(),
                    s.getSubjects());
        }
    }
    
    private static void inputTeachers() {
        while (true) {
            Teacher m = new Teacher();
            
            System.out.print("�̸�? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("�̸���? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("��ȣ? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("��ȭ? ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("�ñ�? ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.print("���ǰ���?(��: �ڹ�,C,C++) ");
            m.setSubjects(keyIn.nextLine());
            
            if (teacherIndex == teachers.length) {
                increaseStorage();
            }
            
            teachers[teacherIndex++] = m;
            
            System.out.print("��� �Ͻðڽ��ϱ�?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    private static void increaseStorage() {
        Teacher[] newList = new Teacher[teachers.length + 3];
        for (int i = 0; i < teachers.length; i++) {
            newList[i] = teachers[i];
        }
        teachers = newList;
    }
    
    private static void deleteTeacher() {
        System.out.print("������ ��ȣ? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= teacherIndex) {
            System.out.println("��ȿ�� ��ȣ�Դϴ�.");
            return;
        }
        
        for (int i = no; i < teacherIndex - 1; i++) {
            teachers[i] = teachers[i + 1];
        }
        teacherIndex--;
        
        System.out.println("�����Ͽ����ϴ�.");
    }
    
    private static void detailTeacher() {
        System.out.print("��ȸ�� ��ȣ? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= teacherIndex) {
            System.out.println("��ȿ�� ��ȣ�Դϴ�.");
            return;
        }
        
        System.out.printf("�̸�: %s\n", teachers[no].getName());
        System.out.printf("�̸���: %s\n", teachers[no].getEmail());
        System.out.printf("��ȣ: %s\n", teachers[no].getPassword());
        System.out.printf("��ȭ: %s\n", teachers[no].getTel());
        System.out.printf("�ñ�: %d\n", teachers[no].getPay());
        System.out.printf("���ǰ���: %s\n", teachers[no].getSubjects());
    }
}