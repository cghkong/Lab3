package APPs;

/**
 * the class is the DutyRoster schedule App, you must follow the hint to inout your data
 * you should pay attention to your inpput if it is splited by ',' or blank
 * your input should be in console
 * the date must be the format of yyyy-MM-dd
 */

import FinalADT.CourseIntervalSet;
import FinalADT.DutyIntervalSet;
import objectdesign.Course;
import objectdesign.Employee;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DutyRosterApp {
    public static void main(String[] args) {
        Map<String,Employee> employeegroup = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("input the start date and deaddline(yyyy-MM-dd,yyyy-MM-dd)");
        Scanner input=new Scanner(System.in);
        String times=input.nextLine();
        String[] timess = times.split(",");
        if(timess.length!=2)
        {
            System.out.println("the wrong format");
            System.exit(0);
        }
        LocalDate startdate = LocalDate.parse(timess[0],formatter);
        LocalDate enddate = LocalDate.parse(timess[1],formatter);
        DutyIntervalSet<Employee> dutyRoster = new DutyIntervalSet<Employee>(startdate,enddate);

        System.out.println("input q to quit from adding employee");
        System.out.println("please input a group of course(name,duty,phone)(split by ',')");
        while (true)
        {
            Scanner input1 = new Scanner(System.in);
            String employeemessage = input1.nextLine();
            String[] message = employeemessage.split(",");
            if(employeemessage.equals("q"))
                break;
            if(message.length!=3)
            {
                System.out.println("the wrong format");
                continue;
            }
            Employee employee = new Employee(message[0],message[1],message[2]);
            employeegroup.put(message[0],employee);
        }

        System.out.println("input 1 to check isfull and see the free time");
        System.out.println("input 2 to see the current Schedule");
        System.out.println("input 3 to add employee");
        System.out.println("input 4 to quit");
        while (true)
        {
            System.out.println("input your choice 1-4");
            Scanner input3 = new Scanner(System.in);
            int ch = input3.nextInt();
            switch (ch)
            {
                case 1: dutyRoster.checkfull();break;
                case 2: dutyRoster.showschedule();break;
                case 3:
                    System.out.println("input the start date , ending date and the name of employee");
                    System.out.println("input q to quit");
                    System.out.println("yyyy-MM-dd,yyyy-MM-dd,name");
                    while (true)
                    {
                        Scanner input2 = new Scanner(System.in);
                        String addingmessage = input2.nextLine();
                        String[] messagess =addingmessage.split(",");
                        if(addingmessage.equals("q"))
                        {
                            break;
                        }
                        if(messagess.length!=3)
                        {
                            System.out.println("the format is wrong");
                            continue;
                        }
                        LocalDate from = LocalDate.parse(messagess[0],formatter);
                        LocalDate to = LocalDate.parse(messagess[1],formatter);
                        dutyRoster.addEmployee(from,to,employeegroup.get(messagess[2]));
                    }
                    break;
                case 4:break;
                default:break;
            }
            if(ch==4)
                break;
        }
    }
}
