package se.ecutb.mattias.data;

import se.ecutb.mattias.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * FindByName metod ska testas.
 */

public class StudentDaoList implements StudentDao{

    private static List<Student>students;

    public StudentDaoList(){
        students = new ArrayList<>();
    }

    //Testad.
    @Override
    public Student saveStudent(Student student) {
        if (!students.contains(student)){
            students.add(student);
            return student;
        }
        return null;
    }

    //Testad.
    @Override
    public Student findByEmail(String email) {
        for (Student student : students){
            if(student.getEmail().equalsIgnoreCase(email)){
                return student;
            }
        }
        return null;
    }

    //Testad.
    @Override
    public List<Student> findByName(String name) {
        List<Student> tempStudent = new ArrayList<>();
        for (Student student : students){
            if (student.getName().equalsIgnoreCase(name)){
                tempStudent.add(student);
                return tempStudent;
            }
        }
        return null;
    }

    //Testad.
    @Override
    public Student findById(int id) {
        for (Student student : students){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    //Testad.
    @Override
    public List<Student> findAll() {
        return students;
    }

    //Testad.
    @Override
    public boolean deleteStudent(Student student) {
        if (students.contains(student)){
            students.remove(student);
            return true;
        }
        return false;
    }
}
