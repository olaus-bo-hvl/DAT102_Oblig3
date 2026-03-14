import java.util.Set;
import java.util.HashSet;

public class JavaSetToMengde<T> implements MengdeADT<T> {

	private Set<T> Mengde;

	public JavaSetToMengde() {
		Mengde = new HashSet<>();
	}

	public boolean erTom() {
		return Mengde.isEmpty();
	}

	public boolean inneholder(T element) {
		return Mengde.contains(element);
	}

	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for (T element : annenMengde.tilTabell()) {
			if (!Mengde.contains(element)) {
				return false;
			}
		}
		return true;
	}

	public boolean erLik(MengdeADT<T> annenMengde) {
		return this.erDelmengdeAv(annenMengde) &&
				annenMengde.erDelmengdeAv(this);
	}

	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for (T element : annenMengde.tilTabell()) {
			if (Mengde.contains(element)) {
				return false;
			}
		}
		return true;
	}

	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> resultat = new JavaSetToMengde<>();

		for (T element : annenMengde.tilTabell()) {
			if (Mengde.contains(element)) {
				resultat.leggTil(element);
			}
		}

		return resultat;
	}

	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> resultat = new JavaSetToMengde<>();

		resultat.Mengde.addAll(this.Mengde);

		for (T element : annenMengde.tilTabell()) {
			resultat.leggTil(element);
		}

		return resultat;
	}

	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> resultat = new JavaSetToMengde<>();

		resultat.Mengde.addAll(this.Mengde);

		for (T element : annenMengde.tilTabell()) {
			resultat.Mengde.remove(element);
		}

		return resultat;
	}

	public void leggTil(T element) {
		Mengde.add(element);
	}

	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for (T element : annenMengde.tilTabell()) {
			Mengde.add(element);
		}
	}

	public T fjern(T element) {
		if (Mengde.remove(element)) {
			return element;
		}
		return null;
	}
	
	public T[] tilTabell() {
		return (T[]) Mengde.toArray(new Object[0]);
	}

	public int antallElementer() {
		return Mengde.size();
	}
}