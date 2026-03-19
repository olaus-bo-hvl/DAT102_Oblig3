package HobbyPerson;

public class Person {

    private String navn;
    private String[] hobbyer;

    public Person(String navn, String ... hobbyer){
        this.navn = navn;
        this.hobbyer = hobbyer;
    }

    public String getNavn() {
        return navn;
    }

    public void setHobbyer(String[] hobbyer) {
        this.hobbyer = hobbyer;
    }

    public String[] getHobbyer() {
        return hobbyer;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean inneholder(String element) {
        int i = 0;
        while (i < getHobbyer().length) {
            if (getHobbyer()[i]!=null && getHobbyer()[i].equals(element)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public double snitt(Person annenPerson) {
        double antall = 0;

        for (String i : getHobbyer()) {
            if (i!=null && annenPerson.inneholder(i)) {
                antall++;
            }
        }
        return antall;
    }

    public double minus(Person annenPerson) {
        double antall = 0;

        for (int i = 0; i < getHobbyer().length; i++) {
            String hobby = getHobbyer()[i];
            if (!annenPerson.inneholder(hobby)) {
                antall++;
            }
        }

        return antall;
    }
}
