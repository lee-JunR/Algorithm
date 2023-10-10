class Solution:
    def removeStars(self, s: str) -> str:
        a = []
        for i in range(len(s)):
            if s[i] == "*":
                a.pop()
            else:
                a.append(s[i])
        return ''.join(map(str, a))