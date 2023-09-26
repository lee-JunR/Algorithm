class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # for j in range(1,len(nums)):
        #     for i in range(len(nums)-j): 
        #         if nums[i] == 0:
        #             nums[i], nums[i+1] = nums[i+1], nums[i]
        n = len(nums)
        i = 0
        for j in range(n):
            if (nums[j] != 0):
                nums[i], nums[j] = nums[j], nums[i]
                i += 1