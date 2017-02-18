class UnionFind {
	public static void main(String[] args) {
		
	}
	public void init(int N) {
		count = N;
		id = new int[];
		for (int i = 0; i < N; i++) {
			id[i] = i;
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
	public void union(int[] arr, int u, int v) {
		int rootU = root(arr, u);
		int rootV = root(arr, v);
		arr[rootU] = rootV;
	}

}
