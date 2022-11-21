package LA1Q1;
//defining node T as a generic class
public class Node<T>{
    //define two private fields, one type T: element, another Node<T>: next
    private  T  element;
    private Node<T> next;


    public Node(){

    }

    public Node(T element, Node<T> next){
        this.element = element;
        this.next = next;

    }
    //getter and one setter method
    public T getElement(){
        return element;
    }
    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }

}



