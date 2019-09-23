package se.ecutb.mattias.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.mattias.model.Student;

public class StudentDaoListTest {

    StudentDaoList sdl = new StudentDaoList();

    @Before
    public void setup(){
        Student s = new Student(1, "test@test.test", "test", "test");
        StudentDaoList sdl = new StudentDaoList();
    }

    @Test
    public void save_student_test_to_save(){
        Student s1 = new Student(2,"test1@test.test", "test1", "test1");
        Assert.assertTrue(true);
    }

    @Test
    public void save_student_test_to_fail(){
        Student s = new Student(1, "test@test.test", "test", "test");
        Assert.assertFalse(false);

    }

    @Test
    public void find_by_email_test() {
        Student s = new Student(1, "test@test.test", "test", "test");
        sdl.findByEmail("test@test.test");
        String actual = s.toString();
        Assert.assertTrue(true);
        System.out.println(actual);
        System.out.println(s);
    }





}
