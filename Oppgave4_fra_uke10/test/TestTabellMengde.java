import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTabellMengde<T> extends TabellMengde<T> {

    TabellMengde<Integer> tabTom;
    TabellMengde<Integer> tabHalv1;
    TabellMengde<Integer> tabHalv2;
    TabellMengde<Integer> tabFull;

    @BeforeEach
    void setup() {
        tabTom = new TabellMengde<>(); //Tom mengde
        tabHalv1 = new TabellMengde<>(); //halvfull mengde
            tabHalv1.leggTil(1);
            tabHalv1.leggTil(3);
            tabHalv1.leggTil(5);
            tabHalv1.leggTil(7);
            tabHalv1.leggTil(9);
        tabHalv2 = new TabellMengde<>(); //halvfull mengde
            tabHalv2.leggTil(2);
            tabHalv2.leggTil(4);
            tabHalv2.leggTil(6);
            tabHalv2.leggTil(8);
            tabHalv2.leggTil(10);
        tabFull = new TabellMengde<>(); //Full mengde
            tabFull.leggTil(1);
            tabFull.leggTil(2);
            tabFull.leggTil(3);
            tabFull.leggTil(4);
            tabFull.leggTil(5);
            tabFull.leggTil(6);
            tabFull.leggTil(7);
            tabFull.leggTil(8);
            tabFull.leggTil(9);
            tabFull.leggTil(10);
    }

    @Test
    void TestTabErTom() {
        assertTrue(tabTom.erTom());
        assertFalse(tabHalv1.erTom());
    }

    @Test
    void TestTabLeggTil() {
        assertTrue(tabTom.erTom());
        tabTom.leggTil(5);
        tabTom.leggTil(5);
        assertFalse(tabTom.erTom());
    }

    @Test
    void TestTabInneholder() {
        assertTrue(tabHalv1.inneholder(5));
        assertFalse(tabHalv1.inneholder(2));
        assertTrue(tabHalv2.inneholder(2));
        assertFalse(tabHalv2.inneholder(5));
    }

    @Test
    void TestTabFjern() {
        assertTrue(tabHalv1.inneholder(3));
        tabHalv1.fjern(3);
        assertFalse(tabHalv1.inneholder(3));
    }

    @Test
    void TestTabAntallElementer() {
        assertEquals(5, tabHalv1.antallElementer());
        tabHalv1.leggTil(11);
        assertEquals(6, tabHalv1.antallElementer());

        assertEquals(5, tabHalv2.antallElementer());
        tabHalv2.fjern(10);
        assertEquals(4, tabHalv2.antallElementer());
    }

    @Test
    void TestTabMengde() {
        assertEquals(10, tabFull.antallElementer());
        //Nå er den full, prøver å legge til en til
        tabFull.leggTil(11);
        assertEquals(11, tabFull.antallElementer());
    }

    @Test
    void TestTabErDelmengdeAv() {
        assertTrue(tabHalv1.erDelmengdeAv(tabFull));
        assertFalse(tabHalv1.erDelmengdeAv(tabHalv2));
    }

    @Test
    void TestTabErLik() {
        assertFalse(tabTom.erLik(tabHalv2));
        tabTom.leggTilAlleFra(tabHalv2);
        assertTrue(tabTom.erLik(tabHalv2));
    }

    @Test
    void TestTabLeggTilAlleFra() {
        assertFalse(tabHalv1.erLik(tabFull));
        assertEquals(5, tabHalv1.antallElementer());
        tabHalv1.leggTilAlleFra(tabHalv2);

        assertTrue(tabHalv1.erLik(tabFull));
        assertEquals(10, tabHalv1.antallElementer());
    }

    @Test
    void TestTabErDisjukt() {
        assertFalse(tabHalv1.erDisjunkt(tabFull));
        assertTrue(tabHalv1.erDisjunkt(tabHalv2));
    }

    @Test
    void TestTabSnitt() {
        assertFalse(tabHalv2.erLik(tabFull));
        TabellMengde<Integer> nyTab = tabFull.snitt(tabHalv2);
        assertTrue(nyTab.erLik(tabHalv2));
    }

    @Test
    void TestTabUnion() {
        assertFalse(tabHalv1.erLik(tabFull));
        assertFalse(tabHalv2.erLik(tabFull));
        TabellMengde<Integer> nyTab = tabHalv1.union(tabHalv2);
        assertTrue(nyTab.erLik(tabFull));
    }

    @Test
    void TestTabMinus() {
        assertFalse(tabFull.erLik(tabHalv1));
        TabellMengde<Integer> nyTab = tabFull.minus(tabHalv2);
        assertTrue(nyTab.erLik(tabHalv1));
    }
}
