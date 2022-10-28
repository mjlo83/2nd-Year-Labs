package Q1;

import javax.swing.*;
import java.util.Scanner;
import java.util.*;
import java.util.function.DoubleFunction;


public class TestingExecutionTime {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Formatter formatter = new Formatter();


        header(1,1);
        System.out.printf("\nEnter an integer number:\n");
        double n = input.nextDouble();
        while(n<0){
            System.out.print("Please enter a new positive integer: ");
             n = input.nextDouble();}
        double a = System.nanoTime();
        double fact =1;
        double i =1;
        while(i<=n) {
            fact = fact * i;
            i++;
        }
        double b = System.nanoTime();

        double d = System.nanoTime();
        factorialIterative(n);
        double f = System.nanoTime();

        double g = System.nanoTime();
        factorialRecursive(n);
        double h = System.nanoTime();


        System.out.printf("Factorial(%.0f) is %.0E"+formatter, n,factorialIterative(n));

        double  factTime= (b-a)/(Math.pow(10,9));
        System.out.printf("\nTime taken by iterative solution inside main: %.2E sec"+formatter, factTime);


        System.out.printf("\nFactorial(%.0f) with iterative method is %.0E "+formatter, n, factorialIterative(n));

        double iterTime = (f-d)/(Math.pow(10,9));
        System.out.printf("\nTime taken by iterative method call: %.2E sec"+formatter, iterTime);


        System.out.printf("\nFactorial(%.0f) with recursive call is %.0E"+formatter, n, factorialRecursive(n));

        double recurTime= (h-g)/(Math.pow(10,9));
        System.out.printf("\nTime taken by recursive method call: %.2E sec"+formatter, recurTime);




        footer(1);
        System.out.print(System.nanoTime());
        System.nanoTime();


    }


    public static void header(int num, int Q){
        System.out.printf("==========================================================\n");
        System.out.printf("Lab Exercise %d-Q %d \nPrepared by: Madison Lo \n" +
                "Student Number: 251244695 \n Goal of this Exercise: " +
                "Checking the code-execution time!",num,Q);
        System.out.printf("\n===========================================================");
    }

    public static double factorialIterative(double n){
        double result =1;
        double i=1;
        while(i<=n){
            result=result*i;
            i++;
        }
        return result;
    }

    public static double factorialRecursive(double n){
        if(n==0){
            return 1;}
        else{
            return n*factorialRecursive(n-1);
        }
    }




    public static void footer(int num){
        System.out.printf("\n==========================================================\n");
        System.out.printf("Completion of Lab Exercise %d is successful!",num);
        System.out.printf("\nSigning off - Maddy");
        System.out.printf("\n==========================================================\n");
    }

}

