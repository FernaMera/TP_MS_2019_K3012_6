import java.text.DecimalFormat;

public class NumeroComplejoBinomica {
    private double real;
    private double imaginario;
    
    public NumeroComplejoBinomica(double x, double y)
    {
        real = x;
        imaginario = y;
    }
    
    /* OPERACIONES BASICAS */ 
    
    
     public String sumar(NumeroComplejoBinomica numeroComplejo){
      float  realSumado = (float) (real + numeroComplejo.real);
        float imaginarioSumado = (float) (imaginario + numeroComplejo.imaginario);

        
        DecimalFormat df = new DecimalFormat("0.00");
        
         System.out.println( "(" + df.format(realSumado) + ";" +  df.format(imaginarioSumado) + ")");
        return "(" + df.format(realSumado) + ";" + df.format(imaginarioSumado) + ")" ;
    }
     
     
      public String restar(NumeroComplejoBinomica numeroComplejo){
      float  realSumado = (float) (real - numeroComplejo.real);
        float imaginarioSumado = (float) (imaginario - numeroComplejo.imaginario);

        
        DecimalFormat df = new DecimalFormat("0.00");
        
         System.out.println( "(" + df.format(realSumado) + ";" +  df.format(imaginarioSumado) + ")");
        return "(" + df.format(realSumado) + ";" + df.format(imaginarioSumado) + ")" ;
    }
    
     public String multiplicar(NumeroComplejoBinomica numeroComplejo){
      float  realM = (float) (real * numeroComplejo.real -numeroComplejo.imaginario * imaginario);
        float imaginarioM = (float) (real*numeroComplejo.imaginario + numeroComplejo.real*imaginario);

        
        DecimalFormat df = new DecimalFormat("0.00");
        
         System.out.println( "(" + df.format(realM) + ";" +  df.format(imaginarioM) + ")");
        return "(" + df.format(realM) + ";" + df.format(imaginarioM) + ")" ;
    }
        public String dividir(NumeroComplejoBinomica numeroComplejo){
            
        //NumeroComplejoBinomica aux=this.conjugate();
        double divisor=Math.pow(numeroComplejo.imaginario, 2)+Math.pow(numeroComplejo.real, 2); 
        double  realD = (float) (real * numeroComplejo.real +numeroComplejo.imaginario * imaginario)/divisor;
        double imaginarioD = (float) -1*(real*numeroComplejo.imaginario - numeroComplejo.real*imaginario)/divisor;
        
        DecimalFormat df = new DecimalFormat("0.00");
        
         System.out.println( "(" + df.format(realD) + ";" +  df.format(imaginarioD) + ")");
        return "(" + df.format(realD) + ";" + df.format(imaginarioD) + ")" ;
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
