package main.com.employee.record.entity;
import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * empNo
     */
    private String empNo;

    /**
     * firstName
     */
    private String firstName;
    /**
     * lastName
     */
    private String lastName;

    /**
     * address
     */
    private String address;

    /**
     * Constructor
     * @param empNo
     */
    public Employee(String empNo) {
        this.empNo = empNo;
    }

    /**
     * Constructor
     * @param empNo
     * @param firstName
     * @param lastName
     * @param address
     */
    public Employee(String empNo,String firstName, String lastName, String address) {
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    /**
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return empNo
     */
    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
}
