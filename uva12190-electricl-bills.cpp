//http://littlemod26.blogspot.com/2016/04/uva-12190-electric-bill.html
#include <bits/stdc++.h> 
#define ll long long
using namespace std;
bool debug = false;
int A, B, total;
bool calPrice(ll p) {
	ll total = 0;
	if (p <= 100) return p*2;
	total += 2*100;
	if (p <= 10000) return total + (p-100)*3;
	total += 3*(10000-100);
	if (p <= 1000000) return total + (p - 10000)*5;
	total += 5*(1000000-10000);
	return total + (p-1000000)*7;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> A >> B) {
    	if (A == 0 && B == 0) break;
    	ll l = 0, r = A, mid = 0, price = 0, diff = 0;
    	while (l < r) {
    		mid = l + (r-l)/2;
    		price = calPrice(mid);
    		if (price == A) break;
    		if (price < A) l = mid+1;
    		else r = mid-1;
    	}
    	l = 0, r = mid, price = mid;
    	while (l < r) {
    		mid = l + (r-l)/2;
    		ll a = calPrice(mid), b = calPrice(price-mid);
    		if (abs(a-b) == B) {cout << a << "\n"; break; }
    		if (a < b || a-b < B) l = mid+1;
    		else r = mid-1;
    	}
    	cout << 0 << "\n";
    }
}
