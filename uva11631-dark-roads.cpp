#include <bits/stdc++.h> 
#define LL long long
#define maxN 200000 
using namespace std;
bool debug = false;
int test, n, m, parent[maxN+5], r[maxN+5];
typedef struct {
	int x, y, z;
} Edge;
Edge edges[maxN];
bool comp(Edge &x, Edge &y) {
	if (x.z < y.z) return true;
	return false;
}
int findParent(int x) {
	while (x != parent[x]) x = parent[x];
	return x;
}
void uf_union(int x, int y) {
	int px = findParent(x), py = findParent(y);
	if (r[px] > r[py]) {
		parent[py] = px;
		r[px] += r[py];
	} else {
		parent[px] = py;
		r[py] + r[px];
	}
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> m >> n) {
        if (m == 0 && n == 0) break;
        int totalCost = 0, mspCost = 0, streetCount = m-1;
        parent[0] = n; r[0]=1;
    	for (int i = 1; i <= n; i++) {
            parent[i] = i;
            r[i] = 1;
    		cin >> edges[i].x >> edges[i].y >> edges[i].z;
    		totalCost += edges[i].z;
    	}
        // parent[n] = n; r[n]=1;
    	sort(edges+1, edges+n, comp);
    	// for (int i = 0; i < n && streetCount; i++) {
        for (int i = 1; i <= n && streetCount; i++) {
    		int px = findParent(edges[i].x), py = findParent(edges[i].y);
    		if (px != py) {
    			mspCost += edges[i].z;
    			uf_union(px, py);
                streetCount--;
    		}
    	}
    	cout << totalCost - mspCost << "\n";
    }
}
