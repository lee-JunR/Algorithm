# # Definition for singly-linked list.
# # class ListNode(object):
# #     def __init__(self, val=0, next=None):
# #         self.val = val
# #         self.next = next
# class Solution(object):
#     def deleteMiddle(self, head):
#         node = head
#         count = 0
#         # 연결 리스트의 길이를 구해서 count 로 초기화
#         while node.next != None:
#             node = node.next
#             count += 1
#         middle = count // 2 # 가운데 인덱스를 구함.
#         if count == 0: return None # 리스트에 아무 요소도 없으면 NULL 반환

#         count, temp = 0, head # 다시 초기화
#         while node.next == middle:
#             node = node.next
#             count += 1
#         node.next = None
#         return node
import math
class Solution:
    def deleteMiddle(self, head):
        c=1
        temp=head
        while temp.next!=None:
            temp=temp.next
            c+=1
        m=c//2
        if m==0:
            return None
        c,temp=1,head
        while c!=m:
            temp=temp.next
            c+=1
        temp.next=temp.next.next
        
        return head