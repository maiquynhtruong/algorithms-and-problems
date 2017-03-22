// https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/practice-problems/algorithm/friendless-dr-sheldon-cooper-14/
class Edge implements Comparable{
    int u, v;
    public Edge(int u, int v) {
        this.u = u; 
        this.v = v; 
    }
}
class Solution {
    static int[] parent;
    static Edge[] edges;
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
        parent = new int[b];
        edges = new Edge[a];
        for (int i = 0; i < a; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[i] = new Edge(u, v);
        }
        int ans = 0;
        for (int i = 0; i < a; i++) {
            Edge e = edges[i];
            if (find(e.u) != find(e.v)) {
                ans++;
                union(e.u, e.v);
            }
        }
    }
    /**************
    Another way is the number of locations minus 1 because if each taxi stays in one city, then the minimum spanning tree has N-1
    vertices, i.e. only need to trust N-1 taxis.
    **************/
    
}
