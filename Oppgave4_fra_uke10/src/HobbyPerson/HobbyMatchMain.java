package HobbyPerson;

public class HobbyMatchMain {


    public static void main(String[] args) {

        Person Endre = new Person("Endre", "Handball", "Trening", "Gaming");
        Person Olaus = new Person("Olaus", "Volleyball", "Gaming", "Tur");
        Person Gunnar = new Person("Gunnar", "Gaming", "Trening", "Biljard", "Volleyball");

        System.out.println("Endre og Olaus har en match-verdi på: " + match(Endre, Olaus));
        System.out.println("Endre og Olaus har fremdeles en match-verdi på: " + match(Olaus, Endre));
        System.out.println("Endre og Gunnar har en match-verdi på: " + match(Endre, Gunnar));
        System.out.println("Gunnar og Olaus har en match-verdi på: " + match(Olaus, Gunnar));
        System.out.println();
        System.out.println("Gunnar og Endre har høyest match-verdi.");
    }

    static double match(Person a, Person b) {
        double antallFelles;
        double antallKunHosDenEne;
        double antallKunHosDenAndre;
        double antallTotalt;

        antallFelles = a.snitt(b);
        antallKunHosDenEne = a.minus(b);
        antallKunHosDenAndre = b.minus (a);
        antallTotalt = antallFelles+antallKunHosDenEne+antallKunHosDenAndre;


        return (antallFelles - (antallKunHosDenEne + antallKunHosDenAndre) /antallTotalt);
    }
}
