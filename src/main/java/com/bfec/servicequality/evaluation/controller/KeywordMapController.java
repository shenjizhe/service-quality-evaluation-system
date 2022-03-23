/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: KeywordMapController.java
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

package com.bfec.servicequality.evaluation.controller;

import com.common.model.Result;
import com.bfec.servicequality.evaluation.entity.KeywordMap;
import com.bfec.servicequality.evaluation.service.KeywordMapService;
import com.common.model.mapper.BaseController;
import com.common.model.mapper.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 关键词字典 控制器
 *
 * @author shenjizhe
 * @date 2022-03-23 13:41:10
 */
@Slf4j
@RestController
@RequestMapping("/keyword-maps")
@Api(tags = "关键词字典")
public class KeywordMapController extends BaseController<KeywordMap> {
    @Autowired
    private KeywordMapService service;

    @Override
    public BaseService getService() {
        return service;
    }


    /**
     * 关键词字典-批量查询
     */
    @ApiOperation(value = "关键词字典-批量查询", notes = "")
    @GetMapping("/batch/")
    public Result<List<KeywordMap>> batchSelect(
            @Parameter String ids
    ) {
        if (ids != null && !ids.isEmpty()) {
            return super.selectByIds(ids);
        } else {
            return super.selectAll();
        }

    }

    /**
     * 关键词字典-批量添加
     */
    @ApiOperation(value = "关键词字典-批量添加", notes = "")
    @PostMapping("/batch/")
    public Result<Integer> batchInsert(
            @RequestBody List<KeywordMap> records
    ) {
        return super.insertList(records);
    }

    /**
     * 关键词字典-批量删除
     */
    @ApiOperation(value = "关键词字典-批量删除", notes = "")
    @DeleteMapping("/batch/")
    public Result<Integer> batchDelete(
            @Parameter String ids
    ) {
        return super.deleteByIds(ids);
    }

    /**
     * 关键词字典-添加
     */
    @ApiOperation(value = "关键词字典-添加", notes = "")
    @PostMapping("/")
    public Result<Integer> singleInsert(
            @RequestBody KeywordMap record
    ) {
        return super.insert(record);
    }

    /**
     * 关键词字典-修改
     */
    @ApiOperation(value = "关键词字典-修改", notes = "")
    @PutMapping("/")
    public Result<Integer> singleUpdate(
            @RequestBody KeywordMap record
    ) {
        return super.update(record);
    }

    /**
     * 关键词字典-删除
     */
    @ApiOperation(value = "关键词字典-删除", notes = "")
    @DeleteMapping("/{id}/")
    public Result<Integer> singleDelete(
            @PathVariable Long id
    ) {
        return  super.delete(id);
    }
}
