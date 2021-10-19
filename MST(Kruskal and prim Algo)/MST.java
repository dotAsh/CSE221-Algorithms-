import java.util.Arrays;
public class MST {
    Graph g;
    public MST(Graph graph){
        g = graph;
    }
    public void KruskalMST() {
        Edge result[] = new Edge[g.V];  
         
        for (int i = 0; i < g.V; ++i) {
            result[i] = new Edge();
        }
        Arrays.sort(g.edge);
        subset subsets[] = new subset[g.V];
        for (int i = 0; i < g.V; ++i) {
            subsets[i] = new subset();
        }
        for (int v = 0; v < g.V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        int  count = 0;
        int e = 0; 
        while (e < g.V - 1) {
            Edge next_edge = new Edge();
            next_edge = g.edge[count++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            
        }
        int total = 0;
        System.out.println("\n"+"by using Kruskal Algo");
        for (int i = 0; i < e; ++i) {
            total = total +result[i].weight;
            if(i!=e-1){
                System.out.print("("+placeName(result[i].src) + " -- "
                                     + placeName(result[i].dest) + " == " + result[i].weight+")"+" ,");
            }else{
                System.out.print("("+placeName(result[i].src) + " -- "
                                     + placeName(result[i].dest) + " == " + result[i].weight+")"+"\n"+"\n");
            }
        }
        System.out.println("total weight "+total);
        
    }
    public String placeName(int x){
        String d ="";
        if(x==0){
            d = "Dhaka";
        }else if(x == 1){
            d = "Chittagong";
        }else if(x == 2 ){
            d ="Barisal";
        }else if(x == 3 ){
            d = "Sylhet";
        }else if(x == 4 ){
            d = "Rajshahi";
        }else if(x == 5){
            d = "khulna";
        }
        return d;
    }    
    public int find(subset subsets[], int i) {    
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    public void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);        
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } 
        else {   
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    
    public  void primMST(int graph[][]) {
        int parent[] = new int[g.V]; 
        int key[] = new int [g.V]; 
        Boolean mstSet[] = new Boolean[g.V]; 
        for (int i = 0; i < g.V; i++) {
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
        key[0] = 0;    
        parent[0] = -1; 
        for (int count = 0; count < g.V-1; count++) {
            int u = minKey(key, mstSet); 
            mstSet[u] = true; 
            for (int v = 0; v < g.V; v++) 
                if (graph[u][v]!=0 && mstSet[v] == false && 
                    graph[u][v] < key[v]) {
                parent[v] = u; 
                key[v] = graph[u][v]; 
            } 
        } 
        printMST(parent, g.V, graph); 
    } 
    public int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int min_index=-1; 
        for (int v = 0; v < g.V; v++) 
            if (mstSet[v] == false && key[v] < min){ 
            min = key[v]; 
            min_index = v; 
        } 
        return min_index; 
    } 
    public void printMST(int parent[], int n, int graph[][]) {
        System.out.println("\n"+"by using Prim's Algo");
        int total = 0;
        for (int i = 1; i < g.V; ++i) {
            total = total +graph[i][parent[i]];
            if(i!=g.V-1){
                System.out.print("("+placeName(parent[i]) + " -- "
                                     + placeName(i) + " == " + graph[i][parent[i]]+")"+" ,");
            }else{
                System.out.print("("+placeName(parent[i]) + " -- "
                                     + placeName(i) + " == " + graph[i][parent[i]]+")"+"\n"+"\n");
            }
        }
        
        System.out.println("total weight "+total);
        
    } 
}