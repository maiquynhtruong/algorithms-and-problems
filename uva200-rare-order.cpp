#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
string s1, s2;
bool visited['Z'+5];
vector< vector<int> > graph;
stack<int> s;
void topoSort(int i) {
	// cout << "i= " << i << "\n";
	visited[i] = true;
	vector<int>::iterator it;
	for (it = graph[i].begin(); it != graph[i].end(); it++) {
		if (!visited[*it]) {
			topoSort(*it);
		}
	}
	// cout << i << "\n";
	s.push(i);
	// cout << s.top() << " ";
}
int main() {
	// ifstream cin("mapping-the-route.in");
	// ofstream cout("mapping-the-route.out");
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	// cin.ignore();
	getline(cin, s1);
	for (int i = 0; i < 'Z'; i++) {
		vector<int> v;
		graph.push_back(v);
	}
	while (getline(cin, s2) && s2[0] != '#') {
		// cout << s1 << " and " << s2 << "\n";
		for (int i = 0; i < min(s1.size(), s2.size()); i++) {
			if (s1[i] != s2[i]) {
				// cout << s1[i] << "-->" << s2[i] << "\n";
				graph[s1[i]].push_back(s2[i]);
				break;
			}
		}
		s1 = s2;
	}
	
	for (int i = 'A'; i <= 'Z'; i++) {
		visited[i] = false;
	}
	for (int i = 'A'; i <= 'Z'; i++) {
		if (!visited[i] && graph[i].size() > 0) topoSort(i);
	}
	while (!s.empty()) {
		char c = s.top();
		cout << c;
		s.pop();
	}
	cout << "\n";
	return 0;
}
