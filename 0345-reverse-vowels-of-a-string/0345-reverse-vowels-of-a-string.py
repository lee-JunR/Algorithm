class Solution:
    def reverseVowels(self, s: str) -> str:
        m = []
        s1 = ''
        for i in range(len(s)):
            if s[i] in ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'):
                m.append(s[i])
        for i in range(len(s)):
            if s[i] in ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'):
                s1 += m.pop()
            else : s1 += s[i]
        return s1