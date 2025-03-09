package com.unitbv.quizz_app.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();

        // Pre-define cache names
        cacheManager.setCacheNames(Arrays.asList(
                "categories",
                "difficulties",
                "questions",
                "answers",
                "questionsByCategory",
                "questionsByDifficulty",
                "searchResults"
        ));

        return cacheManager;
    }
}