/*
 * Copyright 2021-2099 the original author or authors.
 *
 *  @Project: service-quality-evaluation-system
 *  @File: Config.java
 *  @Author: Json Shen
 *  @Date: 2022/3/23 下午5:26
 *  @Email: thirdlucky@126.com
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

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 系统参数
 *
 * @author Jason Shen
 * @version 1.0
 * @date 2022/3/23 17:26
 */

@PropertySource(value = {"classpath:config.properties"},encoding = "utf-8")
@Configuration
@Data
public class Config {

    /**
     * 七鱼 app 秘钥
     */
    @Value("${qiyu.appSecret}")
    private String qiyuAppSecret;
}
