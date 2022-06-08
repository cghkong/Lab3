package ImplementADT;

import Basedesign.*;
import Decoratordesign.*;
import java.time.LocalDate;
import java.util.*;

/**
 * require the weeks>=1,every course name is different
 * the start time and end time must be (8,10),(10,12),(13,15),(15,17),(19,21)
 * require the weekday must 1<=weekday<=7
 * require the hours must be even
 * @param <L>
 */
public class CourseIntervel<L> {
    private final LocalDate startdate;
    private final long weeks;
    private MultiIntervelSet<L> commonMultiIntervelSet = new CommonMultiIntervelSet<>();
    private ClassScheduleSet<L> courseSchedule = new ClassScheduleSet<>(commonMultiIntervelSet);
    private final Map<String,L> coursegroup = new HashMap<>();
    private final Map<L,Long> coursehours = new HashMap<>();
    private final Map<Long,Long> timeslot = new HashMap<>();
    private final ArrayList<String> weekday = new ArrayList<>();

    /**
     * constructor
     * @param startdate
     * @param weeks
     */
    public CourseIntervel(LocalDate startdate, long weeks)
    {
        this.startdate=startdate;
        this.weeks=weeks;
        timeslot.put((long)8,(long)10);
        timeslot.put((long)10,(long)12);
        timeslot.put((long)13,(long)15);
        timeslot.put((long)15,(long)17);
        timeslot.put((long)19,(long)21);
        setweekday();
    }

    /**
     * set the weekday
     */
    public void setweekday()
    {
        weekday.add("Monday");
        weekday.add("Tuesday");
        weekday.add("Wednesday");
        weekday.add("Thursday");
        weekday.add("Friday");
        weekday.add("Saturday");
        weekday.add("Sunday");
    }

    /**
     * get the start date
     * @return
     */
    public LocalDate getStartdate()
    {
        LocalDate localDate = this.startdate;
        return localDate;
    }

    /**
     * get the week numbers
     * @return
     */
    public long getWeeks()
    {
        long t = this.weeks;
        return t;
    }

    /**
     * add a course to the group,require name is unique
     * @param course
     * @param name
     * @return
     */
    public boolean addcourse(L course,String name)
    {
        if(coursegroup.get(name)!=null)
            return false;
        coursegroup.put(name,course);
        coursehours.put(course,(long)0);
        return true;
    }

    /**
     * select the time of course at course schedule
     * the spec is the same to the above(at the class header)
     * course must be in the course group
     * the hours must be available to select
     * @param day
     * @param begin
     * @param end
     * @param name
     * @param hours
     * @return
     */
    public boolean selectcourse(int day,long begin, long end, String name,long hours)
    {
        if(!coursegroup.containsKey(name))
        {
            System.out.println("no such a course");
            return false;
        }
        if(timeslot.containsKey(begin)&&timeslot.get(begin)==end) {
            if(coursehours.get(coursegroup.get(name))<hours)
            {
                courseSchedule.insert_class(day,begin, coursegroup.get(name));
                long hour = coursehours.get(coursegroup.get(name));
                coursehours.remove(coursegroup.get(name));
                coursehours.put(coursegroup.get(name),hour+2);
                return true;
            }
            else {
                System.out.println("the class hours id full");
                return false;
            }
        }
        else {
            System.out.println("the time is not standard");
            return false;
        }
    }

    /**
     * show the not arranged courses
     * @return
     */
    public Set<L> show_class_Unschedule()
    {
        Set<L> Unchedule_class = new HashSet<>();
        for(Map.Entry<L,Long> entry:coursehours.entrySet())
        {
            if(entry.getValue()==0)
            {
                Unchedule_class.add(entry.getKey());
            }
        }
        return Unchedule_class;
    }

    /**
     * @return the percent of free time
     */
    public double percentofleisure()
    {
        double total = 35.0;
        int cnt=0;
        Map<Integer,Map<Long,Set<L>>> classtime = new HashMap<>();
        classtime.putAll(courseSchedule.getClasstime());
        for(Map.Entry<Integer,Map<Long,Set<L>>> entry: classtime.entrySet())
        {
            for(Map.Entry<Long,Set<L>> entry1 : entry.getValue().entrySet())
            {
                if(entry1.getValue().size()==0)
                {
                    cnt++;
                }
            }
        }
        return ((double) cnt)/total;
    }

    /**
     * @return the percent of conflict time
     */
    public double percentofrepeat()
    {
        //double result=0.0;
        double total = 35.0;
        int cnt=0;
        Map<Integer,Map<Long,Set<L>>> classtime = new HashMap<>();
        classtime.putAll(courseSchedule.getClasstime());
        for(Map.Entry<Integer,Map<Long,Set<L>>> entry: classtime.entrySet())
        {
            for(Map.Entry<Long,Set<L>> unit : entry.getValue().entrySet())
            {
                if(unit.getValue().size()>1)
                {
                    cnt++;
                }
            }
        }
        return ((double) cnt)/total;
    }

    /**
     * show the current course schedule
     */
    public void showclassschedule()
    {
        Map<Integer,Map<Long,Set<L>>> classtime = new HashMap<>();
        classtime.putAll(courseSchedule.getClasstime());
        for(int i=1;i<=7;i++)
        {
            System.out.println(weekday.get(i-1));
            printclassofday(i,classtime);
        }
    }

    /**
     * print the  schedule of a day
     * @param d must in 1-7
     * @param classtime
     */
    public void printclassofday(int d,Map<Integer,Map<Long,Set<L>>> classtime)
    {
        ArrayList<Long> moment = new ArrayList<>();
        moment.add((long)8);
        moment.add((long)10);
        moment.add((long)13);
        moment.add((long)15);
        moment.add((long)19);
        for(long t: moment)
        {
            if(classtime.get(d).get(t).size()>0)
            {
                for(L setc :classtime.get(d).get(t))
                {
                    if(t==8)
                    {
                        System.out.println(t+":00-"+(t+2)+":00    "+setc.toString());
                    }
                    else
                    {
                        System.out.println(t+":00-"+(t+2)+":00   "+setc.toString());
                    }

                }
            }
            if(classtime.get(d).get(t).size()==0)
            {
                if(t==8)
                {
                    System.out.println(t+":00-"+(t+2)+":00    free");
                }
                else {
                    System.out.println(t+":00-"+(t+2)+":00   free");
                }
            }
        }
    }
}
