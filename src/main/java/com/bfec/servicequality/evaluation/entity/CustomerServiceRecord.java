/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: CustomerServiceRecord.java
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

package com.bfec.servicequality.evaluation.entity;

import javax.persistence.*;

import com.alibaba.fastjson.annotation.JSONField;
import com.bfec.servicequality.config.RequestKey;
import com.bfec.servicequality.evaluation.controller.QiyuPushCrmInfoController;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 客户服务记录 实体
 *
 * @author shenjizhe
 * @data: 2022-03-23 13:41:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CustomerServiceRecord", description = "客户服务记录")
@Table(name = "customer_service_record")
public class CustomerServiceRecord {
    private static final long serialVersionUID = 2935799905004420207L;

    /**
     * 主键
     * id
     */
    @Id
    @Column(name = "`id`")
    @ApiModelProperty(value = "主键", required = true, dataType = "Long", example = "0")
    private Long id;

    /**
     * 事件类型
     * eventType
     */
    @Column(name = "`event_type`")
    @ApiModelProperty(value = "事件类型", required = true, dataType = "Integer", example = "0")
    @JSONField(name = RequestKey.EVENT_TYPE)
    private Integer eventType;

    /**
     * 会话ID
     * sessionId
     */
    @Column(name = "`session_id`")
    @ApiModelProperty(value = "会话ID", required = true, dataType = "Long", example = "0")
    @JSONField(name = RequestKey.SESSION_ID)
    private Long sessionId;

    /**
     * 创建时间
     * createTime
     */
    @Column(name = "`create_time`")
    @ApiModelProperty(value = "创建时间", required = true, dataType = "Date", example = "2022-03-23 13:41:10")
    @JSONField(name = RequestKey.CREATE_TIME)
    private Date createTime;

    /**
     * 连接开始时间
     * connectionBeginTime
     */
    @Column(name = "`connection_begin_time`")
    @ApiModelProperty(value = "连接开始时间", required = true, dataType = "Date", example = "2022-03-23 13:41:10")
    @JSONField(name = RequestKey.CONNECTION_BEGINE_TIME)
    private Date connectionBeginTime;

    /**
     * 连接结束时间
     * connetionEndTime
     */
    @Column(name = "`connetion_end_time`")
    @ApiModelProperty(value = "连接结束时间", required = true, dataType = "Date", example = "2022-03-23 13:41:10")
    @JSONField(name = RequestKey.CONNECTION_END_TIME)
    private Date connetionEndTime;

    /**
     * 呼叫网
     * from
     */
    @Column(name = "`from`")
    @ApiModelProperty(value = "呼叫网", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.FROM)
    private String from;

    /**
     * 接收方
     * to
     */
    @Column(name = "`to`")
    @ApiModelProperty(value = "接收方", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.TO)
    private String to;

    /**
     * 客户名称
     * user
     */
    @Column(name = "`user`")
    @ApiModelProperty(value = "客户名称", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.USER)
    private String user;

    /**
     * 资讯分类
     * category
     */
    @Column(name = "`category`")
    @ApiModelProperty(value = "资讯分类", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.CATEGORY)
    private String category;

    /**
     * 员工id
     * staffId
     */
    @Column(name = "`staff_id`")
    @ApiModelProperty(value = "员工id", required = true, dataType = "Integer", example = "0")
    @JSONField(name = RequestKey.STAFF_ID)
    private Integer staffId;

    /**
     * 员工姓名
     * staffName
     */
    @Column(name = "`staff_name`")
    @ApiModelProperty(value = "员工姓名", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.STAFF_NAME)
    private String staffName;

    /**
     * 会话状态
     * status
     */
    @Column(name = "`status`")
    @ApiModelProperty(value = "会话状态", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.STATUS)
    private String status;

    /**
     * 通话时长
     * duration
     */
    @Column(name = "`duration`")
    @ApiModelProperty(value = "通话时长", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.DURATION)
    private String duration;

    /**
     * 满意度
     * evaluation
     */
    @Column(name = "`evaluation`")
    @ApiModelProperty(value = "满意度", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.EVALUATION)
    private String evaluation;

    /**
     * 通话录音文件地址
     * recordUrl
     */
    @Column(name = "`record_url`")
    @ApiModelProperty(value = "通话录音文件地址", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.RECORD_URL)
    private String recordUrl;

    /**
     * 号码归属地
     * mobileArea
     */
    @Column(name = "`mobile_area`")
    @ApiModelProperty(value = "号码归属地", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.MOBILE_AREA)
    private String mobileArea;

    /**
     * 排队等待时长
     * waitDuration
     */
    @Column(name = "`wait_duration`")
    @ApiModelProperty(value = "排队等待时长", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.WAIT_DURATION)
    private String waitDuration;

    /**
     * 振铃时长
     * ringRuration
     */
    @Column(name = "`ring_ruration`")
    @ApiModelProperty(value = "振铃时长", required = true, dataType = "String", example = "test")
    @JSONField(name = RequestKey.RING_DURATION)
    private String ringRuration;

    /**
     * 转接的上一通会话ID
     * sessionidFrom
     */
    @Column(name = "`sessionId_from`")
    @ApiModelProperty(value = "转接的上一通会话ID", required = true, dataType = "Long", example = "0")
    @JSONField(name = RequestKey.SESSION_ID_FROM)
    private Long sessionidFrom;

    /**
     * 日期(冗余 - 客服结束时间的日期)
     * day
     */
    @Column(name = "`day`")
    @ApiModelProperty(value = "日期(冗余 - 客服结束时间的日期)", required = true, dataType = "Date", example = "2022-03-23 13:41:10")
    private Date day;
}