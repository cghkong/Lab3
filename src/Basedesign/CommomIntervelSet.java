package Basedesign;

import java.util.*;

/**
 * @param <L> the class is to implement the interface IntervelSet
 */
public class CommomIntervelSet<L> implements IntervelSet<L> {

    /**
     * timeslot is to store the information of times and labels
     */
    private Map<L,Map<Long,Long>> timeslot = new HashMap<>();

    /**
     * Constructor
     */
    public CommomIntervelSet()
    {
    }

    /**
     * to check if it is the time >0 , end time >= begin time
     */
    @Override
    public void checkrep()
    {
        for(Map.Entry<L,Map<Long,Long>> entry : timeslot.entrySet())
        {
            for( Long first :entry.getValue().keySet())
            {
                assert (first>=0);
                assert (entry.getValue().get(first)>=0);
                assert (first<=entry.getValue().get(first));
            }
        }
    }
    /**
     * implement the insert function , adding a time slot to timeslot
     * @param start
     * @param end
     * @param lab1
     */
    @Override
    public  boolean insert(long start,long end,L lab1)
    {
        Map<Long,Long> entry = new HashMap<>();
        if(timeslot.get(lab1)==null)
        {
            entry.put(start,end);
            timeslot.put(lab1,entry);
        }
        else
        {
            entry.putAll(timeslot.get(lab1));
            entry.put(start,end);
            timeslot.remove(lab1);
            timeslot.put(lab1,entry);
        }
        return true;
    }

    /**
     *
     * @return the label set of current instance
     */
    @Override
    public Set<L> labels()
    {
        Set<L> copySet = new HashSet<>();
        for (L unit:timeslot.keySet())
            copySet.add(unit);
        return copySet;
    }

    /**
     *remove the time slot of the linked label
     * @param label
     * @return true if remove success
     */
    @Override
    public boolean remove(L label)
    {
        if(!timeslot.keySet().contains(label))
            return false;
        timeslot.remove(label);
        return true;
    }

    /**
     *return to the label's beginning time
     * @param label
     * @return the beginning time of the label
     */
    @Override
    public long start(L label)
    {
        long temp=0;
        for(long first :timeslot.get(label).keySet())
            temp = first;
        return temp;
    }

    /**
     * return to the label's end time
     * @param label
     * @return the end time of the label
     */
    @Override
    public long end (L label)
    {
        long temp=timeslot.get(label).get(start(label));
        return temp;
    }

    /**
     * @return the timeslot
     */
    @Override
    public Map<L,Map<Long,Long>> getTimeslot()
    {
        Map<L,Map<Long,Long>> dup_timeslot = new HashMap<>();
        dup_timeslot.putAll(timeslot);
        return dup_timeslot;
    }
}
