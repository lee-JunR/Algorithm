#두개의 스트링 word1, word2 가 주어짐. 문자열을 병합해라 교대로, word1 부터 시작하여. 만약 다른 문자열보다 길면 추가된 문자를 병합된 스트링의 끝에 추가할 것.

class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        result = ""
        i, j = 0, 0
        for m in range(len(word1)+len(word2)):
            
            if len(word1) > i: 
            #if word1[i] is not  None:
                result += str(word1[i])
            if len(word2) > j:
            #if word2[i] is not None:
                result += str(word2[j])
            i +=1
            j +=1
        return result
# 지그재그 iterator 라는 이름으로 불림. 더 세련되게 코드를 짤 수도 있을 것 같음. 걸린시간 15분정도
"""
해답 
class Solution(object):
    def mergeAlternately(self, word1, word2):
        result = []
        i = 0
        while i < len(word1) or i < len(word2):
            if i < len(word1):
                result.append(word1[i])
            if i < len(word2):
                result.append(word2[i])
            i += 1
        return ''.join(result)
"""