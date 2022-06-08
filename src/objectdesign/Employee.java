package objectdesign;

/**
 * store the information of employee
 */
public class Employee {
    private final String name;
    private final String duty;
    private final String phone;

    /**
     * Constructor,through three String param
     * @param name
     * @param duty
     * @param phone
     */
    public Employee(String name,String duty,String phone)
    {
        this.name=name;
        this.duty=duty;
        this.phone=phone;
    }

    /**
     * Constructor , through another employee
     * @param employee
     */
    public Employee(Employee employee)
    {
        name = this.getName();
        duty = this.getDuty();
        phone = this.getPhone();
    }

    /**
     * @return the name of a employee
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return the duty of a employee
     */
    public String getDuty()
    {
        return this.duty;
    }

    /**
     * @return the phone of a employee
     */
    public String getPhone()
    {
        return this.phone;
    }

}
