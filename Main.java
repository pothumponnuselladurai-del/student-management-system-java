import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
        System.out.println("----------------------");
    }
}

public class Main {   // Online compiler ku Main use pannunga

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<Student>();
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    list.add(new Student(roll, name, marks));
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (list.size() == 0) {
                        System.out.println("No students found.");
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to Search: ");
                    int searchRoll = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).rollNo == searchRoll) {
                            list.get(i).display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to Delete: ");
                    int deleteRoll = sc.nextInt();
                    boolean removed = false;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).rollNo == deleteRoll) {
                            list.remove(i);
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        System.out.println("Student Deleted Successfully!");
                    } else {
                        System.out.println("Student Not Found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 5);

        sc.close();
    }
}