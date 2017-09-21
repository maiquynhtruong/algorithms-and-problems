// http://codeforces.com/gym/100801/attachments/download/3802/20152016-acmicpc-neerc-northern-subregional-contest-en.pdf
#include <iostream>
#include <fstream>
#include <string>

using namespace std;
bool debug = false;
double r, c, a[105][105];
int main() {
    //ifstream cin("lucky.in");
    //ofstream out("lucky.out");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> r >> c;
    for (int i = 1; i <= r; i++) {
    	for (int j = 1; j <= c; j++) {
    		cin >> a[i][j];
    	}
    }
    int totalWin = 0;
    for (int i = 1; i <= r; i++) {
    	for (int j = 1; j <= c; j++) {
    		int bet = a[i][j];
    		bool win1 = true, win2 = true, win3 = true, win4 = true;
    		for (int dr = 1; dr < i; dr++) if (a[dr][j] >= a[i][j]) win1 = false;
    		for (int dr = i+1; dr <= r; dr++) if (a[dr][j] >= a[i][j]) win2 = false;
    		for (int dc = 1; dc < j; dc++) if (a[i][dc] >= a[i][j]) win3 = false;
    		for (int dc = j+1; dc <=c; dc++) if (a[i][dc] >= a[i][j]) win4 = false;
    		if (win1) totalWin++; if (win2) totalWin++; if (win3) totalWin++; if (win4) totalWin++;
    	}
    }
    cout << totalWin << "\n";
}
