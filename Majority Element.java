// Majority Element 1 : > N/2 : only 1 ans possible at max
// Majority Element 2 : > N/3 : at max 2 ans possbile
// > N/k : at max (k-1) ans possible

// Majority Element 1 : Leetcode169
// Brute force
// TC : O(n * n) SC : O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(nums[j] == nums[i]) {
                    count += 1;
                }
            }
            if(count > n/2) return nums[i];
        }
        return -1;
    }
}

// Better Approach : HashMap
// TC : O(NlogN + N) SC : O(N)
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val + 1);
        }

        for(Map.Entry<Integer, Integer> it : map.entrySet()) {
            if(it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }
}

// Optimal Approach : Boyer Moore Voting Algorithm
// TC : O(2 * N) SC : O(1);
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1;
        int major = nums[0];
        for(int i = 1; i < n; i++) {
            if(count == 0) {
                major = nums[i];
                count = 1;
            } else if(nums[i] == major) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        int count1 = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == major) count1 += 1;
        }
        if(count1 > (n/2)) return major;
        return -1;
    }
}

// Majority Element 2 [more than N/3 times] : leetcode229
// Note : at max 2 possible answers (k=3 : k-1 = 2)
// Brute Force : TC = O(n*n) SC = O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(temp.size() == 0 || temp.get(0) != nums[i]) {
                int count = 0;
                for(int j = 0; j < n; j++) {
                    if(nums[j] == nums[i]) {
                        count += 1;
                    }
                }
                if(count > (n/3)) {
                    temp.add(nums[i]);
                }
            }
            if(temp.size() == 2) break;
        }
        return temp;
    }
}

// Better Approach : Hashing
// TC : O(n * logn) SC : O(n)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int leastOcc = (int)(n / 3) + 1;

        for(int i = 0; i < n; i++) {
            int val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val + 1);

            if(map.get(nums[i]) == leastOcc) {
                temp.add(nums[i]);
            }
            if(temp.size() == 2) break;
        }
        return temp;
    }
}

// Optimal Approach : Extended Boyer Moore Voting Algorithm
// TC : O(n + n) SC : O(1);
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int count1 = 0, count2 = 0;
        int major1 = Integer.MIN_VALUE, major2 = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(count1 == 0 && major2 != nums[i]) {
                count1 = 1;
                major1 = nums[i];
            } else if(count2 == 0 && major1 != nums[i]) {
                count2 = 1;
                major2 = nums[i];
            } else if(nums[i] == major1) {
                count1 += 1;
            } else if(nums[i] == major2) {
                count2 += 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }

        int freq1 = 0;
        int freq2 = 0;
        int leastOcc = (int)(n/3) + 1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == major1) freq1 += 1;
            else if(nums[i] == major2) freq2 += 1;
        }
        List<Integer> ans = new ArrayList<>();
        if(freq1 >= leastOcc) {
            ans.add(major1);
        }
        if(freq2 >= leastOcc) {
            ans.add(major2);
        }

        // if told to sort the ans array
        // Collections.sort(ans); TC : O(2*log2) ~ O(1)

        return ans;
    }
}
