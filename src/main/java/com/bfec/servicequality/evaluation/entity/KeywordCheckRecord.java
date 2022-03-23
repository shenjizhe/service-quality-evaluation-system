/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: KeywordCheckRecord.java
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
 * 关键词检查记录 实体
 *
 * @author shenjizhe
 * @data: 2022-03-23 13:41:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "KeywordCheckRecord", description = "关键词检查记录")
@Table(name = "keyword_check_record")
public class KeywordCheckRecord {
    private static final long serialVersionUID = 5511409471438360193L;

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
     * 语句记录ID
     * resultId
     */
    @Column(name = "`result_id`")
    @ApiModelProperty(value = "语句记录ID", required = true, dataType = "Long", example = "0")
    private Long resultId;

    /**
     * 检查时间
     * checkTime
     */
    @Column(name = "`check_time`")
    @ApiModelProperty(value = "检查时间", required = true, dataType = "Date", example = "2022-03-23 13:41:10")
    private Date checkTime;

    /**
     * 检查列表（关键词，结果语句位置...）
     * checkList
     */
    @Column(name = "`check_list`")
    @ApiModelProperty(value = "检查列表（关键词，结果语句位置...）", required = true, dataType = "String", example = "{\"name\": \"jason.shen\"}")
    private String checkList;

    /**
     * 日期(冗余 - 客服结束时间的日期)
     * day
     */
    @Column(name = "`day`")
    @ApiModelProperty(value = "日期(冗余 - 客服结束时间的日期)", required = true, dataType = "Date", example = "2022-03-23 13:41:10")
    private Date day;
}