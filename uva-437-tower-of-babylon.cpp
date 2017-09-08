#include <bits/stdc++.h> 
using namespace std;
// global variables
bool debug = false;
int n, area = 1000000;
int dim[35][5];
int main() {
    ifstream cin("babylon.inp");
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    while (cin >> n && n != 0) {
    	x = {0}; y = {0}; z = {0};
    	for (int i = 1; i <= n; i++) {
    		cin >> dim[i][1] >> dim[i][2] >> dim[i][3];
    		L[dim[i][1]][dim[i][2]] = dim[i][3]; //L[y[i]][x[i]] = z[i];
    		L[dim[i][1]][dim[i][3]] = dim[i][2]; //L[z[i]][x[i]] = y[i];
    		L[dim[i][2]][dim[i][3]] = dim[i][1]; //L[z[i]][y[i]] = x[i];
    	}	
    	
    	int L[35][35] = {0}; // LIS[i][w][l] tallest tower with top block the ith block
    	// and surface of w*l; 
    	for (int i = 1; i <= n; i++) {
    		for (int j = 1; j <= n; j++) {
    			if (dim[i][1] < dim[j][1] && dim[i][2] < dim[j][2]) 
    				L[dim[i][1]][dim[i][2]] = L[dim[j][1]][dim[j][2]] + dim[i][3]; //L[y[i]][x[i]] = z[i];
    			if (dim[i][1] < dim[j][1] && dim[i][3] < dim[j][3])
    				L[dim[i][1]][dim[i][3]] = L[dim[j][1]][dim[j][3]] + dim[i][2]; //L[z[i]][x[i]] = y[i];
    			if (dim[i][2]] < dim[j][2] && dim[i][3] < dim[j][3])
    				L[dim[i][2]][dim[i][3]] = L[dim[j][2]][dim[j][3]] + dim[j][1];
    		}
    	}
    	int max = L[dim[n][1]][dim[n][2]];
    	if (max < L[dim[n][1]][dim[n][3]]) max = L[dim[n][1]][dim[n][3]];
    	if (max < L[dim[n][2]][dim[n][3]]) max = L[dim[n][2]][dim[n][3]];
    	cout << max;
    }
}
