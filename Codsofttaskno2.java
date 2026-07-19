import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("total subjects ");
        int numSubjects = sc.nextInt();

        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("marks of " + i + " subject(out of 100): ");
            int marks = sc.nextInt();
            
         
            if(marks < 0 || marks > 100) {
                System.out.println("please enter correct number!");
                i--;
                continue;
            }
            totalMarks += marks;
        }

       
        double averagePercentage = (double) totalMarks / numSubjects;

        
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 35) {
            grade = 'E';
        } else {
            grade = 'F'; 
        }

       
        System.out.println("\n------ your result is ------");
        System.out.println("total (Total Marks): " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf(" (Average Percentage): %.2f%%\n", averagePercentage);
        System.out.println(" (Grade): " + grade);
        System.out.println("-------------------------");

        sc.close();
    }
}
