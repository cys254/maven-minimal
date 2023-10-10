package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

@Configuration
@EnableIntegration
public class HelloConfig {

    @Bean
    public IntegrationFlow plusOneFlow() {
        return IntegrationFlows.from("plus_one_input")
               .<Integer>handle((p,h)->p+1)
               .channel("plus_one_output")
               .get();
    }

    @Bean
    public B bean_b(A bean_a) {
        return new B(bean_a);
    }
}

class B {
    A a;
    boolean positive;
    public B(A a) { this.a = a; positive = a.getValue().equals(""); }
}

class A {
    String v;
    public A(String v) { this.v = v; }
    public String getValue() { return v; }
}
