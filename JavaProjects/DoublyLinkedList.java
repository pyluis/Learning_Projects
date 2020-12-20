public class DoublyLinkedList<T> implements Iterable<T>{
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;
    
    private static class Node<T>{
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    public void clear(){

        Node<T> trav = head;
        //set all elements in list to null if the list still has elements
        while(trav!=null){
            Node<T> next = trav.next;
            trav.prev = trav.next = null; 
            trav.data = null;
            trav = next;
        }
        // set head and tail to null 
        head = tail = trav = null;
        size=0; 
    }

    public int getSize(){
        return size;
    }

    public void add(T elem){
        addLast(elem);
    }

    public boolean isEmpty(){
        return getSize()==0;
    }

    public void addLast(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        } else{
            tail.next = new Node<T>(elem,tail,null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(){
        
    }

}