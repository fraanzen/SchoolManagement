package se.ecutb.mattias.data;

import se.ecutb.mattias.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Metoder skall göras.
 */

public class CourseDaoList implements CourseDao {

    private static List<Course>courses;

    public CourseDaoList(){
        courses = new ArrayList<>();
    }

    //Testklar.
    @Override
    public Course saveCourse(Course course){
        if (!courses.contains(course)){
            courses.add(course);
            return course;
        }
        return null;
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        return null;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public boolean removeCourse(Course course) {
        return false;
    }
}
