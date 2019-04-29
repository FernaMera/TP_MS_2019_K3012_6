public class NumeroComplejoPolar extends NumeroComplejo{
    private double modulo;
    private double argumento;
    
    public NumeroComplejoPolar(double x, double y)
    {
        modulo = x;
        argumento = y;
    }

    public NumeroComplejoPolar(String input)
    {
        int finalPrimerNumero = 0;
        int finalSegundoNumero = 0;

        String numeroComplejo = input.replace(',', '.');

        for(int i = 0; i < numeroComplejo.length(); i++)
            if (numeroComplejo.charAt(i) == ';')
                finalPrimerNumero = i;

        modulo = Double.parseDouble(numeroComplejo.substring(1, finalPrimerNumero));

        for(int i = finalPrimerNumero + 1; i < numeroComplejo.length(); i++)
            if(numeroComplejo.charAt(i) == ')' || numeroComplejo.charAt(i) == ']')
                finalSegundoNumero = i;

        argumento = Double.parseDouble(numeroComplejo.substring(finalPrimerNumero + 1, finalSegundoNumero));
    }
    
    public String pasarABinomica()
    {
        double real = modulo * Math.cos(argumento  * Math.PI);
        double imaginario = modulo * Math.sin(argumento  * Math.PI);

        return mostrarResultado("(", real, imaginario, ")");
    }
}
