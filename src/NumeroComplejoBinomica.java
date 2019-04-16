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

public class NumeroComplejoBinomica {
    private int real;
    private int imaginario;
    
    public NumeroComplejoBinomica(int x, int y)
    {
        real = x;
        imaginario = y;
    }
    
    public void pasarAPolar()
    {
        float modulo = (float)Math.sqrt(Math.pow(real, 2) + Math.pow(imaginario, 2));
        double argumento = (double)Math.atan(imaginario/real) / Math.PI;
        
        if(real < 0 && imaginario > 0)
        {
            //sumar PI
            argumento++;
        }
        if(real < 0 && imaginario < 0)
        {
            //sumar PI
            argumento++;
        }
        if(real > 0 && imaginario < 0)
        {
            //sumar 2PI
            argumento += 2;
        }
        
        
        System.out.println("[" + String.format("%.2f", modulo) + ";" + argumento + "PI" + "]");
    }
}
