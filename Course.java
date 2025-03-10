import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    String name;
    int maxStudents;
    int enrolledStudents;
    String prerequisite;

    public Course(String name, int maxStudents, String prerequisite) {
        this.name = name;
        this.maxStudents = maxStudents;
        this.enrolledStudents = 0;
        this.prerequisite = prerequisite;
    }

    public void enrollStudent(String completedPrerequisite) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents >= maxStudents) {
            throw new CourseFullException("Course " + name + " is full.");
        }
        if (!completedPrerequisite.equals(prerequisite)) {
            throw new PrerequisiteNotMetException("Complete " + prerequisite + " before enrolling in " + name + ".");
        }
        enrolledStudents++;
        System.out.println("Successfully enrolled in " + name);
    }
}

public class UniversityEnrollment {
    public static void main(String[] args) {
        Course advancedJava = new Course("Advanced Java", 3, "Core Java");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the course you want to enroll in:");
        String courseName = scanner.nextLine();

        if (courseName.equals("Advanced Java")) {
            System.out.println("Enter prerequisite completed (if any):");
            String completedPrerequisite = scanner.nextLine();

            try {
                advancedJava.enrollStudent(completedPrerequisite);
            } catch (CourseFullException | PrerequisiteNotMetException e) {
                System.out.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }
        } else {
            System.out.println("Course not available.");
        }

        scanner.close();
    }
}
