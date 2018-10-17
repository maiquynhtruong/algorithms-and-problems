// https://uva.onlinejudge.org/external/105/10567.pdf
// https://ideone.com/hD8v4E
#include <iostream>
using namespace std;

int main() {
	string seq;
	int test = 0;
	
	cin >> seq >> test;
	
	while (test-- > 0) {
		string str;
		cin >> str;
		cout << billgates(seq, str) << "\n";	
	}
	
	return 0;
}

string billgates(string seq, string str) {
	
}
