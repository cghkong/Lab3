package Basedesign;

import static org.junit.Assert.*;

import Basedesign.CommomIntervelSet;
import Basedesign.CommonMultiIntervelSet;
import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;
import objectdesign.Employee;
import org.junit.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestMultiIntervalSet {

    @Test
    public void TestIntervel()
    {
        MultiIntervelSet<Employee> multiIntervelSet = new CommonMultiIntervelSet<>();
        Employee employee1 = new Employee("zhansan1","duty","123-1234-1234");
        Employee employee2 = new Employee("zhansan1","duty","123-1234-1234");
        Employee employee3 = new Employee("zhansan1","duty","123-1234-1234");

        multiIntervelSet.insert(15,19,employee1);
        multiIntervelSet.insert(6,11,employee1);
        multiIntervelSet.insert(14,20,employee2);
        multiIntervelSet.insert(21,27,employee3);

        assertEquals(2,multiIntervelSet.intervels(employee1).getTimeslot().size());
        assertEquals(1,multiIntervelSet.intervels(employee2).getTimeslot().size());
        assertEquals(1,multiIntervelSet.intervels(employee3).getTimeslot().size());
    }

    @Test
    public void TestgetcommomIntervelSet()
    {
        MultiIntervelSet<Employee> multiIntervelSet = new CommonMultiIntervelSet<>();
        Employee employee1 = new Employee("zhansan1","duty","123-1234-1234");
        Employee employee2 = new Employee("zhansan1","duty","123-1234-1234");
        Employee employee3 = new Employee("zhansan1","duty","123-1234-1234");

        multiIntervelSet.insert(15,19,employee1);
        multiIntervelSet.insert(6,11,employee1);
        multiIntervelSet.insert(14,20,employee2);
        multiIntervelSet.insert(21,27,employee3);

        Map<Employee,Map<Long,Long>> dup = new HashMap<>();
        Map<Long,Long> entry1 = new HashMap<>();
        Map<Long,Long> entry2 = new HashMap<>();
        Map<Long,Long> entry3 = new HashMap<>();
        entry1.put((long) 15,(long)19);
        entry1.put((long) 6,(long)11);
        dup.put(employee1,entry1);
        entry2.put((long) 14,(long)20);
        dup.put(employee2,entry2);
        entry3.put((long)21,(long)27);
        dup.put(employee3,entry3);

        assertEquals(dup,multiIntervelSet.getcommomIntervelSet().getTimeslot());
    }

}
