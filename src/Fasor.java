public class Fasor extends NumeroComplejo  {
   
   private String funcion; 
   private int frecuencia ;
   private double fase;
   private double amplitud;
   
   public Fasor(String funcion,int frecuencia,double fase,double amplitud){
       this.funcion = funcion;
       this.frecuencia = frecuencia;
       this.fase = fase;
       this.amplitud = amplitud;
   }
   
   public String sumar(Fasor unFasor){
       
       if(this.funcion.equalsIgnoreCase(unFasor.funcion) && (this.frecuencia == unFasor.frecuencia) ){
           
         NumeroComplejoPolar numeroConvertidoF1 = new NumeroComplejoPolar(amplitud,fase);
         NumeroComplejoPolar numeroConvertidoF2 = new NumeroComplejoPolar(unFasor.amplitud,unFasor.fase);
         
         // hago esto porque me quiero quedar con el numero binomico  para poder sacar la amplitud
         NumeroComplejoBinomica numeroConvertidoF11 = new NumeroComplejoBinomica(numeroConvertidoF1.pasarABinomica());
         NumeroComplejoBinomica numeroConvertidoF12 = new NumeroComplejoBinomica(numeroConvertidoF2.pasarABinomica());
        
         NumeroComplejoBinomica complejoSumado = new NumeroComplejoBinomica(numeroConvertidoF11.sumar(numeroConvertidoF12));
         
         
         double amplitudDelFasorSumado =
                 Math.sqrt(Math.pow(complejoSumado.get_real(),2) + Math.pow(complejoSumado.get_imaginario(),2) ) ;
         double argumentoDelFasorSumado =
                 Math.toDegrees(Math.atan(complejoSumado.get_imaginario() / complejoSumado.get_real())) * 0.0174533 ;

         return mostrarResultado(amplitudDelFasorSumado,funcion,frecuencia, argumentoDelFasorSumado,"");
      
      /*En donde puse " " antes iba "PI" pero como directamente los paso a radianes con la conversion
       por ahora no haria falta agregarselo pero se lo dejo por las dudas por si llegamos a modificar algo 
       */
    
       }
      return null;
   }
}
