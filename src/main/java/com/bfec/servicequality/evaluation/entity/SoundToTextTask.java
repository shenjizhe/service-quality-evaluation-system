/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: SoundToTextTask.java
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

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 语音识别任务表 实体
 *
 * @author shenjizhe
 * @data: 2022-03-23 13:41:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SoundToTextTask", description = "语音识别任务表")
@Table(name = "sound_to_text_task")
public class SoundToTextTask {
    private static final long serialVersionUID = 2612795363931021492L;

    /**
     * 主键
     * id
     */
    @Id
    @Column(name = "`id`")
    @ApiModelProperty(value = "主键", required = true, dataType = "Long", example = "0")
    private Long id;

    /**
     * 冗余客服记录的ID
     * serviceRecordId
     */
    @Column(name = "`service_record_id`")
    @ApiModelProperty(value = "冗余客服记录的ID", required = true, dataType = "Long", example = "0")
    private Long serviceRecordId;

    /**
     * 任务ID
     * taskId
     */
    @Column(name = "`task_id`")
    @ApiModelProperty(value = "任务ID", required = true, dataType = "String", example = "test")
    private String taskId;

    /**
     * 请求ID
     * requestId
     */
    @Column(name = "`request_id`")
    @ApiModelProperty(value = "请求ID", required = true, dataType = "String", example = "test")
    private String requestId;

    /**
     * 状态码
     * statusCode
     */
    @Column(name = "`status_code`")
    @ApiModelProperty(value = "状态码", required = true, dataType = "Integer", example = "0")
    private Integer statusCode;

    /**
     * 状态说明
     * statusText
     */
    @Column(name = "`status_text`")
    @ApiModelProperty(value = "状态说明", required = true, dataType = "String", example = "test")
    private String statusText;

    /**
     * 日期(冗余 - 客服结束时间的日期)
     * day
     */
    @Column(name = "`day`")
    @ApiModelProperty(value = "日期(冗余 - 客服结束时间的日期)", required = true, dataType = "Date", example = "2022-03-23 13:41:10")
    private Date day;
}