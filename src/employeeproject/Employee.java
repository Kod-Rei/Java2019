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
public abstract class Employee {
    private String firstName, lastName;
    protected LocalDate dateOfBirth;
    private double salary, bonus;
    private static int numberOfEmployees = 0;
    private int employeeId, departmentId;
    
    abstract public double bonus();
    public final static double BASESALARY = 24000;
    public final static double BASEBONUS = 2000;
    protected double departmentSalary;
    
    public Employee(String firstName, String lastName, LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        employeeId = ++numberOfEmployees;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }
    
    public void decreaseNumberOfEmployees() {
        numberOfEmployees--;
    }

    public int getDepartmentId() {
        return departmentId;
    }
    
    public void setDepartmentId(int departmentId){
        this.departmentId = departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public long getAge(LocalDate dateOfBirth){
        //LocalDate now = LocalDate.now();
        return YEARS.between(dateOfBirth, LocalDate.now());
    }
    
    

    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", departmentSalary=" + departmentSalary + ", bonus=" + bonus + ", salary=" + salary + ", employeeId=" + employeeId + ", departmentId=" + departmentId + '}';
    }
}
