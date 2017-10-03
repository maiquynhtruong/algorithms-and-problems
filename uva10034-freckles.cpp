#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
int n, test, mstCost;
vector<pair<int, int> > points;
vector<pair<int, pair<int, int> > > edges;
int parent[105], rank[105];

void makeSet(int x) {
	parent[x] = x;
	rank[x] = 0;
}
int find(int x) {
	while (x != parent[x]) {
		x = parent[x];
	}
	return x;
}

void union(int x, int y) {
	int xRoot = find(x), yRoot = find(y);
	if (xRoot == yRoot) return;
	// Attach smaller rank tree under root of high rank tree (Union by Rank)
	if (xRoot > yRoot) {
		parent[yRoot] = xRoot;
	} else {
		parent[xRoot] = yRoot;
		// If ranks are same, then make one as root and increment its rank by one
		if (rank[xRoot] == rank[yRoot]) rank[yRoot]++;
	} 
}
compare(pair<int, pair<int, int> > a, <pair<int, pair<int, int> > b) {
	return a.first > b.first;
}
int main() {
//ifstream cin("freckles.in");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> test;
    while (test--) {
    	cin >> n;
    	edges.clear(); points.clear();
    	edges.push_back(0, make_pair(0, 0)); points.push_back(make_pair(0, 0));
    	for (int i = 1; i <= n; i++) {
    		int u, v;
    		cin >> u >> v;
    		u *= 10; v *= 10;
    		for (int j = 1; j < points.size(); j++) {
    			int x = points[j].first - u, y = points[j].second - v;
    			edges.push_back(make_pair(x*x + y*y, make_pair(j, i)));
    		}
    		points.push_back(make_pair(i, make_pair(u, v)));
    	}
    	sort(edges.begin(), edges.end(), compare);
    	for (int i = 1; i < edges.size(); i++) {
    		if (find(edges[i].second.first) != find(edges[i].second.second)) {
    			mstCost += sqrt(edges[i].first);
    			unionSet(edges[i].second.first, edges[i].second.second);
    		}
    	}
    	cout << "Minimum Spanning Tree cost is " << mstCost << "\n";
    }
}
