//http://www.math.bas.bg/infos/files/2010-08-16-Quality%20of%20Living.pdf
// https://luckytoilet.wordpress.com/2010/08/18/ioi-2010-quality-of-living/
#include <bits/stdc++.h> 
#define LL long long 
using namespace std;
bool debug = false;
int R, C, H, W, q[3005][3005];
int checkMedian(int mid) {
	int wsum[W+1];
	bool exists = false;
	for (int i =0; i <= R; i++) {
		for (int j = 0; j <= W; j++) {
			int temp = 0;
			if (q[i][j] > mid) temp = 1;
			else temp = -1;
			if (j == 0) wsum[i] = temp;
			else wsum[i] += temp;
		}
	}
	for (int j = W; j <= C; j++) {
		int sum = 0;
		for (int i = 0; i <= H; i++) {
			sum += wsum[i];
		}
		for (int i = H; i <= R; i++) {
			if (sum < 0) return -1;
			if (sum == 0) exists = true;//return 0;
			if (i != R) sum = sum + wsum[i] - wsum[i-H];
		}
		if (j != C) {
			for (int i = 0; i <= R; i++) {
				int temp = 0;
				if (q[i][j-W] > mid) temp = 1;
				if (q[i][j-W] < mid) temp = -1;
				wsum[i] = wsum[i] - temp;

				temp = 0;
				if (q[i][j] > mid) temp = 1;
				if (q[i][j] < mid) temp = -1;
				wsum[i] = wsum[i] + temp;
			}
		}
	}
	if (exists) return 1; // wait until now to make sure there are no negatives
	else return -1;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> R >> C >> H >> W;
    for (int i = 1; i <= R; i++) {
    	for (int j = 1; j <= C; j++) {
    		cin >> q[i][j];
    	}
    }
    int l = 1, r = R*C, mid = 0;
    while (l < r) {
    	mid = l + (r-l)/2;
    	int res = checkMedian(mid);
    	if (res == 0) { cout << mid << "\n"; break;}
    	if (res == -1) r = mid-1;
    	else l = mid+1;
    }
    cout << l << "\n";
}