package hello.advanced;

import hello.advanced.traced.logtrace.FieldLogTrace;
import hello.advanced.traced.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new FieldLogTrace();
    }
}
