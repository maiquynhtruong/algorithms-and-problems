/**
Give you an array of 01. Find the minimum number of flipping steps so that the array meets the following rules:
The back of 1 can be either1 or 0, but0 must be followed by 0.

Notice: The length of the given array n <= 100000.

Example
Given array = [1,0,0,1,1,1], return 2.

Explanation:
Turn two 0s into 1s.
Given array = [1,0,1,0,1,0], return 2.

Explanation:
Turn the second 1 and the third 1 into 0.
**/

public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        int minFlips = nums.length+1, zeroes = 0, ones = 0;
        int[] numsOf0 = new int[nums.length], numsOf1 = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { zeroes++; }
            numsOf0[i] = zeroes;
            // System.out.print(zeroes + " ");
        }
        System.out.println();
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] == 1) { ones++; }
            numsOf1[i] = ones;
            // System.out.print(ones + " ");
        }
        for (int i = 0; i < nums.length-1; i++) {
            System.out.println(numsOf0[i] + ", " + numsOf1[i+1]);
        }
        // System.out.println("ones= " + ones + ", zeroes= " + zeroes);
        for (int i = 0; i < nums.length-1; i++) {
            if (numsOf0[i] + numsOf1[i+1] < minFlips) minFlips = numsOf0[i] + numsOf1[i+1];
        }
        return minFlips;
    }
}
