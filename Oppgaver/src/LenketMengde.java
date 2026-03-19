public class LenketMengde<T> implements MengdeADT<T>{

    private class Node{
        private T data;
        private Node next;

        private Node(T data){
            this.data = data;
            this.next = null;
        }
    }


    private Node firstNode; //Referanse til første node
    private int numberOfEntries;

    public LenketMengde(){
        initializeDataFields();
    }

    private void initializeDataFields(){
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean erTom() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean inneholder(T element) {
        Node currentNode = firstNode;

        while(currentNode != null){
            if(element.equals(currentNode.data)){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        Node currentNode = firstNode;

        while(currentNode != null){
            if(!annenMengde.inneholder(currentNode.data)){
                return false;
            }
            currentNode = currentNode.next;
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if(numberOfEntries != annenMengde.antallElementer()){
            return false;
        }
        return erDelmengdeAv(annenMengde);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        Node currentNode = firstNode;

        while(currentNode != null){
            if(annenMengde.inneholder(currentNode.data)){
                return false;
            }
            currentNode = currentNode.next;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {

        Node currentNode = firstNode;

        LenketMengde<T> nyMengde = new LenketMengde<>();

        while(currentNode != null){
            if(annenMengde.inneholder(currentNode.data)){
                nyMengde.leggTil(currentNode.data);
            }
            currentNode = currentNode.next;
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {

        LenketMengde<T> nyMengde = new LenketMengde<>();

        nyMengde.leggTilAlleFra(this);
        nyMengde.leggTilAlleFra(annenMengde);

        return nyMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {

        Node currentNode = firstNode;

        LenketMengde<T> nyMengde = new LenketMengde<>();

        while(currentNode != null){
            if(!annenMengde.inneholder(currentNode.data)){
                nyMengde.leggTil(currentNode.data);
            }
            currentNode = currentNode.next;
        }
        return nyMengde;
    }

    @Override
    public void leggTil(T element) {
        if(element != null && !inneholder(element)){
            Node newNode = new Node(element);
            newNode.next = firstNode;
            firstNode = newNode;

            numberOfEntries++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        T[] tabell = annenMengde.tilTabell();

        for(T element : tabell){
            leggTil(element);
        }
    }

    @Override
    public T fjern(T element) {
        if(!inneholder(element)){
            return null;
        }
        Node currentNode = firstNode;
        Node previousNode = null;

        while(currentNode != null){
            if(currentNode.data.equals(element)){

                if(previousNode == null){
                    firstNode = currentNode.next;
                } else{
                    previousNode.next = currentNode.next;
                }
                numberOfEntries--;
                return currentNode.data;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    @Override
    public T[] tilTabell() {
        T[] tabell =(T[]) new Object[numberOfEntries];

        Node currentNode = firstNode;
        int index = 0;

        while(currentNode != null){
            tabell[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }
        return tabell;
    }

    @Override
    public int antallElementer() {
        return numberOfEntries;
    }
}
