# class Solution:
#     def maxVowels(self, s: str, k: int) -> int:
#         vowels = ['a','e','i','o','u']
#         count = 0

#         for i in range(k):
#             if s[i] in vowels:
#                 count +=1 
#         max_count = count
#         for i in range(len(s) - k + 1):
#             if s[i] in vowels:
#                 count += 1
#             if s[i-k] in vowels:
#                 count -= 1
#             max_count = max(max_count, count)
#         return max_count
class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        s_list = list(s)
        vowels = ['a', 'e', 'i', 'o', 'u']
        cnt = 0
        for i in range(k):
            if s_list[i] in vowels:
                cnt = cnt + 1
        max_num = cnt
        for end in range(k,len(s)):
            start = end - k + 1
            if s_list[start-1] in vowels:
                cnt = cnt - 1
            if s_list[end] in vowels:
                cnt = cnt + 1
            max_num = max(max_num, cnt)

        return max_num        