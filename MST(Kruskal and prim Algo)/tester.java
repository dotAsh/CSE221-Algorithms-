import java.io.File;
import java.util.Scanner;
public class tester{
    public static void main(String args[]){
        
        try{
            int a[][] = createAdjacencyMatrix(new File("input.txt"));
            int v = a.length;
            int edgeCount=0;
            for(int i = 0;i<a.length;i++){
                for(int j = 0;j<a.length;j++){
                    if(a[i][j]!=0){
                      edgeCount++;
                    }
                }
            }
           edgeCount = edgeCount/2;  //as the graph is undirected
           System.out.println(edgeCount);
            Graph g = new Graph(v,edgeCount);
            int count = 0;
            for(int i = 0;i<a.length;i++){
                for(int j = i+1;j<a.length;j++){
                    if(a[i][j]!=0){
                    g.edge[count].src = i;
                    g.edge[count].dest = j;
                    g.edge[count].weight = a[i][j];
                     count++;
                    }
                   
                }
            }
           
            MST mst = new MST(g);
            mst.KruskalMST();//Kruskal
            mst.primMST(a);//Prim's
        }catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
    public static int[][] createAdjacencyMatrix(File f1)throws Exception{
        Scanner sc = new Scanner(f1);
        String s = sc.nextLine();
        String tempArray[] = s.split(" ");
        int v = tempArray.length;
        int a[][] = new int [v][v];
        for(int i =0;i<a.length;i++){
            s = sc.nextLine();
            tempArray = s.split(" ");
            for(int j = 0;j<a.length;j++){
                a[i][j] = Integer.parseInt(tempArray[j]);
            }
        }
        return a;
    }
    
}        





