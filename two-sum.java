public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (hm.containsKey(c)) {
                int[] retVal = new int[] {hm.get(c), i};
                return retVal;
            }
            hm.put(nums[i], i);
        }
        return null;
    }
}
