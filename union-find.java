class UnionFind {

	public static void main(String[] args) {
		int N = 10;
		int arr = new int[N];	
		int size = new int[N];
		init(arr, size, N);
	}
	public void init(int[] arr, int[] size, int N) {
		count = N;
		for (int i = 0; i < N; i++) {
			arr[i] = i;
			size[i] = 1;
		}
	}
	public boolean find(int u, int v) {
		if (root(u) == root(v)) {
			return true;
		} else {
			return false;
		}	
	}
	public int root (int[] arr, int i) {
		while (arr[i] != i) {
			i = arr[i];
		}
		return i;
	}
	public void union(int[] arr, int[] size, int u, int v) {
		int rootU = root(arr, u);
		int rootV = root(arr, v);
		if (size[rootU] < size[rootV]) {
			arr[rootU] = arr[rootV];
			size[rootV] += size[rootU];
		} else {
			arr[rootV] = arr[rootU];
			size[rootU] += size[rootV];	
		}
	}

}
