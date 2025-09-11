// leetcode 26
// brute force : Hash Set : does not preserve sorted order because its unordered.
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int k = set.size();
        int j = 0;
        for(int x : set) {
            nums[j++] = x;
        }
        
        return k;
    }
}

// Optimal Approach : Two Pointer
// TC : O(n) SC : O(1);
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;
        while(j < n) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            } else {
                j++;
            }
        }
        return i + 1;
    }
}
