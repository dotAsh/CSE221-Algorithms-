import java.util.Arrays;
public class SortTest{
public static void main(String[] args) {
       int a [] = {3, 5 , 10, 23, 25, 8, 7, 9, 50, 47};  
       
       MyArray myarr01 = new MyArray(a);
       myarr01.selectionSort();
       System.out.println("selection sort :"+myarr01);
       
       MyArray myarr02 = new MyArray(a);
       myarr02.quickSort(0,a.length-1);
       System.out.println("quick sort : "+myarr02);
       
       Arrays.sort(a);
       System.out.println(Arrays.toString(a));
    }

}