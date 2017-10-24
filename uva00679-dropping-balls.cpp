//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=620
#include <bits/stdc++.h>
using namespace std;
int test, D, maxNodes=1, ind;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	while (test--) {
		cin >> D >> ind;
		for (int i = 0; i < D; i++) maxNodes *= 2;
		maxNodes--;
		while (ball_pos < maxNodes) {
			if (nodes[ball_pos]) {
				nodes[ball_pos] = false;
				ball_pos = ball_pos*2;
			} else {
				nodes[ball_pos] = true;
				ball_pos = ball_pos*2+1;
			}
		}
		cout << ball_pos << "\n";
	}
	return 0;
}
