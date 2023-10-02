class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        sum = []
        for i in range(len(gain)):
            if i == 0:
                sum.append(gain[i])
                max_sum = sum[i]
            else:
                sum.append(sum[i-1]+gain[i])
                max_sum = max(max_sum, sum[i])
            
        if max_sum < 0:
            max_sum = 0
        return max_sum
            