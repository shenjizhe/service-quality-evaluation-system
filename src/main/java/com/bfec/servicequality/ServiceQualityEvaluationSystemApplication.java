
/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: ServiceQuanlityEvalutionSystemApplication.java
 * @Author: JasonShen
 * @Date: 2021-08-27 09:37:56
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

package com.bfec.servicequality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 *
 * @author JasonShen
 */
@MapperScan(value = "com.bfec.servicequality.*.mapper")
@SpringBootApplication
public class ServiceQualityEvaluationSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceQualityEvaluationSystemApplication.class, args);
    }
}
