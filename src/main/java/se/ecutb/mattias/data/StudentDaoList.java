package se.ecutb.mattias.data;

import se.ecutb.mattias.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Metoder skall göras.
 */

public class StudentDaoList implements StudentDao{

    private static List<Student>students;

    public StudentDaoList(){
        students = new ArrayList<>();
    }

    @Override
    public boolean saveStudent(Student student) {
        return students.contains(student) ? false : students.add(student);
    }

    @Override
    public Student findByEmail(String email) {
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return false;
    }
}
