
package dfs;

import java.io.File;
import java.util.Scanner;

public class Dfs {

    static int color[];
    static int parent[];
    static int discoveryTime[];
    static int finishedTime[];
    static int time;
    static int a[][];
    static int d[];
    static int p[];
    static int k, j;

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\lenovo\\Desktop\\221 PRACTICE\\dfs\\src\\dfs\\input.txt");
            a = buildAdjacencyMatrix(file);
            
            System.out.print("\n");
            dfs();
            System.out.print("Discovered Nodes: ");
            for (int i = 0; i < a.length; i++) {
                System.out.print(d[i] + " ");
            }
            System.out.print("\n");
            System.out.print("Process Nodes: ");
            for (int i = 0; i < a.length; i++) {
                System.out.print(p[i] + " ");
            }
            System.out.print("\n");
            for (int i = 0; i < a.length; i++) {
                System.out.println("node no: " + i + " discovered time : " + discoveryTime[i] + " finished time : " + finishedTime[i]);
            }
            System.out.print("\n");

        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
    }

    public static void dfs() {
        color = new int[a.length];
        parent = new int[a.length];
        discoveryTime = new int[a.length];
        finishedTime = new int[a.length];
        d = new int[a.length];
        p = new int[a.length];
        time = 0;
        for (int i = 0; i < a.length; i++) {
            if (color[i] == 0) {
                DfsVisit(i);
            }
        }

    }

    public static void DfsVisit(int u) {
        color[u]++;
        time++;
        d[k++] = u;
        discoveryTime[u] = time;
        for (int i = 0; i < a.length; i++) {
            if (a[u][i] == 1 && color[i] == 0) {
                parent[i] = u;
                DfsVisit(i);
            }
        }
        color[u]++;
        p[j++] = u;
        finishedTime[u] = ++time;
    }

    public static int[][] buildAdjacencyMatrix(File f1) throws Exception {

        Scanner sc = new Scanner(f1);
        String s = sc.nextLine();
        int node = Integer.parseInt(s);
        s = sc.nextLine();
        int edge = Integer.parseInt(s);
        String[] tempArray;
        int a[][] = new int[node][node];
      while(sc.hasNext()) {
            s = sc.nextLine();
            tempArray = s.split(" ");
            a[Integer.parseInt(tempArray[0])][Integer.parseInt(tempArray[1])]++;
        }
        return a;
    }

    public static void printAdjacencyMatrix(int a[][]) {
        System.out.println("Adjacency Matrix");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.print("\n");
        }
    }

}
