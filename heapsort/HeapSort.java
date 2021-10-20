package heapsort;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HeapSort {

    /* Heap Sort Method. */
    public static void heapSort(int arr[]) {
        for (int i = arr.length - 1; i > 0; i--) {

            // Move current root to end 
            swap(arr, 0, i);

            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
        }
    }

    /* Method to build a heap. This method will maintain the heap properties.*/
    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 

        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        // If largest is not root 
        if (largest != i) {

            swap(arr, i, largest);
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest);
        }
        //TO DO        
    }

    /* Method to swap largest element in heap */
    public static void buildMaxheap(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) {

            heapify(arr, n, i);
        }

    }

    /*Method to increase the value of element at node i to key, and ensure the heap property of array */
    public static void heapIncreaseKey(int arr[], int i, int key) {
        if (key < arr[i]) {
            System.out.println("ERROR :new key is smaller than the current key.");
        } else {
            arr[i] = key;
            buildMaxheap(arr);
            heapSort(arr);
        }

    }

    /*Method to extract the largest element from heap Array */
    public static void heapExtractMax(int arr[], int size) {
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;
        heapify(arr, size - 1, 0);
    }

    /* Method to insert the key into the array maintaining the heap properties */
    public static int[] maxheapInsert(int arr[], int key) {

        arr = resize(arr);

        arr[arr.length - 1] = key;
        buildMaxheap(arr);
        heapSort(arr);

        return arr;

    }

    public static int[] resize(int[] arr) {
        int temp[] = new int[arr.length + 1];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        return temp;
    }


    /* Method to swap two numbers in an array */
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        try {
            int A[] = input("C:\\Users\\lenovo\\Desktop\\221 PRACTICE\\heapSort\\src\\heapsort\\input.txt");
            printArray(A);
            buildMaxheap(A);
            heapSort(A);
            printArray(A);
            // TO DO   
            // Read the "in.txt" file and store the random numbers in an array
            // display the unsorted array
            // build the max heap using heapify, buildMaxheap, sort methods
            // display the sorted array
            // call heapIncreaseKey() method
            heapIncreaseKey(A, 2, 532);
            printArray(A);

            //display the array after increasing a key
            //call maxheapInsert() method
            A = maxheapInsert(A, 123);
            printArray(A);
            //display the array after inserting a key
            //call heapExtractMax() method

            int Arraysize = A.length - 1;

            heapExtractMax(A, Arraysize);
            printArray(A);
            buildMaxheap(A);
            heapSort(A);
            printArray(A);
            //display the max value of the array
            //See the read file for the sample output.
        } catch (FileNotFoundException e) {
            System.out.println("Error :" + e);
        }
    }

    public static int[] input(String s) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(s));
        int size = sc.nextInt();
        int a[] = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }

    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.print("\n");
    }

}
