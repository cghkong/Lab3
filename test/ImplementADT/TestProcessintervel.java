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

public class TestProcessintervel {
    @Test
    public void TestALl()
    {
        ProcessIntervel<ProCess> proCessProcessIntervel =new ProcessIntervel<>();

        ProCess p1 = new ProCess("P1",1,12,16);
        ProCess p2 = new ProCess("P2",2,2,6);
        ProCess p3 = new ProCess("P3",3,22,26);
        ProCess p4 = new ProCess("P4",4,15,19);

        assertEquals(true,proCessProcessIntervel.insertprocess(p1,12,16));
        assertEquals(true,proCessProcessIntervel.insertprocess(p2,2,6));
        assertEquals(true,proCessProcessIntervel.insertprocess(p3,22,26));
        assertEquals(false,proCessProcessIntervel.insertprocess(p2,2,6));

    }
}
