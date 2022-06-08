package ImplementADT;

import static org.junit.Assert.*;

import objectdesign.Course;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestCourseImplement {

    @Test
    public void TestAll()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse("2021-03-06",formatter);
        CourseIntervel<Course> courseIntervel = new CourseIntervel<>(start,18);

        Course course1 = new Course("1","C1","T1","z1",4);
        Course course2 = new Course("2","C2","T1","z1",2);
        Course course3 = new Course("3","C3","T1","z1",4);
        courseIntervel.addcourse(course1,"C1");
        courseIntervel.addcourse(course2,"C2");
        courseIntervel.addcourse(course3,"C3");

        assertEquals(true,courseIntervel.selectcourse(4,8,10,"C1",4));
        assertEquals(true,courseIntervel.selectcourse(5,8,10,"C2",2));
        assertEquals(true,courseIntervel.selectcourse(3,8,10,"C3",4));
        assertEquals(false,courseIntervel.selectcourse(3,8,10,"C0",4));

        assertEquals(start,courseIntervel.getStartdate());
        assertEquals((long) 18,courseIntervel.getWeeks());
        assertEquals(0.9142,courseIntervel.percentofleisure(),0.01);
        assertEquals(0.0,courseIntervel.percentofrepeat(),0.01);
    }
}
