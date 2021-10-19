package lab01;

import java.io.*;
import java.util.*;

public class task01And02 {

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\lenovo\\Desktop\\221 PRACTICE\\lab01\\src\\lab01\\input.txt");
            int a[][] = buildAdjacencyMatrix(file);
            printAdjacencyMatrix(a);
            System.out.print("\n");
            printAdjacencyMatrixWithDirection(a);
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
    }

    public static int[][] buildAdjacencyMatrix(File f1) throws Exception {

        Scanner sc = new Scanner(f1);
        String s = sc.nextLine();
        int node = Integer.parseInt(s);
        s = sc.nextLine();
        int edge = Integer.parseInt(s);
        String[] tempArray;
        int a[][] = new int[node][node];
        for (int i = 0; i < edge; i++) {
            s = sc.nextLine();
            tempArray = s.split(" ");
            a[Integer.parseInt(tempArray[0])][Integer.parseInt(tempArray[1])]++;
        }
        return a;
    }

    public static void printAdjacencyMatrix(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.print("\n");
        }
    }
    
    
    public static void printAdjacencyMatrixWithDirection(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(j==0){
                  System.out.print(i+" ");
                }
                if(a[i][j]!=0){
                  System.out.print("-->"+j+" ");
                }
            }
            System.out.print("\n");
        }
    }
    
}
