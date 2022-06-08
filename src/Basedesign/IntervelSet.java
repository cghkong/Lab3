package Basedesign;

import java.util.Map;
import java.util.Set;

/**
 * the interface IntervelSet<L> the abstract of time slot
 * @param <L>
 */
public interface IntervelSet<L>{

    /**
     * check the rep if it is illegal
     */
    public void checkrep();

    /**
     * insert a time slot
     * @param start is start time
     * @param end is ending time
     * @param lab1 is a label about the time slot
     */
    public  boolean insert(long start,long end,L lab1);

    /**
     * @return the label set of current instance
     */
    public Set<L> labels();

    /**
     *remove all time slot of the linked label
     * @param label
     * @return true if remove success
     */
    public boolean remove(L label);


    /**
     *return to the label's beginning time
     * @param label
     * @return the beginning time of the label
     */
    public long start(L label);

    /**
     * return to the label's end time
     * @param label
     * @return the end time of the label
     */
    public long end (L label);

    /**
     * @return the timeslot
     */
    public Map<L, Map<Long,Long>> getTimeslot();

}
