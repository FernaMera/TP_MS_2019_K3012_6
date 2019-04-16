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
        double real = modulo * Math.cos(argumento);
        double imaginario = modulo * Math.sin(argumento);
        
        System.out.println("(" + String.format("%.2f",real) + ";" + imaginario + ")");
        return "(" + String.format("%.2f",real) + ";" + imaginario + ")";
    }
}
