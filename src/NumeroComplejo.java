import java.text.DecimalFormat;

public abstract class NumeroComplejo
{
    public String mostrarResultado(String abrirPar, double a, double b, String cerrarPar)
    {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println( abrirPar + df.format(a) + ";" +  df.format(b) + cerrarPar);
        return abrirPar + df.format(a) + ";" + df.format(b) + cerrarPar ;
    }
}
