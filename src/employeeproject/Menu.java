/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeproject;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author kalle
 */
public class Menu {
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    
    public static void printMainMenu(){
        System.out.println("MAIN MENU");
        System.out.println("1. Employee Management");
        System.out.println("2. Statistics");
        System.out.println("3. Exit");
        //System.out.println("7. Top Secret Testing menu");
    }
    
    public static void manageMainMenu(){
        int choice = sc.nextInt();
        switch(choice){
            case 1:
            {
                sc.nextLine();
                manageEmployeeManagementMenu();
                break;
            }
            case 2:
            {
                sc.nextLine();
                manageStatisticsMenu();
                break;
            }
            case 3:
            {
                sc.nextLine();
                EmployeeProject.exit();
                break;
            }
            case 7:
            {
                sc.nextLine();
                manageTestMenu();
                break;
            }
            default:
                System.out.println("\nSomething went wrong.");
                break;
        }
    }
    
    public static void printEmployeeManagementMenu(){
        System.out.println("\nEMPLOYEE MANAGEMENT");
        System.out.println("1. Add employee");
        System.out.println("2. Remove employee");
        System.out.println("3. Update employee name");
        System.out.println("4. Update employee date of birth");
        System.out.println("5. Update employee department");
        System.out.println("6. Update employee salary");
        System.out.println("7. Search for employee (opens submenu)");
        System.out.println("8. Print employees by department");
        System.out.println("9. Print all employees");
        System.out.println("0. Return to main menu");
    }
    
    public static void manageEmployeeManagementMenu(){
        boolean stay = true;
        while(stay){
            printEmployeeManagementMenu();
            int choice = sc.nextInt();
            switch(choice){
                case 1://Add Employee
                {
                    System.out.print("\nInput department ID (1=Janitor, 2=Maintenance/Tech Support, 3=Programming/Development, 4=Admin/Financial): ");
                    int departmentId = EmployeeManager.validDepartmentId();
                    sc.nextLine();
                    System.out.print("Input first name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Input last name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Input date of birth (yyyy/MM/dd): ");
                    String dateOfBirthString = sc.nextLine();
                    LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString, formatter);
                    EmployeeManager.addEmployee(departmentId, firstName, lastName, dateOfBirth);
                    pressEnter();
                    break;
                }
                case 2://Remove Employee
                {
                    System.out.print("\n1. Remove by name.");
                    System.out.print("\n2. Remove by ID.");
                    int subChoice1 = sc.nextInt();
                    if(subChoice1 == 1){
                        sc.nextLine();
                        System.out.print("Input first name: ");
                        String firstName = sc.nextLine();
                        System.out.print("Input last name: ");
                        String lastName = sc.nextLine();
                        EmployeeManager.findEmployeeByFullName(firstName, lastName);
                        EmployeeManager.removeEmployeeByName(firstName, lastName);
                        System.out.print("\nEmployee removed.");
                    }
                    else if(subChoice1 == 2){
                        System.out.print("Input Employee ID: ");
                        int employeeId = sc.nextInt();
                        EmployeeManager.findEmployeeById(employeeId);
                        EmployeeManager.removeEmployeeById(employeeId);
                        System.out.print("\nEmployee removed.");
                        sc.nextLine();
                    }
                    else{
                        System.out.print("\nInvalid input.");
                    }
                    pressEnter();
                    break;
                }
                case 3://Update employee name
                {
                    System.out.print("Input employee ID: ");
                    int employeeId = sc.nextInt();
                    EmployeeManager.updateEmployeeNameById(employeeId);
                    System.out.print("\nName updated.");
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 4://Update employee date of birth
                {
                    System.out.print("Input employee ID: ");
                    int employeeId = sc.nextInt();
                    EmployeeManager.updateEmployeeDateOfBirthById(employeeId);
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 5://Update employee department
                {
                    System.out.print("Input employee ID: ");
                    int employeeId = sc.nextInt();
                    EmployeeManager.updateEmployeeDepartmentById(employeeId);
                    System.out.print("\nDepartment updated.");
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 6://Update employee salary
                {
                    System.out.print("Input employee ID: ");
                    int employeeId = sc.nextInt();
                    EmployeeManager.updateEmployeeSalaryById(employeeId);
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 7://Search for employee via submenu
                {
                    sc.nextLine();
                    manageEmployeeSearchMenu();
                    break;
                }
                case 8://Print employees by department
                {
                    System.out.print("Input department ID (1=Janitor, 2=Maintenance/Tech Support, 3=Programming/Development, 4=Admin/Financial): ");
                    int departmentId = EmployeeManager.validDepartmentId();
                    EmployeeManager.findEmployeeByDepartment(departmentId);
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 9://Print all employees
                {
                    EmployeeManager.printAll();
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 0://Return to main menu
                {
                    sc.nextLine();
                    stay = false;
                    break;
                }
                default://Print error message and return to main menu
                {
                    System.out.print("\nInvalid input.");
                    stay = false;
                    break;
                }
            }
        }
    }
    
    public static void printEmployeeSearchMenu(){
        System.out.println("\nEMPLOYEE SEARCH MENU");
        System.out.println("1. Search for employee by Employee ID");
        System.out.println("2. Search for employee by first name");
        System.out.println("3. Search for employee by last name");
        System.out.println("4. Search for employee by full name");
        System.out.println("0. Return to Employee Management Menu");
    }
    
    public static void manageEmployeeSearchMenu(){
        boolean stay = true;
        while(stay){
            printEmployeeSearchMenu();
            int choice = sc.nextInt();
            switch(choice){
                case 1://search by ID
                {
                    System.out.print("Input employee ID: ");
                    int employeeId = sc.nextInt();
                    EmployeeManager.findEmployeeById(employeeId);
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 2://search by first name
                {
                    sc.nextLine();
                    System.out.print("Input first name: ");
                    String firstName = sc.nextLine();
                    EmployeeManager.findEmployeeByFirstName(firstName);
                    pressEnter();
                    break;
                }
                case 3://search by last name
                {
                    sc.nextLine();
                    System.out.print("Input last name: ");
                    String lastName = sc.nextLine();
                    EmployeeManager.findEmployeeByLastName(lastName);
                    pressEnter();
                    break;
                }
                case 4://search by full name
                {
                    sc.nextLine();
                    System.out.print("Input first name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Input last name: ");
                    String lastName = sc.nextLine();
                    EmployeeManager.findEmployeeByFullName(firstName, lastName);
                    pressEnter();
                    break;
                }
                case 0:
                {
                    sc.nextLine();
                    stay = false;
                    break;
                }
                default:
                {
                    System.out.print("\nInvalid input.");
                    stay = false;
                    break;
                }
            }
        }
    }
    
    public static void printStatisticsMenu(){
        System.out.println("\nEMPLOYEE STATISTICS");
        System.out.println("1. Average monthly salary");
        System.out.println("2. Average monthly salary (per department)");
        System.out.println("3. Average monthly salary (per age group)");
        System.out.println("4. Highest and lowest monthly salary");
        System.out.println("5. Average monthly bonus");
        System.out.println("6. Average monthly bonus (per department)");
        System.out.println("7. Average age");
        System.out.println("8. Average age (per department)");
        System.out.println("0. Return to main menu");
    }
    
    public static void manageStatisticsMenu(){
        boolean stay = true;
        while(stay){
            printStatisticsMenu();
            int choice = sc.nextInt();
            switch(choice){
                case 1://average monthly salary
                {
                    System.out.print("\nAverage monthly salary: " + StatisticsManager.avgSalary(EmployeeManager.employeeList));
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 2://average monthly salary by dept
                {
                    StatisticsManager.avgSalaryAllDepartments(EmployeeManager.employeeList);
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 3://avg monthly salary by age
                {
                    StatisticsManager.avgSalaryByAge(EmployeeManager.employeeList);
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 4://min and max salary
                {
                    StatisticsManager.salaryMinMax(EmployeeManager.employeeList);
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 5://avg bonus
                {
                    System.out.print("\nAverage monthly bonus: " + StatisticsManager.avgBonus(EmployeeManager.employeeList));
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 6://avg bonus per dept
                {
                    StatisticsManager.avgBonusAllDepartments(EmployeeManager.employeeList);
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 7://avg age
                {
                    System.out.print("\nAverage age: " + StatisticsManager.avgAge(EmployeeManager.employeeList));
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 8://avg age per dept
                {
                    StatisticsManager.avgAgeAllDepartments(EmployeeManager.employeeList);
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 0:
                {
                    sc.nextLine();
                    stay = false;
                    break;
                }
                default:
                {
                    System.out.print("\nInvalid input.");
                    pressEnter();
                    stay = false;
                    break;
                }
            }
        }
        
    }
    
    public static void printTestMenu(){
        System.out.println("\nTESTING/DEBUGGING MENU");
        System.out.println("1. Refresh bonus calculations for all departments");
        System.out.println("2. Add example employees");
        System.out.println("0. Return to main menu");
    }
    
    public static void manageTestMenu(){
        boolean stay = true;
        while(stay){
            printTestMenu();
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                {
                    EmployeeManager.refreshEmployeeSalary(1);
                    EmployeeManager.refreshEmployeeSalary(2);
                    EmployeeManager.refreshEmployeeSalary(3);
                    EmployeeManager.refreshEmployeeSalary(4);
                    System.out.print("\nBonus/Salary calculations updated.");
                    sc.nextLine();
                    pressEnter();
                    break;
                }
                case 2:
                {
                    LocalDate dateOfBirth = LocalDate.parse("1990/01/01", formatter);
                    EmployeeManager.addEmployee(1, "Janitor", "McJanitor", dateOfBirth);
                    dateOfBirth = LocalDate.parse("1980/01/01", formatter);
                    EmployeeManager.addEmployee(2, "Tech", "Support", dateOfBirth);
                    dateOfBirth = LocalDate.parse("1970/01/01", formatter);
                    EmployeeManager.addEmployee(3, "Senior", "Developer", dateOfBirth);
                    dateOfBirth = LocalDate.parse("1960/01/01", formatter);
                    EmployeeManager.addEmployee(4, "Section", "Chief", dateOfBirth);
                    dateOfBirth = LocalDate.parse("1960/01/01", formatter);
                    EmployeeManager.addEmployee(1, "Older", "McJanitor", dateOfBirth);
                    dateOfBirth = LocalDate.parse("2000/01/01", formatter);
                    EmployeeManager.addEmployee(2, "Tech-Support", "Young", dateOfBirth);
                    dateOfBirth = LocalDate.parse("2001/01/01", formatter);
                    EmployeeManager.addEmployee(3, "Junior Developer", "the Young", dateOfBirth);
                    dateOfBirth = LocalDate.parse("1975/01/01", formatter);
                    EmployeeManager.addEmployee(4, "Admin", "Person", dateOfBirth);
                    System.out.print("\n8 Employees added.");
                    sc.nextLine();
                    pressEnter();
                    break;
                    
                }
                case 0:
                {
                    sc.nextLine();
                    stay = false;
                    break;
                }
                default:
                {
                    System.out.print("\nInvalid input.");
                    stay = false;
                    break;
                }
            }
        }
    }
    public static void pressEnter(){
        System.out.print("\nPress Enter to continue...");
        String temp = sc.nextLine();
    }
}
