/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

/**
 *
 * @author alumno
 */
public class NumeroComplejoPolar {
    private double modulo;
    private double argumento;
    
    public NumeroComplejoPolar(double x, double y)
    {
        modulo = x;
        argumento = y;
    }
    
    public void pasarABinomio()
    {
        double real = modulo * Math.cos(argumento);
        double imaginario = modulo * Math.sin(argumento);
        
        System.out.println("(" + String.format("%.2f",real) + ";" + imaginario + ")");
    }
}
