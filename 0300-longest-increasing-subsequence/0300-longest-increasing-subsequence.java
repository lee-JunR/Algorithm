// 최장 증가 수열을 구하는 문제이다.
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 각 쌍은 최소 길이 1의 부분 수열이 된다
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    } 
        
}