# class Solution:
#     def maxOperations(self, nums: List[int], k: int) -> int:
#         count = 0
#         for x in nums:
#             if (k-x) != x and x < k and nums.count(x) > 0 and nums.count(k-x) > 0 :
#                 nums.remove(x)
#                 nums.remove(k-x)
#                 count+=1

#             elif nums.count(x) > 1 and x +x == k :
#                 nums.remove(x)
#                 nums.remove(x)
#                 count+=1
#         return count
# 
class Solution: 
    def maxOperations(self, nums: List[int], k: int) -> int: 
        count = 0 
        num_count = collections.Counter(nums) 
        for x in nums: 
            if (k-x) != x and x < k and num_count[x] > 0 and num_count[k-x] > 0 : 
                num_count[x] -= 1 
                num_count[k-x] -= 1 
                count+=1 
            elif num_count[x] > 1 and x + x == k : 
                num_count[x] -= 2 
                count+=1 
        return count