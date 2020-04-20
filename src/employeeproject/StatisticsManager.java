/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeproject;
import java.util.ArrayList;
/**
 *
 * @author kalle
 */
public class StatisticsManager {
    
    public static double avgSalary(ArrayList<Employee> employeeList){
        double salary = 0;
        for(Employee e: employeeList){
            salary += e.getSalary();
        }
        if(!employeeList.isEmpty()){
            return salary/(double)employeeList.size();
        }
        return 0;
    }
    
    public static double avgSalaryByDepartment(ArrayList<Employee> employeeList, int departmentId){
        double salary = 0; 
        double employees = 0;
        for(Employee e: employeeList){
            if(e.getDepartmentId() == departmentId){
                salary += e.getSalary();
                employees++;
            }
        }
        if(employees != 0){
            return salary/employees;
        }
        return 0;
    }
    
    public static void avgSalaryAllDepartments(ArrayList<Employee> employeeList){
        for(int i = 1; i <= 4; i++){
            System.out.print("\nAverage salary in department " + EmployeeManager.getDepartmentName(i) +
                    ": " + avgSalaryByDepartment(employeeList, i));
        }
    }
    
    public static void avgSalaryByAge(ArrayList<Employee> employeeList){
        double salary1 = 0, salary2 = 0, salary3 = 0, salary4 = 0;
        double ageGroup1 = 0, ageGroup2 = 0, ageGroup3 = 0, ageGroup4 = 0;
        for(Employee e: employeeList){
            if(e.getAge(e.getDateOfBirth()) < 30){
                salary1 += e.getSalary();
                ageGroup1++;
            }
            else if((e.getAge(e.getDateOfBirth()) >= 30) && (e.getAge(e.getDateOfBirth()) < 40)){
                salary2 += e.getSalary();
                ageGroup2++;
            }
            else if((e.getAge(e.getDateOfBirth()) >= 40) && (e.getAge(e.getDateOfBirth()) < 50)){
                salary3 += e.getSalary();
                ageGroup3++;
            }
            else if((e.getAge(e.getDateOfBirth()) >= 50)){
                salary4 += e.getSalary();
                ageGroup4++;
            }
        }
        if(ageGroup1 != 0){
            System.out.print("\nAverage salary (age 18-29): " + salary1/ageGroup1);
        }
        if(ageGroup2 != 0){
            System.out.print("\nAverage salary (age 30-39): " + salary2/ageGroup2);
        }
        if(ageGroup3 != 0){
            System.out.print("\nAverage salary (age 40-49): " + salary3/ageGroup3);
        }
        if(ageGroup4 != 0){
            System.out.print("\nAverage salary (age 50+): " + salary4/ageGroup4);
        }
    }
    
    public static void salaryMinMax(ArrayList<Employee> employeeList){
        Employee min = employeeList.get(0);
        Employee max = employeeList.get(0);
        for(Employee e: employeeList){
            if(e.getSalary() < min.getSalary()) min = e;
            if(e.getSalary() > max.getSalary()) max = e;
        }
        System.out.print("\nLowest salary: " + min.toString());
        System.out.print("\nHighest salary: " + max.toString());
    }
    
    public static double avgBonus(ArrayList<Employee> employeeList){
        double bonusSum = 0;
        for(Employee e: employeeList){
            bonusSum += e.getBonus();
        }
        if(!employeeList.isEmpty()){
            return bonusSum/(double)employeeList.size();
        }
        return 0;
    }
    
    public static double avgBonusByDepartment(ArrayList<Employee> employeeList, int departmentId){
        double bonusSum = 0;
        double employees = 0;
        for(Employee e: employeeList){
            if(e.getDepartmentId() == departmentId){
                bonusSum += e.getBonus();
                employees++;
            }
        }
        if(employees != 0){
            return bonusSum/employees;
        }
        return 0;
    }
    
    public static void avgBonusAllDepartments(ArrayList<Employee> employeeList){
        for(int i = 1; i <= 4; i++){
            System.out.print("\nAverage bonus in department " + EmployeeManager.getDepartmentName(i) +
                    ": " + avgBonusByDepartment(employeeList, i));
        }
    }
    
    public static double avgAge(ArrayList<Employee> employeeList){
        double ageSum = 0;
        for(Employee e: employeeList){
            ageSum += (double)e.getAge(e.getDateOfBirth());
        }
        if(!employeeList.isEmpty()){
            return ageSum/(double)employeeList.size();
        }
        return 0;
    }
    
    public static double avgAgeByDepartment(ArrayList<Employee> employeeList, int departmentId){
        double ageSum = 0;
        double employees = 0;
        for(Employee e: employeeList){
            if(e.getDepartmentId() == departmentId){
                ageSum += (double)e.getAge(e.getDateOfBirth());
                employees++;
            }
        }
        if(employees != 0){
            return ageSum/employees;
        }
        return 0;
    }
    
    public static void avgAgeAllDepartments(ArrayList<Employee> employeeList){
        for(int i = 1; i <= 4; i++){
            System.out.print("\nAverage age in department " + EmployeeManager.getDepartmentName(i) +
                    ": " + avgAgeByDepartment(employeeList, i));
        }
    }   
}
