package purifierrental.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import purifierrental.RepairApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { RepairApplication.class })
public class CucumberSpingConfiguration {}
