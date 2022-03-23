/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: KeywordMapMapper.java
 * @Author: JasonShen
 * @Date: 2022-03-23 13:41:10
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

package com.bfec.servicequality.evaluation.mapper;

import com.bfec.servicequality.evaluation.entity.KeywordMap;
import com.common.model.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 关键词字典 映射
 *
 * @author Jason Shen
 * @version 1.0
 * @date 2021/9/7 14:55
 */
@Mapper
public interface KeywordMapMapper extends MyMapper<KeywordMap> {

}
