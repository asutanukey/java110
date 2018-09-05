import java.util.Scanner;

import bitcamp.java110.cms.control.ManagerController;
import bitcamp.java110.cms.control.StudentController;
import bitcamp.java110.cms.control.TeacherController;

public class App {
    
    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {
        
        StudentController.keyIn = keyIn;
        TeacherController.keyIn = keyIn;
        ManagerController.keyIn = keyIn;
        
        while (true) {
            String menu = promptMenu();
            
            if (menu.equals("1")) {
                StudentController.serviceStudentMenu();
                
            } else if (menu.equals("2")) {
                TeacherController.serviceTeacherMenu();
                
            } else if (menu.equals("3")) {
                ManagerController.serviceManagerMenu();
                
            } else if (menu.equals("0")){
                System.out.println("�ȳ��� ������!");
                break;
            }
        }
        
        keyIn.close();
    }

    private static String promptMenu() {
        System.out.println("[�޴�]");
        System.out.println("1.�л� ����");
        System.out.println("2.���� ����");
        System.out.println("3.�Ŵ��� ����");
        System.out.println("0.����");
        
        while (true) {
            System.out.print("�޴� ��ȣ> ");
            
            String menu = keyIn.nextLine();
            
            switch (menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("�޴� ��ȣ�� ��ȿ���� �ʽ��ϴ�.");
            }
        }
    }
}