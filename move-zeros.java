public class Solution {		
    public void moveZeroes(int[] nums) {
        if (nums.length > 1) {
    		int count = 0;
    		for (int i = 0; i < nums.length; i++) {
    			if (nums[i] == 0)
    			    count++;
    		}
    		int i = 0;
    		while (i < nums.length - count) {
	            int j = 0;
			    while (j < nums.length) {
		            if (nums[j] != 0) {
		                nums[i] = nums[j];
	    		        i++;
		            }
			        j++;
			    }
	    		for (int k = nums.length - count; k < nums.length; k++) nums[k] = 0;
        	}
    	}
 	}

 	public void moveZeroesSolution(int[] nums) {
 		int lastNonZeroFound = 0;
 		for (int i = 0; i < nums.length; i++) {
 			if (nums[i] != 0) 
 				nums[lastNonZeroFound++] = nums[i];
 		}

 		for (int i = lastNonZeroFound; i < nums.length; i++) nums[i] = 0;
 	}

 	public void moveZeroesOptimal(int[] nums) {
 		int lastNonZeroFound = 0;
 		int cur = 0;
 		for (; cur < nums.length; cur++) {
 			if (nums[cur] != 0) {
 				int temp = nums[lastNonZeroFound];
 				nums[lastNonZeroFound++] = nums[cur];
 				nums[cur] = temp;
 			}
 		}
 	}
}