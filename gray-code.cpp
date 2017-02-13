//http://ideone.com/4myKSa
#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int n;
	cin >> n;
	int powN = (int) pow(2, n);
	int a[powN][n];
	int bit = 1;
	int col = n-1;
	for (int i = 0; i < powN; i++) 
	for (int j = 0; j < n; j++) a[i][j] = 0;
	for (int len = 2; len <= powN; len *= 2) {
		bit = 0;
		for (int row = 0; row < powN; row+=len) {
			// bit = !bit;
			for (int j = row; j < row + len/2; j++)
				a[j][col] = bit;
			bit = !bit;
			for (int j = row + len/2; j < row + len; j++)
				a[j][col] = bit;
		}	
		col--;
	}
	for (int i = 0; i < powN; i++) {
		for (int j = 0; j < n; j++)
			cout << a[i][j];
		cout << endl;
	}
}