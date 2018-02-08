
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
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

/**
 * Created by T00005839 on 2018/1/23.
 */

public class ApiTest {

    @Test(priority = 1001,description="get请求")
    public  void ApiGet() throws ClientProtocolException, IOException{
        String httpurl="https://tieba.baidu.com/hottopic/browse/topicList";
        //HttpClient httpClient = new DefaultHttpClient();// 实例化HttpClient类
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet http_Get = new HttpGet(httpurl);// 用get方法请求
        http_Get.setHeader("Content-type", "application/json");//设置header信息
        HttpResponse response = httpClient.execute(http_Get);// 执行get请求方法返回
        String strResult = EntityUtils.toString(response.getEntity());
        System.out.println("查看返回的结果：" + strResult);
        JSONObject jsonResult = JSONObject.parseObject(strResult);
        String ZiDuan = jsonResult.getString("errno");
        System.out.println("\n");
        System.out.println(ZiDuan);
    }

    @Test(priority = 1002,description="post请求")
    public  void ApiPost() throws ClientProtocolException, IOException{
        String httpurl="http://";
        //HttpClient httpClient = new DefaultHttpClient();// 实例化HttpClient类
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost http_post = new HttpPost(httpurl);// 用post方法请求
        http_post.setHeader("Content-type", "application/json");//设置header信息
        String Param= ReadFile.formatJson(ReadFile.ReadRequest("Param1"));//拿到请求参数json文件
        StringEntity entity_Param = new StringEntity(Param,"utf-8");//封装请求参数
        http_post.setEntity(entity_Param);//传入请求参数
        HttpResponse response = httpClient.execute(http_post);// 执行post请求方法返回

        String strResult = ReadFile.formatJson(EntityUtils.toString(response.getEntity()));
        System.out.println("查看返回的结果：" + strResult);
        JSONObject jsonResult = JSONObject.parseObject(strResult);
        String ZiDuan = jsonResult.getString("status");
        System.out.println("\n");
        System.out.println("status:"+ZiDuan);
        Assert.assertEquals(ZiDuan,"1");
        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);


    }


}
