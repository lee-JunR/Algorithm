class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        set_arr = []
        for i in set(arr):
           set_arr.append(arr.count(i))
        return len(set_arr) == len(set(set_arr))