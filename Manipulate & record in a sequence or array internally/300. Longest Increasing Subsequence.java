/*
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * refer to https://algorithmsandme.com/longest-increasing-subsequence-in-onlogn/ for explanation. 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] a = new int[n];
        int len = 0;
        a[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            if (nums[i] < a[0]) {
                a[0] = nums[i];
            } else if (nums[i] > a[len]) {
                len++;
                a[len] = nums[i];
            } else {
                a[binarySearch(a, len, nums[i])] = nums[i];
            }
        }
        return (len + 1);

    }
    
    private int binarySearch(int[] nums, int end, int k) {
        int left = 0;
        int right = end;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (k < nums[mid]) {
                right = mid;
            } else if (k > nums[mid]) {
                left = mid;
            } else {
                return mid;
            }            
        }
        if (k > nums[left]) {
            return right;
        } else {
            return left;
        }
    }
}


//Time Complexity O(n^2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] pre = new int[n];
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            pre[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
