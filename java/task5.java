import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Student Class
class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;

    // Constructor
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}

// Student Management System Class
class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.dat";

    // Constructor to load students from file
    public StudentManagementSystem() {
        loadStudentsFromFile();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
    }

    // Remove a student by roll number
    public boolean removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                saveStudentsToFile();
                return true;
            }
        }
        return false;
    }

    // Search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Save students to a file
    private void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Load students from a file
    private void loadStudentsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, initialize empty list
            students = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }
}

// Main Application Class
public class task5 {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a valid number: ");
                }
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name;
                    while ((name = scanner.nextLine()).isEmpty()) {
                        System.out.print("Name cannot be empty. Please enter a valid name: ");
                    }

                    System.out.print("Enter roll number: ");
                    int rollNumber;
                    while (true) {
                        try {
                            rollNumber = Integer.parseInt(scanner.nextLine());
                            if (rollNumber <= 0) {
                                System.out.print("Roll number must be positive. Enter again: ");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid input. Enter a valid roll number: ");
                        }
                    }

                    System.out.print("Enter grade: ");
                    String grade;
                    while ((grade = scanner.nextLine()).isEmpty()) {
                        System.out.print("Grade cannot be empty. Please enter a valid grade: ");
                    }

                    sms.addStudent(new Student(name, rollNumber, grade));
                    System.out.println("Student added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter roll number to remove: ");
                    int rollNumber;
                    while (true) {
                        try {
                            rollNumber = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid input. Enter a valid roll number: ");
                        }
                    }

                    if (sms.removeStudent(rollNumber)) {
                        System.out.println("Student removed successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter roll number to search: ");
                    int rollNumber;
                    while (true) {
                        try {
                            rollNumber = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid input. Enter a valid roll number: ");
                        }
                    }

                    Student student = sms.searchStudent(rollNumber);
                    if (student != null) {
                        System.out.println("Student found: " + student);
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 4 -> sms.displayAllStudents();
                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}