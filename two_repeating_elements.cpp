// http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
#include <iostream>
#include <cmath>
using namespace std;

void checkRepeating1(int* arr, int size) {
	for (int i = 0; i < size; i++) {
		for (int j = i + 1; j < size; j++) {
			if (arr[i] == arr[j]) {
				cout << arr[i] << endl;
			}
		}
	}
}

int fact(int n) {
	return n == 0 ? 1 : n*fact(n-1);
}

/**
Use some math
Since there are n + 2 numbers with two repeating numbers, the other n numbers are consecutive, and we can find the sum 
with the formula n*(n+1)/2 and their product with the formula n!. Therefore, we can find the sum of x and y by subtracting sum of all
elements in the array from n*(n+1)/2 and dividing product of all elements in the array by n! to find product of two repeating numbers.
ONce we have that, we can find the difference by the formula x - y = sqrt(S^2 - 4*P). Once we nailed the sum and difference, finding 
the numbers is relatively easy.
**/
void checkRepeating2(int* arr, int size) {
	int sum = 0;
	int product = 1;
	int n = size - 2;
	
	for (int i = 0; i < size; i++) {
		sum += arr[i];
		product *= arr[i];
	}
	
	sum = sum - n * (n+1) / 2;
	product = product / fact(n);
	int difference = sqrt(sum*sum - 4*product);
	int first = (sum + difference) / 2;
	cout << first << endl;
	int second = (sum - difference) / 2;
	cout << second << endl;
}

void checkRepeating3(int* arr, int s) {
	int count[s-2];
	for (int i = 0; i < s; i++) count[arr[i]] = 0;
	for (int i = 0; i < s; i++) {
		if (count[arr[i]] == 0) count[arr[i]]++;
		else {
			cout << arr[i] << endl;
		}
	}
}

void checkRepeating4(int* arr, int s) {
	for (int i = 0; i < s; i++) {
		int index = abs(arr[i]);
		if (arr[index] > 0) arr[index] *= -1;
		else
			cout << index << endl;
	}
}

int main(int argc, char const *argv[])
{
	int arr[] = {1, 2, 7, 4, 7, 5, 3, 6, 4};
	int arrSize = sizeof(arr) / sizeof(arr[0]);
//	checkRepeating1(arr, arrSize);
	checkRepeating2(arr, arrSize);
	return 0;
}