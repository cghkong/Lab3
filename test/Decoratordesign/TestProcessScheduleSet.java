package Decoratordesign;

import static org.junit.Assert.*;

import Basedesign.CommomIntervelSet;
import Basedesign.CommonMultiIntervelSet;
import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;
import objectdesign.Course;
import objectdesign.Employee;
import objectdesign.ProCess;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestProcessScheduleSet {

    @Test
    public void TestAll()
    {
        MultiIntervelSet<ProCess> multiIntervelSet = new CommonMultiIntervelSet<>();
        ProcessScheduleSet<ProCess> proCessProcessScheduleSet = new ProcessScheduleSet<ProCess>(multiIntervelSet);

        ProCess proCess0 = new ProCess("p0",1234,4,9);
        ProCess proCess1 = new ProCess("p1",1233,6,12);
        ProCess proCess2 = new ProCess("p2",1237,5,10);
        proCessProcessScheduleSet.insert_process(9,proCess0);
        proCessProcessScheduleSet.insert_process(12,proCess0);
        proCessProcessScheduleSet.insert_process(12,proCess1);
        proCessProcessScheduleSet.insert_process(10,proCess2);

        assertEquals(true,proCessProcessScheduleSet.getLabellist().contains(proCess0));
        assertEquals(true,proCessProcessScheduleSet.getLabellist().contains(proCess1));
        assertEquals(true,proCessProcessScheduleSet.getLabellist().contains(proCess2));
        assertEquals(true,proCessProcessScheduleSet.removeall());


    }
}
