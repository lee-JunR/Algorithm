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
