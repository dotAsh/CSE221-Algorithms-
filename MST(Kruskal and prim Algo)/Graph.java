public  class  Graph{
    int V;
    int E;
    Edge edge[];
    public Graph(int v ,int e){
        V = v;
        E = e;
        edge = new Edge[E];
        for(int i =0;i<edge.length;i++){
            edge[i] = new Edge(); 
        }
    }
}