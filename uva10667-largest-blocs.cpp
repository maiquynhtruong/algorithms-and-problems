#include <stdio.h>

int main() {
	int cases, size, blocks;
	int r1, r2, c1, c2;
	int map[][];
	while (cases--) {
		for (int i = r1; i <= r2; i++)
			for (int j = c1; j <= c2; j++) {
				map[i][j] = 1;
			}
		int max;
		int sum[size];
		for (int i = 0; i < size; i++) 
			for (int j = i; j < size; j++) 
				int length = j - i + 1, width;
				for (int k = 1; k < size; k++) {
					width++;
					sum[k] += !map[j][k];
					temp += sum[k];
					if (temp != length * width) {
						sum[k] = 0;
						temp = 0;
					} else {
						if (temp > max) max = temp;
					}	
				}
									
	}
}
