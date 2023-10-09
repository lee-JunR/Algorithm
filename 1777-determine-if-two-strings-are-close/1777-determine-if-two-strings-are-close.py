class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        count_list1 = []
        count_list2 = []
        word1 = list(word1)
        word2 = list(word2)
        if set(word1) == set(word2) and len(word1) == len(word2):
            for i in range(len(set(word1))):
                count_list1.append(word1.count(list(set(word1))[i]))
                count_list2.append(word2.count(list(set(word2))[i]))
            count_list1.sort()
            count_list2.sort()
            return count_list1 == count_list2
        return False
