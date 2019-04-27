public class NumeroComplejoPolar extends NumeroComplejo{
    private double modulo;
    private double argumento;
    
    public NumeroComplejoPolar(double x, double y)
    {
        modulo = x;
        argumento = y;
    }
    
    public String pasarABinomica()
    {
        double real = modulo * Math.cos(argumento  * Math.PI);
        double imaginario = modulo * Math.sin(argumento  * Math.PI);

        return mostrarResultado("(", real, imaginario, ")");
    }
}
