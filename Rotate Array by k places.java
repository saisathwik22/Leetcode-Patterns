// Leetcode 189
// Brute force
// TC : O(3N) SC : O(N)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // kList includes elements that needs to be put in first k places
        // nonKList includes elements that are remaining after filling first k slots.
        List<Integer> kList = new ArrayList<>(); // elements from k+1 to n
        List<Integer> nonKList = new ArrayList<>(); // elements from 0 to k (n-k-1) 
        k = k % n; // normalize k
        for(int i = 0; i < n - k; i++) {
            nonKList.add(nums[i]);
        }
        for(int i = n - k; i < n; i++) {
            kList.add(nums[i]);
        }
        for(int i = 0; i < k; i++) {
            nums[i] = kList.get(i);
        }
        for(int i = k; i < n; i++) {
            nums[i] = nonKList.get(i - k);
        }
    }
}

// optimal approach
class Solution {
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start += 1;
            end -= 1;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
}

// [1,2,3,4,5,6,7] N = 7 , K = 3;
// reverse from index 0 to (N-1 = 6) inclusive | reverse from index 0 to 6
// [7,6,5,4,3,2,1]
// reverse from index 0 to (K-1 = 2) inclusive | reverse from index 0 to 2
// [5,6,7,4,3,2,1]
// reverse from index K to (N-1 = 6) inclusive | reverse from index 3 to 6
// [5,6,7,1,2,3,4]
