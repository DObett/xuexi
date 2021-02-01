package com.niceloo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;

import java.io.IOException;

import static org.junit.Assert.*;

public class StepDefinitions {

    @Given("科目专业类型状态 {string}")
    public void getubjectMajorstype(String subjectMajorstype) {
        System.out.println("subjectMajorstype = " + subjectMajorstype);
    }

    @Given("科目展示状态 {string}")
    public void getsubjectShowstatus(String subjectShowstatus) {
        System.out.println("subjectShowstatus = " + subjectShowstatus);
    }


    /**
     * http://hc.apache.org/httpcomponents-client-5.0.x/quickstart.html
     */
    @When("发起接口测试")
    public void sendReq() throws IOException {
        //真正调用接口
        String url = "https://www.baidu.com";

        Content html = Request.get(url)
                .execute().returnContent();

        System.out.println(html.asString());
    }


    @Then("断言 {string}={string}")
    public void assertRes(String aName,String aValue){

    }


    // 局部的数据存储
    private String realUrl;

    @Given("URL {string}")
    public void getUrl(String url) {
        realUrl = url;
    }

    @When("Get")
    public void request() throws IOException {

        Content html = Request.get(realUrl)
                .execute().returnContent();

        System.out.println(html.asString());
    }
}
