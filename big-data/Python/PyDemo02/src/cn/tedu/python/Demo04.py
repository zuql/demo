#encoding=utf-8
class Person:
    "代表人的类"
    name=""
    addr = "bj"
    def __init__(self,name="zs"):
        self.name = name
        print("Person被构造了。。。")
    def eat(self):
        print("吃。。。")
    def sleep(self):
        print("睡。。。")

p = Person()
print(p.name)
p.eat()

#增加属性
# p1 = Person()
# p1.age = 19
#增加方法
# def study():
#     print("学习。。。。")
# p1.study=study
# p1.study()

#删除属性
# del p1.age

#删除方法
# del p1.study

# del p1.name
# print(p1.name)
# p1.eat()
# del p1.eat


print(Person.__dict__)
print(Person.__doc__)
print(Person.__name__)
print(Person.__module__)





