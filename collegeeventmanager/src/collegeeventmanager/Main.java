package collegeeventmanager;
import java.util.Scanner;
public class Main {
	
	    public static void main(String[] args) {
	        EventManager manager = new EventManager();
	        manager.seedData();
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Welcome to College Event Management System");
	        System.out.print("Enter role (admin/student): ");
	        String role = sc.nextLine().trim().toLowerCase();
	        if (role.equals("admin")) {
	            manager.adminMenu(sc);
	        } else if (role.equals("student")) {
	            manager.studentMenu(sc);
	        } else {
	            System.out.println("Invalid role.");
	        }
	        sc.close();
	    }
	}

