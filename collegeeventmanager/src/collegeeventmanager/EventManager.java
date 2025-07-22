package collegeeventmanager;
import java.util.*;

public class EventManager {
    private List<Event> events = new ArrayList<>();
    private Map<String, List<Integer>> registrations = new HashMap<>();

    public void seedData() {
        events.add(new Event(1, "Hackathon", "2025-08-05"));
        events.add(new Event(2, "Tech Talk", "2025-08-10"));
    }

    public void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View Events");
            System.out.println("2. Add Event");
            System.out.println("3. Delete Event");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1 -> viewEvents();
                case 2 -> addEvent(sc);
                case 3 -> deleteEvent(sc);
                case 4 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void studentMenu(Scanner sc) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        while (true) {
            System.out.println("\nStudent Menu:");
            System.out.println("1. View Events");
            System.out.println("2. Register for Event");
            System.out.println("3. My Registrations");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1 -> viewEvents();
                case 2 -> registerEvent(sc, name);
                case 3 -> viewMyRegistrations(name);
                case 4 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void viewEvents() {
        System.out.println("\nAvailable Events:");
        for (Event e : events) {
            System.out.println(e);
        }
    }

    private void addEvent(Scanner sc) {
        System.out.print("Enter event name: ");
        String name = sc.nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        int id = events.size() + 1;
        events.add(new Event(id, name, date));
        System.out.println("Event added.");
    }

    private void deleteEvent(Scanner sc) {
        System.out.print("Enter event ID to delete: ");
        int id = sc.nextInt(); sc.nextLine();
        events.removeIf(e -> e.id == id);
        System.out.println("Event deleted if existed.");
    }

    private void registerEvent(Scanner sc, String username) {
        System.out.print("Enter event ID to register: ");
        int id = sc.nextInt(); sc.nextLine();
        registrations.putIfAbsent(username, new ArrayList<>());
        registrations.get(username).add(id);
        System.out.println("Registered successfully.");
    }

    private void viewMyRegistrations(String username) {
        System.out.println("Your Registrations:");
        List<Integer> reg = registrations.getOrDefault(username, new ArrayList<>());
        for (int id : reg) {
            events.stream().filter(e -> e.id == id).forEach(System.out::println);
        }
    }
}