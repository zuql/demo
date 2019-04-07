#coding=utf-8
#list的使用
##定义列表
l1 = [1,2,3,"a","b","c",True,False]
##访问列表
print(l1[4])
print(l1[3:6])
print(l1[3:])
print(l1[:6])
print(l1[-2])
##更新列表
l1[4] = "x"
print(l1)
##删除元素
del l1[3:6]
print(l1)
##列表函数
print(len(l1))
print([1,2,3]+["a","b","c"])
print([1,2,3]*3)
print("x" in ["a","b","c"])
print("x" not in ["a","b","c"])

#元组 tuple
##定义元组
t1 = (1,"aa",19,"bj",123.23);
t2 = (2,"bb",29,"sh",1323.23);
##访问元组
print(t1[1])
print(t1[2:4])
print(t1[2:])
print(t1[:4])
print(t1[-2])
##修改元组 - 元组元素不可修改 但是可以将多个元组 拼接为一个新的元组
t = (1,"aaa",19) + (2,"bbb",20)
print(t)

##删除元组 - 元组元素不可删除 但是可以删除整个元组
t = (1,"aaa",19,"bj",222.22)
del t


#Set
##定义set
s = {"aa",123,"bb",True,"aa",999,123,"dd"}
print(s)
##访问set
for i in s:
    print(i)


#字典dict
##定义字典
d = {"name":"zs","age":18,"addr":"bj","salary":999.9}
##访问字典
print(d["name"])
##修改字典
d["salary"] = 1000.0
print(d)
##删除字典
del d["age"] #删除某一项
print(d)
d.clear() #清空字典，字典本身是存在
print(d)
del d ##删除字典本身 

















