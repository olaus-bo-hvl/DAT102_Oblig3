import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTabellMengde<T> extends TabellMengde<T> {

    TabellMengde<Integer> tab;

    @BeforeEach
    void setup() {
        tab = new TabellMengde<>();
    }

    @Test
    void MengdeErTom() {
        assertTrue(tab.erTom());
    }

    @Test
    void MengdeLeggTil() {
        assertTrue(tab.erTom());
        tab.leggTil(5);
        assertFalse(tab.erTom());
    }

    @Test
    void MengdeInneholder() {
        tab.leggTil(5);
        assertTrue(tab.inneholder(5));
    }

    @Test
    void MengdeFjern() {
        tab.leggTil(5);
        assertFalse(tab.erTom());
        tab.fjern(5);
        assertTrue(tab.erTom());
    }

    @Test
    void MengdeAntallElementer() {
        assertEquals(0, tab.antallElementer());
        tab.leggTil(1);
        tab.leggTil(3);
        assertEquals(2, tab.antallElementer());
        tab.leggTil(3);
        assertEquals(2, tab.antallElementer());
    }

    @Test
    void MengdeFullMengde() {
        tab.leggTil(0);
        tab.leggTil(1);
        tab.leggTil(2);
        tab.leggTil(3);
        tab.leggTil(4);
        tab.leggTil(5);
        tab.leggTil(6);
        tab.leggTil(7);
        tab.leggTil(8);
        tab.leggTil(9);
        //Nå er den full, prøver å legge til en til
        tab.leggTil(10);
        assertEquals(11,tab.antallElementer());
    }

}
