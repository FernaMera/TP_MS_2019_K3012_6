public class NumeroComplejoBinomio
{
    private float numeroReal;
    private float numeroImaginario;

    public NumeroComplejoBinomio(float x, float y)
    {
        numeroReal = x;
        numeroImaginario = y;
    }

    public void ConvertirATrigonometica()
    {
        float num1 = 0, num2 = 0;

        //convertir
        num1 = numeroReal;
        num2 = numeroImaginario;

        //mostrar en pantalla
        System.out.print("[" + num1 + ";" + num2 + "]");
    }
}
