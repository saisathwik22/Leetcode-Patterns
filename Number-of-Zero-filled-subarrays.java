// leetcode 2348
// number of subarrays of an array (length n) is n * (n + 1)/2;
// brute force - TC : O(n) and SC : O(1)
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int i = 0;
        while(i < n) {
            int count = 0;
            if(nums[i] == 0) {
                while(i < n && nums[i] == 0) {
                    i += 1;
                    count += 1;
                }
            } else {
                i += 1;
            }
            ans = ans + (count * (count + 1) / 2);
        }
        return ans;
    }
}

// Optimal - Observation
// TC : O(N) SC : O(1)
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long count = 0;
        long ans = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                count += 1;
            } else {
                count = 0;
            }
            ans += count;
        }
        return ans;
    }
}
