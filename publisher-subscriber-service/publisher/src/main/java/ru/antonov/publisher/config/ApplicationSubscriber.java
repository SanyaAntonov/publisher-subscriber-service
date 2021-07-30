package ru.antonov.publisher.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.subscriber")
@Getter
@Setter
public class ApplicationSubscriber {
    private String postApi;

}
