public class NumeroComplejoPolar {
    private double modulo;
    private double argumento;
    
    public NumeroComplejoPolar(double x, double y)
    {
        modulo = x;
        argumento = y;
    }
    
    public String pasarABinomio()
    {
        double real = modulo * Math.cos(argumento  * Math.PI);
        double imaginario = modulo * Math.sin(argumento  * Math.PI);
        
        DecimalFormat df = new DecimalFormat("0.00");
        
       
        
        System.out.println( "(" + df.format(real) + ";" +  df.format(imaginario) + ")");
        return "(" + df.format(real) + ";" + df.format(imaginario) + ")" ;
    }
}
