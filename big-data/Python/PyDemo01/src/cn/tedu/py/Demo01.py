#coding=utf-8
#分号的使用
import math
print("hello python~")
print("你好  中国~")
print("hello python~");print("你好  中国~")


#制表符控制作用范围
if 3>2:
    print("aaa")
    if 5>4:
        print("bbb")
    print("ccc")
print("ddd")

#注释的使用
#单行注释
'''
多行注释
多行注释
'''
"""
多行注释
多行注释
"""

#引用
x = 10
x = 123
x = "abc"
PI = 3.14
PI = 3.1415

#字符串
str = 'abc'
str = "def"
str = '''ghi'''
str = """jkl"""

str = "abc\r\nde\tfghi"
print(str)
str = """abc
de    fgh
i"""
print(str)

#+拼接字符串
str =  "abc" + "def"
print(str)
#*重复字符串
str = "abc"
print(str*3)
#[]索引字符串
str = "abcdef"
print(str[2])
print(str[2:4])
print(str[:4])
print(str[2:])
#in not..in 判断是否包含
str = "abcdef"
print("xyz" in str)
print("xyz" not in str)
#格式化字符串
str = "My name is %s ,my age is %d,my city is %s"  % ("park",18,"bj")
print(str)


#r和R的用法
str = "abc\r\ndef"
print(str)
str = "abc\\r\\ndef"
print(str)
str = r"abc\r\ndef"
print(str)


#布尔类型
flag = True
flag = False
flag = True and False 
flag = True or False
flag = not False


#数值操作
n = abs(10)
print(n)
n = abs(-10)
print(n)
n = max(1,3,6,8,23,5,98,34,93,23,2)
print(n)
print(math.pi)
print(math.e)

#None
x=None

#if 条件判断
n = 11
if n<10:
    print("haha")
elif n<100:
    print("hehe")
else:
    print("xixi")

#while 循环
n = 0
sum = 0
while n<=10:
    sum += n
    n += 1
else:
    print("循环条件不成立时执行else，之后退出循环")
print(sum)

#for 循环
#增强for
l1 = [1,3,5,7,9]
for i in l1:
    print(i)
else:
    print("for循环结束。。")
#普通for
for i in range(5):
    print("haha")
else:
    print("for循环结束。。")
    















