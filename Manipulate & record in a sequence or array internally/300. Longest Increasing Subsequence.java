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
