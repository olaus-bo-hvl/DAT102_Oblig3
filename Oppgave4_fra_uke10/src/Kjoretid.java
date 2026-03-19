public class Kjoretid {
  public static void main(String[] args) {
		int n = 100_000;
		int repetisjoner = 100_000;
		// SetToMengde
		JavaSetToMengde<Integer> hashSetMengde = new JavaSetToMengde<>();
		for (int i = 0; i < n; i++)
		{
			hashSetMengde.leggTil(i);
		}
		for (int i = 0; i < 1000; i++)
		{
			hashSetMengde.inneholder(i);
		}
		// tar tiden i ms
		long startTid = System.currentTimeMillis();
		for (int i = 0; i < repetisjoner; i++)
		{
			hashSetMengde.inneholder(n - 1);
		}
		long sluttTid = System.currentTimeMillis();
		System.out.println("JavaSetToMengde\t: " + (sluttTid - startTid) + " \tms");

		// LenketMengde
		LenketMengde<Integer> lenketMengde = new LenketMengde<>();
		for (int i = 0; i < n; i++)
		{
			lenketMengde.leggTil(i);
		}
		for (int i = 0; i < 1000; i++)
		{
			lenketMengde.inneholder(i);
		}
		startTid = System.currentTimeMillis();
		for (int i = 0; i < repetisjoner; i++)
		{
			lenketMengde.inneholder(n - 1);
		}
		sluttTid = System.currentTimeMillis();
		System.out.println("LenketMengde\t: " + (sluttTid - startTid) + " \tms");

		// TabellMengde
		TabellMengde<Integer> tabellMengde = new TabellMengde<>();
		for (int i = 0; i < n; i++)
		{
			tabellMengde.leggTil(i);
		}
		for (int i = 0; i < 1000; i++)
		{
			tabellMengde.inneholder(i);
		}
		startTid = System.currentTimeMillis();
		for (int i = 0; i < repetisjoner; i++)
		{
			tabellMengde.inneholder(n - 1);
		}
		sluttTid = System.currentTimeMillis();
		System.out.println("TabellMengde\t: " + (sluttTid - startTid) + " \tms");
	}
}
