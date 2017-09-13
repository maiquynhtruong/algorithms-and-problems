#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int n, testcases, car, tc = 1;
int cars[2005];
int LIS[2005], LDS[2005];
int main() {
    //ifstream cin("trainsorting.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> testcases;
    while (tc++ <= testcases) {
    	if (debug) cout << "test: " << tc-1 << "\n";
    	cin >> n;
    	for (int i = 1; i <= n; i++) {
    		cin >> car;
    		cars[i] = car;
    		LIS[i] = 1; LDS[i] = 1;
    	}
    	for (int i = n-1; i >= 1; i--) {
    		for (int j = i+1; j <= n; j++) {
    			if (cars[j] < cars[i] && LIS[j]+1 > LIS[i]) {
    				LIS[i] = LIS[j]+1;
    			}
    		}
    	}
    	for (int i = n-1; i >= 1; i--) {
            for (int j = i+1; j <= n; j++) {
    			if (cars[i] < cars[j] && LDS[i] < LDS[j]+1) {
    				LDS[i] = LDS[j]+1;
    			}
    		}
    	}
    	if (debug) {
    		for (int i = 1; i <= n; i++) cout << cars[i] << " ";
    		cout << "\n";
    		for (int i = 1; i <= n; i++) cout << LIS[i] << " ";
    		cout << "\n";
    		for (int i = 1; i <= n; i++) cout << LDS[i] << " ";
    		cout << "\n";
    	}
    	int maxCar = 0;
    	for (int i = 1; i <= n; i++) {
    		maxCar = max(maxCar, LDS[i] + LIS[i] - 1);
    	}
    	cout << maxCar << "\n";
    }
}
