轻量级接口测试
作者：阳成文

本工程针对http接口测试，拥有如下功能：
1.httpget请求
2.httppost请求
3.数据库操作

目录介绍：
src.main.core:核心代码
src.main.wilson:常用封装函数
src.Request_File:接口请求参数文件
src.test:测试用例代码

使用方法：
常用的有五个封装好的方法
sudo.sql(String db_ip,String db_name,String account,String passwd,String do_what,String ZiDuan)     //操作数据库（可以查字段）
sudo.get(String url)        //获取get请求返回json对象
sudo.post(String url,String ParamFile)      //获取post请求返回json对象
sudo.get_StatusCode(String url)       /获取get请求返回StatusCode
sudo.post_StatusCode(String url,String ParamFile)      /获取get请求返回StatusCode


例如以下，三行代码一个测试用例:
       JSONObject response_json = sudo.post(url1,"Param1");     //接口请求拿数据
       String name=sudo.sql("数据库ip","数据库名","账户","密码","select * from ce_resource where id=2","字段");     //数据库拿数据
       Assert.assertEquals(response_json.getString("name"),name);      //对比接口返回数据和数据库的数据