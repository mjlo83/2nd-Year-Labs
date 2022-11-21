package LA2Q2;

import java.util.Arrays;

public class StudentGrade implements Comparable <StudentGrade> {
    // create fields
    private String firstName;
    private String lastName;
    private int grade;



    //empty constructor
    public StudentGrade(){}

    //constructor with parameters and fields
    public StudentGrade(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }


   //create getter methods
    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }



    //create setter methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }



    // CompareTo method
    public int compareTo(StudentGrade s2) {
        Integer gradeCompare = this.grade;
        int res = gradeCompare.compareTo(s2.getGrade());
        //returns 1 if bigger, -1 if smaller, 0 if the same
        return res;
    }



    // Override the toString method to match given output
    @Override
    public String toString() {
        return "\b\b\t" + String.format("%20s",firstName + " " + lastName) + ":\t" + grade + "\n";
    }


    //printArray, run through array and print in format
    public static void printArray(StudentGrade[] array) {
        for (int i = 0; i< array.length; i++) {
            System.out.printf("%10s %s\t:   \t%d\n", array[i].getFirstName(), array[i].getLastName(), array[i].getGrade());
        }
    }

}
