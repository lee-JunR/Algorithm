#개선 전
# class Solution:
#     def pivotIndex(self, nums: List[int]) -> int:
#         count = 0
#         if sum(nums[1:]) == 0 : return 0
#         else:
#             for i in range(1, len(nums)-1):
#                 if sum(nums[0:i]) == sum(nums[i+1:]):
#                     return i
#             if sum(nums[:len(nums)-1]) == 0 : return len(nums)-1
#             return -1
#개선 후
class Solution(object):
    def pivotIndex(self, nums):
        leftSum, rightSum = 0, sum(nums)
        for idx, ele in enumerate(nums):
            rightSum -= ele
            if leftSum == rightSum:
                return idx     
            leftSum += ele
        return -1       