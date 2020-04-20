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
public class EmployeeAdmin extends Employee {
    Random random = new Random();
    
    public EmployeeAdmin(String firstName, String lastName, LocalDate dateOfBirth){
        super(firstName, lastName, dateOfBirth);
        departmentSalary = 4500 + 800*random.nextInt(5);
        setBonus(bonus());
        setSalary(getBonus() + BASESALARY + departmentSalary);
        setDepartmentId(4);
    }
    
    @Override
    public double bonus(){
        double min = BASEBONUS * 2;
        double max = BASEBONUS * 8;
        double calculatedBonus = getNumberOfEmployees() * 500;
        if(calculatedBonus < min) calculatedBonus = min;
        else if(calculatedBonus > max) calculatedBonus = max;
        
        return calculatedBonus;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }   
}