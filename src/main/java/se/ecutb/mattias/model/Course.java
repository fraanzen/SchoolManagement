package se.ecutb.mattias.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course{

    private static int courseCounter;
    private int courseId;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course(int courseId, String courseName, LocalDate startDate, int weekDuration){
        this.courseId = courseId;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = new ArrayList<>();
    }

    public Course(String courseName, LocalDate startDate, int weekDuration){
        this(++courseCounter, courseName, startDate, weekDuration);
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    List<Student> getStudents() {
        return students;
    }

    //Testad.
    public void register(Student student){
        if (!students.contains(student)) {
            students.add(student);
            System.out.println(student + " Was added.");
        }
    }

    //Testad.
    public void unregister(Student student){
        if (students.contains(student)){
            students.remove(student);
            System.out.println(student + " Was removed.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(startDate, course.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, startDate);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}
