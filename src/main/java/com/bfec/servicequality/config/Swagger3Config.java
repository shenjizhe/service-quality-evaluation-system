/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: Swagger3Config.java
 * @Author: JasonShen
 * @Date: 2021-09-15 20:33:52
 * @Email: thirdlucky@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bfec.servicequality.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author JasonShen
 */
@PropertySource(value = {"classpath:Swagger3.properties"},encoding = "utf-8")
@EnableOpenApi
@Configuration
public class Swagger3Config {

    @Value("${application.restApi.enabled}")
    private Boolean enabled;
    @Value("${application.name}")
    private String applicationName;
    @Value("${application.version}")
    private String applicationVersion;
    @Value("${application.description}")
    private String applicationDescription;
    @Value("${application.group01}")
    private String applicationGroup01;
    @Value("${application.host}")
    private String host;
    @Value("${application.apis.selector}")
    private String selector;


    @Bean
    public Docket docket() {
        Docket build = new Docket(DocumentationType.OAS_30)
                .host(host)
                .apiInfo(apiInfo())
                .enable(enabled)
                .groupName(applicationGroup01)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(selector))
                .paths(PathSelectors.any()).build();
        return build;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(applicationName).description(applicationDescription).version(applicationVersion).build();
    }
}