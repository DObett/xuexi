package com.niceloo;

import com.EnvParameters;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.common.base.Charsets;
//import macaca.client.MacacaClient;

import net.minidev.json.JSONObject;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;


import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.yaml.snakeyaml.Yaml;
import util.TplKit;

import javax.ws.rs.FormParam;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

//import jdk.internal.agent.Agent;

public class StepDefinitions {
    private String postRequest;
    private   String  subjectMajorstyp;
    private String Agent;

    private  String srr;
    private String url;



    @Given("科目专业类型状态 {string}")
    public void getubjectMajorstype(String url) throws Exception {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(subjectMajorstype);
//        httpGet.setHeader("User-Agent","Mozilla/5.0(Windows NT 6.1;Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
//       // 3. 执行httpGet
//        CloseableHttpResponse response = httpClient.execute(httpGet);
//        // 4. 获取返回的实体
//        HttpEntity HttpEntity =  response.getEntity();
//        // 5. 解析实体类
//               String entityJson = EntityUtils.toString(HttpEntity,"utf-8");
//
//        // 6. 打印数据,观看结果
//        System.out.println("返回的数据是:" + entityJson);
        this.url=url;



//        Request.setHeader(HttpHeaders.USER_AGENT, agent);
//        Request.setHeader("User-Agent","Mozilla/5.0(Windows NT 6.1;Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        
        String aa = Request.get(url).addHeader("User-Agent","Mozilla/5.0(Windows NT 6.1;Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0")
                . execute().returnContent().asString(Charsets.UTF_8);
//        StandardCharsets.UTF_8


       this.srr=  aa;

String CC=".main-doc > h3:nth-child(1)";
        Document doc = Jsoup.parse(srr);
        String B =doc.select(CC).text();
        System.out.println(B);
    }


    @Given("科目展示状态 {string}")
    public void getsubjectShowstatus(String subjectShowstatus) {
     //   System.out.println("subjectShowstatus = " + subjectShowstatus);
    }
  //private   String apis;
    private   String TOKEN;
    private   String  ctype;
    String[] cid={"ci3qctj46ucblskl1n1910x","crojix8gra8mi8vjr7jym03","cii859fy6t429m4bo5f4404"};
    String[] api={"ir/taxrate/list","uc/auth/user/brands","uc/auth/menucode/cache"};


    private   String  params="{\"taxrateType\":\"\",\"pageIndex\":0,\"pageSize\":10}";

    private   String a;
    // ""+params+"\"},{\"cid\":\""+cid[1]+"\",\"api\":\""+api[1]+"\"}, {\"cid\":\""+cid[2]+"\",\"api\":\""+api[2]+"\"}]";;
//"apis:[{\"cid\":\""+cid[0]+"\",\"api\":\""+api[0]+"\",\"params\":\"" +
//            ""+params+"\"},{\"cid\":\""+cid[1]+"\",\"api\":\""+api[1]+"\"}, {\"cid\":\""+cid[2]+"\",\"api\":\""+api[2]+"\"}]";

    @Given("apis")
    public String getapis(
                        ) {
        System.out.println(a);


        http://umsacheck.niceloo.com/api/qb/subject/info


        return  a= "apis:[{\"cid\":\""+cid[0]+"\",\"api\":\""+api[0]+"\",\"params\":\""+params+"\"}]";

    }
//\"cid\":\""+cid+"\"\"cid\":\""+cid+"\"
//[{"cid":"c9xwndgrotswlegifbax802","api":"uc/auth/user/menu/tree","params":{}},{"cid":"ci4oqi842hdf5e3uv0apr03","api":"uc/auth/user/brands"},{"cid":"c21u915103j8yqggd0jz704","api":"uc/auth/menucode/cache"}]

    @Given("TOKEN{string}")
    public String getTOKEN(@FormParam("TOKEN") String TOKEN) {
        System.out.println(TOKEN);
        return "{\"TOKEN\":\""+TOKEN+"\"}";
        //   System.out.println("subjectShowstatus = " + subjectShowstatus);
    }



    @Given("ctype{string}")

    public String getctype(@FormParam("ctype") String ctype){
        System.out.println(ctype);
        return "{\"ctype\":\""+ctype+"\"}";


        //   System.out.println("subjectShowstatus = " + subjectShowstatus);
    }





    //MacacaClient driver;



    @When("Get")
    public void  getsendReq() throws IOException {
        //真正调用接口
       //url="https://www.baidu.com";

//        Content aa = Request.get(url).execute().returnContent();
//        System.out.println(aa.asString());
//aaa =subjectMajorstyp;
//        Content aa = Request.get(aaa).execute().returnContent();
//       System.out.println(aa.asString());
//        System.out.println("aaa");
        String  aaa="[{\"cid\":\"cxxekrr5qnxmd14n24vjh5e\",\"api\":\"lg/bill/student/list\",\"params\":{\"billApplyname\":\"\",\"billApplyphone\":\"11\",\"billBizobj\":\"\",\"billNo\":\"\",\"pageIndex\":0,\"pageSize\":50}}]";
        String encodeParams = URLEncoder.encode(aaa, "UTF-8");
        System.out.println(encodeParams);
       // String encodeParam = URLEncoder.encode(TOKEN, "UTF-8");
        //String encodePara = URLEncoder.encode(ctype, "UTF-8");


        Content content = Request
                .get(url+"?params=" +encodeParams+"&ctype=ADMIN.WEB")
                .addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36")
                .execute().returnContent();
        System.out.println("content = " + content.asString());




    }

    @Given("Param")
    public void paramsYaml(String yamlContent) {
        // 替换变量
        String parsedYaml = TplKit.parse(yamlContent, EnvParameters.mongoCache);
        Yaml yaml = new Yaml();
        Map ret = (Map) yaml.load(parsedYaml);
    }

    @Given("CookieX")
//    public void CookieX(Map<String,Object> paramsTmp) {
//        System.out.println("666");
//        Map<String,Object> tmp = new HashMap<>();
//        paramsTmp.forEach((key,value) -> {
//            // 验证是否包含函数表达式
//            String valueTmp = value.toString();
//            if (value.toString().contains("${")){
//                String keyVal = valueTmp.substring(2, valueTmp.length() - 1);
//                tmp.put(key, EnvParameters.mongoCache.get(keyVal));
//            }else {
//                tmp.put(key, value);
//            }
//        });
//        System.out.println(tmp);
//    }



    @Then("断言")
    public void assertRes() throws Exception {
//        String result = JsonPath.parse(aa).read("$.result",String.class);
//        String result1 = JsonPath.parse(aa).read(
//                "$.result",aa
//                String.class);
        Document doc = Jsoup.parse(srr);
      //  String e = doc.getElementsByAttribute("/html/body/div[1]/div[3]/div[1]/div[1]/table/tbody/tr/td/div[1]/div[2]/div/div/table/tbody[1]/tr[1]/td[1]/a").text();
      //  System.out.println(e);
        doc.title("123");
        //打印浏览网址标题
       String A =doc.title();
       //获取元素的文本正则匹配
      String e= doc.getElementsMatchingText("变异$").text();
        String e1= doc.getElementsMatchingText( "第三$").text();//寻找文本匹配给定正则表达式的元素集
      //  String e2= doc.getElementsContainingText("百度首页设置登录").val();
        //这个就相当于json  key =value  打印出文本
        String e2= doc.getElementsByAttributeValue("title","中国女足年终排名亚洲第三").text();
      //  String e3= doc.getElementsByAttributeValueContaining("title","中国女足年终排名亚洲第三").attr("title");  这2 都可以断言 也是key  json模式
        String e3 =doc.getElementsByAttributeValueContaining("title","中国女足年终排名亚洲第三").text();//寻找键为key，值包含match的元素集。
        //寻找包含searchText字符串的元素集。不区分大小写。该文本可能直接出现在该元素中，也可能出现在其子孙元素中。
        String e4= doc.getElementsContainingText("中国女足年终排名亚洲第三").attr("title");//用.text() 就会打印所有文字的元素集合 所以要在后面加.attr("title") 用来区分类似key json 固定值
     // doc.text("123++");
        //打印响应中的所有文本
        //String A1 =doc.text();
        // 文本对比用equals  equals equals equals ！！！！！！！！！




//    if (e2.equals("")) {
//        System.out.println("断言失败");
//        }else {
//        System.out.println(e2);
//    }
     //   assertTrue("响应码断言错误: 期望是天津女排第13次夺联冠军  实际响应码为" + e,"天津女排第13次夺联冠军".equals(e));
//      System.out.println(A);
//        System.out.println(e);
//        System.out.println(e1);
//        System.out.println(e3+1);
//        System.out.println(e4+4);


        //System.out.println(A1);

       // System.out.println(e.val());
        //String  banji = driver.elementByXPath(" //span[contains(text(),\"网坛名将莎拉波娃宣布订婚\")]").getText();
        //assertThat( e, containsString( "一级建造师" ) );
    }


    @Then("JSONPATH_ASSERT {string} equals {string}")
    public void jsonpath_assertEquals(String arg0, String arg1) {
        Document doc = Jsoup.parse(srr);

        String  arg3 =doc.select(arg0).text();
        if (arg3.equals(arg1)) {
        System.out.println("断言OK");
        }else {
        System.out.println("断言失败1");
              }

          Assert.assertTrue(arg3.equals(arg1));
    }
}

