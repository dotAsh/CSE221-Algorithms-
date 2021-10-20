package asssignment221;




import java.io.File;
import java.util.Scanner;

public class A {

    static int color[];

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\lenovo\\Desktop\\221 PRACTICE\\Asssignment221\\src\\asssignment221\\input.txt");
            process(file);
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
    }

    public static int dfs(int a[][], int N[]) {
        color = new int[a.length];
        int UndirecStConnectedCom = 0;
        for (int i = 1; i <a.length; i++) {
            if (color[i] == 0 && N[i]!=0) {
                UndirecStConnectedCom++;
                DfsVisit(i, a, N);
            }
        }
        return UndirecStConnectedCom;
    }

    public static void DfsVisit(int u, int a[][], int N[]) {
        color[u]++;
        for (int i = 1; i <a.length; i++) {
            if (a[u][i] == 1 && color[i] == 0 &&N[i]!=0) {
                DfsVisit(i, a, N);
            }
        }
        color[u]++;
    }

    public static void process(File f1) throws Exception {
        Scanner sc = new Scanner(f1);
        String s = sc.nextLine();
        String[] tempArray = s.split(" ");//A TEMPORARY  ARRAY TO GET THE INPUT FROM THE FILE PROPERLY 
        int node = Integer.parseInt(tempArray[0]);//TOAL NUMBER OF CITY
        int qInstruction = Integer.parseInt(tempArray[1]);//NUMBER OF INSTRUCTION
        int railway[][] = new int[node + 1][node + 1];//ADJ MATRIX OF RAILWAY; SIZE = NODE NUMBER +1 ;AS WE ARE AVOIDING INDEX NO ONE
        int road[][] = new int[node + 1][node + 1];//ADJ MATRIX OF ROAD

        int currentN []= new int[node+1];
        while (sc.hasNext()) {
            // THIS LINE WILL BE EXECUTE 8 TIME AS THE NUMBER OF INSTRUCTION WILL BE EIGHT
            s = sc.nextLine();//taking input ;eight instructions  
            tempArray = s.split(" ");
            int n1 = Integer.parseInt(tempArray[1]);
            int n2 = Integer.parseInt(tempArray[2]);
            currentN[n1] = n1;
            currentN[n2] = n2;
            if (Integer.parseInt(tempArray[0]) == 1) {
                // tempArray[0] = 1 ;considering as a railway
                railway[n1][n2]++;
                railway[n2][n1]++;
            } else if (Integer.parseInt(tempArray[0]) == 2) {
                //tempArray[0] = 2 ;considering as a road
                road[n1][n2]++;
                road[n2][n1]++;
            }
            int x = dfs(railway, currentN);
            /*RETURNS THE NUMBER OF STRONGLY CONNECTED COMPONENT OF 
               AN UNDIRECTED GRAPH AFTER EACH INSTRUCTIONS*/
            int y = dfs(road, currentN);
            if (x == 1 && y == 1) {
                /* x and y both are 1 means
                The transportation network is  balanced for the current number of city*/
                System.out.println("YES");
            } else {
                //if it is more than one for x or for y or both then the network is not balanced
                System.out.println("NO");
            }
        }
    }
}
