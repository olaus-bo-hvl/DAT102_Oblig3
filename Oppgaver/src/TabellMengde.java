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
            if (tabell[i]!=null && tabell[i].equals(element)) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (T i : tabell) {
            if (i == null) {
                continue;
            }
            if (!annenMengde.inneholder(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (!this.erDelmengdeAv(annenMengde) || !annenMengde.erDelmengdeAv(this)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (T i : tabell) {
            if (i==null){continue;}
            if (annenMengde.inneholder(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public TabellMengde<T> snitt(MengdeADT<T> annenMengde) {
        TabellMengde<T> nyTabell = new TabellMengde<>();

        for (T i : tabell) {
            if (i!=null && annenMengde.inneholder(i)) {
                nyTabell.leggTil(i);
            }
        }
        return nyTabell;
    }

    @Override
    public TabellMengde<T> union(MengdeADT<T> annenMengde) {
        TabellMengde<T> nyTabell = new TabellMengde<>();
        nyTabell.leggTilAlleFra(this);
        nyTabell.leggTilAlleFra(annenMengde);
        return nyTabell;
    }

    @Override
    public TabellMengde<T> minus(MengdeADT<T> annenMengde) {
        TabellMengde<T> nyTabell = new TabellMengde<>();

        for (int i = 0; i < antall; i++) {
            T element = tabell[i];
            if (!annenMengde.inneholder(element)) {
                nyTabell.leggTil(element);
            }
        }

        return nyTabell;
    }

    @Override
    public void leggTil(T element) {
        if (element==null){return;}

        for (T i : tabell) {
            if (i!=null && i.equals(element)) {
                System.out.println("Elementet '" + element.toString() + "' finnes allerede i mengden og blir derfor ikke lagt til.");
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
        if (this.erLik(annenMengde)) {return;}
        for (T i : annenMengde.tilTabell()) {
            this.leggTil(i);
        }
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
        tabell[plass] = tabell[antall];
        tabell[antall] = null;
        antall--;
        return element;
    }

    @Override
    public T[] tilTabell() {
        return tabell;
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
