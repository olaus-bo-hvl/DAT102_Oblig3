package Soking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class HashSetVSBinarySearch{
    public static void main (String[] args){

        int antElement = 100000; //Antall elementer vi skal legge til i HashSet og tabell

        HashSet<Integer> hashset = new HashSet<>();
        Integer[] tabell = new Integer[antElement];

        //Startverdi
        int tall = 376;

        for(int i = 0; i < antElement; i++){ //Fyller HashSet og tabell med 100.000 unike tall
            hashset.add(tall);
            tabell[i] = tall;
            tall = (tall+ 45713) % 1000000;
        }

        Arrays.sort(tabell); //Sorterer tabellen

        int antSok = 10000;

        Integer[] sok = new Integer[antSok]; //Lager en tabell med 10.000 tilfeldige søketall
        Random random = new Random();
        for(int i = 0; i < antSok; i++){
            sok[i]= random.nextInt(1000000);
        }
        //Variabel for hvor mange ganger søketallet finnes
        int funnIHashset = 0;
        int funnISortTabell = 0;

        //Søk og tidtaking i nanosekunder
        //      |
        //      |
        //      V

        long start1 = System.nanoTime();
        for(int i = 0; i < sok.length; i++){
            if(hashset.contains(sok[i])){
                funnIHashset++;
            }
        }
        long slutt1 = System.nanoTime();

        long start2 = System.nanoTime();
        for(int i = 0; i < sok.length; i++){
            if(Arrays.binarySearch(tabell, sok[i]) >= 0){
                funnISortTabell++;
            }
        }
        long slutt2 = System.nanoTime();

        //Funn og tid blir skrevet ut

        System.out.println("Antall funn i HashSet: " + funnIHashset);
        System.out.println("Tid brukt HashSet: " + (slutt1 - start1)/1000000 + " ms");//Nanosekunder blir omgjort til millisekunder

        System.out.println("Antall funn i sortert tabell: " + funnISortTabell);
        System.out.println("Tid brukt sortert tabell: " + (slutt2 - start2)/1000000 + " ms");

    }
    /* OBSERVASJON
     - Hashset er raskere enn binærsøk fordi søk i HashSet er O(1)
     - Binærsøk i sortert tabell har kjøretid på O(Log n) per søk
     - Begge metodene finner korrekt antall
     */

}
