
public class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
