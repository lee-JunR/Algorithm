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
# class Solution:
#     def longestOnes(self, nums: List[int], k: int) -> int:
#         left=0
#         count_zero=0
#         max_array=0

#         for right in range(len(nums)):
#             if nums[right] == 0:
#                 count_zero+=1
            
#             while count_zero > k:
#                 if nums[left] == 0:
#                     count_zero-=1
#                 left+=1
            
#             max_array=max(max_array,right-left+1)

#         return max_array


        