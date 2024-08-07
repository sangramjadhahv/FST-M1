#Combining List
'''
Given a two list of numbers create a new list such that
new list should contain only odd numbers from the first
list and even numbers from the second list.
'''

list1=[1,3,2,4,5]
list2=[2,4,6,3,8]
list3=[]

print("list1:", list1)
print("list2:", list2)

# finding odd from firstlist
for num in list1:
    if int(num%2 !=0):
      list3.append(num)

print("After list1 calculation:",list3)

for num in list2:
   if int(num%2==0):
      list3.append(num)
print("After list2 calculation:",list3)