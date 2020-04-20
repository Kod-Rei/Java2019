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
public class Triangel {
    
    private double a, b, c;
    
    public Triangel(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public Triangel(){
    
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
    
    public double getC(){
        return c;
    }
    
    public void setC(double c){
        this.c = c;
    }
    
    public double area(){
        return a*b/2; //OBS endast korrekt för rätvinkliga trianglar
    }
    
    public double omkrets(){
        return a+b+c;
    }
    
    
    
    
}
