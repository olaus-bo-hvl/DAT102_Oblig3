import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLenketMengde{


    private LenketMengde<Integer> lenke1;
    private LenketMengde<Integer> lenke2;
    private LenketMengde<Integer> tomLenke;


    @BeforeEach
    void setup(){
        lenke1 = new LenketMengde<>();
        lenke2 = new LenketMengde<>();
        tomLenke = new LenketMengde<>();

        lenke1.leggTil(1);
        lenke1.leggTil(2);
        lenke1.leggTil(3);

        lenke2.leggTil(2);
        lenke2.leggTil(3);
        lenke2.leggTil(4);
    }

    @Test
    void testErTom(){
        assertTrue(tomLenke.erTom());
        assertFalse(lenke1.erTom());
    }

    @Test
    void testInneholder(){
        assertTrue(lenke1.inneholder(1));
        assertTrue(lenke1.inneholder(2));
        assertTrue(lenke1.inneholder(3));

        assertFalse(lenke1.inneholder(123));
    }

    @Test
    void testErDelmengdeAv(){

        assertFalse(lenke1.erDelmengdeAv(lenke2));
        assertTrue(tomLenke.erDelmengdeAv(lenke2));

        lenke1.fjern(1);

        assertTrue(lenke1.erDelmengdeAv(lenke2));
        assertFalse(lenke2.erDelmengdeAv(lenke1));
    }

    @Test
    void testErLik(){
        assertFalse(lenke1.erLik(lenke2));
        assertFalse(tomLenke.erLik(lenke2));

        lenke1.fjern(1);
        lenke1.leggTil(4);

        assertTrue(lenke1.erLik(lenke2));
    }
    @Test
    void testErDisjunkt(){
        assertFalse(lenke1.erDisjunkt(lenke2));
        assertTrue(tomLenke.erDisjunkt(lenke2));

        tomLenke.leggTil(10);
        tomLenke.leggTil(11);
        tomLenke.leggTil(12);

        assertTrue(tomLenke.erDisjunkt(lenke2));
    }

    @Test
    void testSnitt(){
        MengdeADT<Integer> snitt = lenke1.snitt(lenke2);

        assertTrue(snitt.inneholder(2));
        assertTrue(snitt.inneholder(3));

        assertEquals(2, snitt.antallElementer());

        assertFalse(snitt.inneholder(1));
        assertFalse(snitt.inneholder(4));
    }

    @Test
    void testUnion(){
        MengdeADT<Integer> union = lenke1.union(lenke2);

        assertTrue(union.inneholder(1));
        assertTrue(union.inneholder(2));
        assertTrue(union.inneholder(3));
        assertTrue(union.inneholder(4));

        assertEquals(4, union.antallElementer());
    }

    @Test
    void testMinus(){
        MengdeADT<Integer> minus = lenke1.minus(lenke2);

        assertEquals(1,minus.antallElementer());

        assertTrue(minus.inneholder(1));

        assertFalse(minus.inneholder(2));
        assertFalse(minus.inneholder(3));
        assertFalse(minus.inneholder(4));

    }

    @Test
    void testLeggTil(){

        lenke1.leggTil(10);
        lenke1.leggTil(11);

        assertTrue(lenke1.inneholder(10));
        assertTrue(lenke1.inneholder(11));
    }

    @Test
    void testLeggTilAlleFra(){
        lenke1.leggTilAlleFra(lenke2);

        assertTrue(lenke1.inneholder(1));
        assertTrue(lenke1.inneholder(2));
        assertTrue(lenke1.inneholder(3));
        assertTrue(lenke1.inneholder(4));

        assertEquals(4, lenke1.antallElementer());
    }

    @Test
    void testFjern(){

        assertEquals(1, lenke1.fjern(1));
        assertNull(lenke1.fjern(10));

        assertFalse(lenke1.inneholder(1));

        assertEquals(2, lenke1.antallElementer());
    }

    @Test
    void testTilTabell(){
        Object[] tabell = lenke1.tilTabell();

        assertEquals(3, tabell.length);

        assertTrue(lenke1.inneholder((Integer)tabell[0]));
        assertTrue(lenke1.inneholder((Integer)tabell[1]));
        assertTrue(lenke1.inneholder((Integer)tabell[2]));

    }

    @Test
    void testIngenDupblikater(){
        tomLenke.leggTil(1);
        tomLenke.leggTil(1);
        tomLenke.leggTil(1);

        assertEquals(1, tomLenke.antallElementer());
    }

    @Test
    void testAntallElemeneter(){
        assertEquals(3, lenke1.antallElementer());
        assertEquals(3, lenke2.antallElementer());
        assertEquals(0, tomLenke.antallElementer());
    }

}
