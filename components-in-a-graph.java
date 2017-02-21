// https://www.hackerrank.com/challenges/components-in-graph

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g[] = new int[n+1];
        int b[] = new int[n+1];
        for (int i = 1; i <=n; i++) {
            g[i] = sc.nextInt();
            b[i] = sc.nextInt();
            union(g[i], g[i-1]);
            union(b[i], b[i-1]);
            union(g[i], b[i]);
        }
    }
    
    static class UF {
        int parent[] = new int[30001];
        int size[] = new int[30001];
        public UF(int n) {
            init(n);
        }
        public void init(int n) {
            for (int i = 0; i < n; i++) {
                parent[g[i]] = g[i];
                size[g[i]] = 1;
                parent[b[i]] = b[i];
                size[b[i]] = 1;
            }
        }
        public void union(int u, int v) {
            int i = find(u);
            int j = find(v);
            if (i == j) return;
            if (size[u] > size[v]) {
                parent[v] = parent[u];
                size[u] += size[v];
            } else {
                parent[u] = parent[v];
                size[v] += size[u];
            }
        }
        public int find(int u) {
            if (parent[u] == u) return u;
            else return parent[u] = find(parent[u]);
        }
    }
}
