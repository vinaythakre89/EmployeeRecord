package main.com.employee.record.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import main.com.employee.record.entity.Employee;

public class EmployeeServiceImpl extends UnicastRemoteObject implements EmployeeService {

    private static final long serialVersionUID = 1L;

    private List<Employee> employeeList;

    public EmployeeServiceImpl(List<Employee> list) throws RemoteException {
        super();
        this.employeeList = list;
    }

    /**
     * @param empNo
     * @return Employee
     * @throws RemoteException
     */
    public Employee findByEmpNo(Employee empNo) throws RemoteException {
        Predicate<Employee> emp = x-> x.getEmpNo().equals(empNo.getEmpNo());
        return employeeList.stream().filter(emp).findFirst().get();
    }

    /**
     * @return Employees
     * @throws RemoteException
     */
    public List<Employee> getAllEmployees() throws RemoteException {
        return employeeList;
    }

    // Setting data into Employee List
    private static List<Employee> initializeEmpList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("101","Hiro","Jiro","Shibuya"));
        list.add(new Employee("102","Tana","Hiro","Shinjuku"));
        list.add(new Employee("103","Sato","Abe","Shinjuku"));
        list.add(new Employee("104","Aio","Hiro","Idabashi"));
        list.add(new Employee("105","Aya","Jiro","Ikebukuro"));
        list.add(new Employee("106","Yuka","Kuga","Komagome"));
        list.add(new Employee("107","Saki","Tojo","Akihabara"));
        list.add(new Employee("108","Moto","Dai","Minato"));
        list.add(new Employee("109","Kamo","Kate","Akasaka"));
        list.add(new Employee("109","Ando","Abe","Heiwadai"));
        return list;
    }

    // Main Method
    public static void main(String[] args){
        try {
            Naming.rebind("//localhost/EmployeeRecord", new EmployeeServiceImpl(initializeEmpList()));
            System.err.println("Server Started");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }
}
