package Q2;


import java.util.Scanner;

public class WrkingWithArrays {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        header(1, 2);
        Scanner input = new Scanner(System.in);
        System.out.printf("\nEnter array size: ");
        int size = input.nextInt();
        int Array[] = new int[size];
        double newArray[] = new double[size];

        int minVal = Array[0];
        int maxVal = Array[0];
        mma5methodYourFirst(Array);
        System.out.printf("\nHere is the result...\n");
        int num = fives(Array);
        setZero(Array);
        print(num,Array);
        YourStudentNumber(251244695);
        footer(2, 2);


    }

    public static int fives(int[] myArray) {
        int divFive = 0;
        for (int i = 0; i < myArray.length; i++) {

            if (myArray[i] % 5 == 0) {
                divFive++;
            }
        }
        return divFive;
    }

    public static int setZero(int myArray[]) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] % 5 != 0) {
                myArray[i] = 0;
            }
        }
        return 6;
    }

    public static double averageValue(int num, int myArray[]) {
        double total = 0;
        for (int i = 0; i < myArray.length; i++) {

            total += myArray[i];
        }
        if (fives(myArray) == 0) {
            total = 0.00;
        }
        if (fives(myArray) != 0) {
            total = total / num;
        }
        return total;
    }

    public static void print(int num, int Array[]) {
        if (num != 0) {

            System.out.printf("\nFound " + num + " numbers that are divisible by 5 ");
            System.out.printf("\nThe max is %.2f", maxValue(Array));
            System.out.printf("\nThe min is %.2f", minValue(Array));
            System.out.printf("\nThe average of the numbers divisible by 5 is: %.2f", (averageValue(num, Array)));


        }
        if (num == 0) {
            System.out.print("\nIn the array, there was no number divisible by 5");
        }
    }

    public static void YourStudentNumber(int stuNum) {
        System.out.printf("\nMy student number is " + stuNum);
    }


    int n = input.nextInt();

    public static void mma5methodYourFirst(int myArray[]) {
        Scanner input = new Scanner(System.in);
        int size = myArray.length;


        for ( int i = 0; i < myArray.length; i++) {
            System.out.printf("Enter value %d: ", (i + 1));
            myArray[i] = input.nextInt();

        }

    }

    public static double maxValue(int [] myArray){
        int max = myArray[0];
         for(int i = 0; i< myArray.length; i++){
            if (myArray[i]> max && myArray[i] !=0) {
                max =myArray[i];
            }
        }
            return max;
     }



    public static double minValue(int [] myArray){
    int min = myArray[0];
    for(int i = 0; i< myArray.length;i++){
     min = myArray[i];
    if(myArray[i] < min && myArray[i] !=0) {
     min = myArray[i];
    }
    }
    return min;
    }
    public static void header ( int num, int Q){
        System.out.printf("==========================================================\n");
        System.out.printf("Lab Exercise %d-Q %d \nPrepared by: Madison Lo \n" +
                "Student Number: 251244695 \n Goal of this Exercise: " +
                "Working with arrays and conditional statements!", num, Q);
        System.out.printf("\n===========================================================");
    }
    public static void footer ( int num, int q){
        System.out.printf("\n==========================================================\n");
        System.out.printf("Completion of Lab Exercise %d - Q %d is successful!", num, q);
        System.out.printf("\nSigning off - Maddy");
        System.out.printf("\n==========================================================\n");
    }


}




