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
 
        
        /* ------------------- PRUEBAS CON FASORES---------------------- */
        
        Fasor fasor1 = new Fasor(5,"COS", 3, (1.0/3.0));
        Fasor fasor2 = new Fasor(3,"COS", 3 , (-1.0/5.0));
        
        fasor1.sumar(fasor2);
        
        //Respuesta esperada : 5,56 COS(3,00t + 0,15PI)
        
        System.out.println("************************************+");
        
       /*   MISMO EJERCICIOOOOO!! Variando con sen y cos
        
        */
       
       
       Fasor fasor3 = new Fasor(2,"COS", 4,0);
        Fasor fasor4 = new Fasor(4,"COS", 4 , (-1.0/2.0));
        
        fasor3.sumar(fasor4);
        
        // Respuesta esperada : 4,47 COS(4,00t + 1,65PI)
        
        System.out.println("************************************+");
        
         Fasor fasor5 = new Fasor(2,"COS", 4,0);
        Fasor fasor6 = new Fasor(4,"SEN", 4 ,0);
        
        fasor5.sumar(fasor6);
        
        // Respuesta esperada : 4,47 COS(4,00t + 1,65PI)
        
         System.out.println("************************************+");
         
         Fasor fasor7 = new Fasor(4,"SEN", 4 ,0);
         Fasor fasor8 = new Fasor(2,"COS", 4,0);
     
        
        fasor7.sumar(fasor8);
        // Respuesta esperada : 4,47 COS(4,00t + 1,65PI)
        
        
        /* RESTA */
        
      System.out.println("**************** RESTARRR********************");   
       Fasor fasor9 = new Fasor(2,"COS", 4,0);
        Fasor fasor10 = new Fasor(4,"COS", 4 , (-1.0/2.0));
        
        fasor9.restar(fasor10);
        
        // Respuesta esperada
        
        
        
    }
}
