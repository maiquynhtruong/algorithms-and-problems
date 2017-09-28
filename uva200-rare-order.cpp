#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
string s1, s2;
void topoSort(int i, bool visited[], stack<int> s) {
	visited[i] = true;
	vector<int>::iterator it;
	for (it = graph[i].begin(); it != graph[i].end(); i++) {
		if (!visited[*it]) {
			topoSort(*it, visited, s);
		}
	}
	s.push(i);
}
int main() {
	int main() {
	ifstream cin("mapping-the-route.in");
	// ofstream cout("mapping-the-route.out");
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin.ignore();
	getline(cin, s1);
	for (int i = 0; i < 'Z'; i++) graph.push_back(vector<int>);
	while (getline(cin, s2) && s2[0] != '#') {
		for (int i = 0; i < min(s1.size(), s2.size()); i++) {
			if (s1[i] != s2[i]) {
				cout << s1[i] << "-->" << s2[i];
				graph[s1[i]].push_back(s2[i]);
				break;
			}
		}
		s1 = s2;
	}
	stack<int> main_stack;
	for (int i = 'A'; i <= 'Z'; i++) {
		visited[i] = false;
	}
	for (int i = 'A', i <= 'Z'; i++) {
		if (!visited[i]) topoSort(i, visited, stack);
	}
	while (!s.empty()) {
		cout << s.top() << " ";
		s.pop();
	}
	return 0;
}
