import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Double> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(double grade) {
        grades.add(grade);
    }

    double getAverage() {
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return grades.size() == 0 ? 0 : sum / grades.size();
    }

    double getHighest() {
        double max = grades.get(0);
        for (double g : grades) {
            if (g > max) max = g;
        }
        return max;
    }

    double getLowest() {
        double min = grades.get(0);
        for (double g : grades) {
            if (g < min) min = g;
        }
        return min;
    }

    void displayReport() {
        System.out.println("\nStudent Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();

            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            Student s = new Student(name);

            System.out.print("Enter number of grades: ");
            int gCount = sc.nextInt();

            for (int j = 0; j < gCount; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                double grade = sc.nextDouble();
                s.addGrade(grade);
            }

            students.add(s);
        }

        System.out.println("\n========== CLASS SUMMARY REPORT ==========");

        for (Student s : students) {
            s.displayReport();
        }

        double classSum = 0;
        int totalGrades = 0;
        double classHighest = students.get(0).getHighest();
        double classLowest = students.get(0).getLowest();

        for (Student s : students) {
            for (double g : s.grades) {
                classSum += g;
                totalGrades++;

                if (g > classHighest) classHighest = g;
                if (g < classLowest) classLowest = g;
            }
        }

        System.out.println("\n========== CLASS STATISTICS ==========");
        System.out.println("Class Average: " + (classSum / totalGrades));
        System.out.println("Class Highest: " + classHighest);
        System.out.println("Class Lowest: " + classLowest);

        sc.close();
    }
}
