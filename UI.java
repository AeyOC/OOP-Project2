import java.util.Scanner;
import java.util.InputMismatchException;

public class UI {
    public static void main(String[] args) {
        Supervisor supervisor = new Supervisor();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to SEU University!");
        System.out.println("\r\n" + //
                        "                 \r\n" + //
                        "                 \r\n" + //
                        "  ___  ___ _   _ \r\n" + //
                        " / __|/ _ \\ | | |\r\n" + //
                        " \\__ \\  __/ |_| |\r\n" + //
                        " |___/\\___|\\__,_|\r\n" + //
                        "                 \r\n" + //
                        "                 \r\n" + //
                        "");
        System.out.println("Welcome to the Courses Management System!");
        System.out.println("Select your role:");
        System.out.println("1. Supervisor");
        System.out.println("2. Student");
        System.out.print("Enter your choice: ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        

        if (roleChoice == 1) {
            System.out.println("You are logged in as Supervisor.");
            while (running) {
                System.out.println("\n--- Supervisor Menu ---");
                System.out.println("1. Add Course");
                System.out.println("2. Display All Courses");
                System.out.println("3. Search Courses");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter course title: ");
                            String title = scanner.nextLine().trim();
                            if (title.isEmpty()) {
                                System.out.println("Error: Title cannot be empty.");
                                break;
                            }

                            System.out.print("Enter instructor name: ");
                            String instructor = scanner.nextLine().trim();
                            if (instructor.isEmpty()) {
                                System.out.println("Error: Instructor name cannot be empty.");
                                break;
                            }

                            System.out.print("Enter course area: ");
                            String area = scanner.nextLine().trim();
                            if (area.isEmpty()) {
                                System.out.println("Error: Area cannot be empty.");
                                break;
                            }

                            supervisor.addCourse(title, instructor, area);
                            break;

                        case 2:
                            supervisor.displayCourses();
                            break;

                        case 3:
                            System.out.print("Enter title, instructor, or area to search: ");
                            String query = scanner.nextLine().trim();
                            if (query.isEmpty()) {
                                System.out.println("Error: Search query cannot be empty.");
                            } else {
                                supervisor.searchCourses(query);
                            }
                            break;

                        case 4:
                            running = false;
                            System.out.println("Exiting the system.");
                            break;

                        default:
                            System.out.println("Invalid option. Please enter a number between 1 and 4.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number.");
                    scanner.nextLine();  // Clear the invalid input
                }
            }
        } else if (roleChoice == 2) {
            System.out.println("You are logged in as Student.");
            while (running) {
                System.out.println("\n--- Student Menu ---");
                System.out.println("1. Display All Courses");
                System.out.println("2. Search Courses");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    switch (choice) {
                        case 1:
                            supervisor.displayCourses();
                            break;

                        case 2:
                            System.out.print("Enter title, instructor, or area to search: ");
                            String query = scanner.nextLine().trim();
                            if (query.isEmpty()) {
                                System.out.println("Error: Search query cannot be empty.");
                            } else {
                                supervisor.searchCourses(query);
                            }
                            break;

                        case 3:
                            running = false;
                            System.out.println("Exiting the system.");
                            break;

                        default:
                            System.out.println("Invalid option. Please enter a number between 1 and 3.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number.");
                    scanner.nextLine();  // Clear the invalid input
                }
            }
        } else {
            System.out.println("Invalid role selection. Exiting program.");
        }

        scanner.close();
    }
}
