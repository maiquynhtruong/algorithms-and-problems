// https://uva.onlinejudge.org/external/107/10706.pdf
// https://ideone.com/htgddt
#include <iostream>
using namespace std;

int main() {
	
	return 0;
}

int ithDigit() {
	
}

/**
 a: 1 12 123 1234 12345 123456 1234567 12345678 123456789 -> n(n+1)/2 digits
 Sum of n consecutive numbers starting at k: (n-k+1)*(n+k)/2, with k = above

 12345678910 1234567891011 until 1234567891011...9899 ->
 # of digits: (45+2)*(45+(2*(99-10)))/2, call this b
 
 1234567891011...9899100 1234567891011...9899101 until 1234567891011...9899100...999->
 # of digits: (b+3)*(b+(3*(999-100)))/2
 
 
 */
