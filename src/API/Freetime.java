package API;

/**
 * compute the percent of free time in set
 */

import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;

public class Freetime<L> {

    /**
     * compute the precent of freetime for MultiInterSet
     * @param set
     * @return
     */
    public double calcFreeTimeRatio(MultiIntervelSet<L> set)
    {
        long freetimes = 0;
        int[]  times = null;
        times = new int[10000];
        long mint =Long.MAX_VALUE-1;
        long maxt =0;
        for(L label: set.getcommomIntervelSet().getTimeslot().keySet())
        {
            for(long start :set.getcommomIntervelSet().getTimeslot().get(label).keySet())
            {
                if(start<mint)
                    mint=start;
                long end = set.getcommomIntervelSet().getTimeslot().get(label).get(start);
                if(end>maxt)
                    maxt=end;
                for(int i=(int)start;i<(int)end;i++)
                {
                    times[i]=1;
                }
            }
        }
        if(mint==Long.MAX_VALUE-1)
            return 0.0;
        for(int i=(int) mint;i<(int) maxt;i++)
        {
            if(times[i]==0)
                freetimes++;
        }
        return (double) freetimes / (double) (maxt-mint);
    }

    /**
     * compute the percent of free time for IntervelSet
     * @param set
     * @return
     */
    public double calcFreeTimeRatio(IntervelSet<L> set)
    {
        long freetimes = 0;
        int[]  times = null;
        times = new int[10000];
        long mint =Long.MAX_VALUE-1;
        long maxt =0;
        for(L label: set.getTimeslot().keySet())
        {
            for(long start :set.getTimeslot().get(label).keySet())
            {
                if(start<mint)
                    mint=start;
                long end = set.getTimeslot().get(label).get(start);
                if(end>maxt)
                    maxt=end;
                for(int i=(int)start;i<(int)end;i++)
                {
                    times[i]=1;
                }
            }
        }
        if(mint==Long.MAX_VALUE-1)
            return 0.0;
        for(int i=(int) mint;i<(int) maxt;i++)
        {
            if(times[i]==0)
                freetimes++;
        }
        return (double) freetimes / (double) (maxt-mint);
    }
}
