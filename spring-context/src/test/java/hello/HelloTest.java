package hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={HelloConfig.class})
public class HelloTest {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    Integer one;

    @Autowired
    Integer two;

    @Test
    public void test0() {
        Assertions.assertNotNull(ctx);
    }

    @Test
    public void test1() {
        Assertions.assertNotNull(one);
    }

    @Test
    public void test2() {
        Assertions.assertEquals(2, two);
    }
}
