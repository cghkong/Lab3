package Decoratordesign;

import static org.junit.Assert.*;

import Basedesign.CommomIntervelSet;
import Basedesign.CommonMultiIntervelSet;
import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;
import objectdesign.Course;
import objectdesign.Employee;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestDutyRosterSet {

    @Test
    public void Testinsert()
    {
        IntervelSet<Employee> intervelSet = new CommomIntervelSet<>();
        DutyRosterSet<Employee> dutyRosterSet = new DutyRosterSet<>(intervelSet);
        Employee employee1 = new Employee("zhan","duty","123-1234-1234");
        Employee employee2 = new Employee("zhan1","duty","123-1234-1234");
        Employee employee3 = new Employee("zhan2","duty","123-1234-1234");
        assertEquals(true,dutyRosterSet.insert(4,18,employee1));
        assertEquals(true,dutyRosterSet.insert(0,4,employee2));
        assertEquals(true,dutyRosterSet.insert(20,24,employee3));
        assertEquals(false,dutyRosterSet.insert(20,24,employee3));
    }

    @Test
    public void Testremove()
    {
        IntervelSet<Employee> intervelSet = new CommomIntervelSet<>();
        DutyRosterSet<Employee> dutyRosterSet = new DutyRosterSet<>(intervelSet);
        Employee employee1 = new Employee("zhan","duty","123-1234-1234");
        Employee employee2 = new Employee("zhan1","duty","123-1234-1234");
        Employee employee3 = new Employee("zhan2","duty","123-1234-1234");
        dutyRosterSet.insert(4,18,employee1);
        dutyRosterSet.insert(0,4,employee2);
        dutyRosterSet.insert(15,20,employee3);

        assertEquals(true,dutyRosterSet.remove(employee1));
        assertEquals(true,dutyRosterSet.remove(employee2));
        assertEquals(true,dutyRosterSet.remove(employee3));
        assertEquals(false,dutyRosterSet.remove(employee1));
    }

    @Test
    public void Testgetendofstart()
    {
        IntervelSet<Employee> intervelSet = new CommomIntervelSet<>();
        DutyRosterSet<Employee> dutyRosterSet = new DutyRosterSet<>(intervelSet);
        Employee employee1 = new Employee("zhan","duty","123-1234-1234");
        Employee employee2 = new Employee("zhan1","duty","123-1234-1234");
        Employee employee3 = new Employee("zhan2","duty","123-1234-1234");
        dutyRosterSet.insert(4,18,employee1);
        dutyRosterSet.insert(0,4,employee2);
        dutyRosterSet.insert(15,20,employee3);

        assertEquals(18,dutyRosterSet.getendofstart(4));
        assertEquals(4,dutyRosterSet.getendofstart(0));
        assertEquals(20,dutyRosterSet.getendofstart(15));
    }

}
