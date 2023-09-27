class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        res, l, r = 0, 0 ,len(nums) - 1

        while l < r:
            S = nums[l] + nums[r]
            if S > k:
                r -= 1
            elif S < k:
                l += 1
            else:
                res += 1
                l += 1
                r -= 1
        return res
# class Solution:
#     def maxOperations(self, nums: List[int], k: int) -> int:
#         count = 0
#         temp_nums = list(nums)
#         for x in nums:
#             if (k-x) != x and x < k and temp_nums.count(x) > 0 and temp_nums.count(k-x) > 0 :
#                 temp_nums.remove(x)
#                 temp_nums.remove(k-x)
#                 count+=1

#             elif temp_nums.count(x) > 1 and x +x == k :
#                 temp_nums.remove(x)
#                 temp_nums.remove(x)
#                 count+=1
#         return count

# class Solution: 
#     def maxOperations(self, nums: List[int], k: int) -> int: 
#         count = 0 
#         num_count = collections.Counter(nums) 
#         for x in nums: 
#             if (k-x) != x and x < k and num_count[x] > 0 and num_count[k-x] > 0 : 
#                 num_count[x] -= 1 
#                 num_count[k-x] -= 1 
#                 count+=1 
#             elif num_count[x] > 1 and x + x == k : 
#                 num_count[x] -= 2 
#                 count+=1 
#         return count