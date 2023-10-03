class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        len_nums = len(nums)
        count = 0
        for i in range(len_nums):
            for j in nums[i+1:]:
                if nums[i] == j:
                    count += 1
        return count