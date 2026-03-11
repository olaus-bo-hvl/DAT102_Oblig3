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

        return null;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        return null;
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

    }

    @Override
    public T fjern(T element) {
        return null;
    }

    @Override
    public T[] tilTabell() {
        return null;
    }

    @Override
    public int antallElementer() {
        return numberOfEntries;
    }
}
