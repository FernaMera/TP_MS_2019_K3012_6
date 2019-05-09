public class Main 
{
    public static void main(String[] args)
    {
        //TODO : PASAR A CORRESPONDIENTES TESTS
        //Para Probar:
        NumeroComplejoBinomica unNumero = new NumeroComplejoBinomica(1, 1);
        NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(3, 4);


        unNumero.pasarAPolar();
        
        
        // Pruebas :
        
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
         
         
      // Pruebas con Operaciones
        
        otroNumero.sumar(unNumero);
        otroNumero.restar(unNumero);
        otroNumero.multiplicar(unNumero);
        otroNumero.dividir(unNumero);
      
        //
      
        //Pruebas con clase NumeroComplejoPolar
        
        System.out.println("****************************");
        
        NumeroComplejoPolar numeroD1 = new NumeroComplejoPolar(2,0.33);
        
         NumeroComplejoPolar numeroD2 = new NumeroComplejoPolar(5,0.2);
         
         numeroD1.multiplicar(numeroD2);
         
         System.out.println("****************************");
         
         numeroD1.dividir(numeroD2);
 
        
        
    }
}
