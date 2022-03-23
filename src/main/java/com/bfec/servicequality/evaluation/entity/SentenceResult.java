/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: SentenceResult.java
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
 * 语句识别结果 实体
 *
 * @author shenjizhe
 * @data: 2022-03-23 13:41:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SentenceResult", description = "语句识别结果")
@Table(name = "sentence_result")
public class SentenceResult {
    private static final long serialVersionUID = 3129860718646447923L;

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
    @ApiModelProperty(value = "任务ID", required = true, dataType = "Long", example = "0")
    private Long taskId;

    /**
     * 请求ID
     * requestId
     */
    @Column(name = "`request_id`")
    @ApiModelProperty(value = "请求ID", required = true, dataType = "String", example = "test")
    private String requestId;

    /**
     * 识别的结果数据
     * sentences
     */
    @Column(name = "`sentences`")
    @ApiModelProperty(value = "识别的结果数据", required = true, dataType = "String", example = "{\"name\": \"jason.shen\"}")
    private String sentences;

    /**
     * 词信息
     * words
     */
    @Column(name = "`words`")
    @ApiModelProperty(value = "词信息", required = true, dataType = "String", example = "{\"name\": \"jason.shen\"}")
    private String words;

    /**
     * 识别音频总时长（毫秒）
     * bizDuration
     */
    @Column(name = "`biz_duration`")
    @ApiModelProperty(value = "识别音频总时长（毫秒）", required = true, dataType = "Long", example = "0")
    private Long bizDuration;

    /**
     * 日期(冗余 - 客服结束时间的日期)
     * day
     */
    @Column(name = "`day`")
    @ApiModelProperty(value = "日期(冗余 - 客服结束时间的日期)", required = true, dataType = "Date", example = "2022-03-23 13:41:10")
    private Date day;
}