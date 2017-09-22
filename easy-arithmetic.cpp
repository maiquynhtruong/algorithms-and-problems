#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
char p, c, n;
queue<int> q;
int main() {
	ifstream cin("easy-arithmetic.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> c) {
    	if (c == '+') {
    		q.push_back(c);
    		while (cin >> c && '0' <= c && c <='9') {
    			q.push_back(c);
    		}
    	} else if (c == '-') {
    		q.push_back(c);
    		q.push_back('+');
    		while (cin >> c && '0' < c && c <='9') {
    			q.push_back(c);
    		}
    	} else {
    		if (c == '0') {
    			q.push_back(c);
    			q.push_back('+');
    		}
    		while (cin >> c && '0' < c && c <='9') {
    			q.push_back(c);
    		}
    	}
    }
    
}
