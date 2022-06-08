package Basedesign;

import static org.junit.Assert.*;

import Basedesign.CommomIntervelSet;
import Basedesign.CommonMultiIntervelSet;
import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;
import objectdesign.Employee;
import org.junit.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestIntervalSet {

    @Test
    public void TestInsert()
    {
        CommomIntervelSet<Employee> commomIntervelSet = new CommomIntervelSet<>();
        Employee employee1 = new Employee("zhansan1","duty","123-1234-1234");
        Employee employee2 = new Employee("zhansan2","duty","123-1234-1234");
        Employee employee3 = new Employee("zhansan3","duty","123-1234-1234");
        assertEquals(true,commomIntervelSet.insert(5,16,employee1));
        assertEquals(true,commomIntervelSet.insert(10,20,employee2));
        assertEquals(true,commomIntervelSet.insert(8,12,employee3));

        assertEquals(16,commomIntervelSet.end(employee1));
        assertEquals(20,commomIntervelSet.end(employee2));
        assertEquals(12,commomIntervelSet.end(employee3));
    }

    @Test
    public void Teststart()
    {
        CommomIntervelSet<Employee> commomIntervelSet = new CommomIntervelSet<>();
        Employee employee1 = new Employee("zhansan1","duty","123-1234-1234");
        Employee employee2 = new Employee("zhansan2","duty","123-1234-1234");
        Employee employee3 = new Employee("zhansan3","duty","123-1234-1234");
        assertEquals(true,commomIntervelSet.insert(4,12,employee1));
        assertEquals(true,commomIntervelSet.insert(11,20,employee2));
        assertEquals(true,commomIntervelSet.insert(7,9,employee3));

        assertEquals(4,commomIntervelSet.start(employee1));
        assertEquals(11,commomIntervelSet.start(employee2));
        assertEquals(7,commomIntervelSet.start(employee3));
    }

    @Test
    public void Testend()
    {
        CommomIntervelSet<Employee> commomIntervelSet = new CommomIntervelSet<>();
        Employee employee1 = new Employee("zhansan1","duty","123-1234-1234");
        Employee employee2 = new Employee("zhansan2","duty","123-1234-1234");
        Employee employee3 = new Employee("zhansan3","duty","123-1234-1234");
        assertEquals(true,commomIntervelSet.insert(9,11,employee1));
        assertEquals(true,commomIntervelSet.insert(3,20,employee2));
        assertEquals(true,commomIntervelSet.insert(7,23,employee3));

        assertEquals(11,commomIntervelSet.end(employee1));
        assertEquals(20,commomIntervelSet.end(employee2));
        assertEquals(23,commomIntervelSet.end(employee3));
    }

    @Test
    public void Testlabel()
    {
        CommomIntervelSet<Employee> commomIntervelSet = new CommomIntervelSet<>();
        Employee employee1 = new Employee("zhansan1","duty","123-1234-1234");
        Employee employee2 = new Employee("zhansan2","duty","123-1234-1234");
        Employee employee3 = new Employee("zhansan3","duty","123-1234-1234");
        assertEquals(true,commomIntervelSet.insert(9,11,employee1));
        assertEquals(true,commomIntervelSet.insert(3,20,employee2));
        assertEquals(true,commomIntervelSet.insert(7,23,employee3));

        Set<Employee> set = new HashSet<>();
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);

        assertEquals(set,commomIntervelSet.labels());
    }

    @Test
    public void Testremove()
    {
        CommomIntervelSet<Employee> commomIntervelSet = new CommomIntervelSet<>();
        Employee employee1 = new Employee("zhansan1","duty","123-1234-1234");
        Employee employee2 = new Employee("zhansan2","duty","123-1234-1234");
        Employee employee3 = new Employee("zhansan3","duty","123-1234-1234");
        commomIntervelSet.insert(9,11,employee1);
        commomIntervelSet.insert(3,20,employee2);
        commomIntervelSet.insert(7,23,employee3);

        commomIntervelSet.remove(employee1);
        Set<Employee> set = new HashSet<>();
        set.add(employee2);
        set.add(employee3);

        assertEquals(set,commomIntervelSet.labels());
    }

    @Test
    public void TestgetTimeslot()
    {
        CommomIntervelSet<Employee> commomIntervelSet = new CommomIntervelSet<>();
        Employee employee1 = new Employee("zhansan1","duty","123-1234-1234");
        Employee employee2 = new Employee("zhansan2","duty","123-1234-1234");
        Employee employee3 = new Employee("zhansan3","duty","123-1234-1234");
        commomIntervelSet.insert(9,11,employee1);
        commomIntervelSet.insert(3,20,employee2);
        commomIntervelSet.insert(7,23,employee3);

        Set<Employee> set = new HashSet<>();
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);

        assertEquals(set,commomIntervelSet.getTimeslot().keySet());
    }


}
