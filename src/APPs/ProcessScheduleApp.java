package APPs;

/**
 * the class is the process schedule App, you must follow the hint to inout your data
 * you should pay attention to your inpput if it is splited by ',' or blank
 * your input should be in console
 */
import FinalADT.ProcessIntervalSet;
import objectdesign.ProCess;

import java.util.Scanner;

public class ProcessScheduleApp {
    public static void main(String[] args) {
        ProcessIntervalSet<ProCess> processSchedule = new ProcessIntervalSet<>();

        System.out.println("input 1 is to add a group of processes");
        System.out.println("input 2 is to randomly execute");
        System.out.println("input 3 is to execute by shortruning priority");
        System.out.println("input 4 is to show the result");
        System.out.println("input 5 is to quit");
        while (true)
        {
            System.out.println("input your choice 1-5");
            Scanner input = new Scanner(System.in);
            int ch = input.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("input q to quit");
                    System.out.println("input(name,PID,Shorttime,longtime)");
                    while (true)
                    {
                        Scanner input1 = new Scanner(System.in);
                        String message = input1.nextLine();
                        String[] pmessage = message.split(",");
                        if(message.equals("q")) break;
                        if(pmessage.length!=4)
                        {
                            System.out.println("the wrong format");
                            continue;
                        }
                        long pid =Long.valueOf(pmessage[1]);
                        long st =Long.valueOf(pmessage[2]);
                        long lt =Long.valueOf(pmessage[3]);
                        ProCess proCess = new ProCess(pmessage[0],pid,st,lt);
                        processSchedule.addprocess(proCess,proCess.getLongtime(),proCess.getShorttime());
                    }
                    break;
                case 2:
                    processSchedule.randomexe();
                    break;
                case 3:
                    processSchedule.shortprocessexe();
                    break;
                case 4:
                    processSchedule.show();
                    break;
                case 5:break;
                default:break;
            }
            if(ch==5)
                break;
        }

    }

}
