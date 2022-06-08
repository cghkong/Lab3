package objectdesign;

/**
 * the information about a course
 * the field is ID,name,teacher,position,hours
 * require hours is long type
 */
public class Course {
    private final String ID;
    private final String name;
    private final String teacher;
    private final String position;
    private final long hours;

    /**
     * require hours is an even (hours%2==0)
     */
    public void checkrep()
    {
        if((this.hours%2)!=0)
        {
            throw new RuntimeException("the hours is not standard");
        }
    }

    /**
     * Constructor
     * @param ID
     * @param name
     * @param teacher
     * @param position
     * @param hours
     */
    public Course(String ID, String name,String teacher,String position,long hours)
    {
        this.ID=ID;
        this.name=name;
        this.teacher=teacher;
        this.position=position;
        this.hours=hours;
        checkrep();
    }

    /**
     * @return the ID of a course
     */
    public String getID(){
        return this.ID;
    }

    /**
     * @return the teacher of a course
     */
    public String getTeacher()
    {
        return this.teacher;
    }

    /**
     * @return the position of position
     */
    public String getPosition()
    {
        return this.position;
    }

    /**
     * @return the hours of course
     */
    public long getHours()
    {
        return this.hours;
    }

    /**
     * @return the name of a course
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return the String of information about a course
     */
    @Override
    public String toString() {
        return "name:"+this.name+"  teacher:"+this.teacher+"  location:"+this.position;
    }
}
