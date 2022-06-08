package FinalADT;

import objectdesign.ProCess;
import ImplementADT.ProcessIntervel;


/**
 * the class is the final ADT  that process schedule, the detailed method is packed in other classes,
 * we delegate ProcessIntervel to do
 * the time is required >=0
 * the time starts from 0
 * the shortest time is required <= the longest time
 * @param <L>
 */
public class ProcessIntervalSet<L> {

    private ProcessIntervel<L> processSchedule = new ProcessIntervel<>();

    public boolean addprocess(L PS,long longtime,long shorttime)
    {
        return processSchedule.insertprocess(PS,longtime,shorttime);
    }

    public void randomexe()
    {
        processSchedule.random_execute();
    }

    public void shortprocessexe()
    {
        processSchedule.shortprocess_priority();
    }

    public void show()
    {
        processSchedule.showresult();
    }

}
