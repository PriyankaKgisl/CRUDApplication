package CRUDApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StudentClass {
    private int studID;
    private String studName;
    private String studEmailID;
    private char studGrade;
    private Long studNumber;

    static HashMap<Integer, StudentClass> studentData = new HashMap<>();

    static int countStudent = 1;

    public int getStudID() {
        return studID;
    }

    public void setStudID(int studID) {
        this.studID = studID;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudEmailID() {
        return studEmailID;
    }

    public void setStudEmailID(String studEmailID) {
        this.studEmailID = studEmailID;
    }

    public char getStudGrade() {
        return studGrade;
    }

    public void setStudGrade(char studGrade) {
        this.studGrade = studGrade;
    }

    public Long getStudNumber() {
        return studNumber;
    }

    public void setStudNumber(Long studNumber) {
        this.studNumber = studNumber;
    }

}

public class Main {
    private static void printMenu() {
        System.out.println("1. To create a new student");
        System.out.println("2. To remove a student");
        System.out.println("3. To update a student");
        System.out.println("4. To display all students data");
        System.out.println("5. To search a student");
        System.out.println("6. To exit application");
    }

    private static void toCreateANewStudent() {
        System.out.println("Welcome - Creating a new student");
        Scanner input = new Scanner(System.in);

        StudentClass obj = new StudentClass();
        obj.setStudID(StudentClass.countStudent);
        System.out.println("Student ID: " + obj.getStudID());

        System.out.print("Enter student name: ");
        obj.setStudName(input.next());

        System.out.print("Enter student email: ");
        obj.setStudEmailID(input.next());

        System.out.print("Enter student grade: ");
        obj.setStudGrade(input.next().charAt(0));

        System.out.print("Enter student number: ");
        obj.setStudNumber(input.nextLong());

        StudentClass.studentData.put(obj.getStudID(), obj);
        StudentClass.countStudent++;
        System.out.println("Thank you - Student creation successful\n");

        toDisplayStudentData();
    }

    private static void toRemoveAStudent() {
        System.out.println("Welcome - Remove a student");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the ID of the student to be removed: ");
        int id = input.nextInt();
        if (StudentClass.studentData.containsKey(id)) {
            StudentClass.studentData.remove(id);
            System.out.println("Student is removed successfully\n");
            toDisplayStudentData();

        } else {
            System.err.println("Student does not exist with this id!!!\n");
        }
    }

    private static void toUpdateAStudent() {
        System.out.println("Welcome - Update a student");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the ID of the student to be updated: ");
        int id = input.nextInt();
        if (StudentClass.studentData.containsKey(id)) {
            System.out.println("1. Update name");
            System.out.println("2. Update email");
            System.out.println("3. Update grade");
            System.out.println("4. Update number");
            System.out.print("Enter the choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the updated name: ");
                    String name = input.next();
                    StudentClass.studentData.get(id).setStudName(name);
                    break;
                case 2:
                    System.out.println("Enter the updated email: ");
                    String email = input.next();
                    StudentClass.studentData.get(id).setStudEmailID(email);
                    break;
                case 3:
                    System.out.println("Enter the updated grade: ");
                    char grade = input.next().charAt(0);
                    StudentClass.studentData.get(id).setStudGrade(grade);
                    break;
                case 4:
                    System.out.println("Enter the updated number: ");
                    long number = input.nextLong();
                    StudentClass.studentData.get(id).setStudNumber(number);
                    break;
                default:
                    System.err.println("Invalid choice!!!");
                    return;
            }
            System.out.println("Student data updated successfully!!!\n");
            toDisplayStudentData();
        } else {
            System.err.println("Student does not exist with this id!!!\n");
        }
    }

    private static void toDisplayStudentData() {
        System.out.println("Welcome - Printing students data");

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Student ID \t\t Student Name \t\t Student Email \t\t Student Grade \t\t Student Number");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Map.Entry<Integer, StudentClass> studentData : StudentClass.studentData.entrySet()) {
            System.out.println(studentData.getKey() + "\t\t\t\t" +
                    studentData.getValue().getStudName() + "\t\t\t\t" +
                    studentData.getValue().getStudEmailID() + "\t\t\t\t" +
                    studentData.getValue().getStudGrade() + "\t\t\t\t" +
                    studentData.getValue().getStudNumber());
        }
        System.out.println("--------------------------------------------------------------------------------------");

        System.out.println("Printed Students Data Successfully\n");
    }

    private static void toSearchAStudent() {
        System.out.println("Welcome - Search a student");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the ID of the student to be searched: ");
        int id = input.nextInt();

        if (StudentClass.studentData.containsKey(id)) {
            System.out.println("Student Name: " + StudentClass.studentData.get(id).getStudName());
            System.out.println("Student Email: " + StudentClass.studentData.get(id).getStudEmailID());
            System.out.println("Student Grade: " + StudentClass.studentData.get(id).getStudGrade());
            System.out.println("Student Number: " + StudentClass.studentData.get(id).getStudNumber());
            System.out.println("Student data is displayed successfully\n");
        } else {
            System.err.println("Student does not exist with this id!!!\n");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Boolean flag = true;
        System.out.println("\t\t\tStudent Database Application\n");
        while (flag) {
            printMenu();
            System.out.println("Enter a choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    toCreateANewStudent();
                    break;
                case 2:
                    toRemoveAStudent();
                    break;
                case 3:
                    toUpdateAStudent();
                    break;
                case 4:
                    toDisplayStudentData();
                    break;
                case 5:
                    toSearchAStudent();
                    break;
                case 6:
                    flag = false;
                    System.out.println("Application is exited");
                    break;
                default:
                    System.err.println("Invalid choice!!!");
                    break;
            }
        }

        System.out.println("Have a good day!!!");
    }
}





