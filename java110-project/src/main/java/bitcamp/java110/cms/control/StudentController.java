package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class StudentController {

    static Student[] students = new Student[5];
    static int studentIndex = 0;
    
    public static Scanner keyIn;
    
    static class Student extends Member {
        protected String school;
        protected boolean working;
        protected String tel;
        
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
            System.out.print("�л� ����> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printStudents();
            } else if (command.equals("add")) {
                inputStudents();
            } else if (command.equals("delete")) {
                deleteStudent();
            } else if (command.equals("detail")) {
                detailStudent();
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("��ȿ���� �ʴ� ����Դϴ�.");
            }
        }
    }
    
    private static void printStudents() {
        int count = 0;
        for (Student s : students) {
            if (count++ == studentIndex)
                break;
            System.out.printf("%d: %s, %s, %s, %s, %b, %s\n",
                    count - 1,
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel());
        }
    }
    
    private static void inputStudents() {
        while (true) {
            Student m = new Student();
            
            System.out.print("�̸�? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("�̸���? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("��ȣ? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("�����з�? ");
            m.setSchool(keyIn.nextLine());
            
            System.out.print("��������?(true/false) ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("��ȭ? ");
            m.setTel(keyIn.nextLine());
            
            
            if (studentIndex == students.length) {
                increaseStorage();
            }
            
            students[studentIndex++] = m;
            
            System.out.print("��� �Ͻðڽ��ϱ�?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

    private static void increaseStorage() {
        Student[] newList = new Student[students.length + 3];
        for (int i = 0; i < students.length; i++) {
            newList[i] = students[i];
        }
        students = newList;
    }
    
    private static void deleteStudent() {
        System.out.print("������ ��ȣ? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= studentIndex) {
            System.out.println("��ȿ�� ��ȣ�Դϴ�.");
            return;
        }
        
        for (int i = no; i < studentIndex - 1; i++) {
            students[i] = students[i + 1];
        }
        studentIndex--;
        
        System.out.println("�����Ͽ����ϴ�.");
    }
    
    private static void detailStudent() {
        System.out.print("��ȸ�� ��ȣ? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= studentIndex) {
            System.out.println("��ȿ�� ��ȣ�Դϴ�.");
            return;
        }
        
        System.out.printf("�̸�: %s\n", students[no].getName());
        System.out.printf("�̸���: %s\n", students[no].getEmail());
        System.out.printf("��ȣ: %s\n", students[no].getPassword());
        System.out.printf("�����з�: %s\n", students[no].getSchool());
        System.out.printf("��ȭ: %s\n", students[no].getTel());
        System.out.printf("��������: %b\n", students[no].isWorking());
    }
    
    static {
        Student s = new Student();
        s.setName("a");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("b");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("c");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("d");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("e");
        students[studentIndex++] = s;
    }
}