#include <stdio.h>

int main() {
	int n, max = -1000000;
	fscanf(fin, "%d", &n);
	int bets[n], sum[n];
	for (int i = 0; i < n; i++) {
		fscanf(fin, "%d", &bets[i]);
		sum[i] += sum[i-1];
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i; j++)
			if (sum[i-1] - sum[j] > 0) 
				if (max < bets[i] + sum[i-1] - sum[j]) max = bets[i] + sum[i-1] - sum[j];
	}
	if (max < 0) printf("%s", "Losing streak");
	else printf("%d", max);
}
