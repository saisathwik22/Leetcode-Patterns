// leetcode 151
// Using in-built features of java
// TC : O(n) SC : O(n)
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);
            if(i > 0) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}

// using 2 pointer appraoch in O(1) space
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.trim().toCharArray();
        int n = arr.length;

        // Step 1: reverse the whole string
        reverse(arr, 0, n - 1);

        int i = 0, l = 0, r = 0;
        while (i < n) {
            // copy the word forward
            while (i < n && arr[i] != ' ') {
                arr[r++] = arr[i++];
            }

            if (l < r) {
                // reverse current word
                reverse(arr, l, r - 1);

                // only add space if more words exist ahead
                if (i < n) {
                    arr[r++] = ' ';
                }

                l = r; // next word start
            }

            i++; // skip spaces
        }

        // build string from valid part of arr
        return new String(arr, 0, r);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}

// Using 2 Pointer Approach - using StringBuilder
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.trim().toCharArray();
        int n = arr.length;

        // Step 1: reverse the whole string
        reverse(arr, 0, n - 1);

        int i = 0, l = 0, r = 0;
        StringBuilder result = new StringBuilder();

        while (i < n) {
            while (i < n && arr[i] != ' ') {
                arr[r++] = arr[i++];
            }

            if (l < r) {
                reverse(arr, l, r - 1);             // reverse current word
                result.append(arr, l, r - l);       // append word
                result.append(" ");                 // add space
                r++;                                // move pointer forward
                l = r;
            }

            i++;
        }

        // remove trailing space
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
