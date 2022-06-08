package API;

import static org.junit.Assert.*;

import Basedesign.CommomIntervelSet;
import Basedesign.CommonMultiIntervelSet;
import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;
import objectdesign.Employee;
import org.junit.*;
import org.junit.Test;

public class APItest {

    /**
     * we have consider the case that at 5 is bound point test the intervelset
     * the case that a label have many time slot for multiIntervelset
     */
    @Test
    public void calcConflictRatio()
    {
        Conflict<Employee> conflict = new Conflict<>();
        IntervelSet<Employee> intervelSet = new CommomIntervelSet<>();
        MultiIntervelSet<Employee> multiIntervelSet = new CommonMultiIntervelSet<>();
        Employee employee1 = new Employee("zhansan","professor","123-1234-1234");
        Employee employee2 = new Employee("zhansan","professor","123-1234-1234");
        Employee employee3 = new Employee("zhansan","professor","123-1234-1234");
        intervelSet.insert(5,13,employee1);
        intervelSet.insert(10,20,employee2);
        intervelSet.insert(0,5,employee3);

        multiIntervelSet.insert(0,6,employee1);
        multiIntervelSet.insert(7,15,employee2);
        multiIntervelSet.insert(10,20,employee1);

        assertEquals(0.15,conflict.calcConflictRatio(intervelSet),0.01);
        assertEquals(0.25,conflict.calcConflictRatio(multiIntervelSet),0.01);
    }

    /**
     * choose the case that free time between 6 and 7,bound check
     * and another case is that check the bound at 5
     */
    @Test
    public void Testfreetime()
    {
        Freetime<Employee> freetime = new Freetime<>();
        IntervelSet<Employee> intervelSet = new CommomIntervelSet<>();
        MultiIntervelSet<Employee> multiIntervelSet = new CommonMultiIntervelSet<>();
        Employee employee1 = new Employee("zhansan","professor","123-1234-1234");
        Employee employee2 = new Employee("zhansan","professor","123-1234-1234");
        Employee employee3 = new Employee("zhansan","professor","123-1234-1234");
        intervelSet.insert(5,8,employee1);
        intervelSet.insert(13,20,employee2);
        intervelSet.insert(0,5,employee3);

        multiIntervelSet.insert(0,6,employee1);
        multiIntervelSet.insert(7,15,employee2);
        multiIntervelSet.insert(10,20,employee1);

        assertEquals(0.25,freetime.calcFreeTimeRatio(intervelSet),0.01);
        assertEquals(0.05,freetime.calcFreeTimeRatio(multiIntervelSet),0.01);
    }

    /**
     * test the similarity between s1,s2
     * the case is special for that change the label but the time is same
     */
    @Test
    public void TestSimilarity()
    {
        Similarity<Employee> similarity = new Similarity<>();
        MultiIntervelSet<Employee> multiIntervelSet1 = new CommonMultiIntervelSet<>();
        MultiIntervelSet<Employee> multiIntervelSet2 = new CommonMultiIntervelSet<>();
        Employee employee1 = new Employee("zhansan","professor","123-1234-1234");
        Employee employee2 = new Employee("zhansan","professor","123-1234-1234");
        Employee employee3 = new Employee("zhansan","professor","123-1234-1234");

        multiIntervelSet1.insert(0,6,employee1);
        multiIntervelSet1.insert(7,15,employee2);
        multiIntervelSet1.insert(10,20,employee3);

        multiIntervelSet2.insert(0,6,employee1);
        multiIntervelSet2.insert(8,9,employee3);
        multiIntervelSet2.insert(10,20,employee1);

        assertEquals(0.30,similarity.Similarity(multiIntervelSet1,multiIntervelSet2),0.01);
    }

}
