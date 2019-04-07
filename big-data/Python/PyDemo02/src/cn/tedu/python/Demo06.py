#coding=utf-8
class Person:
    __name = "zs"
    def __say(self):
        print("说 。。")
        
p = Person()
print(p.__name)
p.__say()