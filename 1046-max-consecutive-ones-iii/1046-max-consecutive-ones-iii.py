# class Solution:
#     def longestOnes(self, nums: List[int], k: int) -> int:

#         count = 0
#         s, e = 0, 1
#         max_count = 0
#         while e <= len(nums):
#             if nums[s:e].count(0) <= k:
#                 count  = (e-s)
#                 e += 1
#                 max_count = max(max_count, count)
#             else :
#                 s+=1
#         return max_count
class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        left=0
        count_zero=0
        max_array=0

        for right in range(len(nums)):
            if nums[right] == 0:
                count_zero+=1
            
            while count_zero > k:
                if nums[left] == 0:
                    count_zero-=1
                left+=1
            
            max_array=max(max_array,right-left+1)

        return max_array


        