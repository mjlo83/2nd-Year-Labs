package LA1Q1;

import java.util.Queue;
import java.util.LinkedList;
import java.util.*;
import java.io.*;
import java.util.Deque;

public class SinglyLinkList<T> {

    //private fields head and tail, and size to keep track of number of elements in list
    private Node<T> head = null;
    private T element;
    private Node<T> tail = null;
    private int size = 0;

    //constructor without parameters
    public SinglyLinkList() {

    }

    //constructor with parameters
    public SinglyLinkList(Node<T> head, Node<T> tail, int size) {
        head = this.head;
        tail = this.tail;
        size = this.size;

    }


    // removeLast(): remove the tail and return element, then assign next in line to last
    public T removeLast() {


        Node<T> findTail = head; //Node object, starts at head and moves toward tail
        Node<T> nLast = null;//finds value before tail, set to null for now (finds second last item)


        while (findTail.getNext() != null) {// keep moving down(looping), until it reaches the end

            nLast = findTail; //set nLast to findTail
            findTail = findTail.getNext(); //move further down the list until tail is found


        }
        size--;//decrease size by one unit to account for element removed
        nLast.setNext(null);//removes last element by setting the element next to nLast(2nd last) to null
        tail = nLast;//sets new tail to second last element
        if (isEmpty()) {
            return null;
        }

        return findTail.getElement(); //returns tail
    }


    //pushAtHead: realize the linkList as a stack with the head as the top of the stack, push an element to the top of the stack
    public void pushAtHead(T element) {
        //uses addFirst method to push an element to the head of the stack
        addFirst(element);

    }

    //removeFirst(): removes the head and returns the element, and then assigns the node before the current tail as its new tail
    public T removeFirst() {
        if (isEmpty())
            return null;
        T answer = head.getElement();//get head, to return element
        head = head.getNext();//set 2nd first element to new head
        size--;//decrease size to account for removed head

        if (size == 0)
            tail = null;
        return answer;
    }


    //realize the linklist as a stack with the head as the top of the stack, then assigns the node before the current tail as its new tail
    public T popFromHead() {
        //get current head so it can be removed
        T answer = head.getElement();
        //call on remove first to pop Header from stack
        removeFirst();
        System.out.print(answer);
        return answer;// return old head
    }

    //pushAtTail: realize as stack with tail as top of stack
    public void pushAtTail(T element) {
        //call on addLast to push new element to bottom of stack
        addLast(element);
    }

    //popFromTail: realize as stack with tail as head, and return popped value
    public T popFromTail() {
        T answer = tail.getElement();//get current tail to return
        removeLast();// call on remove last to pop element from bottom of stack
        System.out.print(answer);
        return answer;//return old tail
    }


    //getter method for field size, gets size
    public int getSize() {
        //returns size of stack or list
        return size;
    }


    //returns ture if the list is empty
    public Boolean isEmpty() {
        //returns true if empty
        return size == 0;
    }

    //Override the Object's toString() method, which will return the list as a string
    //used when we call sLL
    @Override
    public String toString() {
        String linkedListString = "[";
        Node<T> newNode = head;

        if (!isEmpty()) {
            do {
                linkedListString += newNode.getElement().toString();
                if (newNode.getNext() != null) {
                    linkedListString += ", ";
                    //formats list
                } else {
                    linkedListString += "]";
                }
                newNode = newNode.getNext();
            }
            while (newNode != null);
        } else {
            linkedListString = "[]";
        }
        return linkedListString; //returns list as string when printed
    }


    // add a node at the front of the linked list, and makes it a new head
    //u could also set this up like addLast, but this is shorter
    public void addFirst(T element) {
        head = new Node<>(element, head); //create new head using the input as the element and place at top of list
        if (size == 0) {
            tail = head;// if the size of the list is already empty, the new head will be both the head and the tail
        }
        size++;// increased size to account for added element
    }

    // add a node at the tail of the linked list, and makes it a new tail
    public void addLast(T element) {
        Node<T> newest = new Node<>(element, null); //create new node to add to tail of list, using input as the element
        if (isEmpty())
            head = newest;//if list is already empty the added element will be both the head and the tail
        else
            //brings the newest to the back so it can be the tail
            tail.setNext(newest);
        tail = newest;//sets the newest to the new tail
        size++;//increases size to account for added element
    }

    public void enqueueAtTail(T element) {
        //calls on addLast to add an element at the end of the queue
        addLast(element);
    }

    public T dequeueAtHead() {
        //stores value of current head
        T answer = head.getElement();
        //calls on removeFirst to remove an element at the beginning of the queue
        removeFirst();
        System.out.print(answer);
        return answer;// returns value of old head

    }

    //searchStack(): search an element in the stack from the head to tail, and return an integer value of the position in the link list, if not found it will return zero
    public int searchStack(T search) {//call the input element we're looking for search
        Node<T> check = new Node<>();// create new Node check, which will go down the stack and check if the elements match the search
        check = head;//heads to see if element is at the head
        int i;
        for (i = 1; i <= size; i++) {
            if (search == check.getElement())//check is check == search
                break;// if yes break and return index
            check = check.getNext();//if not check the next element
        }
        if (i > size) {
            System.out.print("The value is not found!");//if entire stack is checked and no search match, return message
        } else {
            //if found, print found message
            System.out.print("\nThe value " + search + " is found in location " + i + " from the top of the stack");
        }

        return i;

    }

}
