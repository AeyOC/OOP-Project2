import java.util.ArrayList;

public class Supervisor {
    private ArrayList<Course> courses = new ArrayList<>();

    public Supervisor() {
        // Adding sample courses directly
        Course course1 = new Course();
        course1.title = "DS230";
        course1.instructor = "Abdelwaheb Trabelsi";
        course1.area = "Programming";
        courses.add(course1);

        Course course2 = new Course();
        course2.title = "DS231";
        course2.instructor = "Mohammed Jarraya";
        course2.area = "Programming";
        courses.add(course2);

        Course course3 = new Course();
        course3.title = "MATH150";
        course3.instructor = "Majed Alotaibi";
        course3.area = "Mathematics";
        courses.add(course3);

        Course course4 = new Course();
        course4.title = "SCI101";
        course4.instructor = "Usama AlAli";
        course4.area = "Science";
        courses.add(course4);
    }

    // Add a new course
    public void addCourse(String title, String instructor, String area) {
        Course newCourse = new Course();
        newCourse.title = title;
        newCourse.instructor = instructor;
        newCourse.area = area;
        courses.add(newCourse);
        System.out.println("Course added: " + title);
    }

    // Display all courses
    public void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course course : courses) {
                System.out.println("Course: " + course.title + ", Instructor: " + course.instructor + ", Area: " + course.area);
            }
        }
    }

    // Search courses by title, instructor, or area
    public void searchCourses(String query) {
        boolean found = false;
        for (Course course : courses) {
            if (course.title.equalsIgnoreCase(query) || 
                course.instructor.equalsIgnoreCase(query) || 
                course.area.equalsIgnoreCase(query)) {
                System.out.println("Course: " + course.title + ", Instructor: " + course.instructor + ", Area: " + course.area);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No courses found for query: " + query);
        }
    }
}
