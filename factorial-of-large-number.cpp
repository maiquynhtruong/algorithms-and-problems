#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int n, res[n+5], product, sz;
int main() {
	ifstream cin("diving-for-gold.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> n;
    res[1] = 1;
    sz = 1;
    for (int i = 2; i <= n; i++) {
    	carry = 0;
    	for (int s = 1; s <= sz; s++) {
    		product = res[s]*i + carry;
    		res[s] = product % 10;
    		carry = product / 10;
    	}
    	if (carry > 0) {
    		while (carry > 0) {
    			res[++sz] = carry % 10;
    			carry = carry / 10;
    		}
    	}
    }
    for (int i = 1; i <= sz; i++) cout << res[i];
}
