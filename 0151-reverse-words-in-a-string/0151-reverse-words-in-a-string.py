class Solution:
    def reverseWords(self, s: str) -> str:
        rlist = list(reversed(list(s.split())))
        s = ''
        for i in rlist :
            s +=  ' ' +i 
        s = s.lstrip()

        return s