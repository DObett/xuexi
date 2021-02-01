package a.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin =  {"pretty", "html:target/cucumber.html", "json:target/cucumber/cucumber.json"},
        features = "classpath:/features/",
        useFileNameCompatibleName = true ,
        glue = {"classpath:a.example"})
public class RunCucumberTest {



}

