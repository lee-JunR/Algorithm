''' 틀린 풀이
class Solution:
    def compress(self, chars: List[str]) -> int:
        counter = {}
        idx = 0
        for value in chars:
            if value in counter:
                counter[value] += 1
            else:
                counter[value] = 1
        s = []
        for i in range(len(counter)):
            
            s.append(list(counter.keys())[i])
            if str(list(counter.values())[i]) != "1":
                if len(str(list(counter.values())[i])) > 1:
                    for j in range(len(str(list(counter.values())[i]))):
                        s.append(str(list(counter.values())[i])[j])
                else :
                    s.append(str(list(counter.values())[i]))
        if len(chars) != 1:
            for i in range(len(s)):
                    chars[i] = s[i]
            chars = chars[0:len(s)]
            return len(chars)
'''
class Solution:
    def compress(self, chars: List[str]) -> int:
        d=[]
        c=1
        for i in range(1,len(chars)):
            if chars[i]==chars[i-1]:
                c+=1
            else:
                d.append([chars[i-1],c])
                c=1
        d.append([chars[-1],c]) 
        i=0
        for k,v in d:
            chars[i]=k
            i+=1
            if v>1:
                for item in str(v):
                    chars[i]=str(item)
                    i+=1
        return i