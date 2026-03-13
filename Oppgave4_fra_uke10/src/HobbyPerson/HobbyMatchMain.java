package HobbyPerson;

public class HobbyMatchMain {


    public static void main(String[] args) {

        Person Endre = new Person("Endre", "Handball", "Trening", "Gaming");
        Person Olaus = new Person("Olaus", "Volleyball", "Gaming", "Tur");
        Person Gunnar = new Person("Gunnar", "ingen", "nothing", "jepp");

        System.out.println("Match-verdien er på: " + match(Endre, Olaus));
        System.out.println("Match-verdien er på: " + match(Olaus, Endre));
        System.out.println("Match-verdien er på: " + match(Endre, Gunnar));
        System.out.println("Match-verdien er på: " + match(Gunnar, Endre));
    }

    static double match(Person a, Person b) {
        int antallFelles;
        int antallKunHosDenEne;
        int antallKunHosDenAndre;
        int antallTotalt;

        antallFelles = a.snitt(b);
        antallKunHosDenEne = a.minus(b);
        antallKunHosDenAndre = b.minus (a);
        antallTotalt = antallFelles+antallKunHosDenEne+antallKunHosDenAndre;


        return antallFelles - (antallKunHosDenEne + antallKunHosDenAndre) /antallTotalt;
    }
}
