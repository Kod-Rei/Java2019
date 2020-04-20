/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeproject;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 *
 * @author kalle
 */
public class EmployeeJanitor extends Employee {
    private long age;
    public EmployeeJanitor(String firstName, String lastName, LocalDate dateOfBirth){
        super(firstName, lastName, dateOfBirth);
        departmentSalary = 500;
        setBonus(bonus());
        setSalary(getBonus() + BASESALARY + departmentSalary);
        setDepartmentId(1);
    }
    
    @Override
    public double bonus(){
        age = YEARS.between(dateOfBirth, LocalDate.now());
        return BASEBONUS + age * 15;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
