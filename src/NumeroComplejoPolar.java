public class NumeroComplejoPolar extends NumeroComplejo implements NumeroComplejoInterfaz{
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

        String auxiliar = input.replace("PI", "");
        String numeroComplejo = auxiliar.replace(',', '.');

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
        double real = modulo * Math.cos(argumento * Math.PI);
        double imaginario = modulo * Math.sin(argumento * Math.PI);

        return mostrarResultado("(", real, imaginario, ")");
    }
    
    public String sumar(NumeroComplejoBinomica numeroComplejo){
        NumeroComplejoBinomica numeroConvertido = new NumeroComplejoBinomica(this.pasarABinomica());
        return numeroConvertido.sumar(numeroComplejo);
    }

    public String sumar(NumeroComplejoPolar numeroComplejo){
        NumeroComplejoBinomica convertido1=new NumeroComplejoBinomica(this.pasarABinomica());
        NumeroComplejoBinomica convertido2=new NumeroComplejoBinomica(numeroComplejo.pasarABinomica());
        return convertido1.sumar(convertido2);
    }
   
    public String restar(NumeroComplejoBinomica numeroComplejo){
        NumeroComplejoBinomica numeroConvertido = new NumeroComplejoBinomica(this.pasarABinomica());
        return numeroConvertido.restar(numeroComplejo);
    }

    public String restar(NumeroComplejoPolar numeroComplejo){
        NumeroComplejoBinomica convertido1=new NumeroComplejoBinomica(this.pasarABinomica());
        NumeroComplejoBinomica convertido2=new NumeroComplejoBinomica(numeroComplejo.pasarABinomica());
        return convertido1.restar(convertido2);
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
        if (numeroComplejo.modulo == 0)
            return null;
        double moduloD = modulo / numeroComplejo.modulo;
        double argumentoD = argumento - numeroComplejo.argumento;
         
        return mostrarResultado("[", moduloD, argumentoD, "PI]");
    }
    
    public String potenciar(int potencia) {
        double moduloPotenciado = Math.pow(modulo, potencia);
        double argumentoPotenciado = argumento*potencia;
        
    if(argumentoPotenciado >= 0 && argumentoPotenciado <= 2){
           return mostrarResultado("[", moduloPotenciado, argumentoPotenciado , "PI]");
       }
       else{
           while( argumentoPotenciado > 2 ){
               
               
                argumentoPotenciado = argumentoPotenciado - 2 ;
                
                if((argumentoPotenciado >=0 && argumentoPotenciado <=2)){
                    break;
                    
                }
           }
            return mostrarResultado("[", moduloPotenciado, argumentoPotenciado , "PI]");
       }    
         
    }
    
    public String raiz(int unNumero)
    {
        double modulo = Math.pow(this.modulo, ((double)1/(double)unNumero));
        double argumento;
        
        String resultado = "";
        for(int i = 0; i< unNumero; i++)
        {
            argumento = (this.argumento + 2 * i) / unNumero;

            if(esPrimitiva(unNumero, i)){
                resultado += "Primitiva:";
            }
            resultado += mostrarResultado("[", modulo, argumento, "PI]\n");
        }
        
        return resultado;
    }

    private boolean esPrimitiva(int raiz, int numero)
    {
        if(mcd(raiz, numero) == 1)
            return true;

        return false;
    }

    private int mcd(int num1,int num2)
    {
        if(num2==0)
            return num1;
        else
            return mcd(num2, num1 % num2);
    }
}
