/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeproject;
import java.util.Scanner;
/**
 *
 * @author kalle
 */
public class EmployeeProject {
    
    static Scanner sc = new Scanner(System.in);
    static boolean loop = true;
    
    public static void main(String[] args) {
        
        while(loop){
            Menu.printMainMenu();
            Menu.manageMainMenu();
        }
    }
    
    public static void exit(){
        loop = false;
    }
}

