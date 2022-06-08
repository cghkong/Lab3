package ImplementADT;

import static org.junit.Assert.*;

import Basedesign.CommomIntervelSet;
import Basedesign.CommonMultiIntervelSet;
import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;
import objectdesign.Course;
import objectdesign.Employee;
import objectdesign.ProCess;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestDutyRoster {

    @Test
    public void TestAll()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse("2021-01-10",formatter);
        LocalDate end = LocalDate.parse("2021-03-10",formatter);
        DutyIntervel<Employee> dutyIntervel = new DutyIntervel<>(start,end);
        assertEquals(59,dutyIntervel.DateChange(end,start));

        Employee employee1 = new Employee("e1","d1","1234");
        Employee employee2 = new Employee("e2","d1","1234");
        Employee employee3 = new Employee("e3","d1","1234");

        LocalDate f1 = LocalDate.parse("2021-01-12",formatter);
        LocalDate f2 = LocalDate.parse("2021-01-23",formatter);
        LocalDate f3 = LocalDate.parse("2021-02-12",formatter);
        LocalDate t1 = LocalDate.parse("2021-01-22",formatter);
        LocalDate t2 = LocalDate.parse("2021-01-26",formatter);
        LocalDate t3 = LocalDate.parse("2021-02-22",formatter);

        dutyIntervel.insert(f1,t1,employee1);
        dutyIntervel.insert(f2,t2,employee2);
        dutyIntervel.insert(f3,t3,employee3);

        dutyIntervel.checkfull();
        dutyIntervel.showschedule();
    }

}
