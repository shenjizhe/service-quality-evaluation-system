/**
 * Copyright 2021-2099 the original author or authors.
 *
 * @Project: service-quality-evaluation-system
 * @File: RequestKey.java
 * @Author: Json Shen
 * @Date: 2022/3/23 下午7:53
 * @Email: thirdlucky@126.com
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bfec.servicequality.config;

/***
 * 请求键名称
 *
 * @author JasonShen
 */
public final class RequestKey {
    /***
     * 七鱼推送事件类型
     * <p>
     * 1 - 获取用户信息
     * 2 - VR校验
     * 3 - 自定义IVR接口
     * 4 - 播放内容接口
     * 5 - 挂断时同步通话记录
     * 6 - 同步电话服务记录字段
     * 7 - 接起时同步通话记录
     */
    public final static String EVENT_TYPE = "eventtype";

    /**
     * 会话ID
     */
    public final static String SESSION_ID = "sessionid";

    /**
     * 呼叫方向
     */
    public final static String DIRECTION = "direction";

    /**
     * 创建时间
     */
    public final static String CREATE_TIME = "createtime";

    /**
     * 连接开始时间
     */
    public final static String CONNECTION_BEGINE_TIME = "connectionbeginetime";

    /**
     * 连接结束时间
     */
    public final static String CONNECTION_END_TIME = "connectionendtime";

    /**
     * 呼叫方
     */
    public final static String FROM = "from";

    /**
     * 接收方
     */
    public final static String TO = "to";

    /**
     * 客户名称
     */
    public final static String USER = "user";

    /**
     * 资讯分类
     */
    public final static String CATEGORY = "category";

    /**
     * 员工id
     */
    public final static String STAFF_ID = "staffid";

    /**
     * 员工姓名
     */
    public final static String STAFF_NAME = "staffname";

    /**
     * 会话状态
     */
    public final static String STATUS = "status";

    /**
     * 重复咨询次数
     */
    public final static String VISIT_TIMES = "visittimes";

    /**
     * 通话时长
     */
    public final static String DURATION = "duration";

    /**
     * 满意度
     */
    public final static String EVALUATION = "evaluation";

    /**
     * 通话录音文件地址
     */
    public final static String RECORD_URL = "record_url";

    /**
     * 溢出来源
     */
    public final static String OVERFLOW_FROM = "overflowFrom";

    /**
     * 分流客服组
     */
    public final static String SHUNT_GROUP_NAME = "shuntGroupName";

    /**
     * ivr路径
     */
    public final static String IVR_PATH = "ivrPath";

    /**
     * 号码归属地
     */
    public final static String MOBILE_AREA = "mobileArea";

    /**
     * 排队等待时长
     */
    public final static String WAIT_DURATION = "waitDuration";

    /**
     * 振铃时长
     */
    public final static String RING_DURATION = "ringDuration";

    /**
     * 转接的上一通会话ID
     */
    public final static String SESSION_ID_FROM = "sessionIdFrom";
}
