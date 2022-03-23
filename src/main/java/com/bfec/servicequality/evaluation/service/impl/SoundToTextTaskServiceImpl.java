/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: SoundToTextTaskServiceImpl.java
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

package com.bfec.servicequality.evaluation.service.impl;

import com.bfec.servicequality.evaluation.entity.SoundToTextTask;
import com.bfec.servicequality.evaluation.mapper.SoundToTextTaskMapper;
import com.bfec.servicequality.evaluation.service.SoundToTextTaskService;
import com.common.model.mapper.MyMapper;
import com.common.model.mapper.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 语音识别任务表 服务实现
 *
 * @author Jason Shen
 * @version 1.0
 * @date 2022-03-23 13:41:10
 */
@Service
public class SoundToTextTaskServiceImpl
    extends BaseServiceImpl<SoundToTextTask>
    implements SoundToTextTaskService {

    @Resource
    private SoundToTextTaskMapper mapper;

    @Override
    protected MyMapper getMapper() {
    return mapper;
    }
}
