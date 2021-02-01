package com.niceloo;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.DocStringType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.awt.datatransfer.MimeTypeParameterList;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StepDefinitions {

    private Object Response;

    @Given("科目专业类型状态 {string}")
    public void getubjectMajorstype(String subjectMajorstype) {
        System.out.println("subjectMajorstype = " + subjectMajorstype);
    }

    @Given("科目展示状态 {string}")
    public void getsubjectShowstatus(String subjectShowstatus) {
        System.out.println("subjectShowstatus = " + subjectShowstatus);
    }


    /**
     * https://cucumber.io/docs/guides/
     * http://rest-assured.io/
     *
     * 方式一: https://cucumber.io/docs/guides/api-automation/
     */
    @When("发起接口测试")
    public void sendReq() throws IOException {
        //真正调用接口
        System.out.println("真正调用接口");

        // java 调用接口
        Request.get("http://targethost/homepage")
                .execute().returnContent();

    }


    @Then("断言 {string}={string}")
    public void assertRes(String aName,String aValue){

    }

    // 临时存储 subjectId
    private String subjectId;

    @Given("科目ID {string}")
    public void getSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    // 临时存储 url
    private String url;

    @Given("URL {string}")
    public void getUrl(String url) {
        this.url = url;
        MimeTypeParameterList params = null;
        Response = given().contentType("application/json;charset=UTF-8")
                .header("Content-Type","application/x-www-form-urlencoded;charset=UTF-8")
                .formParam("apis", params.get("apis").toString())
                .formParam("ctype",params.get("ctype").toString())
                .when().log().all().post(url);
    }



    private String jsonStr;

    @When("GET")
    public void get() throws IOException {
        //包装 json
        String params = "{\"subjectId\":\""+subjectId+"\"}";
        // url encode 编码
        String encodeParams = URLEncoder.encode(params, "UTF-8");
        System.out.println(encodeParams);

        Content content = Request
                .get(url + "?params=" + encodeParams+"&ctype=mon.test")
                .addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36")
                .execute().returnContent();
        System.out.println("content = " + content.asString());
       // String[] formParams ;
        //List<String> stringList = Arrays.asList(formParams);
        List<NameValuePair> param=new ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair("pwd","2544"));
        param.add(new BasicNameValuePair("pwd","2544"));
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        String api ;

        formParams(api,param.get("api").toString());
        formParams.add(new BasicNameValuePair("password", password));





        Content conten = Request.post(url).bodyForm(param).addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36")
                .execute().returnContent();




        this.jsonStr = content.asString();
    }



    //    https://github.com/json-path/JsonPath
    @Then("Assert")
    public void jsonAssert(){
        String result = JsonPath.parse(jsonStr).read("$.result",String.class);
        String result1 = JsonPath.parse(jsonStr).read(
                "$.result",
                String.class
        );


        assertTrue("响应码断言错误: 期望是GB20041  实际响应码为" + result,"GB20041".equals(result));
    }
}
