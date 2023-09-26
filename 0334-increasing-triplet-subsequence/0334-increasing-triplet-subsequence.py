# class Solution:
#     def increasingTriplet(self, nums: List[int]) -> bool:
#         # if len(nums) < 4 :
#         #     return nums.sort() == nums
#         # else
#             for i in enumerate(nums):
#                 for j in enumerate(nums[i[0]+1:]): # 2,3,4,5
#                     if len(nums[i[0]+1:])>2 and i[1] < j[1]: # i = 1 < j = 2
#                         for k in enumerate(nums[j[0]+1:]): 
#                             if j[1] < k[1]:
#                                 return True
class Solution:
    def increasingTriplet(self, nums):
        f = float('inf')
        s = float('inf')
        
        for n in nums:
            # If n is less than f, it means n can be a potential candidate for the first element of an increasing triplet subsequence. So, it updates f to n.
            if n <= f:
                f = n
            # If n is greater than f and less than s, it means n can be a potential candidate for the second element of an increasing triplet subsequence. So, it updates s to n.
            elif n <= s:
                s = n
            # If n is greater than both f and s, it indicates the presence of an increasing triplet subsequence. So, it returns True.
            elif n > s:
                return True
        
        # If the loop completes without finding an increasing triplet subsequence, it means there is no such subsequence in the array, so it returns False.
        return False