import java.text.DecimalFormat;

public abstract class NumeroComplejo
{
    public String mostrarResultado(String abrirPar, double a, double b, String cerrarPar)
    {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println( abrirPar + df.format(a) + ";" +  df.format(b) + cerrarPar);
        return abrirPar + df.format(a) + ";" + df.format(b) + cerrarPar ;
    }
    // para poder mostrar los fasores
     public String mostrarResultado(double amplitud, String funcion ,double frecuencia ,double fase ,String numeroPi  ){
        
        DecimalFormat d = new DecimalFormat("0.00");
         System.out.println( d.format(amplitud) + " " + funcion + "(" + d.format(frecuencia) +"t" + d.format(fase) + numeroPi + ")");
        return d.format(amplitud) + funcion + "(" + d.format(frecuencia) + "t"  + d.format(fase) +numeroPi + ")" ;
    }
}
