package Basedesign;

import java.util.ArrayList;
import java.util.Set;

/**
 * the interface MultiIntervelSet is to describe that a label may have more than one time slot
 * @param <L>
 */
public interface MultiIntervelSet<L> {

    /**
     * check the Rep
     */
    public void checkRep();

    /**
     * @return the set of labels
     */
    public Set<L> labels();

    /**
     * label must in the Set of all labels that existed
     * @param label all time slots of the label with IntervelSet<integer>
     * @return
     */
    public IntervelSet<Integer> intervels(L label);

    /**
     * insert a time slot
     * @param start
     * @param end
     * @param lab1
     * @return
     */
    public  boolean insert(long start,long end,L lab1);

    /**
     * remove all the time slot that linked to label
     * @param label if remove success,return true ,else false
     * @return
     */
    public boolean remove(L label);

    /**
     * @return the object CommomIntervelSet
     */
    public IntervelSet<L> getcommomIntervelSet();

}
