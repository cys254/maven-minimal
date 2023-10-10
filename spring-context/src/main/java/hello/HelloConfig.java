package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class HelloConfig {

    @Bean
    public int one() {
        return 1;
    }

    @Bean
    public Integer two(String x) {
        return Integer.valueOf(x);
    }
}
