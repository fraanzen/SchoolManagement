package se.ecutb.mattias.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.mattias.data.CourseDaoList;
import se.ecutb.mattias.data.StudentDaoList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseTest {

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
    public void register_test(){
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(studentTest);
        courseTest.register(studentTest);
        Assert.assertEquals(expectedList, courseTest.getStudents());

    }

    @Test
    public void unregister_test(){
        List<Student> expectedList = new ArrayList<>();
        courseTest.register(studentTest);
        courseTest.unregister(studentTest);
        Assert.assertEquals(expectedList, courseTest.getStudents());
    }
}
