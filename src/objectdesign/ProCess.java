package objectdesign;

/**
 * store the information about process
 */
public class ProCess {
    private final String name;
    private final long PID;
    private final long shorttime;
    private final long longtime;

    /**
     * Constructor
     * @param name
     * @param PID
     * @param shorttime
     * @param longtime
     */
    public ProCess(String name,long PID,long shorttime,long longtime)
    {
        this.name=name;
        this.PID=PID;
        this.shorttime=shorttime;
        this.longtime=longtime;
    }

    /**
     * @return the name of a process
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return the PID of a process
     */
    public long getPID()
    {
        return this.PID;
    }

    /**
     * @return the shortest time of a process
     */
    public long getShorttime()
    {
        return this.shorttime;
    }

    /**
     * @return the longest time of a process
     */
    public long getLongtime()
    {
        return this.longtime;
    }

    /**
     * @return the diff between longtime and shorttime
     */
    public long getdiff()
    {
        return longtime-shorttime;
    }

    @Override
    public String toString() {
        return "name:"+this.name+" PID:"+this.PID+"  ";
    }
}