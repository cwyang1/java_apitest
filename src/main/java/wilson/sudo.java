package wilson;

//import com.alibaba.fastjson.JSONObject;


import com.alibaba.fastjson.JSONObject;
import core.ReadFile;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.sql.*;

//import org.apache.http.impl.client.HttpClients;

/**
 * Created by T00005839 on 2018/1/31.
 */
public class sudo {
    public static JSONObject get(String url) throws ClientProtocolException, IOException {
        String httpurl=url;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet http_Get = new HttpGet(httpurl);// 用get方法请求
        http_Get.setHeader("Content-type", "application/json");//设置header信息
        HttpResponse response = httpClient.execute(http_Get);// 执行get请求方法返回
        String strResult = EntityUtils.toString(response.getEntity());
        JSONObject jsonResult = JSONObject.parseObject(strResult);
//        String ZiDuan = jsonResult.getString("errno");
        return jsonResult;
    }

    public static JSONObject get(String url,String cookie) throws ClientProtocolException, IOException {
        String httpurl=url;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet http_Get = new HttpGet(httpurl);// 用get方法请求
        http_Get.setHeader("Content-type", "application/json");//设置header信息
        http_Get.setHeader("Cookie", cookie);//设置header信息
        HttpResponse response = httpClient.execute(http_Get);// 执行get请求方法返回
        String strResult = EntityUtils.toString(response.getEntity());
        JSONObject jsonResult = JSONObject.parseObject(strResult);
//        String ZiDuan = jsonResult.getString("errno");
        return jsonResult;
    }

    public  static JSONObject post(String url,String ParamFile) throws ClientProtocolException, IOException{
        String httpurl=url;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost http_post = new HttpPost(httpurl);// 用post方法请求
        http_post.setHeader("Content-type", "application/json");//设置header信息
        String Param= ReadFile.formatJson(ReadFile.ReadRequest(ParamFile));//拿到请求参数json文件
        StringEntity entity_Param = new StringEntity(Param,"utf-8");//封装请求参数
        http_post.setEntity(entity_Param);//请求参数
        HttpResponse response = httpClient.execute(http_post);// 执行post请求方法返回
        String strResult = ReadFile.formatJson(EntityUtils.toString(response.getEntity()));
        JSONObject jsonResult = JSONObject.parseObject(strResult);
        return jsonResult;
    }
    public  static JSONObject post(String url,String ParamFile,String cookie) throws ClientProtocolException, IOException{
        String httpurl=url;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost http_post = new HttpPost(httpurl);// 用post方法请求
        http_post.setHeader("Content-type", "application/json");//设置header信息
        http_post.setHeader("Cookie", cookie);//设置header信息
        String Param= ReadFile.formatJson(ReadFile.ReadRequest(ParamFile));//拿到请求参数json文件
        StringEntity entity_Param = new StringEntity(Param,"utf-8");//封装请求参数
        http_post.setEntity(entity_Param);//请求参数
        HttpResponse response = httpClient.execute(http_post);// 执行post请求方法返回
        String strResult = ReadFile.formatJson(EntityUtils.toString(response.getEntity()));
        JSONObject jsonResult = JSONObject.parseObject(strResult);
        return jsonResult;
    }

    public static String sql (String db_ip,String db_name,String account,String passwd,String do_what){
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://"+db_ip+"/"+db_name;
        //MySQL配置时的用户名
        String user = account;
        //MySQL配置时的密码
        String password = passwd;
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = do_what;
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
//            System.out.println("-----------------");
//            System.out.println("执行结果如下所示:");

            String ZiDuan = null;

//            while(rs.next()){
//                //获取ZiDuan这列数据
//                ZiDuan = rs.getString(ZiDuan);
//                //输出结果
//                System.out.println(ZiDuan);
//            }

            rs.close();
            con.close();
            return null;
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
//            System.out.println("数据库数据成功获取！！");
        }

        return null;
    }

    public static String sql (String db_ip,String db_name,String account,String passwd,String do_what,String ZiDuan){
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://"+db_ip+"/"+db_name;
        //MySQL配置时的用户名
        String user = account;
        //MySQL配置时的密码
        String password = passwd;
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = do_what;
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                //获取ZiDuan这列数据
                ZiDuan = rs.getString(ZiDuan);
                //输出结果
//                System.out.println(ZiDuan);
            }

            rs.close();
            con.close();
            return ZiDuan;
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
//            System.out.println("数据库数据成功获取！！");
        }

        return null;
    }

    public static int get_StatusCode(String url) throws ClientProtocolException, IOException {
        String httpurl=url;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet http_Get = new HttpGet(httpurl);// 用get方法请求
        http_Get.setHeader("Content-type", "application/json");//设置header信息
        HttpResponse response = httpClient.execute(http_Get);// 执行get请求方法返回
        return response.getStatusLine().getStatusCode();
    }

    public static int get_StatusCode(String url,String cookie) throws ClientProtocolException, IOException {
        String httpurl=url;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet http_Get = new HttpGet(httpurl);// 用get方法请求
        http_Get.setHeader("Content-type", "application/json");//设置header信息
        http_Get.setHeader("Cookie", cookie);//设置header信息
        HttpResponse response = httpClient.execute(http_Get);// 执行get请求方法返回
        return response.getStatusLine().getStatusCode();
    }

    public  static int post_StatusCode(String url,String ParamFile) throws ClientProtocolException, IOException{
        String httpurl=url;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost http_post = new HttpPost(httpurl);// 用post方法请求
        http_post.setHeader("Content-type", "application/json");//设置header信息
        String Param= ReadFile.formatJson(ReadFile.ReadRequest(ParamFile));//拿到请求参数json文件
        StringEntity entity_Param = new StringEntity(Param,"utf-8");//封装请求参数
        http_post.setEntity(entity_Param);//请求参数
        HttpResponse response = httpClient.execute(http_post);// 执行post请求方法返回
        return response.getStatusLine().getStatusCode();
    }
    public  static int post_StatusCode(String url,String ParamFile,String cookie) throws ClientProtocolException, IOException{
        String httpurl=url;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost http_post = new HttpPost(httpurl);// 用post方法请求
        http_post.setHeader("Content-type", "application/json");//设置header信息
        http_post.setHeader("Cookie", cookie);//设置header信息
        String Param= ReadFile.formatJson(ReadFile.ReadRequest(ParamFile));//拿到请求参数json文件
        StringEntity entity_Param = new StringEntity(Param,"utf-8");//封装请求参数
        http_post.setEntity(entity_Param);//请求参数
        HttpResponse response = httpClient.execute(http_post);// 执行post请求方法返回
        return response.getStatusLine().getStatusCode();
    }
}
