// leetcode 334
// i < j < k such that nums[i] < nums[j] < nums[k]

// TC : O(n) SC : O(1)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int z = nums[i];

            if(z <= x) {
                x = z;
            } else if(z <= y) {
                y = z;
            } else {
                return true;
            }
        }
        return false;
    }
}
