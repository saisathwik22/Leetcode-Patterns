// Leetcode 283
// Brute Force :
// TC : O(2*N) | SC : O(number of non zero elements)
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                temp.add(nums[i]);
            }
        }
        int tempSize = temp.size();
        for(int i = 0; i < tempSize; i++) {
            nums[i] = temp.get(i);
        }
        for(int i = tempSize; i < n; i++) {
            nums[i] = 0;
        }
    }
}

// Optimal Approach : 
// TC : O(2*N)  SC : O(1);
class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                j = i;
                break;
            }
        }
        if(j == -1) return;
        for(int i = j + 1; i < n; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j += 1;
            }
        }        
    }
}
