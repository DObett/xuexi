package org.example;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin =  {"pretty", "html:target/cucumber.html", "json:target/cucumber/cucumber.json"},
        features = "classpath:/org.example/",
        useFileNameCompatibleName = true ,
        glue = {"classpath:org.example"})
public class RunCucumberTest {

}

