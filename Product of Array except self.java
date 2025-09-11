// leetcode238
// TC : O(3N) SC : O(2N)
// if input array should not be tampered, store the final product in new array int[] result;
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n + 1];
        int[] rightProduct = new int[n + 1];

        leftProduct[0] = 1;
        rightProduct[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i -1];
        }
        for(int i = n-2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < n; i++) {
            nums[i] = leftProduct[i] * rightProduct[i];
        }

        return nums;
    }
}
