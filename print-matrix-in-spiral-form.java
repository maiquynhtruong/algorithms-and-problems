// Not finished
class Ideone {
	public static int[] spiralCopy(int[] mat) {
		int top = 0, bottom = mat.length-1, left = 0, right = mat[0].length-1;
		int index = 0;
		int[] res = new int[mat.length*mat[0].length];
		while(index < mat.length*mat[0].length) {
			for (int i = left; i <= right; i++) {
				res[index++] = mat[top][i];
			}
			for (int i = top+1; i <= bottom; i++) {
				res[index++] = mat[i][right];
			}
			for (int i = right-1; i >= left; i--) {
				res[index++] = mat[bottom][i];
			}
			for (int i = bottom-1; i >= top-1; i--) {
				res[index++] = mat[i][left];
			}
			left++; right--; top++; bottom--;
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		int[] inputMatrix  = {{1,    2,   3,  4,    5},
				      {6,    7,   8,  9,   10},
				      {11,  12,  13,  14,  15},
				      {16,  17,  18,  19,  20}};
		
	}
}

/**

a[0][0] = 1
a[0][1] = 2
a[0][2] = 3
a[0][3] = 4
a[0][4] = 5
a[1][4] = 10
a[2][4] = 15
a[3][4] = 20
a[3][3] = 19
a[3][2] = 18
a[3][1] = 17
a[3][0] = 16
a[2][0] = 11
a[1][0] = 6
a[1][1] = 7
a[1][2] = 8
a[1][3] = 9
a[2][3] = 14
a[2][2] = 13
a[2][1] = 12

**/
