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

    public String[] snitt(Person annenPerson) {
        String[] nyTabell = new String[getHobbyer().length + annenPerson.getHobbyer().length];

        int j = 0;
        for (String i : getHobbyer()) {
            if (i!=null && annenPerson.inneholder(i)) {
                nyTabell[j] = i;
                j++;
            }
        }
        return nyTabell;
    }
}
