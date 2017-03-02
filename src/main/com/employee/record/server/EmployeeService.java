package main.com.employee.record.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import main.com.employee.record.entity.Employee;

public interface EmployeeService extends Remote {
     /**
      *
      * @param empNo
      * @return Employee
      * @throws RemoteException
      */
     Employee findByEmpNo(Employee empNo) throws RemoteException;

    /**
     *
     * @return Employees
     * @throws RemoteException
     */
     List<Employee> getAllEmployees() throws RemoteException;
}
