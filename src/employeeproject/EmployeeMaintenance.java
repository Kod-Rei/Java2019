/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeproject;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author kalle
 */
public class EmployeeMaintenance extends Employee {
    Random random = new Random();
    public EmployeeMaintenance(String firstName, String lastName, LocalDate dateOfBirth){
        super(firstName, lastName, dateOfBirth);
        departmentSalary = 1500;
        setBonus(bonus());
        setSalary(getBonus() + BASESALARY + departmentSalary);
        setDepartmentId(2);
    }
    
    @Override
    public double bonus(){
        int numberOfNetworkFailures = random.nextInt(10);
        return (BASEBONUS * 2) - (numberOfNetworkFailures * 100);
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
