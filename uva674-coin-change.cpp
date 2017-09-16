#include <bits/stdc++.h> 
using namespace std;
// global variables
bool debug = true;
int a, denominations = 4;
long dp[8000];
int c[5] = {5, 10, 25, 50};
int main() {
    ifstream cin("dollars.inp");
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    dp[0] = 1;
    for (int j = 0; j <= denominations; j++) {
        for (int i = c[j]; i <= a; i++) {
            dp[i]+=dp[i-c[j]];
        }
    }
    while (cin >> a) {
    	cout << dp[a] << "\n";
    }
}

 // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
 // 1 1 1 1 1 2 2 2 2 2 4  4  4  4  4  6  6  6  6  6  9
 
 // 10 = 1*5+5*1, 1*10, 		                        5*2,               10*1
 // 15 = 1*5+5*2, 1*10+5*1,            1*15,           5*3, 10*1+1*5,     10*1+5*1
 // 20 = 1*5+5*3, 1*10+5*2, 1*10+10*1, 1*15+5*1, 1*20, 5*4, 10*1+1*5+5*1, 10*1+5*2, 10*2
