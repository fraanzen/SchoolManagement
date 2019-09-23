package se.ecutb.mattias.data;

import se.ecutb.mattias.model.Course;
import java.time.LocalDate;
import java.util.List;

public interface CourseDao{

    Course saveCourse(Course course);

    Course findById(int id);

    List<Course> findByName(String name);

    List<Course> findByDate(LocalDate date);

    List<Course> findAll();

    boolean removeCourse(Course course);


}
