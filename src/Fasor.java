public class Fasor extends NumeroComplejo  {
   
   private double amplitud;
   private String funcion; 
   private int frecuencia ;
   private double fase;
  

   public Fasor(double amplitud,String funcion, int frecuencia, double fase){
       this.amplitud = amplitud;
       this.funcion = funcion;
       this.frecuencia = frecuencia;
       this.fase = fase;
       
   }
   
   public String sumar(Fasor unFasor){

       //chequear primero que la frecuencia sea igual y luego si las funciones no son iguales convertirlas
       /*if(frecuencia == unFasor.frecuencia){
           if(!funcion.equalsIgnoreCase(unFasor.funcion)){
               //TODO convertir ambas funciones a cosenos
           }
           //TODO hacer lo mismo que esta abajo
       }*/
      if (this.frecuencia == unFasor.frecuencia) {
         if(this.funcion.equalsIgnoreCase(unFasor.funcion) ){

       this.calcular_fasor_sumado(unFasor);
       }
         else{
             if(this.funcion.equalsIgnoreCase("SEN")&& unFasor.funcion.equalsIgnoreCase("COS")){
               this.convertir_fasor_seno_a_coseno();
        
                this.calcular_fasor_sumado(unFasor);
         }else{
                 if(this.funcion.equalsIgnoreCase("COS")&& unFasor.funcion.equalsIgnoreCase("SEN")){
                  unFasor.convertir_fasor_seno_a_coseno();
             
                  this.calcular_fasor_sumado(unFasor);
                 
             }
           
      }
      
      
   }
      
   }
      return null;
   }
   
   public String restar(Fasor unFasor){

      
      if (this.frecuencia == unFasor.frecuencia) {
         if(this.funcion.equalsIgnoreCase(unFasor.funcion) ){

       this.calcular_fasor_restado(unFasor);
       }
         else{
             if(this.funcion.equalsIgnoreCase("SEN")&& unFasor.funcion.equalsIgnoreCase("COS")){
               this.convertir_fasor_seno_a_coseno();
        
                this.calcular_fasor_restado(unFasor);
         }else{
                 if(this.funcion.equalsIgnoreCase("COS")&& unFasor.funcion.equalsIgnoreCase("SEN")){
                  unFasor.convertir_fasor_seno_a_coseno();
             
                  this.calcular_fasor_restado(unFasor);
                 
             }
           
      }
      
      
   }
      
   }
      return null;
   }
   
   
   
   
   
   public void convertir_fasor_seno_a_coseno(){
       //TODO usar funciones de abajo para MODIFICAR el fasor
    
       this.set_funcion("COS");
       this.set_fase(-0.5);
       
   }
   
   public String calcular_fasor_sumado(Fasor unFasor){
       
         NumeroComplejoPolar numeroConvertidoF1 =
                 new NumeroComplejoPolar(amplitud,fase);
         NumeroComplejoPolar numeroConvertidoF2 = 
                 new NumeroComplejoPolar(unFasor.amplitud,unFasor.fase);
          NumeroComplejoBinomica complejoSumado =
                  new NumeroComplejoBinomica(numeroConvertidoF1.sumar(numeroConvertidoF2));
           NumeroComplejoPolar complejoFinal = 
                     new NumeroComplejoPolar(complejoSumado.pasarAPolar());
              return mostrarResultado(complejoFinal.get_modulo(), funcion, frecuencia, complejoFinal.get_argumento());
         
   }
   
    public String calcular_fasor_restado(Fasor unFasor){
       
         NumeroComplejoPolar numeroConvertidoF1 =
                 new NumeroComplejoPolar(amplitud,fase);
         NumeroComplejoPolar numeroConvertidoF2 = 
                 new NumeroComplejoPolar(unFasor.amplitud,unFasor.fase);
          NumeroComplejoBinomica complejoRestado =
                  new NumeroComplejoBinomica(numeroConvertidoF1.restar(numeroConvertidoF2));
           NumeroComplejoPolar complejoFinal = 
                     new NumeroComplejoPolar(complejoRestado.pasarAPolar());
              return mostrarResultado(complejoFinal.get_modulo(), funcion, frecuencia, complejoFinal.get_argumento());
         
   }
   
   
    
   public void set_funcion(String funcion) {
       this.funcion = funcion;
   }

   public void set_fase(double fase) {
       this.fase = this.fase + fase;
   }

}
   
   
   
