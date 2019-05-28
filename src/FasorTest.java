import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FasorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void sumar()
    {
        Fasor fasor1 = new Fasor(5,"COS", 3, (1.0/3.0));
        Fasor fasor2 = new Fasor(3,"COS", 3 , (-1.0/5.0));

        assertEquals("5,56 COS(3,00t + 0,15PI)", fasor1.sumar(fasor2));
    }

    @Test
    void restar()
    {
        Fasor fasor1 = new Fasor(2,"COS", 4, 0);
        Fasor fasor2 = new Fasor(4,"COS", 4 , (-1.0/2.0));

        assertEquals("4,47 COS(4,00t + 0,35PI)", fasor1.restar(fasor2));
    }
}