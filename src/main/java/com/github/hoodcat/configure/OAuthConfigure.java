package com.github.hoodcat.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:oauth.properties")
public class OAuthConfigure {
    
}
