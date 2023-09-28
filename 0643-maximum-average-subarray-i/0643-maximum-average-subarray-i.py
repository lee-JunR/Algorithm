class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        sum = 0
        for i in range(k):
            sum += nums[i]
        max_sum = sum
        for i in range(len(nums)-k+1):
            if sum > max_sum:
                max_sum = sum
            if i == len(nums)-k: break
            sum += nums[i+k]
            sum -= nums[i]
        return max_sum/k
