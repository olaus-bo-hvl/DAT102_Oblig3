public class TabellMengde<T> implements MengdeADT<T> {

    private int antall = 0;
    private T[] tabell;

    public TabellMengde() {
        tabell = (T[]) new Object[10];
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        int i = 0;
        while (i < antall) {
            if (tabell[i] == element) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public void leggTil(T element) {
        if (antall == tabell.length) {
            tabell = fullTabell(tabell);
        }

        boolean sjekk = true;
        for (T i : tabell) {
            if (i.equals(element)) {
                sjekk = false;
            }
        }
        
        if (sjekk == true) {
            tabell[antall] = element;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

    }

    @Override
    public T fjern(T element) {
        return null;
    }

    @Override
    public T[] tilTabell() {
        return null;
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    public T[] fullTabell(T[] fullTab) {
        T[] nyTab = (T[]) new Object[fullTab.length*2];

        int j = 0;
        for (T i : fullTab) {
            nyTab[j] = fullTab[j];
            j++;
        }

        return nyTab;
    }
}
