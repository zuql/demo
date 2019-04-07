#encoding=utf-8
#定义函数
def sumx(n1,n2):
    "两数求和函数"
    return n1 + n2

#调用函数
r = sumx(2,3)
print(r)

#缺省参数
def sumx2(n1,n2=10):
    return n1 + n2
print(sumx2(2,3))
print(sumx2(2))

def sumx3(n1=1,n2=10,n3=100):
    return n1 + n2 * n3
print(sumx3())
print(sumx3(n3 = 1000))

print(sumx3(n3 = 2,n1 = 3,n2 = 4))


#不定长参数
def sumx4(*nums):
    sum = 0
    for n in nums:
        sum += n
    return sum
r = sumx4(2,3,4)
print(r)
r = sumx4(2,3,4,5,6)
print(r)
    
#函数直接量定义函数
sumx5 = lambda n1,n2:n1+n2;
print(sumx5(2,3))
    
    
#函数作为类的成员
class Person:
    name="zs"
    age=19
    def eat(self,food):
        print("吃。。。"+food)
    def sleep(self):
        print("睡。。。")
#函数作为局部成员
def eat(food):
    zl = "孜然"
    def cook(food):
        return "做熟"+food +"加" + zl
    print("吃"+cook(food))

#高阶函数  将函数作为方法参数传递
def eatx(food,how2Cook):
    food2 = how2Cook(food)
    print("吃。。"+food2)
def cookYRC(food):
    return "烤熟"+food
eatx("羊肉串",cookYRC)
eatx("涮羊肉",lambda food:"煮熟"+food)


#高阶函数  将函数作为另一个函数 的返回值返回
def lookUpCaiPu(cai):
    if cai == "羊肉串":
        def cookYRC(food):
            return "烤熟"+food
        return cookYRC
    elif cai == "涮羊肉":
        return lambda food:"煮熟"+food;
    else:
        return lambda food:"做熟"+food;
cookFunc= lookUpCaiPu("涮羊肉")
print(cookFunc("羊肉"))





