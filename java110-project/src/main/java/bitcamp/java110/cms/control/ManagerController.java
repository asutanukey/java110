package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class ManagerController {

    static Manager[] managers = new Manager[100];
    static int managerIndex = 0;
    
    public static Scanner keyIn;
    
    static class Manager extends Member {
        protected String position;
        protected String tel;

        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
    }
    
    
    public static void serviceManagerMenu() {
        while (true) {
            System.out.print("�Ŵ��� ����> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printManagers();
            } else if (command.equals("add")) {
                inputManagers();
            } else if (command.equals("delete")) {
                deleteManager();
            } else if (command.equals("detail")) {
                detailManager();
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("��ȿ���� �ʴ� ����Դϴ�.");
            }
        }
    }
    
    private static void printManagers() {
        int count = 0;
        for (Manager s : managers) {
            if (count++ == managerIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %s\n", 
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getTel(),
                    s.getPosition());
        }
    }
    
    private static void inputManagers() {
        while (true) {
            Manager m = new Manager();
            
            System.out.print("�̸�? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("�̸���? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("��ȣ? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("��ȭ? ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("����? ");
            m.setPosition(keyIn.nextLine());
            
            if (managerIndex == managers.length) {
                increaseStorage();
            }
            
            managers[managerIndex++] = m;
            
            System.out.print("��� �Ͻðڽ��ϱ�?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    private static void increaseStorage() {
        Manager[] newList = new Manager[managers.length + 3];
        for (int i = 0; i < managers.length; i++) {
            newList[i] = managers[i];
        }
        managers = newList;
    }
    
    private static void deleteManager() {
        System.out.print("������ ��ȣ? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= managerIndex) {
            System.out.println("��ȿ�� ��ȣ�Դϴ�.");
            return;
        }
        
        for (int i = no; i < managerIndex - 1; i++) {
            managers[i] = managers[i + 1];
        }
        managerIndex--;
        
        System.out.println("�����Ͽ����ϴ�.");
    }
    
    private static void detailManager() {
        System.out.print("��ȸ�� ��ȣ? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= managerIndex) {
            System.out.println("��ȿ�� ��ȣ�Դϴ�.");
            return;
        }
        
        System.out.printf("�̸�: %s\n", managers[no].getName());
        System.out.printf("�̸���: %s\n", managers[no].getEmail());
        System.out.printf("��ȣ: %s\n", managers[no].getPassword());
        System.out.printf("����: %s\n", managers[no].getPosition());
        System.out.printf("��ȭ: %s\n", managers[no].getTel());
    }
}