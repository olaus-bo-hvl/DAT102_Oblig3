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

//    @Test
//    void MengdeFjern() {
//        tab.leggTil();
//    }


}
