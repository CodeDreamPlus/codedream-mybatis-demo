package com.codedreamplus.student.config;

import com.codedreamplus.mybatis.plugins.MybatisPlusAutoFill;
import com.codedreamplus.mybatis.plugins.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ShiJianlong
 * @date 2022/3/21 23:04
 */

@Configuration(proxyBeanMethods = false)
public class CodeDreamConfig {
    @Bean
    public UserHandler userHandler() {
        return new UserHandler() {
            @Override
            public Long getUserId() {
                return 444444L;
            }
        };
    }

    @Bean
    public MybatisPlusAutoFill mybatisPlusAutoFill(UserHandler userHandler) {
        return new MybatisPlusAutoFill(userHandler);
    }
}
