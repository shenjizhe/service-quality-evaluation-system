/*
 * Copyright 2021-2099 the original author or authors.
 *
 *  @Project: service-quality-evaluation-system
 *  @File: EventType.java
 *  @Author: Json Shen
 *  @Date: 2022/3/23 下午8:23
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

package com.bfec.servicequality.enums;

/**
 * 事件类型
 * @author JasonShen
 */
public enum EventType {
    GetInfo(1, "获取用户信息"),
    IVRCheck(2, "IVR校验"),
    IVRInterface(3, "自定义IVR接口"),
    PlayContent(4, "播放内容接口"),
    RecordAfterHungUp(5, "挂断时同步通话记录"),
    RecordInfo(6, "同步电话服务记录字段"),
    RecordCallIn(7, "接起时同步通话记录"),
    ;

    EventType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * 检查值是否一致
     *
     * @param value 要检查的值
     * @return 是否一致
     */
    public boolean check(int value){
        return value == this.value;
    }

    /**
     * 类型值
     */
    private int value;

    /**
     * 名称
     */
    private String name;
}
