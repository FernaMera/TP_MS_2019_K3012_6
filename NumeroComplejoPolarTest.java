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
        //TODO
    }

    @Test
    void multiplicar1() {
        //TODO
    }

    @Test
    void dividir() {
        //TODO
    }

    @Test
    void dividir1() {
        //TODO
    }

    @Test
    void raizCuadrada() {
        NumeroComplejoPolar unNumeroComplejo = new NumeroComplejoPolar(8,1.5);
        
        assertEquals("[2;0.5PI]\n[2;1.17PI]\n[2;1.83PI]", unNumeroComplejo.raiz(3));
    }
    
    @Test
    void pasarABinomica() {
        assertEquals("(1,00;1,00)", numeroComplejo.pasarABinomica());
    }
}