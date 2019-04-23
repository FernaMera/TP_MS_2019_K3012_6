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
        
        
        
        if(real == 0 && imaginario >= 1){
            argumento = 0.5;
        }
        
        if(real == 0 && imaginario <= -1){
            argumento = 0.75;
        }
        
        if(real < 0 && imaginario == 0){
            argumento = 1;
        }
        
        
        //2do Cuadrante
        if(real < 0 && imaginario > 0)
        {
            //sumar PI
            argumento++;
        }
        
        // 3er Cuadrante
        if(real < 0 && imaginario < 0)
        {
            //sumar PI
            argumento++;
        }
        
        //4to Cuadrante
        if(real > 0 && imaginario < 0)
        {
            //sumar 2PI
            argumento += 2;
        }
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        System.out.println("[" + df.format(modulo) + ";" + df.format(argumento) + "PI" + "]");
        return "[" + df.format(modulo) + ";" +df.format (argumento) + "PI" + "]" ;
    }
}
