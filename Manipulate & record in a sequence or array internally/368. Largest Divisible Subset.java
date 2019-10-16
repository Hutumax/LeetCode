class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] pre = new int[n]; //数组从小到大排序后，用pre[]记录对应每个位置的前一个符合subset要求的数字的index，类似于listnode中的prev指针作用。
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            pre[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
        }
        
        int max = 0;
        int max_i = 0; //记录符合条件最长subset的最后（最大）一个数的index。
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                max_i = i;
            }
        }
        
        while (pre[max_i] != max_i) {
            ans.add(nums[max_i]);
            max_i = pre[max_i];
        }
        ans.add(nums[max_i]);
        Collections.reverse(ans);
        return ans;
    }
}
