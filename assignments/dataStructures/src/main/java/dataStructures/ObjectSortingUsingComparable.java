package dataStructures;

import java.util.Arrays;

public class ObjectSortingUsingComparable {

    public static void main(String[] args) {

    //sorting object array
    Employee1Comparable[] empArr = new Employee1Comparable[4];
    empArr[0] = new Employee1Comparable(10, "Mikey", 25, 10000);
    empArr[1] = new Employee1Comparable(20, "Arun", 29, 20000);
    empArr[2] = new Employee1Comparable(5, "Lisa", 35, 5000);
    empArr[3] = new Employee1Comparable(1, "Pankaj", 32, 50000);

    //sorting employees array using Comparable interface implementation
    Arrays.sort(empArr);
    System.out.println("\n Default Sorting of Employees list:\n"+Arrays.toString(empArr));

}
}