package Decoratordesign;

import Basedesign.*;

import java.util.ArrayList;
import java.util.Set;

/**
 * the class is as the basic decorator to implement the interface MultiIntervelSet
 * @param <L>
 */
public abstract class MultiIntervelSetDecorator<L> implements MultiIntervelSet<L> {
    protected final MultiIntervelSet<L> multiIntervelSet;

    public MultiIntervelSetDecorator(MultiIntervelSet<L> multiIntervelSet)
    {
        super();
        this.multiIntervelSet=multiIntervelSet;
    }

    /**
     * delegate multiIntervelSet to do
     * check rep
     */
    @Override
    public void checkRep() {
        multiIntervelSet.checkRep();
    }

    /**
     * delegate multiIntervelSet to do
     * @param label if remove success,return true ,else false
     * @return
     */
    @Override
    public boolean remove(L label) {
        return multiIntervelSet.remove(label);
    }

    /**
     * delegate multiIntervelSet to do
     * @param label all time slots of the label with IntervelSet<integer>
     * @return
     */
    @Override
    public IntervelSet<Integer> intervels(L label) {
        return multiIntervelSet.intervels(label);
    }

    /**
     * delegate multiIntervelSet to do
     * @param start
     * @param end
     * @param lab1
     * @return
     */
    @Override
    public boolean insert(long start, long end, L lab1) {
        return multiIntervelSet.insert(start,end,lab1);
    }

    /**
     * delegate multiIntervelSet to do
     * @return
     */
    @Override
    public Set<L> labels() {
        return multiIntervelSet.labels();
    }

    /**
     * delegate multiIntervelSet to do
     * @return
     */
    @Override
    public IntervelSet<L> getcommomIntervelSet() {
        return multiIntervelSet.getcommomIntervelSet();
    }
}
