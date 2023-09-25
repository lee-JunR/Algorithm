class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        nums_check = []
        answer = nums
        nums_mul = 1
        for i in range(len(nums)):
            if nums[i] != 0:
                nums_mul *= nums[i]
            else :
                nums_check.append(0)
                
        for i in range(len(nums)):
            if len(nums_check) > 1 :
                answer[i] = 0
            elif len(nums_check) == 1 and nums[i] != 0:
                answer[i] = 0
            elif nums[i] != 0:
                answer[i] = int(nums_mul/nums[i])
            else : # nums[i] == 0
                answer[i] = nums_mul
        
        return answer