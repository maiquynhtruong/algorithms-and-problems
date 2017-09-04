#include <bits/stdc++.h>
using namespace std;
bool debug = false;
char grid[101][101];
int res[101][101];
int m, n;
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
int main() {
	ifstream cin("rings.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	cin >> n >> m;
	for (int i = 0; i <= n+1; i++) {
		for (int j = 0; j <= m+1; j++) {
			grid[i][j] = '.';
			if (i > 0 && i <= n && j > 0 && j <= m) cin >> grid[i][j];
		}
	}
	for (int i = 0; i <= n+1; i++) {
		for (int j = 0; j <= m+1; j++) {
			if (grid[i][j] == '.') {
				res[i][j] = 0;
				for (int d = 0; d < 4; d++) {
					if (grid[i+dy[d]][j+dx[d]] == 'T') res[i+dy[d]][j+dx[d]] = 1;
				}
			}
		}
	}

	if(debug) {
		for (int i = 0; i <= n+1; i++) {
			for (int j = 0; j <= m+1; j++) {
				cout << grid[i][j];
			}
			cout << "\n";
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				cout << res[i][j] << " ";

			}
			cout << "\n";
		}
	}
	bool done = false;
	int curNum = 1;
	while (!done) {
		done = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (res[i][j] == curNum) {
					for (int d = 0; d < 4; d++) {
						if (grid[i+dy[d]][j+dx[d]] == 'T' && res[i+dy[d]][j+dx[d]] == 0) {
							res[i+dy[d]][j+dx[d]] = curNum+1;
							done = false;
						}
					}
				}
			}
		}
		curNum++;
	}
	if(debug) {
		cout << "\n";
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				cout << res[i][j] << " ";

			}
			cout << "\n";
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (res[i][j] == 0) cout << '.' << '.';
			else cout << '.' << res[i][j];
		}
		cout << "\n";
	}
	return 0;
}
