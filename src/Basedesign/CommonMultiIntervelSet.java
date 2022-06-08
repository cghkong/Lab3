package Basedesign;

import java.util.*;

/**
 * the class is to implement interface MultiIntervelSet
 * @param <L>
 */
public class CommonMultiIntervelSet<L> implements MultiIntervelSet<L>{

    private IntervelSet<L> commomIntervelSet = new CommomIntervelSet<>();

    /**
     * constructor
     */
    public CommonMultiIntervelSet()
    {
    }

    /**
     * Constructor , through another intervelSet
     * @param intervelSet
     */
    public CommonMultiIntervelSet(IntervelSet<L> intervelSet)
    {
        this.commomIntervelSet=intervelSet;
    }

    /**
     * use the method that in CommomIntervelSet
     */
    @Override
    public void checkRep() {
        commomIntervelSet.checkrep();
    }

    /**
     * delegate commomIntervelSet to do
     * @return the Set of labels
     */
    @Override
    public Set<L> labels() {
        return commomIntervelSet.labels();
    }

    /**
     * delegate commomIntervelSet to do
     * @param start
     * @param end
     * @param lab1
     * @return
     */
    @Override
    public boolean insert(long start, long end, L lab1) {
        return commomIntervelSet.insert(start,end,lab1);
    }

    /**
     * delegate commomIntervelSet to do
     * @param label if remove success,return true ,else false
     * @return
     */
    @Override
    public boolean remove(L label)
    {
        return commomIntervelSet.remove(label);
    }

    /**
     * implement the new mathod
     * @param label all time slots of the label with IntervelSet<integer>
     * @return
     */
    @Override
    public IntervelSet<Integer> intervels(L label)
    {
        IntervelSet<Integer> labelintervelset = new CommomIntervelSet<>();
        int cnt=0;
        for(Map.Entry<Long,Long> entry: commomIntervelSet.getTimeslot().get(label).entrySet())
        {
            labelintervelset.insert(entry.getKey(),entry.getValue(),cnt);
            cnt++;
        }
        return labelintervelset;
    }

    /**
     * @return the object commomIntervelSet
     */
    @Override
    public IntervelSet<L> getcommomIntervelSet() {
        return this.commomIntervelSet;
    }
}
