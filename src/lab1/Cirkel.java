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
public class Cirkel {
    
    private final double PI = 3.14;
    private double radie;
    
    public Cirkel (double radie){
        this.radie = radie;
    }
    
    public Cirkel(){
        
    }
    
    public double getRadie(){
        return radie;
    }
    
    public void setRadie(double radie){
        this.radie = radie;
    }
    
    public double area(){
        return radie*radie*PI;
    }
    
    public double omkrets(){
        return 2*PI*radie;
    }
    
}
