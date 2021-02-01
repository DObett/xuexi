import com.alibaba.fastjson.JSONObject;
import com.list;
import net.minidev.json.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import com.list;




public class ce {


    public static void main(String[] args) throws Exception{

        // 1. 生成Http对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 2. 获取httpGet对象

       // https://baike.baidu.com/item/22/395521
       // https://baike.baidu.com/item/young and beautiful/22170668?fr=aladdin"
     //   http://api.fanyi.baidu.com/api/trans/vip/translate?q=apple&from=en&to=zh&appid=2015063000000001&salt=1435660288&sign=f89f9594663708c1605f3d736d01d2d4
//https://music.163.com/#/song?id=513054681&autoplay=true&market=baiduhd

        String  q="羊和美丽";
        String from="en";
        String to="zh";
        String appid="20210109000667145";
        String salt="1435660288";
        String mi="gLcrRLqHHhzqLoIKbn3W";
         String  sign=appid+q+salt+mi;
        MessageDigest md = MessageDigest.getInstance("MD5");
              String   ss=ce.getMD5(sign);

        System.out.println("返回的数据是:" + ss);
        String urlString = URLEncoder.encode(q,"UTF-8");
        System.out.println(urlString);

        //HttpGet httpGet = new HttpGet("http://api.fanyi.baidu.com/api/trans/vip/translate?q="+urlString+"&from=auto&to=en&appid=20210109000667145&salt=1435660288&sign=" +ss);

        HttpGet httpGet = new HttpGet("https://music.163.com/#/song?id=513054681&autoplay=true&market=baiduhd");



        // 3. 执行httpGet
        CloseableHttpResponse response = httpClient.execute(httpGet);
        // 4. 获取返回的实体
        HttpEntity httpEntity = response.getEntity();

        // 5. 解析实体类
      //  String entityJson = EntityUtils.toString(httpEntity,"utf-8");
        String entityJson = EntityUtils.toString(httpEntity,"SHIFT_JIS");

       // Document doc =new Document(entityJson).outputSettings().charset("Unicode");;
      //  doc.outputSettings().charset("Unicode");
        System.out.println("JSON字符串转换成JSON对象\n" + entityJson );
        JSONObject jsonObject1 = JSONObject.parseObject(entityJson);
        System.out.println("JSON字符串转换成JSON对象\n" + jsonObject1);
        String result = jsonObject1.getString("trans_result");
        String from1 = jsonObject1.getString("from");
        String to1 = jsonObject1.getString("to");
       // System.out.println(result+from1+to1);

        String jsonString = jsonObject1.toJSONString();
        System.out.println("JSON对象转换为JSON字符串\n" + jsonString);


        Map<String,Object> params =new HashMap<>();



        params.put(result,result);
        params.put(from1,from1);
        params.put(to1,to1);
String ger= (String) params.get(result);
String gee=ger.replace("[","");
        String geee=gee.replace("]","");

        JSONObject jsonObject2 = JSONObject.parseObject(geee);
        System.out.println("JSON字符串转换成JSON对象\n" + jsonObject2);


        System.out.println(params.get(result));





        Document    doc=Jsoup.parse(entityJson);
//              String a=  doc.toString().replace("{","");
//              String b=a.replace("\"","");
//        JSONArray json = JSONArray.response.jsonPath().get(doc);
//        String data = StringUtils.strip(json.toString(),"[]");
//        Map<String,Object> params =new HashMap<>();
               //String b= doc.("from").text();


      //  Document doc = Jsoup.parse(entityJson);
       // String cc= doc.select("div.para:nth-child(15)").text();

//        int cc1= doc.getElementsByAttributeValue("label-module","para").size();
//
//        System.out.println(cc1);
//
//        for (int x=1;x<cc1;x++){
//            String cc= doc.getElementsByAttributeValue("label-module","para").select("div.para:nth-child("+x+")").text();
//              if (cc.length()>1){
//                  System.out.println(cc);
//              }
//
//        }



        // 6. 打印数据,观看结果
        //System.out.println(entityJson);
        System.out.println(jsonObject1);

        //System.out.println("返回的数据是:" + cc);


        // 7. 关闭连接对象
        response.close();
        httpClient.close();











    }

    public static String getMD5(String str) throws Exception {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new Exception("MD5加密出现错误");
        }
    }
}


