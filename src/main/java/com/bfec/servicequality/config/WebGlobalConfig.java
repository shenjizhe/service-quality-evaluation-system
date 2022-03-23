
/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: WebGlobalConfig.java
 * @Author: JasonShen
 * @Date: 2021-12-03 13:43:55
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

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** 网络配置，主要为了解决跨域问题
 * @author JasonShen*/
@Configuration
public class WebGlobalConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        // .allowedOrigins("http://yyy.com", "http://xxx.com") //
        // 允许跨域的域名
        .allowedOriginPatterns("*")
        .allowedMethods("*")
        .allowedHeaders("*")
        .allowCredentials(true)
        .exposedHeaders(HttpHeaders.SET_COOKIE)
        .maxAge(3600L);
  }
}
