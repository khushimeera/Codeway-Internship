
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char grade;
        int totalMarks = 0;
        System.out.println("Enter the number of subjects:");
        int numberOfSubjects = scanner.nextInt();

       for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Marks should be between 0 and 100.");
                i--; 
            } else {
                totalMarks =totalMarks + marks;
            }
        }

       
        float averagePercentage = (float) totalMarks / numberOfSubjects;

        
        
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

       
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.err.println("*******Congratulations**********");
        System.out.println("Grade: " + grade);

       
    }
}