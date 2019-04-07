#coding=utf-8
class Teacher:
    name = ""
    def __init__(self,name):
        self.name = name
    def teach(self):
        print(self.name+"讲课。。。")
    def run(self):
        print("跑步。。。")

class Coder:
    def code(self):
        print("写代码。。。")
    def run(self):
        print("运行代码。。。")
        
class JavaTeacher(Coder,Teacher):
    def __init__(self,name):
        Teacher.__init__(self, name)
    def debug(self):
        print("调试代码。。。")
    def code(self):
        print("边讲边写。。。")

jt = JavaTeacher("zs")
jt.teach()
jt.code()
jt.debug()
jt.run()