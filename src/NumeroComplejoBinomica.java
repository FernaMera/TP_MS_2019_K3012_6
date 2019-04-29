public class NumeroComplejoBinomica extends NumeroComplejo{
    private double real;
    private double imaginario;
    
    public NumeroComplejoBinomica(double x, double y)
    {
        real = x;
        imaginario = y;
    }

    public NumeroComplejoBinomica(String input)
    {
        int finalPrimerNumero = 0;
        int finalSegundoNumero = 0;

        String numeroComplejo = input.replace(',', '.');

        for(int i = 0; i < numeroComplejo.length(); i++)
            if (numeroComplejo.charAt(i) == ';')
                finalPrimerNumero = i;

        real = Double.parseDouble(numeroComplejo.substring(1, finalPrimerNumero));


        for(int i = finalPrimerNumero + 1; i < numeroComplejo.length(); i++)
            if(numeroComplejo.charAt(i) == ')' || numeroComplejo.charAt(i) == ']')
                finalSegundoNumero = i;

        imaginario = Double.parseDouble(numeroComplejo.substring(finalPrimerNumero + 1, finalSegundoNumero));
    }
    
    /* OPERACIONES BASICAS */ 
    
    
    public String sumar(NumeroComplejoBinomica numeroComplejo){
        double realSumado = real + numeroComplejo.real;
        double imaginarioSumado = imaginario + numeroComplejo.imaginario;

        return mostrarResultado("(", realSumado, imaginarioSumado, ")");
    }
     
     
    public String restar(NumeroComplejoBinomica numeroComplejo){
        double realSumado = real - numeroComplejo.real;
        double imaginarioSumado = imaginario - numeroComplejo.imaginario;

        return mostrarResultado("(", realSumado, imaginarioSumado, ")");
    }
    
    public String multiplicar(NumeroComplejoBinomica numeroComplejo){
        double realM = real * numeroComplejo.real -numeroComplejo.imaginario * imaginario;
        double imaginarioM = real*numeroComplejo.imaginario + numeroComplejo.real*imaginario;

        return mostrarResultado("(", realM, imaginarioM, ")");
    }

    public String dividir(NumeroComplejoBinomica numeroComplejo){
        //NumeroComplejoBinomica aux=this.conjugate();
        double divisor=Math.pow(numeroComplejo.imaginario, 2)+Math.pow(numeroComplejo.real, 2); 
        double  realD = (float) (real * numeroComplejo.real +numeroComplejo.imaginario * imaginario)/divisor;
        double imaginarioD = (float) -1*(real*numeroComplejo.imaginario - numeroComplejo.real*imaginario)/divisor;

        return mostrarResultado("(", realD, imaginarioD, ")");
    }
    
    /* VERR-ANALIZAR
       public NumeroComplejoBinomica conjugate()
       {
           double imaginarioAux= (imaginario*-1);
           
           return new NumeroComplejoBinomica(real, imaginarioAux);
       }
    
    */
    
    public String pasarAPolar()
    {
        double modulo = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginario, 2));
        double argumento = Math.atan(imaginario/real) / Math.PI;
        
        if(real == 0 && imaginario > 0){
            argumento = 0.5;
        }
        
        if(real == 0 && imaginario < 0 ){
            argumento = 0.75;
        }
        
        if(real < 0 && imaginario == 0){
            argumento = 1;
        }

        if(real == 0 && imaginario == 0){
            argumento = 0;
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

        return mostrarResultado("[", modulo, argumento, "PI]");
    }
}
