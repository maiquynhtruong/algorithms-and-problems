#include <bits/stdc++.h> 
using namespace std;
// global variables
bool debug = false;
int n;
struct brick {
	int x, y, z;
	block(int a, int b, int c) {
		x = a; y = b; z = c;
	}
	bool operator < (brick b) const {
		if (x < b.x && y < b.y) return true;
		else return false;
	}
};
vector<brick> bricks;
int main() {
    //ifstream cin("babylon.inp");
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    while (cin >> n && n != 0) {
    	for (int i = 1; i <= n; i++) {
    		int x, y, z;
    		cin >> x >> y >> z;
    		bricks.push_back(x, y, z);
    		bricks.push_back(y, x, z);
    		bricks.push_back(x, z, y);
    		bricks.push_back(z, x, y);
    		bricks.push_back(y, z, x);
    		bricks.push_back(z, y, x);
    	}	
    	sort(bricks.begin(), bricks.end());
    	int num = bricks.size() + 5;
    	int LIS[num], totalMaxH = 0, maxH = 0;
    	fill(LIS, LIS + num, 1);
    	for (int i = 1; i <= num; i++) {
    		for (int j = i-1; j >= 1; j--) {
    			if (bricks[j].x > bricks[i].x && bricks[j].y > bricks[i].y && LIS[j]+bricks[i].z > LIS[i]) {
    				LIS[i] = LIS[j] + 1;
    				maxH = max(maxH, bricks[i].z + LIS[j]);
       			}
    		}
    		bricks[i] = maxH;
    		totalMaxH = max(totalMaxH, maxH);
    	} 
    	cout << totaMaxH << "\n";
    }
}
