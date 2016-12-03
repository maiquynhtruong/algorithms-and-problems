// Basically the same problem as two rectangles overlapping but now count the number of windows (rectangles) that needs to be
// close in order to close the bottommost window. The close button is at the top right corner
// Input format: First line has N, number of windows. For the next N lines, there are 4 numbers in the ith line. u[i], v[i], x[i], y[i] 
// representing upper left coordinates (u[i], v[i]) and lower right coordinatese (x[i], y[i]) of the ith window 
// Example input:
// 3
// 1 4 7 1
// 2 5 6 2
// 2 9 5 7
// http://ideone.com/qc5ajc
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define MAXN 100
vector<int> ans;
int cnt = 0;
int x[MAXN], y[MAXN], u[MAXN], v[MAXN];
bool vis[MAXN]; // Not sure about the use of vis because once a window is on top of other windows, it is not likely to be behind 
		// any of those windows again
int n;
int a[MAXN][MAXN];
bool hidden(int i, int j) { // if window j hides window i
	if ((x[i] >= x[j] && x[i] <= u[j]) || (v[i] >= y[j] && v[i] <= v[j]))
		return true;
	else 
		return false;
}

void dfs(int i) {
	cnt++;
	// vis[i] = true;
	ans.push_back(i);
	for (int j = i+1; j < n; j++) 
		// if (!vis[j]) 
		if (a[i][j]) dfs(j);
}
int main() {
	cin >> n;
	
	for (int i = 0; i < n; i++) 
		cin >> u[i] >> v[i] >> x[i] >> y[i];
	dfs(0);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			if (hidden(i, j)) a[i][j] == true;
		vis[i] = false;
	}
	sort(ans.begin(), ans.end());
	cout << cnt << endl;
	for (vector<int>::iterator it = ans.begin(); it != ans.end(); ++it)
		cout << *it+1 << " ";
}
