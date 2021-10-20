
package knapsack;

// A Dynamic Programming based solution for 0-1 Knapsack problem 
public class Knapsack {
    // Driver program to test above function 

    public static void main(String args[]) {

        int[] valueArray = {60, 100, 120};
        int[] weightArray = {10, 20, 30};
        int maxWeight = 50;
        int numberOfElement = valueArray.length;
        System.out.println(knapSack(maxWeight, weightArray, valueArray, numberOfElement));
    }

    // A utility function that returns maximum of two integers 
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // Returns the maximum value that can be put in a knapsack of capacity W 
    public static int knapSack(int maxWeight, int[] weightArray, int[] valueArray, int numberOfElement) {

        int K[][] = new int[numberOfElement + 1][maxWeight + 1];

        // Build table K[][] in bottom up manner 
        for (int i = 0; i <= numberOfElement; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (weightArray[i - 1] <= w) {
                    K[i][w] = max(valueArray[i - 1] + K[i - 1][w - weightArray[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        

        return K[numberOfElement][maxWeight];
    }

}
