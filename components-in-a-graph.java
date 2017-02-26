// https://www.hackerrank.com/challenges/components-in-graph

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UF uf = new UF();
        uf.init(2*n);
        for (int i = 1; i <=n; i++) {
            int g = sc.nextInt();
            int b = sc.nextInt();
            uf.union(g, b);
        }
        int maxSize = Integer.MIN_VALUE, minSize = Integer.MAX_VALUE;
        for (int i = 1; i <= 2*n; i++) {
            int p = uf.find(i);
            int s = uf.size[p];
            if (s > 1) {
                if (minSize > s) minSize = s;
                if (maxSize < s) maxSize = s;
            }
        }
        System.out.println(minSize + " " + maxSize);
    }
    
    static class UF {
    	static final int MAXN = 30001;
        int parent[] = new int[MAXN];
        int size[] = new int[MAXN];
        
        public void init(int n) {
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public void union(int u, int v) {
            int i = find(u);
            int j = find(v);
            // System.out.println("u= " + u + ", v= " + v + ", i= " + i + ", j= " + j);
            if (i == j) return;
            parent[i] = j;
            size[j] += size[i];
            // System.out.println("size[" + j + "]= " + size[j]);
            // if (size[j] > maxSize) maxSize = size[j];
            // if (size[j] < minSize) minSize = size[j];
        }
        public int find(int u) {
            if (parent[u] == u) return u;
            else return parent[u] = find(parent[u]);
        }
    }
}
