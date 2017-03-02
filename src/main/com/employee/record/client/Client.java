package main.com.employee.record.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

import main.com.employee.record.entity.Employee;
import main.com.employee.record.server.EmployeeService;

public class Client {

    // Employee Service
    private static EmployeeService service;

    // Main Method
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        service = (EmployeeService) Naming.lookup("//localhost/EmployeeRecord");
        boolean findmore;
        do{
            String[] options = {"Show All Employees", "Find Employee Details By EmployeeID", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose the Service Which you want to Execute!", "Option dialog", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch(choice){
                case 0:
                    // getAllEmployees method call
                    List<Employee> list = service.getAllEmployees();
                    StringBuilder builder = new StringBuilder();
                    list.forEach(x -> builder.append(drawTable(x.getFirstName(),x.getLastName(),x.getAddress())));
                    JOptionPane.showConfirmDialog(null,"<html><table><tr><td>First Name</td>" +"<td>Last Name</td>" +"<td>Address</td>" +"</tr></table>" +builder,"Employee Record",JOptionPane.OK_CANCEL_OPTION);
                    break;
                case 1:
                    String empNo = JOptionPane.showInputDialog("Please Type Employee No");
                    try{
                        // findByEmpNo method call
                        Employee emp = service.findByEmpNo(new Employee(empNo));
                        JOptionPane.showMessageDialog(null, "First Name : " +emp.getFirstName() +"\n"+ "Last Name : " +emp.getLastName()  +"\n" + "Address : " +emp.getAddress(),"Employee Search Result", JOptionPane.INFORMATION_MESSAGE);
                    }catch(NoSuchElementException ex){
                        JOptionPane.showMessageDialog(null, "No Employee Associated with the Employee No "+empNo);
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
            findmore = (JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION);
        }while(findmore);
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param address
     * @return String
     */
    public static String drawTable(String firstName,String lastName,String address){
        final String str =
                "<html><table>" +
                        "<tr><td>"+firstName +"</td>&emsp&emsp&emsp"+
                        "<td>"+lastName +"</td>&emsp&emsp&emsp" +
                        "<td>"+address +"</td>&emsp&emsp&emsp" +
                        "</tr>"+
                        "</table>";
        return str;
    }
}