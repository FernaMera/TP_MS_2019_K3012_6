public class NumeroComplejoBinomica {
    private double real;
    private double imaginario;
    
    public NumeroComplejoBinomica(double x, double y)
    {
        real = x;
        imaginario = y;
    }
    
    public String pasarAPolar()
    {
        double modulo = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginario, 2));
        double argumento = Math.atan(imaginario/real) / Math.PI;
        
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
        return "[" + String.format("%.2f", modulo) + ";" + argumento + "PI" + "]";
    }
}
