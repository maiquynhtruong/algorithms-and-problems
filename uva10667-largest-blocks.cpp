#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int p, s, b, r1, r2, c1, c2;
int a[105][105];
int main() {
    ifstream cin("largest_blocks.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> p;
    while (p--) {
    	cin >> s >> b;
    	for (int i = 1; i <= s; i++) fill(a[i], a[i]+s+1, 1);
    	for (int block = 1; block <= b; block++) {
    		cin >> r1 >> c1 >> r2 >> c2;
    		for (int i = r1; i <= r2; i++) {
    			for (int j = c1; j <= c2; j++) {
    				a[i][j] = 0;
    				// if (i > 0) a[i][j] += a[i-1][j];
    				// if (j > 0) a[i][j] += a[i][j-1];
    				// if (i > 0 && j > 0) a[i][j] -= a[i-1][j-1];
    			}
    		}
    	}
    	for (int i = 1; i <= s; i++) {
    		for (int j = 1; j <= s; j++) {
    			if (i > 1) a[i][j] += a[i-1][j];
    			if (j > 1) a[i][j] += a[i][j-1];
    			if (i > 1 && j > 1) a[i][j] -= a[i-1][j-1];
    		}
    	}
    	if (debug) {
    		for (int i = 1; i <= s; i++) {
    			for (int j = 1; j <= s; j++) {
    				cout << a[i][j] << " ";
    			}
    			cout << "\n";
    		}
    	}
    	int maxArea = 0, curSum=0, curArea = 0;
    	for (int i = 1; i <= s; i++) {
    		for (int j = 1; j <= s; j++) {
    			for (int k = i; k <= s; k++) {
    				for (int l = j; l <= s; l++) {
    					curSum = a[k][l];
    					if (i > 1) curSum -= a[i-1][l];
    					if (j > 1) curSum -= a[k][j-1];
    					if (i > 1 && j > 1) curSum += a[i-1][j-1];
    					if (curSum==(k-i+1)*(l-j+1)) {
    						if (debug) cout << "[" << i << ", " << j << "] -> [" << k << ", " << l << "]: " << curArea << "\n";
    						maxArea = max(maxArea, curSum);
    					}
    				}
    			}
    		}
    	}
    	
    	cout << maxArea << "\n";
    }
}
