package Decoratordesign;
import static org.junit.Assert.*;
import Basedesign.CommonMultiIntervelSet;
import Basedesign.MultiIntervelSet;
import objectdesign.Course;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestClassScheduleSet {

    @Test
    public void Testinsert_class()
    {
        MultiIntervelSet<Course> multiIntervelSet = new CommonMultiIntervelSet<>();
        ClassScheduleSet<Course> courseClassScheduleSet = new ClassScheduleSet<>(multiIntervelSet);
        Course course1 = new Course("2341","C1","T1","P1",4);
        Course course2 = new Course("2341","C2","T1","P2",2);
        Course course3 = new Course("2341","C2","T1","P3",4);
        assertEquals(true,courseClassScheduleSet.insert_class(1,8,course1));
        assertEquals(true,courseClassScheduleSet.insert_class(4,13,course1));
        assertEquals(true,courseClassScheduleSet.insert_class(2,10,course3));
        assertEquals(true,courseClassScheduleSet.insert_class(3,10,course3));
    }

    @Test
    public void Testinsert()
    {
        MultiIntervelSet<Course> multiIntervelSet = new CommonMultiIntervelSet<>();
        ClassScheduleSet<Course> courseClassScheduleSet = new ClassScheduleSet<>(multiIntervelSet);
        Course course1 = new Course("2341","C1","T1","P1",4);
        Course course2 = new Course("2341","C2","T1","P2",2);
        Course course3 = new Course("2341","C2","T1","P3",4);
        assertEquals(true,courseClassScheduleSet.insert(8,10,course1));
        assertEquals(true,courseClassScheduleSet.insert(10,12,course1));
        assertEquals(true,courseClassScheduleSet.insert(13,15,course3));
        assertEquals(true,courseClassScheduleSet.insert(19,21,course3));
    }

    @Test
    public void Testgetclasstime()
    {
        MultiIntervelSet<Course> multiIntervelSet = new CommonMultiIntervelSet<>();
        ClassScheduleSet<Course> courseClassScheduleSet = new ClassScheduleSet<>(multiIntervelSet);
        Course course1 = new Course("2341","C1","T1","P1",4);
        Course course2 = new Course("2341","C2","T1","P2",2);
        Course course3 = new Course("2341","C2","T1","P3",4);
        assertEquals(true,courseClassScheduleSet.insert_class(1,8,course1));
        assertEquals(true,courseClassScheduleSet.insert_class(4,13,course1));
        assertEquals(true,courseClassScheduleSet.insert_class(2,10,course2));
        assertEquals(true,courseClassScheduleSet.insert_class(3,10,course3));

        Map<Integer, Map<Long, Set<Course>>> ctime = new HashMap<>();
        ctime.putAll(courseClassScheduleSet.getClasstime());
        assertEquals(true,ctime.get(4).get((long)13).contains(course1));
        assertEquals(true,ctime.get(2).get((long)10).contains(course2));
        assertEquals(false,ctime.get(3).get((long)8).contains(course3));
        assertEquals(true,ctime.get(1).get((long)8).contains(course1));
    }
}
