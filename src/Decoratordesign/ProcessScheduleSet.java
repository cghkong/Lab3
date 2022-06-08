package Decoratordesign;

import Basedesign.MultiIntervelSet;

import java.util.ArrayList;

/**
 * the class is personal decorator to meet the requirement of processIntervalSet
 * require time >=0
 * @param <L>
 */
public class ProcessScheduleSet<L> extends MultiIntervelSetDecorator<L>{
    private final ArrayList<L> Labellist = new ArrayList<>();
    private final ArrayList<Long> timelist = new ArrayList<>();

    /**
     * constructor
     * @param multiIntervelSet
     */
    public ProcessScheduleSet(MultiIntervelSet<L> multiIntervelSet) {
        super(multiIntervelSet);
        timelist.add((long)0);
    }

    /**
     * insert a process,require time >0
     * @param righttime
     * @param label
     */
    public void insert_process(long righttime,L label)
    {
        Labellist.add(label);
        timelist.add(righttime);
    }

    /**
     * get the label with Arraylist
     * @return
     */
    public ArrayList<L> getLabellist()
    {
        ArrayList<L> dup_labellist = new ArrayList<>();
        for(int i=0;i<Labellist.size();i++)
        {
            dup_labellist.add(Labellist.get(i));
        }
        return dup_labellist;
    }

    /**
     * get the timelist
     * @return
     */
    public ArrayList<Long> getTimelist()
    {
        ArrayList<Long> dup_timelist = new ArrayList<>();
        for (int i=0;i<timelist.size();i++)
        {
            dup_timelist.add(timelist.get(i));
        }
        return dup_timelist;
    }

    /**
     * clear all data that already existing
     */
    public boolean removeall()
    {
        Labellist.clear();
        timelist.clear();
        timelist.add((long)0);
        if(timelist.size()==1)
            return true;
        return false;
    }

}
