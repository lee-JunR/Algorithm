class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        '''
        if str2.find(str1[str1.find(str2):len(str2)]) == '':
            return str2(str1[str1.find(str2):len(str2)])
        else:
            return str1[str1.find(str2):len(str2)]
        '''
        if str1 + str2 != str2 + str1:
            return ""

        # 겹치는 문자의 길이는 무조건 두 문자의 길이의 최대공약수
        length = math.gcd(len(str1), len(str2))
        return str2[:length]