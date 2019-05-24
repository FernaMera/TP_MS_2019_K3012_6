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
        Fasor fasor1 = new Fasor("COS", 3, (1.0/3.0), 5);
        Fasor fasor2 = new Fasor("COS", 3 , (-1.0/5.0), 3);

        assertEquals("5,56 COS(3,00t + 0,15PI)", fasor1.sumar(fasor2));
    }
}