#include <stdio.h>

int main() {
	int n, max = -1000000;
	while (fscanf("%d", &n) == 1 && n > 0) {
		int bet, sum = 0;
		for (int i = 0; i < n; i++) {
			fscanf(fin, "%d", &bet);
			sum += bet;
			if (sum < 0) sum = 0;
			else if (max < sum) max = sum;
		}
	}
	if (max < 0) printf("%s", "Losing streak");
	else printf("%d", max);
}
