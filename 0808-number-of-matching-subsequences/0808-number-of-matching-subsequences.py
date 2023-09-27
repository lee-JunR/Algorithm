#  find 써도 되는데 전 문제인 two pointer (-> 392. Is Subsequence) 풀고 와서 문제를 잘못읽었다. 결과는 timeout
#class Solution:
#     def numMatchingSubseq(self, s: str, words: List[str]) -> int:
#         k = count = 0
#         for k in range(len(words)):
#             i = j = 0
#             while i < len(s) and j < len(words[k]):
#                 if words[k][j] == s[i]:
#                     j+=1
#                 i+=1
#                 if j==len(words[k]):
#                     count+=1
#         return count
class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        word_dict = defaultdict(list)
        count = 0
        
        for word in words:
            word_dict[word[0]].append(word)            
        
        for char in s:
            if char in word_dict:
                cur_words = word_dict.pop(char)
                for word in cur_words:
                    if len(word) == 1:
                        count += 1
                    else:
                        word_dict[word[1]].append(word[1:])
        return count        