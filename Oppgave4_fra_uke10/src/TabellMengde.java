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
        for (T i : tabell) {
            if (i == element) {
                System.out.println("Elementet finnes allerede i mengden og blir derfor ikke lagt til.");
                return;
            }
        }

        if (antall == tabell.length) {
            tabell = fullTabell(tabell);
        }
        tabell[antall] = element;
        antall++;
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

    }

    @Override
    public T fjern(T element) {
        int plass = 0;
        boolean sjekk = true;
        for (int i = 0; i < tabell.length; i++) {
            if (tabell[i] == element) {
                plass = i;
                sjekk = false;
            }
        }

        if (sjekk) {
            return null;
        }

        for (int i = plass; i < tabell.length-1; i++) {
            tabell[i] = tabell[i+1];
        }
        antall--;
        return element;
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
