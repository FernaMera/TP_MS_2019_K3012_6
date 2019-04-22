public class Main
{
    public static void main(String[] args)
    {
        //Para Probar:
        NumeroComplejoBinomica unNumero = new NumeroComplejoBinomica(4, 5);

        unNumero.pasarAPolar();
        
        
        // Pruebas 
        
        // 1er cuadrante
        
        NumeroComplejoBinomica numero1 = new NumeroComplejoBinomica(1,1);
        
        
        NumeroComplejoPolar numero2 = new NumeroComplejoPolar(1.41,0.25);
        
       numero1.pasarAPolar();
      
       
      numero2.pasarABinomica();

      
      System.out.println("*************************************************");
      
      // 1er Cuadrante 
      
       NumeroComplejoBinomica numero3 = new NumeroComplejoBinomica(1.73,1);
       NumeroComplejoPolar numero4 = new NumeroComplejoPolar(2,0.17);
       
       
       numero3.pasarAPolar();
       numero4.pasarABinomica();
       
       
       
       System.out.println("*************************************************");
       
       
       
       // 3er cuadrante
        NumeroComplejoBinomica numero5 = new NumeroComplejoBinomica(-2,-3.46);
        NumeroComplejoPolar numero6 = new NumeroComplejoPolar(4, 1.33);
        
        numero5.pasarAPolar();
        numero6.pasarABinomica();
        
        
        
        System.out.println("*************************************************");
        
         NumeroComplejoBinomica numero7 = new NumeroComplejoBinomica(0,-1);
         
         numero7.pasarAPolar();
         
         
         System.out.println("*************************************************");
         
         NumeroComplejoBinomica numero8 = new NumeroComplejoBinomica(0,1);
         
         numero8.pasarAPolar();
         
         
      
      
        
        
    }
}
