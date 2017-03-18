// https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/practice-problems/algorithm/friendless-dr-sheldon-cooper-14/
class Edge implements Comparable{
    int u, v, w;
    public Edge(int u, int v, int w) {
        this.u = u; 
        this.v = v; 
        this.w = w;
    }
    public int compareTo(Edge other) {
        this.w - other.w;   
    }
}
class Solution {
    static int[] parent;
    static Edge
    public static void union(int u, int v) {
        int a = find(u);
        int b = find(v);
        if (a == b) return;
        parent[a] = b;
    }
    public int find(int u) {
        while (u != parent[u]) u = parent[u];
        return u;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for (int i = 0; i < a; i++) {
            
        }
    }
    
}
