package ImplementADT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Basedesign.CommomIntervelSet;
import Basedesign.CommonMultiIntervelSet;
import Basedesign.IntervelSet;
import Basedesign.MultiIntervelSet;
import Decoratordesign.DutyRosterSet;
import Decoratordesign.MultiDutyRosterSet;
import objectdesign.Employee;

/**
 * require frtime must be < totaldays
 * totaldays must be > 0
 * start must be before end
 * @param <L>
 */
public class DutyIntervel<L> {

    private IntervelSet<L> intervelSet = new CommomIntervelSet<>();
    private DutyRosterSet<L> commomIntervelSet = new DutyRosterSet<>(intervelSet);
    private LocalDate start,end;
    private long totaldays;
    private long frtime=0;
    private Map<String,Employee> employeeSet = new HashMap<>();

    public DutyIntervel()
    {

    }

    /**
     * constructor by string(filename)
     * @param filename
     */
    public DutyIntervel(String filename)
    {
        readfromfile(filename);
    }

    /**
     * get diff between current and start
     * @param current
     * @param start
     * @return
     */
    public long DateChange(LocalDate current,LocalDate start)
    {
        long days = current.toEpochDay()-start.toEpochDay();
        return days;
    }

    /**
     * another Constructor
     * @param start
     * @param end
     */
    public DutyIntervel(LocalDate start, LocalDate end)
    {
        this.start=start;
        this.end=end;
        this.totaldays=DateChange(end,start);
    }

    /**
     * adding a  label to course schedule
     * @param from before to
     * @param to  after from
     * @param Label cannot exist already
     */
    public boolean insert(LocalDate from,LocalDate to,L Label)
    {
        long begin = DateChange(from,start);
        long ending = DateChange(to,start);
        return commomIntervelSet.insert(begin,ending,Label);
    }

    /**
     * remove a label
     * @param Label
     */
    public void remove(L Label)
    {
        commomIntervelSet.remove(Label);
    }


    /**
     * get the name of the label
     * @param label
     * @return
     */
    public String showname(L label)
    {
        Employee employee = (Employee)label;
        return employee.getName();
    }

    /**
     * check if it is full
     */
    public void checkfull(){
        getcurmessage(0);
    }

    /**
     * show the current schedule
     */
    public void showschedule()
    {
        getcurmessage(1);
    }

    /**
     * get the information about schedule
     * @param flag
     */
    public void getcurmessage(int flag)
    {
        frtime=0;
        ArrayList<Long> begintime = new ArrayList<>();
        Map<Long,L> employeetime = new HashMap<>();
        for(L employee:commomIntervelSet.labels())
        {
            long start1 = commomIntervelSet.start(employee);
            begintime.add(start1);
            employeetime.put(start1,employee);
        }
        Collections.sort(begintime);

        long pre=0;
        for(int i=0;i<begintime.size();i++)
        {
            if(begintime.get(i) >pre)
            {
                LocalDate f1 = start.plusDays(pre);
                LocalDate t1 = start.plusDays(begintime.get(i)-1);
                frtime = frtime + DateChange(t1,f1);
                System.out.println(f1+" --  "+t1+"\tfree");
            }

            long timeending = commomIntervelSet.getendofstart(begintime.get(i));
            if(flag==1)
            {
                LocalDate f1 = start.plusDays(begintime.get(i));
                LocalDate t1 = start.plusDays(timeending);
                System.out.println(f1+" --  "+t1+"\t"+showname(employeetime.get(begintime.get(i))));
            }
            pre = timeending+1;
            if(i==begintime.size()-1&&pre<=totaldays)
            {
                LocalDate f2 = start.plusDays(pre);
                frtime = frtime + DateChange(end,f2);
                System.out.println(f2+" --  "+end+"\tfree");
            }
        }
        if(begintime.size()==0)
        {
            System.out.println(start+" --  "+end+"\tfree");
            System.out.println("the percent of free is: "+1.0);
        }
        else {
            System.out.println("the percent of free is: "+(double)frtime/(double) totaldays);
        }

    }

    /**
     * read from the file to construct a schedule
     * the file is store in relative path
     * @param filename
     */
    public void readfromfile(String filename)
    {
        File file = new File(filename);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String buffline = "";
            while ((buffline=reader.readLine())!=null)
            {
                buffline = buffline.trim();
                buffline = buffline.replace("{",",");
                buffline = buffline.replace("}","");
                String[] line = buffline.split(",");
                Pattern pattern = Pattern.compile("([a-zA-Z]+)\\s*([a-zA-Z]+)");
                Pattern pattern1 = Pattern.compile("([0-9]{3})-([0-9]{4})-([0-9]{4})");
                Pattern pattern2 = Pattern.compile("([0-9]{4})-([0-9]{2})-([0-9]{2})");
                Matcher matcher = pattern.matcher(buffline);
                Matcher matcher1 = pattern1.matcher(buffline);
                Matcher matcher2 = pattern2.matcher(buffline);
                String[] infor = {"",""};
                int i=0;

                while (matcher.find())
                {
                    infor[i] =matcher.group();
                    i++;
                }
                String phone="";
                while (matcher1.find())
                {
                    phone = matcher1.group();
                }
                String[] date = {"",""};
                int j=0;
                while (matcher2.find())
                {
                    date[j]=matcher2.group();
                    j++;
                }
                if(infor[0].equals("Period"))
                {
                    start = LocalDate.parse(date[0],formatter);
                    end = LocalDate.parse(date[1],formatter);
                    totaldays = DateChange(end,start);
                }
                else if(infor[1].length()!=0&&line.length>2)
                {
                    if(phone.length()==0)
                    {
                        System.out.println("the file is illegal(the format of phone id wrong)");
                        System.exit(0);
                    }
                    Pattern pattern0 = Pattern.compile("[0-9]+");
                    Matcher matcher0 = pattern0.matcher(line[0]);
                    if(matcher0.find())
                    {
                        System.out.println("the file is illegal(name including number)");
                        System.exit(0);
                    }
                    Matcher matcher4 = pattern0.matcher(line[1]);
                    if(matcher4.find())
                    {
                        System.out.println("the file is illegal(duty including number)");
                        System.exit(0);
                    }
                    Employee employee = new Employee(infor[0],infor[1],phone);
                    if(employeeSet.containsKey(infor[0]))
                    {
                        System.out.println("the file is illegal(including the same employee)");
                        System.exit(0);
                    }
                    employeeSet.put(infor[0],employee);
                }
                else if(infor[0].length()!=0&&line.length>2){
                    if(date[0].length()==0||date[1].length()==0)
                    {
                        System.out.println("the file is illegal(the format of date is wrong)");
                        System.exit(0);
                    }
                    LocalDate from = LocalDate.parse(date[0],formatter);
                    LocalDate to = LocalDate.parse(date[1],formatter);
                    if(employeeSet.get(infor[0])==null)
                    {
                        System.out.println("the file is illegal(cannot found the employee)");
                        System.exit(0);
                    }
                    insert(from,to,(L)employeeSet.get(infor[0]));
                }
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
