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
    
    
    
    public String sumar(NumeroComplejoBinomica numeroComplejo){
    
       NumeroComplejoBinomica numeroConvertido = new NumeroComplejoBinomica(this.pasarABinomica());
      return numeroConvertido.sumar(numeroComplejo);
    }
   
   public String restar(NumeroComplejoBinomica numeroComplejo){
       NumeroComplejoBinomica numeroConvertido = new NumeroComplejoBinomica(this.pasarABinomica());
       return numeroConvertido.restar(numeroComplejo);
       
   }
   
   public String multiplicar(NumeroComplejoBinomica numeroComplejo){
       NumeroComplejoBinomica numeroConvertido = new NumeroComplejoBinomica(this.pasarABinomica());
       return numeroConvertido.multiplicar(numeroComplejo);
   }
    
    
    
     public String multiplicar(NumeroComplejoPolar numeroComplejo){
       double moduloM = modulo * numeroComplejo.modulo;
       double argumentoM = argumento + numeroComplejo.argumento;
       
         return mostrarResultado("[", moduloM, argumentoM, "PI]");
         
    }
    
    public String dividir(NumeroComplejoBinomica numeroComplejo){
        NumeroComplejoBinomica numeroConvertido = new NumeroComplejoBinomica(this.pasarABinomica());
        return numeroConvertido.dividir(numeroComplejo);
    }
    
    
    public String dividir(NumeroComplejoPolar numeroComplejo){
       
        
     double moduloD = modulo / numeroComplejo.modulo;
     double argumentoD = argumento - numeroComplejo.argumento;    
         
     return mostrarResultado("[", moduloD, argumentoD, "PI]");
             
    
        
    }
    
    
}
