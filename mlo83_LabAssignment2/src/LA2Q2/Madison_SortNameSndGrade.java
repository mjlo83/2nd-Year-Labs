package LA2Q2;

import java.util.Collections;
import java.util.Vector;

public class Madison_SortNameSndGrade {
    public static void main(String[] args) {

        //create 3 arrays with 8 first names, 8 last names, 8 randomly generated grades between 60-85
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        //create and populate randomized grades
        Integer[] grd = {(int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26)};


        // create a vector lass instance with sg using StudentGrade tag
        Vector<StudentGrade> sg = new Vector<>();

        // add each StudentGrade object to the Vector class with its add method
        StudentGrade s1 = new StudentGrade(fnArray[0], lnArray[0], grd[0]);
        sg.add(s1);
        StudentGrade s2 = new StudentGrade(fnArray[1], lnArray[1], grd[1]);
        sg.add(s2);
        StudentGrade s3 = new StudentGrade(fnArray[2], lnArray[2], grd[2]);
        sg.add(s3);
        StudentGrade s4 = new StudentGrade(fnArray[3], lnArray[3], grd[3]);
        sg.add(s4);
        StudentGrade s5 = new StudentGrade(fnArray[4], lnArray[4], grd[4]);
        sg.add(s5);
        StudentGrade s6 = new StudentGrade(fnArray[5], lnArray[5], grd[5]);
        sg.add(s6);
        StudentGrade s7 = new StudentGrade(fnArray[6], lnArray[6], grd[6]);
        sg.add(s7);
        StudentGrade s8 = new StudentGrade(fnArray[7], lnArray[7], grd[7]);
        sg.add(s8);


        // print the unsorted array
        System.out.println("The Unsorted Array..........\n" + sg + "\b\b");

        // Print sorted array with Collections.sort(sg)
        Collections.sort(sg); // sort the array by the grade values
        System.out.println("Sorted by Grades..........\n" + sg + "\b\b");



        //create an array of Student Grade type with the length of fnArray created
        StudentGrade[] students = new StudentGrade[fnArray.length];
        //use vector's copyInto array to copy sg into students
        sg.copyInto(students);


        //sort first names with insertion sort and print to match output
        insertionSort(students, 1);
        System.out.println("Sorted by First Names..........");
        printArray(students);


        //sort last names with insertion sort and print to match output
        insertionSort(students, 2);
        System.out.println("\nSorted by Last Names..........");
        printArray(students);
        System.out.print("\n");

        //call footer
        footer(2);
    }

    //print array to loop through array and print to match sample output
    public static void printArray(StudentGrade[] array){

        for(int i = 0; i <array.length; i++){
            System.out.printf("%10s %s\t:   \t%d\n", array[i].getFirstName(), array[i].getLastName(), array[i].getGrade());

        }
    }

    //similar to question 1 put tweaked to match question 2
    public static StudentGrade[] insertionSort(StudentGrade[] a, int which) {

        if (which == 1) {
            for (int i = 1; i < a.length; i++) {
                StudentGrade key = a[i];

                // check if value is greater, if it is switch position
                for (int j = i - 1; j >= 0 && (a[j].getFirstName().compareTo(key.getFirstName()) > 0); j--) {
                    // switch the index positions
                    a[j + 1] = a[j];
                    // replace with key
                    a[j] = key;
                }
            }

        }


        if (which == 2) {
            for (int i = 1; i < a.length; i++) {
                StudentGrade key = a[i];

                // run through if value is greater, switch positions
                for (int j = i - 1; j >= 0 && (a[j].getLastName().compareTo(key.getLastName()) > 0); j--) {

                    a[j + 1] = a[j];
                    //replace with temporary
                    a[j] = key;
                }
            }

        }

        //return sorted array
        return a;


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
