package Decoratordesign;


import Basedesign.MultiIntervelSet;

import java.util.*;

/**
 * the class is personal decorator to meet the requirement of courseIntervalSet
 * @param <L>
 */
public class ClassScheduleSet<L> extends MultiIntervelSetDecorator<L>{
    private MultiIntervelSet<L> multiIntervelSet;
    private final Map<Integer, Map<Long, Set<L>>> classtime = new HashMap<>();

    /**
     * Constructor
     * @param multiIntervelSet
     */
    public ClassScheduleSet(MultiIntervelSet<L> multiIntervelSet) {
        super(multiIntervelSet);
        this.multiIntervelSet=multiIntervelSet;
        setClasstime();
    }

    /**
     * require the coures are not conflict
     */
    @Override
    public void checkRep() {
        super.checkRep();
    }

    /**
     * set a empty course schedule
     */
    public void setClasstime()
    {
        for(int i=1;i<=7;i++)
        {
            Map<Long,Set<L>> time1 = new HashMap<>();
            Set<L>  setcourse1 = new HashSet<>();
            Set<L>  setcourse2 = new HashSet<>();
            Set<L>  setcourse3 = new HashSet<>();
            Set<L>  setcourse4 = new HashSet<>();
            Set<L>  setcourse5 = new HashSet<>();
            time1.put((long)8,setcourse1);
            time1.put((long)10,setcourse2);
            time1.put((long)13,setcourse3);
            time1.put((long)15,setcourse4);
            time1.put((long)19,setcourse5);
            classtime.put(i,time1);
        }
    }

    /**
     * @param start
     * @param end
     * @param lab1
     * @return
     */
    @Override
    public boolean insert(long start, long end, L lab1) {
        boolean result = super.insert(start,end,lab1);
        return result;
    }

    /**
     * insert a course to course schedule
     * require the course time is not conflict
     * @param day
     * @param start
     * @param course
     * @return
     */
    public boolean insert_class(int day,long start,L course)
    {
        classtime.get(day).get(start).add(course);
        checkRep();
        return true;
    }

    /**
     * get the course schedule
     * @return
     */
    public Map<Integer,Map<Long,Set<L>>> getClasstime()
    {
        Map<Integer,Map<Long,Set<L>>> dup_classtime = new HashMap<>();
        dup_classtime.putAll(classtime);
        return dup_classtime;
    }
}
