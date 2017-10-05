#include <iostream>
using namespace std;
int test, n, k, a[100005];
int main() {
	cin >> test;
	while (test--) {
		cin >> n >> k;	
		int ans = k;
		set<int> next, cur;
		for (int i = 1; i <= n; i++) {
			cin >> a[i];
			cur.insert(a[i]);
		}
		// cur.insert(a[1]);
		for (int i = 2; i <= k; i++) {
			next.insert(a[i+k]);
		}
		vector<int> diff;
		for (int i = k+1; i <= n; i++) {
			set_difference(cur, cur+k, next, next+n, diff.begin());
			
		}
		
		
	}
	return 0;
}
