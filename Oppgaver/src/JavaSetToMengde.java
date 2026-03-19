import java.util.Set;
import java.util.HashSet;

public class JavaSetToMengde<T> implements MengdeADT<T> {

	private Set<T> mengde;

	public JavaSetToMengde() {
		mengde = new HashSet<>();
	}
	public boolean erTom() {
		return mengde.isEmpty();
	}
	public boolean inneholder(T element) {
		return mengde.contains(element);
	}
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for (T element : this.tilTabell()) {
			if (!annenMengde.inneholder(element)) {
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
			if (mengde.contains(element)) {
				return false;
			}
		}
		return true;
	}
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> resultat = new JavaSetToMengde<>();

		for (T element : annenMengde.tilTabell()) {
			if (mengde.contains(element)) {
				resultat.leggTil(element);
			}
		}
		return resultat;
	}
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> resultat = new JavaSetToMengde<>();

		resultat.mengde.addAll(this.mengde);

		for (T element : annenMengde.tilTabell()) {
			resultat.leggTil(element);
		}
		return resultat;
	}
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> resultat = new JavaSetToMengde<>();

		resultat.mengde.addAll(this.mengde);

		for (T element : annenMengde.tilTabell()) {
			resultat.mengde.remove(element);
		}
		return resultat;
	}
	public void leggTil(T element) {
		mengde.add(element);
	}
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for (T element : annenMengde.tilTabell()) {
			leggTil(element);
		}
	}
	public T fjern(T element) {
		if (mengde.remove(element)) {
			return element;
		}
		return null;
	}
	public T[] tilTabell() {
		return (T[]) mengde.toArray((T[]) new Object[mengde.size()]);
	}
	public int antallElementer() {
		return mengde.size();
	}
}