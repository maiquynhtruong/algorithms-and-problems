#include <bits/stdc++.h> 
#define LL long long
#define maxN 400000 
using namespace std;
bool debug = false;
int test, n, m, parent[maxN], rank[maxN];
typedef struct {
	int x, y, z;
} Edge;
Edge edges[maxN];
bool comp(Edge &x, Edge &y) {
	if (x.z < y.z) return true;
	return false;
}
void initi(int n) {
	for (int i = 0; i <= n; i++) {
		parent[i] = i;
		rank[i] = 1;
	}
	edges.clear();
}
int findParent(int x) {
	while (x != parent[x]) x = parent[x];
	return x;
}
void uf_union(int x, int y) {
	int px = findParent(x), py = findParent(y);
	if (rank[px] > rank[py]) {
		parent[py] = px;
		rank[px] += rank[py];
	} else {
		parent[px] = py;
		rank[py] + rank[px];
	}
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int totalCost = 0, mspCost = 0;
    while (cin >> n >> m) {
    	initi(m);
    	for (int i = 1; i <= m; i++) {
    		cin >> edges[i].x >> edges[i].y >> edges[i].z;
    		totalDis += edges[i].z;
    	}
    	sort(edges, edges+m+1, comp);
    	for (int i = 1; i <= m; i++) {
    		int px = findParent(edges[i].x), py findParent(edges[i].y]);
    		if (px != py) {
    			mspCost += edges[i].z;
    			uf_union(px, py);
    		}
    	}
    	cout << totalCost - mspCost << "\n";
    }
}
