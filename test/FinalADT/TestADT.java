package FinalADT;

import static org.junit.Assert.*;

import ImplementADT.DutyIntervel;
import ImplementADT.ProcessIntervel;
import objectdesign.Course;

import objectdesign.Employee;
import objectdesign.ProCess;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TestADT {

    @Test
    public void TestCourseIntervalSet()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse("2021-03-06",formatter);
        CourseIntervalSet<Course> courseCourseIntervalSet = new CourseIntervalSet<>(start,18);
        Course course1 = new Course("1","C1","T1","z1",4);
        Course course2 = new Course("2","C2","T1","z1",2);
        Course course3 = new Course("3","C3","T1","z1",4);
        assertEquals(true,courseCourseIntervalSet.add_course(course1,course1.getName()));
        assertEquals(true,courseCourseIntervalSet.add_course(course2,course2.getName()));
        assertEquals(true,courseCourseIntervalSet.add_course(course3,course3.getName()));
        assertEquals(false,courseCourseIntervalSet.add_course(course3,course3.getName()));

        assertEquals(true,courseCourseIntervalSet.select_course(4,8,10,"C1",4));
        assertEquals(true,courseCourseIntervalSet.select_course(3,8,10,"C2",2));
        assertEquals(true,courseCourseIntervalSet.select_course(2,8,10,"C3",4));
        assertEquals(false,courseCourseIntervalSet.select_course(4,8,10,"C0",4));

    }

    @Test
    public void TestDutyIntervalSet()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse("2021-01-10",formatter);
        LocalDate end = LocalDate.parse("2021-03-06",formatter);
        DutyIntervalSet<Employee> dutyIntervalSet = new DutyIntervalSet<>(start,end);

        Employee employee1 = new Employee("e1","d1","1234");
        Employee employee2 = new Employee("e2","d1","1234");
        Employee employee3 = new Employee("e3","d1","1234");

        LocalDate f1 = LocalDate.parse("2021-01-12",formatter);
        LocalDate f2 = LocalDate.parse("2021-01-23",formatter);
        LocalDate f3 = LocalDate.parse("2021-02-12",formatter);
        LocalDate t1 = LocalDate.parse("2021-01-22",formatter);
        LocalDate t2 = LocalDate.parse("2021-01-26",formatter);
        LocalDate t3 = LocalDate.parse("2021-02-22",formatter);
        assertEquals(true,dutyIntervalSet.addEmployee(f1,t1,employee1));
        assertEquals(true,dutyIntervalSet.addEmployee(f2,t2,employee2));
        assertEquals(true,dutyIntervalSet.addEmployee(f2,t2,employee3));
        assertEquals(false,dutyIntervalSet.addEmployee(f3,t3,employee1));
    }

    @Test
    public void TestProcessIntervalSet()
    {
        ProcessIntervalSet<ProCess> proCessProcessIntervalSet = new ProcessIntervalSet<>();

        ProCess p1 = new ProCess("P1",1,12,16);
        ProCess p2 = new ProCess("P2",2,2,6);
        ProCess p3 = new ProCess("P3",3,22,26);

        assertEquals(true,proCessProcessIntervalSet.addprocess(p1,12,16));
        assertEquals(true,proCessProcessIntervalSet.addprocess(p2,2,6));
        assertEquals(true,proCessProcessIntervalSet.addprocess(p3,22,26));
        assertEquals(false,proCessProcessIntervalSet.addprocess(p3,2,6));

    }
}
