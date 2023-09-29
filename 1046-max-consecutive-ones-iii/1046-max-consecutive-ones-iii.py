''' 개선 전
class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:

        count = 0
        s, e = 0, 1
        max_count = 0
        while e <= len(nums):
            if nums[s:e].count(0) <= k:
                count  = (e-s)
                e += 1
                max_count = max(max_count, count)
            else :
                s+=1
        return max_count
'''
# 개선 후
class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        zero_count = 0
        start = end = max_count = 0

        while end < len(nums):
            if nums[end] == 0:
                zero_count += 1

            while zero_count > k:
                if nums[start] == 0:
                    zero_count -= 1
                start += 1

            max_count = max(max_count, end - start + 1)
            end += 1

        return max_count