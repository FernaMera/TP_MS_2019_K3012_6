import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumeroComplejoBinomicaTest {

    private final NumeroComplejoBinomica numeroBinomico = new NumeroComplejoBinomica(1,1);

    @BeforeEach
    void setUp() {

    }

    @Test
    void sumar() {
         NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(1,1);

         assertEquals("(2,00;2,00)", numeroBinomico.sumar(otroNumero));
    }

    @Test
    void sumar1() {
        NumeroComplejoPolar otroNumero = new NumeroComplejoPolar(1.41,0.25);

        assertEquals("(2,00;2,00)", numeroBinomico.sumar(otroNumero));
    }

    @Test
    void restar() {
        NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(2,2);

        assertEquals("(-1,00;-1,00)", numeroBinomico.restar(otroNumero));
    }

    @Test
    void restar1() {
        NumeroComplejoPolar otroNumero = new NumeroComplejoPolar(1.41,0.25);

        assertEquals("(0,00;0,00)", numeroBinomico.restar(otroNumero));
    }

    @Test
    void multiplicar() {
        NumeroComplejoBinomica unNumero = new NumeroComplejoBinomica(3,2);
        NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(5,-3);

        assertEquals("(21,00;1,00)", unNumero.multiplicar(otroNumero));
    }

    @Test
    void multiplicar1() {
        //TODO
    }

    @Test
    void dividir() {
        NumeroComplejoBinomica unNumero = new NumeroComplejoBinomica(3,2);
        NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(5,-3);

        assertEquals("(0,26;0,56)", unNumero.dividir(otroNumero));
    }

    @Test
    void dividir1() {
        //TODO
    }

    @Test
    void dividirPorCero(){
        NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(0,0);

        assertNull(numeroBinomico.dividir(otroNumero));
    }

    @Test
    void pasarAPolarPrimerCuadrante() {
        assertEquals("[1,41;0,25PI]", numeroBinomico.pasarAPolar());
    }

    @Test
    void pasarAPolarSegundoCuadrante() {
        NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(-1,1);

        assertEquals("[1,41;0,75PI]", otroNumero.pasarAPolar());
    }

    @Test
    void pasarAPolarTercerCuadrante() {
        NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(-1,-1);

        assertEquals("[1,41;1,25PI]", otroNumero.pasarAPolar());
    }

    @Test
    void pasarAPolarCuartoCuadrante() {
        NumeroComplejoBinomica otroNumero = new NumeroComplejoBinomica(1,-1);

        assertEquals("[1,41;1,75PI]", otroNumero.pasarAPolar());
    }
}