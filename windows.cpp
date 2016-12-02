// Not finished
// Basically the same problem as two rectangles overlapping but now count the number of windows (rectangles) that needs to be
// close in order to close the bottommost window. The close button is at the top right corner

#include <iostream>
using namespace std;
vector<int> v;
int count = 0;

bool overlap(int i, int j) {
	if ((x[i] >= x[j] && x[i] <= u[j]) || (v[i] >= y[j] && v[i] <= v[j]))
		return true;
	else 
		return false;
}

void dfs(int i) {
	count++;
	vis[i] = true;
	v.push_back(i);
	for (int j = i+1; j < n; j++) 
		if (!vis[j] && a[i][j])			
			dfs(j);
}
int main() {
	int n;
	cin >> n;
	int u[n], v[n], x[n], y[n];
	
	for (int i = 0; i < n; i++) 
		cin >> u[i] >> v[i] >> x[i] >> y[i];
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			if (overlap(i, j)) a[i][j] == true;
		
	for (vector<int>::iterator it = v.begin(); it != v.end(); ++it)
		cout << *it << " ";
}
