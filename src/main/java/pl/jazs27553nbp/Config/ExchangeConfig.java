package pl.jazs27553nbp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class ExchangeConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
