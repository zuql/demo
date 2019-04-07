#coding=utf-8
try:
    #file = open("1.txt")
    raise IOError
except IOError:
    print("IO异常~！")
else:
    print("没有异常~！")
finally:
    print("无论有没有异常，都会执行finally~")