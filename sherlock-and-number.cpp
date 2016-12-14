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
		A[0] = 0;
		for (int i = 1; i <= k; i++) {
			cin >> A[i];
			// cout << A[i] << " ";
		}
		// cout << endl;
		sort(A, A + k + 1);
		// for (int i = 1; i <= k; i++) cout << A[i] << " "; cout << endl;
		
		int last = 0, sum = A[1] - A[0] - 1, i =10;
		while (sum < p && sum > 0) {
			i++;
			sum += A[i] - A[i-1] - 1;
			cout << i << ", sum= " << sum << endl;
		}
		
		sum -= A[i] - A[i-1] - 1;
		cout << A[i] + p - sum << endl;
	}
	return 0;
}
