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
}

