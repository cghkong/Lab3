package ImplementADT;

import Basedesign.*;
import Decoratordesign.ProcessScheduleSet;
import objectdesign.ProCess;
import java.util.Random;
import java.util.*;

/**
 * the class is to implement the method that process schedule required
 * the time is required >=0
 * the time starts from 0
 * the shortest time is required <= the longest time
 * @param <L>
 */
public class ProcessIntervel<L> {

    private MultiIntervelSet<L>  multiIntervelSet= new CommonMultiIntervelSet<>();
    private ProcessScheduleSet<L> processSchedule = new ProcessScheduleSet(multiIntervelSet);
    private final ArrayList<L> processgroup = new ArrayList<L>();
    private final Map<L,Long> longesttime = new HashMap<>();
    private final Map<L,Long> shorttime = new HashMap<>();
    private long time_cur=0;

    /**
     * add a process to waiting queue
     * @param PS the label
     * @param ltime the longest time
     * @param stime the shortest time
     * @return
     */
    public boolean insertprocess(L PS,long ltime,long stime)
    {
        if(processgroup.contains(PS))
            return false;
        processgroup.add(PS);
        longesttime.put(PS,ltime);
        shorttime.put(PS,stime);
        return true;
    }

    /**
     * execute by randomly
     */
    public void random_execute()
    {
        processSchedule.removeall();
        ArrayList<L> dup_processes = new ArrayList<L>();
        ArrayList<Long> useedtime = new ArrayList<>();
        for(L p : processgroup)
        {
            dup_processes.add(p);
            long t=0;
            useedtime.add(t);
        }
        Random random = new Random();
        int index;
        long times;

        int fr =0;
        while (dup_processes.size()>0)
        {
            index = random.nextInt(dup_processes.size());
            times = Math.abs((random.nextLong())%(longesttime.get(dup_processes.get(index))));
            while (times==0)
            {
                times = Math.abs((random.nextLong())%(longesttime.get(dup_processes.get(index))));
            }
            fr=random.nextInt(5);
            if(fr==1)
            {
                time_cur = time_cur+times;
                ProCess proCess = new ProCess("free",0,0,0);
                processSchedule.insert_process(time_cur,(L)proCess);
                continue;
            }
            else
            {
                if((times+useedtime.get(index))>longesttime.get(dup_processes.get(index)))
                {
                    times=longesttime.get(dup_processes.get(index))-useedtime.get(index);
                }
                time_cur=times+time_cur;
                processSchedule.insert_process(time_cur,dup_processes.get(index));
            }
            if((useedtime.get(index)+times)>=longesttime.get(dup_processes.get(index)))
            {
                dup_processes.remove(index);
                useedtime.remove(index);
            }
            else {
                useedtime.set(index,useedtime.get(index)+times);
            }
        }
    }

    /**
     * execute by the shortest of the longest time first
     */
    public void shortprocess_priority()
    {
        processSchedule.removeall();
        ArrayList<Long> surplustime = new ArrayList<Long>();
        ArrayList<L> surplusprocess = new ArrayList<L>();
        for(L p : processgroup)
        {
            surplustime.add(longesttime.get(p));
            surplusprocess.add(p);
        }
        Random random = new Random();
        Random random1 = new Random();
        long constanttime=0;
        while (!surplusprocess.isEmpty())
        {
            int fr=random.nextInt(5);
            long minvalue=Long.MAX_VALUE-1;
            int index=0;
            int i=0;
            for(i=0;i<surplustime.size();i++)
            {
                if(surplustime.get(i)<minvalue)
                {
                    minvalue=surplustime.get(i);
                    index=i;
                }
            }
            constanttime=0;
            while (constanttime==0)
            {
                constanttime = Math.abs(random1.nextLong()%(minvalue*2-1));
                if(constanttime>minvalue)
                {
                    constanttime=minvalue;
                }
            }
            if(fr==1)
            {
                time_cur=time_cur+constanttime;
                ProCess proCess = new ProCess("free",0,0,0);
                processSchedule.insert_process(time_cur,(L) proCess);
                continue;
            }
            else
            {
                time_cur=time_cur+constanttime;
                processSchedule.insert_process(time_cur,surplusprocess.get(index));
            }
            long diff = longesttime.get(surplusprocess.get(index))-shorttime.get(surplusprocess.get(index));
            if((surplustime.get(index)-constanttime)>diff)
            {
                surplustime.set(index,surplustime.get(index)-constanttime);
            }
            else
            {
                surplustime.remove(index);
                surplusprocess.remove(index);
            }
        }
    }

    /**
     * show the current result
     */
    public void showresult()
    {
        for(int i=0;i<processSchedule.getLabellist().size();i++)
        {
            long pre = processSchedule.getTimelist().get(i);
            long pro = processSchedule.getTimelist().get(i+1);
            System.out.println(processSchedule.getLabellist().get(i).toString()+pre+"--"+pro);
        }
    }

}

