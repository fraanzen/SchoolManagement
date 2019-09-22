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

    //Testklar.
    @Override
    public Student saveStudent(Student student) {
        if (!students.contains(student)){
            students.add(student);
            return student;
        }
        return null;
    }

    //Testklar.
    @Override
    public Student findByEmail(String email) {
        for (Student student : students){
            if(student.getEmail().equalsIgnoreCase(email)){
                return student;
            }
        }
        return null;
    }

    //Testklar. OKLAR?
    @Override
    public List<Student> findByName(String name) {
        for (Student student : students){
            if (student.getName().equals(name)){
                return (List<Student>) student;
            }
        }
        return null;
    }

    //Testklar.
    @Override
    public Student findById(int id) {
        for (Student student : students){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    //Testklar.
    @Override
    public List<Student> findAll() {
        return students;
    }
    //Testklar.
    @Override
    public boolean deleteStudent(Student student) {
        if (students.contains(student)){
            students.remove(student);
            return true;
        }
        return false;
    }
}
