#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
int n, d[] = {0, 1, 5, 10, 25, 50};
long a[30005];
int main() {
	ifstream cin("let-me-count-the-ways.in");
	ofstream cout("let-me-count-the-ways.out");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    for (int j = 0; j <= 30005; j++) a[j] = 1;
    for (int i = 2; i <= 5; i++) {
    	for (int j = d[i]; j <= 30005; j++) {
    		a[j] += a[j-d[i]];
    	}
    	// for (int j = 0; j <= 20; j++) {
    	// 	cout << a[j] << " ";
    	// }
    	// cout << "\n";
    }
    while (cin >> n) {

    	if (a[n] == 1) {
    		cout << "There is only 1 way to produce " << n << " cents change.\n";
    	} else if (a[n] > 1) {
    		cout << "There are " << a[n] << " ways to produce " << n << " cents change.\n";
    	}
    }
}	
