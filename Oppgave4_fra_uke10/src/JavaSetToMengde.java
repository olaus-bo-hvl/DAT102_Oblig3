import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {
	
	private Set<T> Mengde;
	
	public JavaSetToMengde() {
		Mengde = new java.util.HashSet<T>();
	}
	boolean erTom(Set Mengde) {
		
		return Mengde.isEmpty();
	}
	boolean inneholder(T element) {
		
		return Mengde.contains(T element);
	}
	boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		// Mengde c annenMengde
		//        -
		return Mengde.containsAll(annenMengde);
	}
	boolean erLik(MengdeADT<T> annenMengde) {
		// Mengde c annenMengde
		return annenMengde.containsAll(Mengde);
	}
	boolean erDisjunkt(MengdeADT<T> annenMengde) {
		
		for (T element : annenMengde) {
			if (Mengde.contains(element)) {
				return false;
			}
		}
		return true;
	}
	MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		
		mengdeSnitt = new java.util.HashSet<T>();
		for (T element : annenMengde) {
			if (Mengde.contains(element)) {
				mengdeSnitt.add(T element);
			}
		}
		return mengdeSnitt;
	}
	MengdeADT<T> union(MengdeADT<T> annenMengde) {
		
		mengdeUnion = new java.util.HashSet<>();
		mengdeUnion.addAll(Mengde);
		mengdeUnion.addAll(annenMengde);
	}
	MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		mengdeMinus = new java.util.HashSet<>();
		mengdeMinus = Mengde.removeAll(annenMengde);
	}
	void leggTil(T element) {
		if (!Mengde.contains(element)) {
			Mengde.add(element);
		}
	}
	void leggTilAlleFra(MengdeADT<T> annenMengde) {
		Mengde.addAll(annenMengde);
	}
	T fjern(T element) {
		if (Mengde.contains(T element)) {
			Mengde.remove(T element);
		} else {
			return null;
		}
	}
	T[] tilTabell() {
		T[] Tabell = Mengde.toArray();
		return Tabell;
	}
	int antallElementer() {
		return Mengde.size();
	}
}
