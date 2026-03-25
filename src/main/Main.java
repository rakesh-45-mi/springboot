package main;

import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Find Student by RegNo");
            System.out.println("4. Find All Students");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Gender (M/F): ");
                    String gender = sc.nextLine();
                    System.out.print("Register No: ");
                    int regno = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("DOB (YYYY-MM-DD): ");
                    String dob = sc.nextLine();
                    dao.insertStudent(new Student(name, gender, regno, email, dob));
                    break;

                case 2:
                    System.out.print("Enter RegNo to delete: ");
                    dao.deleteStudent(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter RegNo to find: ");
                    Student s = dao.findStudent(sc.nextInt());
                    if (s != null) System.out.println(s);
                    break;

                case 4:
                    List<Student> all = dao.findAllStudents();
                    if (all.isEmpty()) System.out.println("No students found.");
                    else all.forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Bye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}