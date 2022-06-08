package FinalADT;

import objectdesign.Course;
import ImplementADT.CourseIntervel;

import java.time.LocalDate;

/**
 * the class is the final ADT for courseIntervelSet,and we delegate courseSchedule to do
 * require the weeks>=1,every course name is different
 * the start time and end time must be (8,10),(10,12),(13,15),(15,17),(19,21)
 * require the weekday must 1<=weekday<=7
 * require the hours must be even
 * @param <L>
 */
public class CourseIntervalSet<L> {

    private CourseIntervel<L> courseSchedule;

    public CourseIntervalSet(LocalDate start, long weeks)
    {
        this.courseSchedule = new CourseIntervel<L>(start,weeks);
    }

    /**
     * add a course to a waiting selected group
     * @param course
     * @param name is unique
     * @return
     */
    public boolean add_course(L course,String name)
    {
        return courseSchedule.addcourse(course,name);
    }

    /**
     * select the time for a course
     * @param day >=1, <=7
     * @param begin must be 8,10,13,15,19
     * @param end  must be 10,12,15,17,21
     * @param name is unique for every course
     * @param hours must be even
     * @return
     */
    public boolean select_course(int day,long begin,long end,String name,long hours)
    {
        return courseSchedule.selectcourse(day,begin,end,name,hours);
    }

    /**
     * print the not arranged course
     */
    public void print_Unscheduleclasss()
    {
        System.out.println("Unschedule classes:"+courseSchedule.show_class_Unschedule());
    }

    /**
     * print the percent of free time
     */
    public void print_perofleisure()
    {
        System.out.println("percent of free:"+courseSchedule.percentofleisure());
    }

    /**
     * print the percent of conflict time
     */
    public void print_perofrepeat()
    {
        System.out.println("percent of repeat:"+courseSchedule.percentofrepeat());
    }

    /**
     * print the current course schedule
     */
    public void print_curclassSchedule()
    {
        courseSchedule.showclassschedule();
    }

}
