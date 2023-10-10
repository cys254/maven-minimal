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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@SpringJUnitConfig(classes={HelloConfig.class})
@IntegrationComponentScan
public class HelloTest {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    TestGateway testGateway;

    @Autowired
    B bean_b;

    @MockBean
    A bean_a = new A("");


    @BeforeEach
    void setup() {
        System.out.println("CHEND a.v=" + bean_a.getValue());
        System.out.println("CHEND b.a.v=" + bean_b.a.getValue());
        System.out.println("CHEND b.a.p=" + bean_b.positive);
    }

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
