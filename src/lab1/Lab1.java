/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.util.Scanner;
//import java.lang.String;

/**
 *
 * @author kalle
 */
public class Lab1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean fortsatt = true;
        
        do{
            System.out.print("Rätvinklig (t)riangel, (r)ektangel, eller (c)irkel? ");
            String resultat;
            String val = sc.nextLine();
            switch(val){
                case "t":
                case "T":
                    Triangel t = new Triangel();
                    System.out.print("Längd på sida a (katet): ");
                    t.setA(sc.nextDouble());
                    System.out.print("Längd på sida b (katet): ");
                    t.setB(sc.nextDouble());
                    System.out.print("Längd på sida c (hypotenusa): ");
                    t.setC(sc.nextDouble());
                    resultat = "En rätvinklig triangel med kateterna " +
                            t.getA() + " och " + t.getB() + " samt hypotenusan " +
                            t.getC();
                    System.out.print("Vill du beräkna (a)rea, (o)mkrets, eller (b)åde och? ");
                    sc.nextLine();
                    val = sc.nextLine();
                    resultat += areaOmkrets(val, t.area(), t.omkrets());
                    System.out.println(resultat);
                    break;
                    
                case "r":
                case "R":
                    Rektangel r = new Rektangel();
                    System.out.print("Längd på sida a (höjd): ");
                    r.setA(sc.nextDouble());
                    System.out.print("Längd på sida b (bredd): ");
                    r.setB(sc.nextDouble());
                    resultat = "En rektangel med sidorna " + r.getA() + 
                            " och " + r.getB();
                    System.out.print("Vill du beräkna (a)rea, (o)mkrets, eller (b)åde och? ");
                    sc.nextLine();
                    val = sc.nextLine();
                    resultat += areaOmkrets(val, r.area(), r.omkrets());
                    
                    System.out.println(resultat);
                    break;
                    
                case "c":
                case "C":
                    Cirkel c = new Cirkel();
                    System.out.print("Längd på cirkelns radie: ");
                    c.setRadie(sc.nextDouble());
                    resultat = "En cirkel med radien " + c.getRadie();
                    System.out.print("Vill du beräkna (a)rea, (o)mkrets, eller (b)åde och? ");
                    sc.nextLine();
                    val = sc.nextLine();
                    resultat += areaOmkrets(val, c.area(), c.omkrets());
                    
                    System.out.println(resultat);
                    break;
                
                default:
                    System.out.println("Något gick fel, försök igen!");
                    break;
            }
            System.out.println("Vill du göra en ny beräkning? (y/n)");
            val = sc.nextLine();
            if (!val.startsWith("y") && !val.startsWith("Y")){
                fortsatt = false;
            }
        }while(fortsatt);
    }
    public static String areaOmkrets(String val, double area, double omkrets){
        String resultat = "";
        if (val.startsWith("a") || val.startsWith("A") || 
                val.startsWith("b") || val.startsWith("B")){
            resultat += " har arean " + area;
        }
        if (val.startsWith("o") || val.startsWith("O") || 
                val.startsWith("b") || val.startsWith("B")){
            resultat += " och har omkretsen " + omkrets;
        }
        return resultat;
    }
    
}
