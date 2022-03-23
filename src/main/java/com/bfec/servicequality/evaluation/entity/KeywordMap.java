/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: KeywordMap.java
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
 * 关键词字典 实体
 *
 * @author shenjizhe
 * @data: 2022-03-23 13:41:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "KeywordMap", description = "关键词字典")
@Table(name = "keyword_map")
public class KeywordMap {
    private static final long serialVersionUID = 8119150671246602994L;

    /**
     * 字典ID
     * id
     */
    @Id
    @Column(name = "`id`")
    @ApiModelProperty(value = "字典ID", required = true, dataType = "Long", example = "0")
    private Long id;

    /**
     * 关键词
     * keyword
     */
    @Column(name = "`keyword`")
    @ApiModelProperty(value = "关键词", required = true, dataType = "String", example = "test")
    private String keyword;

    /**
     * 关键词分类（1. 敏感词 ）
     * type
     */
    @Column(name = "`type`")
    @ApiModelProperty(value = "关键词分类（1. 敏感词 ）", required = true, dataType = "Integer", example = "0")
    private Integer type;

    /**
     * 创建时间
     * createTime
     */
    @Column(name = "`create_time`")
    @ApiModelProperty(value = "创建时间", required = true, dataType = "Date", example = "2022-03-23 13:41:10")
    private Date createTime;

    /**
     * 修改时间
     * updateTime
     */
    @Column(name = "`update_time`")
    @ApiModelProperty(value = "修改时间", required = true, dataType = "Date", example = "2022-03-23 13:41:10")
    private Date updateTime;
}