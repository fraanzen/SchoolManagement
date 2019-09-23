package se.ecutb.mattias.data;

import se.ecutb.mattias.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Metoder klara, testa.
 */

public class CourseDaoList implements CourseDao {

    private static List<Course> courses;

    public CourseDaoList() {
        courses = new ArrayList<>();
    }

    //Testklar.
    @Override
    public Course saveCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            return course;
        }
        return null;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses)
            if (course.getCourseId() == id) {
                return course;
            }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> tempCourse = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(name)){
                tempCourse.add(course);
                return tempCourse;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        for (Course course : courses) {
            if (course.getStartDate().equals(date)) {
                return courses;
            }
        }
        return null;
    }


    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            return true;
        }
        return false;
    }
}


