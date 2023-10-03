class Solution:
    def uniqueOccurrences(self, A):
        return sum(set(Counter(A).values())) == len(A)