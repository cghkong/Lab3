package FinalADT;

import ImplementADT.DutyIntervel;
import objectdesign.Employee;

import java.time.LocalDate;

/**
 * the class is the final ADT for dutyIntervelSet,and delegate DutyIntervel to do
 * require frtime must be < totaldays
 * totaldays must be > 0
 * start must be before end
 * @param <L>
 */
public class DutyIntervalSet<L> {

    DutyIntervel<L> dutyRosterTimeExcel;
    private LocalDate start,end;

    public DutyIntervalSet(String fileReader)
    {
       dutyRosterTimeExcel= new DutyIntervel<L>(fileReader);
    }

    /**
     * constructor
     * @param start must before end
     * @param end must after start
     */
    public DutyIntervalSet(LocalDate start, LocalDate end)
    {
        dutyRosterTimeExcel = new DutyIntervel<L>(start,end);
    }

    /**
     * add employee to dutyRoster schedule
     * @param from is required before to
     * @param to is required after from
     * @param Label
     */
    public boolean addEmployee(LocalDate from,LocalDate to,L Label)
    {
        return dutyRosterTimeExcel.insert(from,to,Label);
    }

    /**
     * delete an employee
     * @param Label must be in DutyRoster schedule
     */
    public void deleteEmployee(L Label)
    {
        dutyRosterTimeExcel.remove(Label);
    }

    /**
     * to check if it is full and print the free time
     */
    public void checkfull()
    {
        dutyRosterTimeExcel.checkfull();
    }

    /**
     * to show the current schedule
     */
    public void showschedule()
    {
        dutyRosterTimeExcel.showschedule();
    }

}
