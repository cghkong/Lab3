package Decoratordesign;

import Basedesign.IntervelSet;

import java.util.Map;
import java.util.Set;

/**
 * the abstract class is as a decorator to implement IntervelSet
 * @param <L>
 */
public abstract class IntervelSetDecorator<L> implements IntervelSet<L> {
    protected final IntervelSet<L> intervelSet;

    /**
     * constructor
     * @param intervelSet
     */
    protected IntervelSetDecorator(IntervelSet<L> intervelSet) {
        super();
        this.intervelSet = intervelSet;
    }

    /**
     * delegate IntervelSet to do
     */
    @Override
    public void checkrep() {
        intervelSet.checkrep();
    }

    /**
     * delegate IntervelSet to do
     * @param start is start time
     * @param end is ending time
     * @param lab1 is a label about the time slot
     * @return
     */
    @Override
    public boolean insert(long start, long end, L lab1) {
        return intervelSet.insert(start,end,lab1);
    }

    /**
     * delegate IntervelSet to do
     * @return
     */
    @Override
    public Set<L> labels() {
        return intervelSet.labels();
    }

    /**
     * delegate IntervelSet to do
     * @param label
     * @return
     */
    @Override
    public boolean remove(L label) {
        return intervelSet.remove(label);
    }

    /**
     * delegate IntervelSet to do
     * @param label
     * @return
     */
    @Override
    public long start(L label) {
        return intervelSet.start(label);
    }

    /**
     * delegate IntervelSet to do
     * @param label
     * @return
     */
    @Override
    public long end(L label) {
        return intervelSet.end(label);
    }

    /**
     * delegate IntervelSet to do
     * @return
     */
    @Override
    public Map<L, Map<Long, Long>> getTimeslot() {
        return intervelSet.getTimeslot();
    }
}
