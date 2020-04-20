/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeproject;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author kalle
 */
public class EmployeeManager {
    
    public static ArrayList<Employee> employeeList = new ArrayList<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    
    //This function must be updated if new departments are added
    public static void addEmployee(int departmentId, String firstName, String lastName, LocalDate dateOfBirth){
        switch(departmentId){
            case 1:
            {
                Employee e = new EmployeeJanitor(firstName, lastName, dateOfBirth);
                employeeList.add(e);
                refreshEmployeeSalary(4);
                break;
            }
            case 2:
            {
                Employee e = new EmployeeMaintenance(firstName, lastName, dateOfBirth);
                employeeList.add(e);
                refreshEmployeeSalary(4);
                break;
            }
            case 3:
            {
                Employee e = new EmployeeProgrammer(firstName, lastName, dateOfBirth);
                employeeList.add(e);
                refreshEmployeeSalary(4);
                break;
            }
            case 4:
            {
                Employee e = new EmployeeAdmin(firstName, lastName, dateOfBirth);
                employeeList.add(e);
                refreshEmployeeSalary(4);
                break;
            }
            default:
                break;
        }
    }
    
    public static void removeEmployeeById(int employeeId){
        for(Employee e: employeeList){
            if(e.getEmployeeId() == employeeId){
                employeeList.remove(e);
            }
        }
    }
    
    public static void removeEmployeeByName(String firstName, String lastName){
        for(Employee e: employeeList){
            if((e.getFirstName().equalsIgnoreCase(firstName)) && (e.getLastName().equalsIgnoreCase(lastName))){
                e.decreaseNumberOfEmployees();
                employeeList.remove(e);
            }
        }
    }
    
    public static void updateEmployeeNameById(int employeeId){
        for(Employee e: employeeList){
            if(e.getEmployeeId() == employeeId){
                EmployeeProject.sc.nextLine();
                System.out.println("Employee ID: " + e.getEmployeeId() + ". Name: " + e.getFirstName() + " " + e.getLastName());
                System.out.print("Enter new first name: ");
                String firstName = EmployeeProject.sc.nextLine();
                System.out.print("\nEnter new last name: ");
                String lastName = EmployeeProject.sc.nextLine();
                e.setFirstName(firstName);
                e.setLastName(lastName);
            }
        }
    }
    
    public static void updateEmployeeDateOfBirthById(int employeeId){
        for(Employee e: employeeList){
            if(e.getEmployeeId() == employeeId){
                EmployeeProject.sc.nextLine();
                System.out.println("Employee ID: " + e.getEmployeeId() + ". Name: " + e.getFirstName() + " " + e.getLastName());
                System.out.println("Date of birth: " + e.getDateOfBirth());
                System.out.print("Update date of birth (yyyy/MM/dd): ");
                String newDate = EmployeeProject.sc.nextLine();
                LocalDate newDateOfBirth = LocalDate.parse(newDate, formatter);
                e.setDateOfBirth(newDateOfBirth);
                System.out.print("\nNew date of birth: " + e.getDateOfBirth());
            }
        }
    }
    
    //NOTE: this function will not play nice if additional departments are added
    public static void updateEmployeeDepartmentById(int employeeId){
        for(Employee e: employeeList){
            if(e.getEmployeeId() == employeeId){
                System.out.println("Employee ID: " + e.getEmployeeId() + ". Name: " + e.getFirstName() + " " + e.getLastName());
                System.out.println("Department ID: " + e.getDepartmentId());
                System.out.print("Enter new Department ID (1-4): ");                //make the numbers dynamic if possible
                int newId = validDepartmentId();
                String firstName = e.getFirstName();
                String lastName = e.getLastName();
                LocalDate dateOfBirth = e.getDateOfBirth();
                addEmployee(newId, firstName, lastName, dateOfBirth);
                findEmployeeByFullNameAndDepartment(firstName, lastName, newId);    //output inconsistent with other EmployeeManager functions
                removeEmployeeById(employeeId);
            }
        }
    }
    
    public static int validDepartmentId(){                                      //could be moved to an enum
        int departmentId = EmployeeProject.sc.nextInt();
        while((departmentId != 1) && (departmentId != 2) && (departmentId != 3) && (departmentId != 4)){
            System.out.print("\nInvalid input, try again: ");
            departmentId = EmployeeProject.sc.nextInt();
        }
        return departmentId;
    }
    
    public static void updateEmployeeSalaryById(int employeeId){
        for(Employee e: employeeList){
            if(e.getEmployeeId() == employeeId){
                System.out.println("Employee ID: " + e.getEmployeeId() + ". Name: " + e.getFirstName() + " " + e.getLastName());
                System.out.println("Current salary: " + e.getSalary());
                System.out.print("Enter new salary: ");
                double newSalary = EmployeeProject.sc.nextDouble();
                e.setSalary(newSalary);
                System.out.print("\nNew salary: " + e.getSalary());
            }
        }
    }
    
    // primarily used to update EmployeeAdmin bonus when new employees are added
    public static void refreshEmployeeSalary(int departmentId){
        for(Employee e: employeeList){
            if(e.getDepartmentId() == departmentId){
                e.setBonus(e.bonus());
                e.setSalary(e.getBonus() + Employee.BASESALARY + e.departmentSalary);
            }
        }
    }
    
    public static void findEmployeeByFullNameAndDepartment(String firstName, String lastName, int departmentId){
        for(Employee e: employeeList){
            if((e.getFirstName().equalsIgnoreCase(firstName)) && (e.getLastName().equalsIgnoreCase(lastName)) && (e.getDepartmentId() == departmentId)){
                System.out.println(e);
            }
        }
    }
    
    public static void findEmployeeByFullName(String firstName, String lastName){
        for(Employee e: employeeList){
            if((e.getFirstName().equalsIgnoreCase(firstName)) && (e.getLastName().equalsIgnoreCase(lastName))){
                System.out.println(e);
            }
        }
    }
    
    public static void findEmployeeByFirstName(String firstName){
        for(Employee e: employeeList){
            if(e.getFirstName().equalsIgnoreCase(firstName)){
                System.out.println(e);
            }
        }
    }
    
    public static void findEmployeeByLastName(String lastName){
        for(Employee e: employeeList){
            if(e.getLastName().equalsIgnoreCase(lastName)){
                System.out.println(e);
            }
        }
    }
    
    public static void findEmployeeById(int employeeId){
        for(Employee e: employeeList){
            if(e.getEmployeeId() == employeeId){
                System.out.println(e);
            }
        }
    }
    
    //NOTE: does not check if the given number is valid (1-4)
    public static void findEmployeeByDepartment(int departmentId){
        for(Employee e: employeeList){
            if(e.getDepartmentId() == departmentId){
                System.out.println(e);
            }
        }
    }
    
    
    public static void printAll(){
        for(Employee e: employeeList){
            System.out.println(e);
        }
    }
    
    public static String getDepartmentName(int departmentId){
        switch(departmentId){
            case 1:
            {
                return "1 (Janitor)";
            }
            case 2:
            {
                return "2 (Maintenance/Network Technician)";
            }
            case 3:
            {
                return "3 (Programming/Development)";
            }
            case 4:
            {
                return "4 (Administration/Financial)";
            }
            default:
            {
                return departmentId + " (Error -- Invalid department)";
            }
        }
    }
}