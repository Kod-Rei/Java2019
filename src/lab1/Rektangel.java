/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author kalle
 */
public class Rektangel {
    
    private double a, b;
    
    public Rektangel(double a, double b){
        this.a = a;
        this.b = b;
    }
    
    public Rektangel(){
        
    }
    
    public double getA(){
        return a;
    }
    
    public void setA(double a){
        this.a = a;
    }
    
    public double getB(){
        return b;
    }
    
    public void setB(double b){
        this.b = b;
    }
    
    public double area(){
        return a*b;
    }
    
    public double omkrets(){
        return 2*a+2*b;
    }
}
