class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        zero_count = 0
        start = end = max_count = 0

        while end < len(nums):
            if nums[end] == 0:
                zero_count += 1

            while zero_count > 1:
                if nums[start] == 0:
                    zero_count -= 1
                start += 1

            max_count = max(max_count, end - start + 1)
            end += 1

        return max_count-1