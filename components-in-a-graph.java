// https://www.hackerrank.com/challenges/components-in-graph

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g[] = new int[n+1];
        int b[] = new int[n+1];
        UF uf = new UF();
        uf.init(g, b, n);
        for (int i = 1; i <=n; i++) {
            g[i] = sc.nextInt();
            b[i] = sc.nextInt();
            uf.union(g, b, g[i], g[i-1]);
            uf.union(g, b, b[i], b[i-1]);
            uf.union(g, b, g[i], b[i]);
        }
        System.out.println(UF.maxSize + " " + UF.minSize);
    }
    
    static class UF {
        int parent[] = new int[30001];
        int size[] = new int[30001];
        static int maxSize = 0, minSize = Integer.MAX_VALUE;
        public void init(int g[], int b[], int n) {
            for (int i = 0; i < n; i++) {
                parent[g[i]] = g[i];
                size[g[i]] = 1;
                parent[b[i]] = b[i];
                size[b[i]] = 1;
            }
        }
        public void union(int g[], int b[], int u, int v) {
            int i = find(u);
            int j = find(v);
            if (i == j) return;
            if (size[u] > size[v]) {
                parent[v] = parent[u];
                size[u] += size[v];
                if (size[u] > maxSize) maxSize = size[u];
                if (size[u] < minSize) minSize = size[u];
            } else {
                parent[u] = parent[v];
                size[v] += size[u];
                if (size[v] > maxSize) maxSize = size[v];
                if (size[v] < minSize) minSize = size[v];
            }
        }
        public int find(int u) {
            if (parent[u] == u) return u;
            else return parent[u] = find(parent[u]);
        }
    }
}
