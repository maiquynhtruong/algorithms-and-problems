#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
int parent[105], rnk[105];
 
void uf_makeset(int x) {
	parent[x] = x;
	rnk[x] = 0;
}
int uf_find(int x) {
	while (x != parent[x]) {
		x = parent[x];
	}
	return x;
}
void uf_union(int x, int y) {
	int rx = uf_find(x), ry = uf_find(y);
	if (rx == ry) return;
	// Attach smaller rank tree under root of high rank tree (Union by Rank)
	if (rx > ry) {
		parent[ry] = rx;
	} else {
		parent[rx] = ry;
		// If ranks are same, then make one as root and increment its rank by one
		if (rnk[rx] == rnk[ry]) rnk[ry]++;
	}
}
bool compare(pair<float, pair<int, int>> &a, pair<float, pair<int, int>> &b) {
	return a.first < b.first;
}
float euclidian(pair<float, float> &a, pair<float, float> &b) {
	float f = a.first - b.first, s = a.second - b.second;
	return sqrt(f*f + s*s);
}
int main() {
    int n, T;
    float u, v;
    scanf("%d", &T);
    while (T--) {
    	scanf("%d", &n);
    	vector<pair<float, float>> points; points.clear();
    
	for (int i = 0; i < n; i++) {
	            scanf("%f %f", &u, &v);
	            // printf("%.2f %.2f\n", u, v);
	            points.push_back(make_pair(u, v));
	}
 
        for (int i = 0; i < n; i++) uf_makeset(i);
    	
    vector<pair<float, pair<int, int> > > E; E.clear();
    vector<pair<float, pair<int, int> > > X; X.clear();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                E.push_back(make_pair(euclidian(points[i], points[j]), make_pair(i, j)));
            }
        }
        sort(E.begin(), E.end(), compare);
 
         for (int i = 0; i < E.size(); i++) {
            if (uf_find(E[i].second.first) != uf_find(E[i].second.second)) {
                X.push_back(E[i]);
                uf_union(E[i].second.first, E[i].second.second);
            }
        }
    	float mstCost = 0;
    	for (int i = 0; i < X.size(); i++) mstCost += X[i].first;
    	printf("%.2f\n", mstCost);
    	if (T > 0) cout << "\n";
    	
    }
}
