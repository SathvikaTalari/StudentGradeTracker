import java.util.Scanner;

class Student {
    public String name;
    public int[] grades;

    Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Students:");
        int numStudents = sc.nextInt();
        sc.nextLine(); 
        Student[] students = new Student[numStudents];
        System.out.println("How many Grades for each Student?:");
        int numGrades = sc.nextInt();
        sc.nextLine(); 

        // Getting the Details of students
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter Student's Name:");
            String name = sc.nextLine();
            int[] grades = new int[numGrades];
            System.out.println("Enter the Grades:");
            for (int j = 0; j < numGrades; j++) {
                System.out.println("Grade " + (j + 1) + ":");
                grades[j] = sc.nextInt();
            }
            sc.nextLine();
            students[i] = new Student(name, grades);
        }
         
        // using switch case statement
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Student Details");
            System.out.println("2. Display Overall Stats");
            System.out.println("3. Exit");
            System.out.println("Enter your Choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < numStudents; i++) {
                        displayStats(students[i]);
                        System.out.println("_____________________");
                    }
                    break;
                case 2:
                    displayOverallStats(students, numStudents);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return; 
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void displayStats(Student s) {
        int highest = s.grades[0];
        int lowest = s.grades[0];
        int sum = 0;
        for (int i = 0; i < s.grades.length; i++) {
            int grade = s.grades[i];
            if (grade > highest) {
                highest = grade;
            }
            if (grade < lowest) {
                lowest = grade;
            }
            sum += grade;
        }
        float average = (float) sum / s.grades.length;
        System.out.println("Student: " + s.name);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.println("Average Grade: " + average);
    }

    public static void displayOverallStats(Student[] students, int numStudents) {
        float overallHighestAverage = 0;
        String highestStudent = "";
        float overallLowestAverage = Float.MAX_VALUE;
        String lowestStudent = "";

        for (int i = 0; i < numStudents; i++) {
            Student s = students[i];
            int sum = 0;
            for (int j = 0; j < s.grades.length; j++) {
                sum += s.grades[j];
            }
            float average = (float) sum / s.grades.length;

            if (average > overallHighestAverage) {
                overallHighestAverage = average;
                highestStudent = s.name;
            }
            if (average < overallLowestAverage) {
                overallLowestAverage = average;
                lowestStudent = s.name;
            }
        }
        System.out.println("Overall Highest Average Grade: " + overallHighestAverage + " by " + highestStudent);
        System.out.println("Overall Lowest Average Grade: " + overallLowestAverage + " by " + lowestStudent);
    }
}

