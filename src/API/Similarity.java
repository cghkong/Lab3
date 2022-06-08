package API;

/**
 * the class is to compute the similarity of two MultiIntervelSet object
 */

import Basedesign.CommonMultiIntervelSet;
import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;

import java.util.*;

public class Similarity<L> extends CommonMultiIntervelSet<L> {
    Map<L, ArrayList<Long>> starttime1 = new HashMap<>();
    Map<L, ArrayList<Long>> starttime2 = new HashMap<>();
    Map<Long,Long> fromto1 = new HashMap<>();
    Map<Long,Long> fromto2 = new HashMap<>();

    /**
     * compute the similarity between s1 and s2
     * @param s1
     * @param s2
     * @return
     */
    public double Similarity(MultiIntervelSet<L> s1,MultiIntervelSet<L> s2)
    {
        double result=0.0;
        long similarity=0;
        change(s2,starttime2,fromto2);
        change(s1,starttime1,fromto1);


        long mintime = Math.min(getMintime(fromto1),getMintime(fromto2));
        long maxtime = Math.max(getMaxtime(fromto1),getMaxtime(fromto2));
        for(L label : starttime1.keySet())
        {
            for(int i=0;i<starttime1.get(label).size();i++)
            {
                if(starttime2.get(label)==null)
                {
                    break;
                }
                for(int j=0;j<starttime2.get(label).size();j++)
                {
                    long s2f = starttime2.get(label).get(j);
                    long s2t = fromto2.get(s2f);
                    long s1f = starttime1.get(label).get(i);
                    long s1t = fromto1.get(s1f);
                    if(s2t>s1f && s2f<s1t)
                    {
                        long simf,simt;
                        simt= Math.min(s2t, s1t);
                        simf= Math.max(s2f, s1f);
                        similarity+=simt-simf;
                    }
                }
            }
        }
        if(maxtime==mintime)
            return 0.0;
        result = (double)((double) similarity) / (double) (maxtime-mintime);
        return result;
    }

    /**
     * @param fromto
     * @return the maxtime of time slot
     */
    public long getMaxtime(Map<Long,Long> fromto)
    {
        long maxtime = 0;
        if(fromto.size()==0)
            return 0;
        for(long t:fromto.keySet())
        {
            if(fromto.get(t)>maxtime)
                maxtime = fromto.get(t);
        }
        return maxtime;
    }

    /**
     * @param fromto
     * @return the mintime of the time slot
     */
    public long getMintime(Map<Long,Long> fromto)
    {
        long mintime=Long.MAX_VALUE-1;
        if(fromto.keySet().size()==0)
            return 0;
        for(long t : fromto.keySet())
        {
            if(t<mintime)
                mintime=t;
        }
        return mintime;
    }

    /**
     * change the data from s1 to fromto and starttime
     * @param s1
     * @param starttime
     * @param fromto
     */
    public void change(MultiIntervelSet<L> s1,Map<L,ArrayList<Long>> starttime,Map<Long,Long> fromto)
    {
        for(L label : s1.labels())
        {
            ArrayList<Long> list = new ArrayList<>();
            for(Map.Entry<Integer,Map<Long,Long>> entry :s1.intervels(label).getTimeslot().entrySet())
            {
                for(Map.Entry<Long,Long> entry1 : entry.getValue().entrySet())
                {
                    list.add(entry1.getKey());
                    fromto.put(entry1.getKey(),entry1.getValue());
                }

            }
            starttime.put(label,list);
        }
    }
}
