#include <iostream>
using namespace std;
char grid[101][101];
int res[101][101];
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
int main() {
	int m, n;
	scanf("%d %d", &m, &n);
	for (int i = 1; i < n; i++)
		for (int j = 1; j < m; j++) {
			scanf("%c", &grid[i][j]);
			if (grid[i][j] == '.') {
				res[i][j] = 0;
				for (int d = 0; d < 4; d++) {
					res[i+dy[d]][j+dx[i]] = 1;
				}
			}
		}
	boolean done = false;
	while (!done) {
		done = true;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (res[i][j] > 0) {
					done = false;
					for (int d = 0; d < 4; d++) {
						if (grid[i+dy[d]][j+dx[i]] == 'T') res[i+dy[d]][j+dx[i]] = res[i][j]+1;
					}
				}
			}
		}
	}
	// print
	for (int i = 1; i < n; i++) {
		for (int j = 1; j < m; j++) {
			if (res[i][j] == 0) {
				printf(".%c", '.');
			} else {
				printf(".%d", res[i][j]);
			}
		}
		printf("%n");
	}
	return 0;
}
