import org.testng.annotations.Test;
import wilson.sudo;

import java.io.IOException;

/**
 * Created by T00005839 on 2018/1/30.
 */
public class degug {
    @Test
    public static void main() throws IOException {
//        String res= ReadFile.formatJson(ReadFile.ReadRequest("Param1"));
////        File file = new File("Param1");
////        String req=a.readFileToString(file);
//        System.out.println(res);

       String url="https://jingyan.baidu.com/asyncreq/log?method=getLog&likeNum=33246112491423447815&type1423=588699369";
       String url1="http://";
//        sudo.get(url);
//        System.out.println("-----------------");
//        JSONObject js = sudo.post(url1,"Param1");
//        String js_str = js.getString("status");
////        System.out.println(js);
////        System.out.println("status:"+js_str);
//        String url="https://jingyan.baidu.com/asyncreq/log?method=getLog&likeNum=33246112491423447815&type1423=588699369";

//        JSONObject js = sudo.post(url1,"Param1");
//        String name=sudo.sql("127.0.0.1","sql_name","accout","passwd","select * from ce_resource where id=2","name");
//        Assert.assertEquals(js.getString("status"),"1");

        System.out.println(sudo.get_StatusCode(url));
        System.out.println(sudo.post_StatusCode(url,"Param1"));
//        System.out.println(sudo.post_StatusCode(url1,"Param1"));
//        System.out.println(sudo.get_StatusCode(url));
//        Assert.assertEquals(sudo.get_StatusCode(url),200);

    }
}
