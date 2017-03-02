package test.com.employee.record.test;



import main.com.employee.record.entity.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    public void testCaseOne() {
        Employee employee=new Employee(null);
        employee.setEmpNo("101");
        employee.setFirstName("Vinay");
        employee.setLastName("T");
        employee.setAddress("Nagpur");
        assertEquals( "Result", employee.getEmpNo(),"101");
    }

    @Test
    public void testCaseTwo() {
        Employee employee=new Employee(null);
        employee.setEmpNo("102");
        employee.setFirstName("Sharad");
        employee.setLastName("B");
        employee.setAddress("Sangli");
        assertEquals("Result",employee.getFirstName(),"Sharad");
    }

    @Test
    public void testCaseThree() {
        Employee employee=new Employee(null);
        employee.setEmpNo("103");
        employee.setFirstName("Dhaval");
        employee.setLastName("D");
        employee.setAddress("Pune");
        assertEquals("Result",employee.getLastName(),"D");
    }


}
