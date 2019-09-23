package se.ecutb.mattias.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.mattias.model.Course;
import se.ecutb.mattias.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoListTest {

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
    public void save_course_test_added() {
        Course actual = CourseDaoTest.saveCourse(courseTest);
        Course expected = courseTest;
        Assert.assertEquals(expected, actual);
        actual = CourseDaoTest.saveCourse(courseTest);
        expected = null;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void find_by_id_test() {
        CourseDaoTest.saveCourse(courseTest);
        Course actual = CourseDaoTest.findById(1);
        Course expected = courseTest;
        Assert.assertEquals(expected, actual);
        System.out.println(CourseDaoTest.findById(1));
        actual = CourseDaoTest.findById(2);
        expected = null;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void find_by_name_test() {
        List<Course> expectedList = new ArrayList<>();
        expectedList.add(courseTest);
        CourseDaoTest.saveCourse(courseTest);
        List<Course> actual = CourseDaoTest.findByName("Test");
        Assert.assertEquals(expectedList, actual);
        expectedList = null;
        actual = CourseDaoTest.findByName("Test1");
    }

    @Test
    public void find_all_test() {
        Course courseTest1 = new Course(1, "Test1", LocalDate.parse("2019-10-10"), 10);
        List<Course> expectedList = new ArrayList<>();
        expectedList.add(courseTest);
        expectedList.add(courseTest1);
        CourseDaoTest.saveCourse(courseTest);
        CourseDaoTest.saveCourse(courseTest1);
        List<Course> actualList = CourseDaoTest.findAll();
        Assert.assertEquals(expectedList, actualList);
        System.out.println(CourseDaoTest.findAll());
    }

    @Test
    public void delete_student_test() {
        CourseDaoTest.saveCourse(courseTest);
        Course actual = courseTest;
        Course expected = courseTest;
        Assert.assertEquals(expected, actual);
        CourseDaoTest.removeCourse(courseTest);
        actual = null;
        expected = null;
        CourseDaoTest.removeCourse(courseTest);
    }

    @Test
    public void find_by_date_test() {
        List<Course> expectedList = new ArrayList<>();
        expectedList.add(courseTest);
        CourseDaoTest.saveCourse(courseTest);
        List<Course> actual = CourseDaoTest.findByDate(LocalDate.parse("2019-10-10"));
        Assert.assertEquals(expectedList, actual);
        System.out.println(CourseDaoTest.findByDate(LocalDate.parse("2019-10-10")));
        expectedList = null;
        actual = CourseDaoTest.findByDate(LocalDate.parse("2020-10-10"));
    }

}
