package com.hdragon.blog.infra.common;

import com.hdragon.blog.domain.ranking.repository.RankingRepository;
import com.hdragon.blog.infra.interceptor.RankingInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final RankingRepository rankingRepository;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new RankingInterceptor(rankingRepository))
                .addPathPatterns("/search/*");
    }

}