package a.example;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.common.base.Charsets;
import io.restassured.RestAssured;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.yaml.snakeyaml.Yaml;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class StepDefinitions {

      private String api;
      private String urll ="http://192.168.10.102:7010";
    private String aa;
    public Map<String, Object> params = new HashMap();
    @Given("网址 {string}")
    public void geturl(String url) throws Exception {
        String aa = Request.get(url).addHeader("User-Agent","Mozilla/5.0(Windows NT 6.1;Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0")
                . execute().returnContent().asString(Charsets.UTF_8);
        String CC=".main-doc > h3:nth-child(1)";
        Document doc = Jsoup.parse(aa);
        String B =doc.select(CC).text();
        this.aa=aa;
        System.out.println(B);
    }

    @Given("^API \"(.*?)\"$")
    public void api(String api) {
        this.api = api;
        this.urll=urll+api;
    }
    @Given("Param")
    public void paramsYaml(String yamlContent) throws IOException {

        Yaml yaml = new Yaml();
        Map ret = (Map)yaml.load(yamlContent);
        this.params = ret;
        //JSON字符串转换成JSON对象
        Map map=new HashMap();
        params.keySet();
        Set<String> keySet = params.keySet();

        for(String key : params.keySet()){

                if (params.get(key)==null){

                    map.put(""+key+"",""+" "+"");

                }else{
                    map.put(""+key+"",""+params.get(key)+"");

                }

            }





        String  param= JSON.toJSONString(map);
        JSONArray jArray = new JSONArray();
        jArray.add(map);
        String str = jArray.toString();
        System.out.println(str);
        System.out.println(param);
       // JSONObject jsonObject1 = JSONObject.parseObject(yamlContent);
        //System.out.println("JSON字符串转换成JSON对象\n" + jsonObject1);
        System.out.println(yamlContent);
        String encodeParams= URLEncoder.encode(param,"UTF-8");
        System.out.println(urll+"?params="+encodeParams+"&ctype=YOULU.WEB");
        String aa = Request.get(urll+"?params="+encodeParams+"&ctype=YOULU.WEB")
                .addHeader("User-Agent","Mozilla/5.0(Windows NT 6.1;Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0")
                .execute().returnContent().asString(Charsets.UTF_8);

          this.aa=aa;
         JSONObject jsonObject1 = JSONObject.parseObject(aa);
        System.out.println("JSON字符串转换成JSON对象\n" + jsonObject1);

        JSONObject json = new JSONObject();
       // Response response = (Response)((RequestSpecification) RestAssured.given().contentType("application/json;charset=UTF-8").param("params", new Object[]{params}).param("ctype", new Object[]{"YOULU.WEB"}).body(json.toJSONString()).when().log().all());





    }

    @When("Get")
            public void when() throws Exception{


    }




    @Then("JSONPATH_ASSERT {string} equals {string}")
    public void jsonpath_assertEquals(String arg0, String arg1) throws Exception {
        if (isJSON2(aa) == true) {
            String arg3 = JsonPath.read(aa, "$." + arg0);
            if (arg3.equals(arg1)) {
                System.out.println("断言OK");
            }
        } else {

                    Document doc = Jsoup.parse(aa);

                    String  arg4 =doc.select(arg0).text();
                     if (arg4.equals(arg1)) {
                        System.out.println("断言OK");
                        }
        }




//        for (int x=0;x<2;x++) {
//            switch (x){
//
//                case 0 :
//
//                    Document doc = Jsoup.parse(srr);
//
//                    String  arg4 =doc.select(arg0).text();
//                     if (arg4.equals(arg1)) {
//                        System.out.println("断言OK");
//                        }
//
//                case 1:
//
//                    String  arg3 = JsonPath.read(aa,"$."+arg0);
//                    if (arg3.equals(arg1)) {
//                        System.out.println("断言OK");
//                    }
//
//        }

       // Assert.assertTrue(arg3.equals(arg1));
    }





























    public static boolean isJSON2(String str) {
        boolean result = false;
        try {
            Object obj= JSON.parse(str);
            result = true;
        } catch (Exception e) {
            result=false;
        }
        return result;
    }
}