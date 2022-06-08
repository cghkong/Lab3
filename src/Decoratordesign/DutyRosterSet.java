package Decoratordesign;


import Basedesign.IntervelSet;
import objectdesign.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * the DutyRosterSet extends IntervelSetDecorator
 * the DutyRosterSet is to add and implement the personal method
 * @param <L>
 */
public class DutyRosterSet<L> extends IntervelSetDecorator<L> {
    private IntervelSet<L> intervelSet;
    private Map<L,Long> begin = new HashMap<>();
    private Map<L,Long> ending = new HashMap<>();
    private Map<Long,Long> timeslot = new HashMap<>();
    private Map<String,Employee> employeeSet = new HashMap<>();


    /**
     * Constructor
     * @param intervelSet
     */
    public DutyRosterSet(IntervelSet<L> intervelSet) {
        super(intervelSet);
        this.intervelSet=intervelSet;
    }

    @Override
    public void checkrep() {
        super.checkrep();
    }

    /**
     * require the lab1 is not in the time slot
     * @param start is start time
     * @param end is ending time
     * @param lab1 is a label about the time slot
     * @return if insert sucess,return true;else false
     */
    @Override
    public boolean insert(long start, long end, L lab1) {
        if(begin.containsKey(lab1))
        {
            System.out.println("label is already existing");
            return false;
        }
        begin.put(lab1,start);
        ending.put(lab1,end);
        timeslot.put(start,end);
        boolean res = super.insert(start,end,lab1);
        checkrep();
        return res;
    }

    /**
     * remove all the time slot about the label
     * @param label
     * @return if success ,return true
     */
    @Override
    public boolean remove(L label) {
        if(!begin.containsKey(label))
            return false;
        long starts = begin.get(label);
        timeslot.remove(starts);
        begin.remove(label);
        ending.remove(label);
        return super.remove(label);
    }

    /**
     * get the end time that is corresponding to the start time
     * @param start in the time slot
     * @return the end time
     */
    public long getendofstart(long start)
    {
        return timeslot.get(start);
    }

}
