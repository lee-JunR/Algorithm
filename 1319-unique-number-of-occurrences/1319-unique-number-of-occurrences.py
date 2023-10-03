class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        count_arr = []
        for i in set(arr):
           count_arr.append(arr.count(i))
        return len(count_arr) == len(set(count_arr))