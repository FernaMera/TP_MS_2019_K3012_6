import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumeroComplejoPolarTest {

    private final NumeroComplejoPolar numeroComplejo = new NumeroComplejoPolar(1.41, 0.25);

    @BeforeEach
    void setUp() {
    }

    @Test
    void sumar() {
        NumeroComplejoPolar otroNumero = new NumeroComplejoPolar(1.41,0.25);

        assertEquals("(2,00;2,00)", numeroComplejo.sumar(otroNumero));
    }

    @Test
    void sumar1() {
        NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(1,1);

        assertEquals("(2,00;2,00)", numeroComplejo.sumar(otroNumero));
    }

    @Test
    void restar() {
        NumeroComplejoPolar otroNumero = new NumeroComplejoPolar(1.41,0.25);

        assertEquals("(0,00;0,00)", numeroComplejo.restar(otroNumero));
    }

    @Test
    void restar1() {
        NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(20,20);

        assertEquals("(-19,00;-19,00)", numeroComplejo.restar(otroNumero));
    }

    @Test
    void multiplicar() {
        NumeroComplejoPolar unNumero = new NumeroComplejoPolar(2,0.33);
        NumeroComplejoPolar otroNumero = new NumeroComplejoPolar(5,0.2);

        assertEquals("[10,00;0,53PI]", unNumero.multiplicar(otroNumero));
    }

    @Test
    void multiplicar1() {
        //TODO
    }

    @Test
    void dividir() {
        NumeroComplejoPolar unNumero = new NumeroComplejoPolar(2,0.33);
        NumeroComplejoPolar otroNumero = new NumeroComplejoPolar(5,0.2);

        assertEquals("[0,40;0,13PI]", unNumero.dividir(otroNumero));
    }

    @Test
    void dividir1() {
        //TODO
    }

    @Test
    void potenciaVeinte() {
        NumeroComplejoPolar unNumeroComplejo = new NumeroComplejoPolar(Math.sqrt(2), 0.25);

        assertEquals("[1024,00;1,00PI]", unNumeroComplejo.potenciar(20));
    }

    @Test
    void raizCubica() {
        NumeroComplejoPolar unNumeroComplejo = new NumeroComplejoPolar(8,1.5);
        
        assertEquals("[2,00;0,50PI]\n[2,00;1,17PI]\n[2,00;1,83PI]\n", unNumeroComplejo.raiz(3));
    }

    @Test
    void pasarABinomica() {
        assertEquals("(1,00;1,00)", numeroComplejo.pasarABinomica());
    }
}
