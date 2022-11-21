package LA2Q1;

import java.util.*;


public class MadisonTestingSortingMethods {


    public static void main(String[] args) {
        header(2, 1);

        Integer[] sz = new Integer[5];
        Integer[] backup = new Integer[5];

        // create random object
        Random random = new Random();


        //populate first array with random values from  13 to 93 inclusive
        for (int i = 0; i < 5; i++) {
            sz[i] = random.nextInt(13, 93);
        }

        //copy sz into backup using system array copy
        System.arraycopy(sz, 0, backup, 0, sz.length);

        //create a List<> for the integer array to take advantage of toString() method
        List<Integer> list = Arrays.asList(sz);
        List<Integer> list1 = Arrays.asList(backup);

        System.out.println("Testing execution time of different sorting methods for sorting 5 random numbers: ");
        System.out.println("The unsorted list: " + list);

        long iterativeTimer = System.nanoTime();
        Collections.sort(list);
        long endTimeIterative = System.nanoTime();
        long time = endTimeIterative - iterativeTimer;
        double iterativeTimerDub = (double) time;


        //divide time by 1000000 to get into milliseconds from nano seconds
        System.out.printf("Collections' Sorting Time: %.2f milliseconds\n", iterativeTimerDub / 1000000);
        System.out.println("The sorted list using Collections' sort method: " + list);


        System.out.println("\nThe unsorted list: " + list1);
        double selectionTimer = (double) selectionSort(sz);
        System.out.printf("My Selection-Sort Time: %.2f milliseconds\n", selectionTimer * Math.pow(10, -6));
        System.out.println("The sorted list using selection-sort: " + list);
        System.arraycopy(backup, 0, sz, 0, sz.length);


        System.out.println("\nThe unsorted list: " + list1);
        double bubbleTimer = (double) bubbleSort(sz);
        System.out.printf("My bubble-Sort Time: %.2f milliseconds\n", bubbleTimer * Math.pow(10, -6));
        System.out.println("The sorted list using bubble-sort: " + list);
        System.arraycopy(backup, 0, sz, 0, sz.length);


        System.out.println("\nThe unsorted list: " + list1);
        double insertionTimer = (double) insertionSort(sz);
        System.out.printf("My insertion-Sort Time: %.2f milliseconds\n", insertionTimer * Math.pow(10, -6));
        System.out.println("The sorted list using insertion-sort: " + list);
        System.arraycopy(backup, 0, sz, 0, sz.length);


        //System.out.println("\nThe unsorted list: " + list1);
        double mergeTimer = (double) mergeSort(sz);
        System.out.printf("My merge-Sort Time: %.2f milliseconds\n", mergeTimer * Math.pow(10, -6));
        System.out.println("The sorted list using merge-sort: " + list);
        System.arraycopy(backup, 0, sz, 0, sz.length);


        System.out.println("\nThe unsorted list: " + list1);
        double quickTimer = (double) quickSort(sz, 0, sz.length - 1);
        System.out.printf("My quick-Sort Time: %.2f milliseconds\n", quickTimer * Math.pow(10, -6));
        System.out.println("The sorted list using quick-sort: " + list);
        System.arraycopy(backup, 0, sz, 0, sz.length);


        //System.out.println("\nThe unsorted list: " + list1);
        double bucketTimer = (double) bucketSort(sz, 0, sz.length - 1, 5);
        System.out.printf("My bucket-Sort Time: %.2f milliseconds\n", bucketTimer * Math.pow(10, -6));
        System.out.println("The sorted list using bucket-sort: " + list);
        System.arraycopy(backup, 0, sz, 0, sz.length);


        footer(2);

    }



    //accepts a generic array and returns the time elapsed in sorting the array
    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {

        // get current system time
        long t1 = System.nanoTime();


        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min].compareTo(a[j]) > 0) {
                    min = j;
                }
            }

            T temp = a[i];
            a[i] = a[min];
            a[min] = temp;

        }


        //  get current system time in nanoseconds
        long t2 = System.nanoTime();

        // get difference in times to get elapsed time.
        long Timer = (t2 - t1);

        return Timer;


    }


    //create bubbleSort method to sort and return time elapsed
    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {

        //// get current system time
        long t1 = System.nanoTime();



        //run through elements of array and compare values to rearrange
        for (int i = 1; i < a.length; i++) {

            for (int j = 0; j < a.length - i; j++) {

                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }

            }
        }


        //  get current system time nanoseconds
        long t2 = System.nanoTime();

        // get elapsed time.
        long Timer = (t2 - t1);

        return Timer;


    }

    //create insertion sort method to sort and return time
    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {

        //get current system time
        long t1 = System.nanoTime();


        //run through values
        for (int i = 1; i < a.length; i++) {
            // start at one because we can't compare from zero
            T key = a[i];
            for (int j = i - 1; j >= 0 && a[j].compareTo(key) == 1; j--) {
                a[j + 1] = a[j];
                a[j] = key;
            }

        }


        //  get time
        long t2 = System.nanoTime();


        long Timer = (t2 - t1);

        return Timer;


    }


    //create mergeSort to sort and return time
    public static <T extends Comparable<? super T>> long mergeSort(T[] S) {

        long t1 = System.nanoTime();

        int curr = S.length;
        if(curr<2){
            long t2 = System.nanoTime();
            return t1 - t2;
        }

        // divide by 2 to get the middle of the array
        int m = curr/2;

        // copy first and second halves of arrays
        T[] S1 = Arrays.copyOfRange(S,0,m);
        T[] S2 = Arrays.copyOfRange(S,m,curr);

        //divide and conquer with recursion
        mergeSort(S1);
        mergeSort(S2);

        int i =0, j=0;
        while(i+j<curr){
            if(j==S2.length || (i<S1.length && (S1[i].compareTo(S2[j])<0))) {
                //increment i
                S[i + j] = S1[i++];
            }else{
                //increment j
                S[i+j] = S2[j++];
            }
        }


        // take the second system time
        long t2 = System.nanoTime();
        // calculated the difference in system times for the elapsed time of the method
        long Timer = t2 - t1;
        // return the elapsed time in long format
        return Timer;


    }


    //create quickSort to sort and return time
    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b) {

        // get system time
        long t1 = System.nanoTime();

        if (a < b) {

            T pivot = s[b];

            int j = a - 1;
            for (int i = a; i < b; i++) {
                if (s[i].compareTo(pivot) < 0) {
                    j++;
                    //perform classic swap
                    T temp = s[i];//create temp for swapping
                    s[i] = s[j];
                    s[j] = temp;

                }

            }
            s[b] = s[j + 1];
            s[j + 1] = pivot;

            //call to make recursive
            quickSort(s, a, j);
            quickSort(s, j + 2, b);
        }




        long t2 = System.nanoTime();

        long Timer = t2 - t1;
        // return time
        return Timer;


    }

    //create bucketSort to sort and return time
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {

        // get time
        long t1 = System.nanoTime();

            //since radix is 10, create 10 buckets using vector assuming positive numbers
        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket
        for (int i = 0; i < 10; i++) {
            bucket[i] = new Vector<>();
        }
        for (int i = 0; i < maxDigits; i++) {
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }

            for (int index = first; index <= last; index++) {
                Integer d = DigitFinder(a[index], i);
                bucket[d].add(a[index]);
            }
            int index = 0;
            for (int k = 0; k < 10; k++) {
                for (int m = 0; m < bucket[k].size(); m++) {
                    a[index++] = bucket[k].get(m);
                }
            }
        }


        long t2 = System.nanoTime();

        long Timer = t2 - t1;
        // return time
        return Timer;
    }

        //extracts the ith digit from a decimal number
    public static Integer DigitFinder ( int num, int i){
        int t = 0;
        for (int w = 0; w <= i; w++) {
            t = num % 10;
            num = num / 10;
        }
        return t;
    }




        public static void header ( int num, int Q){
            System.out.printf("============================================================================================\n");
            System.out.printf("Lab Assignments %d-Q %d \nPrepared by: Madison Lo \n" +
                    "Student Number: 251244695 \nGoal of this Exercise: " +
                    "Working with double linked and nested lists. Also using comparable and comparator.", num, Q);
            System.out.printf("\n============================================================================================\n");
        }

        public static void footer ( int num){
            System.out.printf("\n============================================================================================\n");
            System.out.printf("Completion of Lab Assignment  %d is successful!", num);
            System.out.printf("\nSigning off - Maddy");
            System.out.printf("\n=============================================================================================\n");
        }
    }


