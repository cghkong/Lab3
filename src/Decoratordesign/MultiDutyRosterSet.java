package Decoratordesign;

import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;

import java.util.ArrayList;
import java.util.Map;

/**
 * to deal with that a label that can have more than one time slot
 * through add another decorator to achieve the goal
 * @param <L>
 */
public class MultiDutyRosterSet<L> extends MultiIntervelSetDecorator<L>{
    MultiIntervelSet<L>  multiIntervelSet;


    /**
     * Constructor
     * @param multiIntervelSet
     */
    public MultiDutyRosterSet(MultiIntervelSet<L> multiIntervelSet) {
        super(multiIntervelSet);
        this.multiIntervelSet=multiIntervelSet;
    }

    /**
     * require the label that has existed already
     * @param label
     * @return the start time of label with a ArrayList
     */
    public ArrayList<Long> start(L label)
    {
        ArrayList<Long> starttime=new ArrayList<>();
        for(Long time :multiIntervelSet.getcommomIntervelSet().getTimeslot().get(label).keySet())
        {
            starttime.add(time);
        }
        return starttime;
    }

    /**
     * get the end time of a label that is corresponding to the start time
     * @param time
     * @param label
     * @return the end time
     */
    public Long getendofstart(Long time,L label)
    {
        long ending = multiIntervelSet.getcommomIntervelSet().getTimeslot().get(label).get(time);
        return ending;
    }

}
