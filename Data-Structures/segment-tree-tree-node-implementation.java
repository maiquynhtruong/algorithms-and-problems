public class NumArray {
    
    class SegmentTreeNode {
		int start, end; // range that the node covers
		SegmentTreeNode left, right;
		int sum;
		SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.sum = 0;
		}
	}
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length-1);
    }
    
    
    public SegmentTreeNode build(int[] arr, int start, int end) {
//         if (root != null) System.out.println("build1. start= " + root.start + ", end= " + root.end +	", sum= " + root.sum);
// 		else System.out.println("build1. null, start= " + start + ", end= " + end);
		if (start > end) { 
			return null;
		} else {
			SegmentTreeNode root = new SegmentTreeNode(start, end);
			if (start == end) {
				root.sum = arr[start];
			} else {
				int mid = (start + end) / 2;
				root.left = build(arr, start, mid);
				root.right = build(arr, mid+1, end);
				root.sum = root.left.sum + root.right.sum;
			}
// 			System.out.println("build2. start= " + start + ", end= " + end + ", sum= " + root.sum);
			return root;
		}
	} 
	
	
	public void update(SegmentTreeNode root, int i, int val) {
// 		if (root != null) System.out.println("update1. start= " + root.start + ", end= " + root.end +	", sum= " + root.sum);
// 		else System.out.println("update1. null");
		if (root.start == root.end) {
			root.sum = val;
// 			System.out.println("update2. start= " + root.start + ", end= " + root.end + 	", sum= " + root.sum + ", val= " + val);
		} else {
			int mid = (root.start + root.end) / 2;
			if (mid >= i) {
				update(root.left, i, val);
			} else {
				update(root.right, i, val);
			}
			root.sum = root.left.sum + root.right.sum;
// 			System.out.println("update3. start= " + root.start + ", end= " + root.end + 
// 		", sum= " + root.sum);
		}
	}
	
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    public int query(SegmentTreeNode root, int left, int right) {
// 		System.out.println("query. start= " + root.start + ", end= " + root.end + ", sum= " + root.sum);
		if (root.start > right || root.end < left) {
			return 0;
		} 
		if (root.end == right && root.start == left) {
			return root.sum;
		} 
		int mid = (root.start + root.end) / 2;
		if (mid >= right) {
		    return query(root.left, left, right);
		}
		if (mid < left) {
		    return query(root.right, left, right);
		}
		int leftSum = query(root.left, left, mid);
		int rightSum = query(root.right, mid+1, right);
		return leftSum + rightSum;
	}
	
    public int sumRange(int i, int j) {
        return query(root, i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
