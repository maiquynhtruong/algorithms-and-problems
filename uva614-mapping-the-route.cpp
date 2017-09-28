#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
int n, m, sr, sc, er, ec, a[15][15], ans[15][15], test = 0;
bool visited[15][15];
int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
bool move(int i, int j, int num) {
	// cout << i << " " << j << " " << num << "\n";
	ans[i][j] = num;
	visited[i][j] = true;
	if (i == er && j == ec) {return true;}
	if (!visited[i-1][j] && (a[i-1][j] == 0 || a[i-1][j] == 1)) { // up
		if (move (i-1, j, num+1)) return true;
	}
	if (!visited[i][j-1] && (a[i][j-1] == 0 || a[i][j-1] == 2)) { // left
		if (move (i, j-1, num+1)) return true;
	}
	if ((a[i][j] == 0 || a[i][j] == 2) && a[i][j] != 3 && !visited[i][j+1]) { // right
		if (move (i, j+1, num+1)) return true;
	}
	if ((a[i][j] == 0 || a[i][j] == 1) && a[i][j] != 3 && !visited[i+1][j]) { // down
		if (move (i+1, j, num+1)) return true;
	}	 
	ans[i][j] = -1;
	return false;
}
int main() {
	ifstream cin("mapping-the-route.in");
	// ofstream cout("mapping-the-route.out");
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> n >> m >> sr >> sc >> er >> ec && n != 0 && m != 0 && sr != 0 && sc != 0 && er != 0 && ec != 0) {
    	for (int i = 0; i <= n+1; i++) {
    		a[i][0] = 1;
    		visited[i][0] = true;
    		visited[i][m+1] = true;
    	}
    	for (int j = 0; j <= m+1; j++) {
    		a[0][j] = 2;
    		visited[0][j] = true;
    		visited[n+1][j] = true;
    	}
    	for (int i = 1; i <= n; i++) {
    		for (int j = 1; j <= m; j++) {
    			visited[i][j] = false;
    			ans[i][j] = 0;
    			cin >> a[i][j];
    		}
    	}
    	move(sr, sc, 1);
    	cout << "Maze " << ++test << "\n\n+";
    	for (int j = 1; j <= m; j++) { cout << "---+"; }
    	cout << "\n";
    	for (int i = 1; i <= n; i++) {
    		cout << "|";
    		for (int j = 1; j <= m; j++) {
    			if (ans[i][j] == 0) {
    				cout << "   ";
    				if (a[i][j] == 1 || a[i][j] == 3 || j == m) cout << "|";
    				else cout << " ";
    			} else if (ans[i][j] == -1) { 
    				cout << "???";
    				if (a[i][j] == 1 || a[i][j] == 3 || j == m) cout << "|";
    				else cout << " ";
    			} else {
    				if (ans[i][j] < 10) cout << "  " << ans[i][j];
    				else if (ans[i][j] < 100) cout << " " << ans[i][j];
    				else cout << ans[i][j];
    				if (a[i][j] == 1 || a[i][j] == 3 || j == m) cout << "|";
    				else cout << " ";
    			}
    		}
    		cout << "\n+";
    		for (int j = 1; j <= m; j++) {
    			if (i == n) { 
    				cout << "---+";
    			} else {
    				if (a[i][j] == 2 || a[i][j] == 3) cout << "---+";
    				else cout << "   +";
    			}
    		}
    		cout << "\n";
    	}
    	cout << "\n\n";
    }
    
}
