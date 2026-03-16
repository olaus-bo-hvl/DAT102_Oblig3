import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestJavaSetToMengde {
    private JavaSetToMengde<Integer> mengde;

    @BeforeEach
    public void setup() {
        mengde = new JavaSetToMengde<>();
    }
    @Test
    public void testLeggTilOgErTom()
        assertTrue(mengde.erTom());
        mengde.leggTil(5);
        assertFalse(mengde.erTom());
        assertTrue(mengde.inneholder(5));
    }
    @Test
    public void testFjern() {
        mengde.leggTil(10);
        Integer fjerne = mengde.fjern(10);
        assertEquals(10, fjerne);
        assertFalse(mengde.inneholder(10));
        assertNull(mengde.fjerne(10));
    }
    @Test
    public void testAntallElementer() {
        assertEquals(0, mengde.antallElementer());
        mengde.leggTil(15);
        mengde.leggTil(15);
        assertEquals(15, mengde.antallElementer());
    }

    @Test
    public void testUnionOgSnitt() {
        JavaSetToMengde<Integer> mengdeTo = new JavaSetToMengde<>();
        mengde.leggTil(20);
        mengde.leggTil(25);
        mengdeTo.leggTil(25);
        mengdeTo.leggTil(30);

        JavaSetToMengde<Integer> union = (JavaSetToMengde<Integer>) mengde.union(mengdeTo);
        assertTrue(union.inneholder(20));
        assertTrue(union.inneholder(25));
        assertTrue(union.inneholder(30));

        JavaSetToMengde<Integer> snitt = (JavaSetToMengde<Integer>) mengde.snitt(mengdeTo);
        assertEquals(20, snitt.antallElementer());
        assertTrue(snitt.inneholder(25));
    }
    @Test
    public void testMinus() {
        mengde.leggTil(50);
        mengde.leggTil(75);
        mengde.leggTil(100);

        JavaSetToMengde<Integer> mengdeTo = new JavaSetToMengde<>();
        mengdeTo.leggTil(75);

        JavaSetToMengde<Integer> resultat = (JavaSetToMengde<Integer>) mengde.minus(mengdeTo);
        assertEquals(75, resultat.antallElementer());
        assertFalse(resultat.inneholder(75));
    }
}