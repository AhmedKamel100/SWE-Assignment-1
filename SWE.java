
import java.util.ArrayList;
import java.util.Scanner;

//TO DO LIST APP

public class SWE {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("1- Add Task");
            System.out.println("2- Remove Task");
            System.out.println("3- Show Tasks");
            System.out.println("4- Exit");
            System.out.print("Choose: ");
          
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter task: ");
                String task = input.nextLine();
                tasks.add(task);
                System.out.println("Task added\n");
            } 
            else if (choice == 2) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks to remove\n");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + "- " + tasks.get(i));
                    }
                    System.out.print("Enter task number to remove: ");
                    int index = input.nextInt();
                    input.nextLine();
                    if (index > 0 && index <= tasks.size()) {
                        tasks.remove(index - 1);
                        System.out.println("Task removed\n");
                    } else {
                        System.out.println("Invalid number\n");
                    }
                }
            } 
            else if (choice == 3) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available\n");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + "- " + tasks.get(i));
                    }
                    System.out.println();
                }
            } 
            else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid choice\n");
            }
        }
    }
}