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
public class EmployeeProgrammer extends Employee {
    Random random = new Random();
    public EmployeeProgrammer(String firstName, String lastName, LocalDate dateOfBirth){
        super(firstName, lastName, dateOfBirth);
        departmentSalary = 2750;
        setBonus(bonus());
        setSalary(getBonus() + BASESALARY + departmentSalary);
        setDepartmentId(3);
    }
    
    @Override
    public double bonus(){
        int overtimeHours = random.nextInt(100);
        double max = BASEBONUS * 2.8;
        if((overtimeHours * 100) < max) return overtimeHours*100;
        return max;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }   
}
