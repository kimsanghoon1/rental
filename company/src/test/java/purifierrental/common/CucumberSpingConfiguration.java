package purifierrental.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import purifierrental.CompanyApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { CompanyApplication.class })
public class CucumberSpingConfiguration {}
