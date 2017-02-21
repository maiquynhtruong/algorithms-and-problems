// https://www.hackerrank.com/challenges/merging-communities

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        UF uf = new UF(n);
        uf.init(n);
        for (int i = 0; i < q; i++) {
            String op = sc.next();
            if (op.equals("M")) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                uf.union(u, v);     
            } else if (op.equals("Q")) {
                int u = sc.nextInt();
                int root_u = uf.find(u);
                System.out.println(uf.size[root_u]);
            }
        }
    }
    static class UF {
    int parent[];
    int size[];
    public UF(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        init(n);
    }
    public void init(int n) {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public void union(int u, int v) {
        int i = find(u);
        int j = find(v);
        if (i == j) return;
        if (size[i] > size[j]) {
            parent[j] = parent[i];
            size[i] += size[j];
        } else {
            parent[i] = parent[j];
            size[j] += size[i];
        }
    }
    public int find(int u) {
        if (u == parent[u]) return u;
        else return parent[u] = find(parent[u]);
    } 
}
    
}
