#coding=utf-8
# 1. 案例1：访问url读取返回结果
# import urllib2
# response = urllib2.urlopen("http://www.baidu.com")
# print response.read()

# 2. 案例2：构造request访问url读取返回结果
# import urllib2
# request = urllib2.Request("http://www.baidu.com");
# response = urllib2.urlopen(request)
# print response.read()

# # 3. 案例3：实现 get请求
# import urllib
# import urllib2
# data = urllib.urlencode({"username":"张三","psw":"123"})
# request = urllib2.Request("http://www.baidu.com?"+data)
# response = urllib2.urlopen(request)
# print response.read()

# #4. 案例4：Post提交
# import urllib
# import urllib2
# data = urllib.urlencode({"username":"park","password":"123"}) 
# request = urllib2.Request("https://www.baidu.com",data)
# response = urllib2.urlopen(request)
# print response.read()

# 5. 案例5：设置Headers
# import urllib  
# import urllib2  
# url = 'http://www.baidu.com'
# data = urllib.urlencode({"username":"park","password":"123"}) 
# headers = { 'User-Agent' : 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3559.6 Safari/537.36'}  
# request = urllib2.Request(url, data, headers)  
# response = urllib2.urlopen(request)  
# print response.read() 

# 案例 6：代理设置
import urllib2
enable_proxy = True
proxy_handler = urllib2.ProxyHandler({"http" : 'http://127.0.0.1:1080'})
null_proxy_handler = urllib2.ProxyHandler({})
if enable_proxy:
    opener = urllib2.build_opener(proxy_handler)
else:
    opener = urllib2.build_opener(null_proxy_handler)
urllib2.install_opener(opener)



