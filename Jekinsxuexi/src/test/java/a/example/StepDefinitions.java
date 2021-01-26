package a.example;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.common.base.Charsets;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;

import static org.junit.Assert.*;

public class StepDefinitions {
      private  String srr;

    @Given("网址 {string}")
    public void geturl(String url) throws Exception {
        String aa = Request.get(url).addHeader("User-Agent","Mozilla/5.0(Windows NT 6.1;Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0")
                . execute().returnContent().asString(Charsets.UTF_8);
        String CC=".main-doc > h3:nth-child(1)";
        Document doc = Jsoup.parse(aa);
        String B =doc.select(CC).text();
        this.srr=aa;
        System.out.println(B);
    }

    @When("Get")
            public void when() throws Exception{


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
