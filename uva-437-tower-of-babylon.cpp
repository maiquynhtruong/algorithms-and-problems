#include <bits/stdc++.h> 
using namespace std;
// global variables
bool debug = false;
int n, area = 1000000, block = 1, size[100][3], x, y, z;
int main() {
    ifstream cin("babylon.inp");
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    while (cin >> n && n != 0) {
    	for (int i = 1; i <= n; i++) {
    		cin >> x >> y >> z;
    		int size1 = dim[i][1]*dim[i][2], size2= dim[i][1]*dim[i][3], size3 = dim[i][2]*dim[i][3];
    		size[block][1] = x; size[block][2] = y; size[block++][3] = z;
    		if (z != y) {size[block][1] = x; size[block][2] = z; size[block++][3] = y; }
    		if (x != y) {size[block][1] = y; size[block][2] = z; size[block++][3] = x; }
    	}	
    	// sort(size.begin(), size.end());
    	int LIS[block+5], maxH = 0;
    	for (int i = 1; i <= block; i++) {
    		for (int j = i-1; j >= 1; j--) {
    			if (size[j][1] > size[i][1] && size[j][2] > size[i][2] && LIS[j]+1 > LIS[i]) {
    				LIS[i] = LIS[j] + 1;
    				size[i][3] += size[j][3];
       			}
    		}
    		maxH = max(maxH, size[i][3]);
    	} 
    	cout << maxH << "\n";
    }
}
