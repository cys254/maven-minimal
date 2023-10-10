package hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
// import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import org.springframework.integration.config.EnableIntegration;
import org.springframework.test.annotation.DirtiesContext;

@IntegrationComponentScan(basePackages = {"hello"})
@SpringJUnitConfig(classes={HelloConfig.class,HelloTest.TestGateway.class})
//@EnableIntegration
//@DirtiesContext
public class HelloTest {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    TestGateway testGateway;

    @Test
    public void test0() {
        Assertions.assertNotNull(ctx);
        Assertions.assertNotNull(testGateway);
        Assertions.assertEquals(1, testGateway.plusOne(0));
    }

    @MessagingGateway
    public interface TestGateway {

        @Gateway(requestChannel = "plus_one_input", replyChannel = "plus_one_output")
        int plusOne(int x);
    }
}
