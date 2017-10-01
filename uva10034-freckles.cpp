#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
int n, test, mstCost;
vector<pair<int, int> > points;
vector<pair<int, pair<int, int> > > edges;
int main() {
	ifstream cin("freckles.in");
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
    			// edges.push_back(make_pair(x*x + y*y, make_pair(i, points[j].first)));
    		}
    		points.push_back(make_pair(i, make_pair(u, v)));
    	}
    	sort(edges.begin(), edges.end());
    	for (int i = 1; i < edges.size(); i++) {
    		pair<int, pair<int, int> > edge = edges[i];
    		if (!isSameSet(edges[i].second.first, edges[i].second.second)) {
    			mstCost += edges[i].first;
    			unionSet(edges[i].second.first, edges[i].second.second);
    		}
    	}
    	cout << "Minimum Spanning Tree cost is " << mstCost << "\n";
    }
}
