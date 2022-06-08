package APPs;

/**
 * the class is the Course schedule App, you must follow the hint to inout your data
 * you should pay attention to your inpput if it is splited by ',' or blank
 * your input should be in console
 * the date must be the format of yyyy-MM-dd
 */

import FinalADT.CourseIntervalSet;
import objectdesign.Course;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CourseScheduleApp {
    public static void main(String[] args) {
        Map<String,Long> nametohour = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("input the start date(yyyy-MM-dd)");
        Scanner input=new Scanner(System.in);
        String starts=input.nextLine();
        LocalDate startdate = LocalDate.parse(starts,formatter);
        System.out.println("input the number of weeks");
        long weeks = input.nextLong();
        CourseIntervalSet<Course> courseSchedule = new CourseIntervalSet<Course>(startdate,weeks);

        System.out.println("input q to quit from adding course");
        System.out.println("please input a group of course(ID,name,teacher,position,hours)(split by ',')");
        while (true)
        {
            Scanner input1 = new Scanner(System.in);
            String coursemessage = input1.nextLine();
            String[] message = coursemessage.split(",");
            if(message[0].equals("q")) break;
            if(message.length!=5)
            {
                System.out.println("the format is wrong");
                continue;
            }
            long hour = Long.valueOf(message[4]);
            nametohour.put(message[1],hour);
            Course course = new Course(message[0],message[1],message[2],message[3],hour);
            courseSchedule.add_course(course,course.getName());
        }
        System.out.println("input 1 to see the percent of free time");
        System.out.println("input 2 to see the percent of conflict time");
        System.out.println("input 3 to see the percent of Unschedule class");
        System.out.println("input 4 to see the current schedule");
        System.out.println("input 5 to select a course");
        System.out.println("input 6 to quit");

        while (true) {
            System.out.println("input your choice  1-6");
            Scanner input3 = new Scanner(System.in);
            int ch = input3.nextInt();
            switch (ch) {
                case 1:
                    courseSchedule.print_perofleisure();
                    break;
                case 2:
                    courseSchedule.print_perofrepeat();
                    break;
                case 3:
                    courseSchedule.print_Unscheduleclasss();
                    break;
                case 4:
                    courseSchedule.print_curclassSchedule();
                    break;
                case 5:
                    System.out.println("select the time of a course");
                    System.out.println("Monday to Sunday is corresponding 1 to 7 and you can only chooose 8,10,13,15,19 at a day");
                    System.out.println("you can only chooose the time of (8,10),(10,12),(13,15),(15,17),(19,21) at a day");
                    System.out.println("input q to quit");
                    System.out.println("input(weekday start end classname(split by ',')");
                    while (true) {
                        Scanner input2 = new Scanner(System.in);
                        String classmessage = input2.nextLine();
                        String[] message1 = classmessage.split(",");
                        if (message1[0].equals("q")) break;
                        if(message1.length!=4)
                        {
                            System.out.println("the format is wrong");
                            continue;
                        }
                        int weekday = Integer.valueOf(message1[0]);
                        long from = Long.valueOf(message1[1]);
                        long to = Long.valueOf(message1[2]);
                        if(!nametohour.containsKey(message1[3]))
                        {
                            System.out.println("no such a course,input again");
                            continue;
                        }
                        long h = nametohour.get(message1[3]);
                        courseSchedule.select_course(weekday, from, to, message1[3], h);
                    }
                    break;
                default:break;
            }
            if(ch==6)
                break;
        }
    }
}
