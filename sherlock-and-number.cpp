// https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/sherlock-and-numbers/
#include <iostream>
#include <algorithm>
using namespace std;
int A[100005];

int main() {
	int T; cin >> T;
	while (T--) {
		int N, k, p;
		cin >> N >> k >> p;
		for (int i = 0; i < k; i++) {
			int m = 0; cin >> m;
			if (m= < p) p++;
		}
		if (p <= N) cout << p << endl;
		else cout << -1 << endl;
		
		
	}
	return 0;
}
