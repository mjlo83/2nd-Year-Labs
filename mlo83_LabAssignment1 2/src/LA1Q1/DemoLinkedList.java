package LA1Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;

public class DemoLinkedList {
    Scanner input = new Scanner(System.in);



    public DemoLinkedList() {
    }

    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        //populate and declare numbers and names from manual
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(56, -22, 34, 57, 98));
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));


        header(1, 1);

        System.out.print("\n\n\nThe given Integer array: " + numbers);
        System.out.print("\nThe given String array: " + names);
        //creating and populating the Integer linked list
        SinglyLinkList<Integer> sLL = new SinglyLinkList<>();
        for (int i = 0; i < numbers.size() - 2; i++) {
            sLL.addFirst(numbers.get(i)); //add first three
        }
        for (int i = numbers.size() - 1; i > 2; i--) {
            sLL.addLast(numbers.get(i)); //add last two
        }
        SinglyLinkList<String> people = new SinglyLinkList<>();
        for (int i = 0; i < numbers.size() - 2; i++) {
            people.addFirst(names.get(i));//add first three
        }
        for (int i = numbers.size() - 1; i > 2; i--) {
            people.addLast(names.get(i));//add last two
        }

        System.out.print("\nYour Integer list " + sLL);
        System.out.print("\nYour String list " + people);

        stackDemo(sLL); // call stackDemo

        queueDemo(people); // call queueDemo

        System.out.println("\nLet's search the Stack...");
        System.out.print("\nThe current stack: " + sLL);


        System.out.print("\n\nStack demo with the Integer linked list...");
        while(true) {
            System.out.print("\nEnter the value you are searching for: ");
            int value = input.nextInt();
            sLL.searchStack(value);//call searchStack

            System.out.print("\nDo you wish to continue? (enter 'y' for yes or enter an other key to discontinue)");
            char yes = input.next().charAt(0);

            if(yes != 'y') break;
        }






        footer(1);
    }
    public static void queueDemo(SinglyLinkList people){
        System.out.print("\n\n\nQueue demo with the String linked list ... ");
        System.out.print("\nNote: Head is the Q-front, and Tail is the Q-rear");
        System.out.print("\n\nLet's enqueue Joelle and Lukas in the queue in sequence ...");
        System.out.print("\n\nThe current Queue:" + people);
        people.enqueueAtTail("Joelle");//add Joelle to end of queue
        System.out.print("\n\nAfter Joelle is enqueued, the revise Queue : " + people);
        people.enqueueAtTail("Lukas");//add Lukas to end of queue
        System.out.print("\nAfter Lukas is enqueued, the revised Queue: " + people);
        System.out.print("\n\nLet's dequeue first three elements from the queue in sequence");
        System.out.print("\n\nThe current Queue is: " + people +"\n");// print current queue
        people.dequeueAtHead();//dequeue at head
        System.out.print(" has been dequeued! The revised queue: "+ people +"\n");
        people.dequeueAtHead();//dequeue at head
        System.out.print(" has been dequeued! The revised queue: "+ people +"\n");
        people.dequeueAtHead();//dequeue at head
        System.out.print(" has been dequeued! The revised queue: "+ people +"\n");


    }


    public static void  stackDemo(SinglyLinkList sLL) {

        Scanner input = new Scanner(System.in);
        System.out.print("\n\nStack demo with the Integer stack list . . .");

        System.out.print("\nWhich end of the Linked List would you like to use as the stack top?");
        while (true) {
            System.out.print("\nEnter 1 for head or 2 for tail: ");
            //validate user entered an integer
            boolean intVerify = input.hasNextInt();
            while (intVerify == false) {
                input.next();
                System.out.print("\nIncorrect input! Enter 1 for head or 2 for tail: ");
                intVerify = input.hasNextInt();

            }

            int choice = input.nextInt();
            boolean intVerify2 = false;
            while (true){
                //verify that the user has entered one of two
                if (choice == 1){

                    break;
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println("\nIncorrect input! Enter 1 for head or 2 for tail: ");

                    intVerify2 = input.hasNextInt();
                    while (intVerify2 == false) {
                        input.next();
                        System.out.print("\nIncorrect input! Enter 1 for head or 2 for tail: ");
                        intVerify2 = input.hasNextInt();

                    }

                    choice = input.nextInt();
                }
            }

            while(intVerify==true) {


                if (choice == 1) {// if user chooses one
                    System.out.print("\nStack Top: Head of the linked list ");
                    System.out.print("\n\nLet's pop all the elements from the stack in sequence: ");
                    System.out.print("\nThe current stack: ");
                    System.out.print("\n" + sLL +"\n");

                    for(int i =0; i< sLL.getSize() +4;i++){
                        sLL.popFromHead();
                        System.out.print(" has been popped! The Revised stack: " +sLL+'\n');
                    }
                    System.out.print("\nLet's push 39 and -58 in the stack...");
                    System.out.print("\nThe current stack: " + sLL);
                    sLL.pushAtHead(39);// add 39 to start of stack
                    System.out.print("\nAfter 39 is pushed, the revised stack: "+ sLL);
                    sLL.pushAtHead(-58);// add -58 to start of stack
                    System.out.print("\nAfter -58 is pushed, the revised stack: " +sLL);

                    break;



                }
                if (choice == 2) {
                    //if user chooses two
                    System.out.print("\nStack Top:Tail of the linked list");
                    System.out.print("\n\nLet's pop the first three the elements from the stack in sequence: ");
                    System.out.print("\nThe current stack: ");
                    System.out.print( sLL + "\n");
                    for(int j =0; j< 3; j++){//pop first last three elements of stack

                        sLL.popFromTail();
                        System.out.print(" has been popped! The Revised stack: " +sLL+'\n');
                    }
                    System.out.print("\nLet's push 39 and -58 in the stack...");
                    System.out.print("\nThe current stack: "+ sLL);
                    sLL.pushAtTail(39);//add 39 at end of stack
                    System.out.print("\nAfter 39 is pushed, the revised stack: "+ sLL);
                    sLL.pushAtTail(-58);//add -58 at end of stack
                    System.out.print("\nAfter -58 is pushed, the revised stack: "+ sLL);
                    break;


                }

            }
        break;

        }
    }









    public static void header(int num, int Q) {
        System.out.printf("============================================================================================\n");
        System.out.printf("Lab Assignment %d-Q %d \nPrepared by: Madison Lo \n" +
                "Student Number: 251244695 \nGoal of this Exercise: " +
                "Working with Stack and Queues using Single Linked Lists", num, Q);
        System.out.printf("\n============================================================================================");
    }

    public static void footer(int num) {
        System.out.printf("\n============================================================================================\n");
        System.out.printf("Completion of Lab Assignment %d is successful!", num);
        System.out.printf("\nSigning off - Maddy");
        System.out.printf("\n=============================================================================================\n");
    }
}