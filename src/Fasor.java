public class Fasor extends NumeroComplejo  {
   
   private String funcion; 
   private int frecuencia ;
   private double fase;
   private double amplitud;

   public Fasor(String funcion, int frecuencia, double fase, double amplitud){
       this.funcion = funcion;
       this.frecuencia = frecuencia;
       this.fase = fase;
       this.amplitud = amplitud;
   }
   
   public String sumar(Fasor unFasor){

       //chequear primero que la frecuencia sea igual y luego si las funciones no son iguales convertirlas
       /*if(frecuencia == unFasor.frecuencia){
           if(!funcion.equalsIgnoreCase(unFasor.funcion)){
               //TODO convertir ambas funciones a cosenos
           }

           //TODO hacer lo mismo que esta abajo
       }*/
       if(this.funcion.equalsIgnoreCase(unFasor.funcion) && (this.frecuencia == unFasor.frecuencia) ){

         NumeroComplejoPolar numeroConvertidoF1 = new NumeroComplejoPolar(amplitud,fase);
         NumeroComplejoPolar numeroConvertidoF2 = new NumeroComplejoPolar(unFasor.amplitud,unFasor.fase);
         
         //me quiero quedar con el numero binomico  para poder sacar la amplitud
         NumeroComplejoBinomica numeroConvertidoF11 = new NumeroComplejoBinomica(numeroConvertidoF1.pasarABinomica());
         NumeroComplejoBinomica numeroConvertidoF12 = new NumeroComplejoBinomica(numeroConvertidoF2.pasarABinomica());
        
         NumeroComplejoBinomica complejoSumado = new NumeroComplejoBinomica(numeroConvertidoF11.sumar(numeroConvertidoF12));

         /*SE PUEDE RESOLVER PASANDO DE NUEVO A POLAR
         double amplitudDelFasorSumado =
                 Math.sqrt(Math.pow(complejoSumado.get_real(),2) + Math.pow(complejoSumado.get_imaginario(),2) ) ;
         double argumentoDelFasorSumado =
                 Math.toDegrees(Math.atan(complejoSumado.get_imaginario() / complejoSumado.get_real())) * 0.0174533 ;
         */
         NumeroComplejoPolar complejoFinal = new NumeroComplejoPolar(complejoSumado.pasarAPolar());

         /*el argumento queda dividido por pi, por lo que lo agrego siempre en el resultado -VER: mostrarResultado*/
         return mostrarResultado(complejoFinal.get_modulo(), funcion, frecuencia, complejoFinal.get_argumento());
       }
      return null;
   }

   public void convertir_fasor(){
       //TODO usar funciones de abajo para MODIFICAR el fasor
   }

   public void set_funcion(String funcion) {
       this.funcion = funcion;
   }

   public void set_fase(double fase) {
       this.fase = fase;
   }
}
