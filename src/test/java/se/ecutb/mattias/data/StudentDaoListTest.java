package se.ecutb.mattias.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.mattias.model.Course;
import se.ecutb.mattias.model.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoListTest {

    public Course courseTest;
    public Student studentTest;
    public CourseDaoList CourseDaoTest;
    public StudentDaoList StudentDaoTest;

    @Before
    public void setup() {
        courseTest = new Course(1, "Test", LocalDate.parse("2019-10-10"), 10);
        studentTest = new Student(1, "Test", "test@test.com", "Testvägen");
        CourseDaoTest = new CourseDaoList();
        StudentDaoTest = new StudentDaoList();
    }

    @Test
    public void save_student_test_to_save() {
        Student actual = StudentDaoTest.saveStudent(studentTest);
        Student expected = studentTest;
        Assert.assertEquals(actual, expected);
        actual = StudentDaoTest.saveStudent(studentTest);
        expected = null;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void find_by_email_test() {
        StudentDaoTest.saveStudent(studentTest);
        Student actual = StudentDaoTest.findByEmail("test@test.com");
        Student expected = studentTest;
        Assert.assertEquals(expected, actual);
        System.out.println(StudentDaoTest.findByEmail("test@test.com"));
        actual = StudentDaoTest.findByEmail("fel@emailtest.com");
        expected = null;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void find_by_name_test() {
        Student studentTest1 = new Student(2, "Test", "test@test.com", "Testvägen");
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(studentTest);
        expectedList.add(studentTest1);
        StudentDaoTest.saveStudent(studentTest);
        StudentDaoTest.saveStudent(studentTest1);
        List<Student> actual = StudentDaoTest.findByName("Test");
        System.out.println(StudentDaoTest.findByName("Test"));
        Assert.assertEquals(expectedList, actual);
        
    }

    @Test
    public void find_by_id_test() {
        StudentDaoTest.saveStudent(studentTest);
        Student actual = StudentDaoTest.findById(1);
        Student expected = studentTest;
        Assert.assertEquals(expected, actual);
        System.out.println(StudentDaoTest.findById(1));
        actual = StudentDaoTest.findById(2);
        expected = null;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void find_all_test() {
        Student studentTest1 = new Student(2, "Test1", "test1@test.com", "Testvägen1");
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(studentTest);
        expectedList.add(studentTest1);
        StudentDaoTest.saveStudent(studentTest);
        StudentDaoTest.saveStudent(studentTest1);
        List<Student> actualList = StudentDaoTest.findAll();
        Assert.assertEquals(expectedList, actualList);
        System.out.println(StudentDaoTest.findAll());
    }

    @Test
    public void delete_student_test() {
        StudentDaoTest.saveStudent(studentTest);
        Student actual = studentTest;
        Student expected = studentTest;
        Assert.assertEquals(expected, actual);
        StudentDaoTest.deleteStudent(studentTest);
        actual = null;
        expected = null;
        StudentDaoTest.deleteStudent(studentTest);
    }

}

