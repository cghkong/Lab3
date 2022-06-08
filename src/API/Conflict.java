package API;

/**
 * compute the percent of conflict time
 */

import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Conflict<L> {

    /**
     * compute the percent of conflict time for IntervelSet
     * @param set
     * @return
     */
    public double calcConflictRatio(IntervelSet<L> set)
    {
        long concflict = 0;
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
                    if(times[i]==1)
                    {
                        concflict++;
                    }
                    else {
                        times[i]=1;
                    }
                }
            }
        }
        if(mint==Long.MAX_VALUE-1)
            return 0.0;
        return (double) concflict / (double) (maxt-mint);
    }

    /**
     * compute the percent of free time for MultiIntervelSet
     * @param set
     * @return
     */
    public double calcConflictRatio(MultiIntervelSet<L> set)
    {
        long concflict = 0;
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
                    if(times[i]==1)
                    {
                        concflict++;
                    }
                    else {
                        times[i]=1;
                    }
                }
            }
        }
        if(mint==Long.MAX_VALUE-1)
            return 0.0;
        return (double) concflict / (double) (maxt-mint);
    }
}
