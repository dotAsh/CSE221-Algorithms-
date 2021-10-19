
package lab03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;

public class BFS {

    private Queue<Integer> queue;
    static int[] parent;
    static boolean hasCycle = false;
    static int countCycle = 0;

    public BFS() {

        queue = new LinkedList<Integer>();
    }

    public void bfs(int[][] adjacencyMatrix, int source) {

        int numberOfNodes = adjacencyMatrix.length - 1;

        int[] visited = new int[numberOfNodes + 1];

        int element;
        parent = new int[numberOfNodes + 1];

        visited[source] = 1;
        queue.add(source);

        while (!queue.isEmpty()) {

            element = queue.remove();
            System.out.print(element + "\t");

            int i = 1;
            while (i <= numberOfNodes) {
                if (adjacencyMatrix[element][i] == 1 && visited[i] == 1) {
                    hasCycle = true;
                    countCycle++;
                }
                if (adjacencyMatrix[element][i] == 1 && visited[i] == 0) {
                    parent[i] = element;
                    queue.add(i);
                    visited[i] = 1;
                }
                i++;
            }

        }

        System.out.println();
    }

    public static void main(String args[]) {

        int number_no_nodes;
        int source;
        Scanner scanner = null;

        try {

            scanner = new Scanner(System.in);

            int[][] adjacencyMatrix = buildAdjacencyMatrix(new File("input.txt"));

            System.out.println("Enter the source for the graph");
            source = scanner.nextInt();

            System.out.println("The BFS traversal of the graph is ");
            BFS bfs = new BFS();

            bfs.bfs(adjacencyMatrix, source);
            System.out.println();

            for (int i = 1; i < adjacencyMatrix.length; i++) {
                System.out.print(i + " : distance from source - " + distance(parent, source, i) + ", path -> ");
                printPath(parent, source, i);
                System.out.print("\n");
            }
            System.out.print("\n");

            MaxShortestDistance(parent, source);

            System.out.print("\n");
            if (hasCycle) {
                System.out.println("The current graph contains " + countCycle + " cycle(s).");
            } else {
                System.out.println("No cycle in the current graph");
            }

        } catch (Exception e) {

            System.out.println("Wrong Input Format");
        }
        scanner.close();

    }

    public static void MaxShortestDistance(int parent[], int source) {
        int max = distance(parent, source, 1);
        int maxNodeIndex = 1;
        for (int i = 2; i < parent.length; i++) {
            if (max < distance(parent, source, i)) {
                maxNodeIndex = i;
                max = distance(parent, source, i);
            }
        }
        System.out.print("(v1 : " + source + "," + "v2 : " + maxNodeIndex + ")" + " Distance :" + max + "; Path :");
        printPath(parent, source, maxNodeIndex);
        System.out.print("\n");
    }

    public static int distance(int[] parent, int source, int i) {
        if (i == source) {
            return 0;
        }
        return 1 + distance(parent, source, parent[i]);

    }

    public static void printPath(int[] parent, int source, int nodeIndex) {
        if (source == nodeIndex) {
            System.out.print(source);
            return;
        } else {
            printPath(parent, source, parent[nodeIndex]);
            System.out.print(" " + nodeIndex);
            return;
        }
    }

    public static int[][] buildAdjacencyMatrix(File f1) throws Exception {

        Scanner sc = new Scanner(f1);
        String s = sc.nextLine();
        int node = Integer.parseInt(s);
        s = sc.nextLine();
        int edge = Integer.parseInt(s);
        String[] tempArray;
        int a[][] = new int[node + 1][node + 1];
        for (int i = 0; i < edge; i++) {
            s = sc.nextLine();
            tempArray = s.split(" ");
            a[Integer.parseInt(tempArray[0])][Integer.parseInt(tempArray[1])]++;
        }
        return a;
    }

}
