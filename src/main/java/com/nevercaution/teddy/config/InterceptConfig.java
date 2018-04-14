package com.nevercaution.teddy.config;

import com.nevercaution.teddy.handler.CustomResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class InterceptConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(getCustomResolver());
    }

    @Bean
    public CustomResolver getCustomResolver() {
        return new CustomResolver();
    }
}
