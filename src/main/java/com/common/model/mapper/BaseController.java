/*
* Copyright 2021-2099 the original author or authors.
*
* @File: base-controller.vm
* @Author: JasonShen
* @Date: 2021-08-26 16:28:06
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

package com.common.model.mapper;

import com.common.model.Result;

import java.util.List;

/**
* 基础控制器类
*
* @author shenjizhe
* @data: 2021/9/12 9:59
*/
public abstract class BaseController<T> {

    /**
    * 取得服务
    *
    * @return 服务
    */
    public abstract BaseService<T> getService();
    
    /**
    * 删除单条
    *
    * @param id 主键
    * @return 删除的数量
    */
    public Result<Integer> delete(long id) {
        BaseService<T> service = getService();
        int count = service.deleteByPrimaryKey(id);
        return Result.success(count);
    }
    
    /**
    * 批量查询
    *
    * @param ids 逗号分割的逐渐列表
    * @return 实体列表
    */
    public Result<List<T>> selectByIds(String ids) {
        BaseService<T> service = getService();
        List<T> list = service.selectByIds(ids);
        return Result.success(list);
    }
    
    /**
    * 批量删除
    *
    * @param ids 逗号分割的逐渐列表
    * @return 被删除的数量
    */
    public Result<Integer> deleteByIds(String ids) {
        BaseService<T> service = getService();
        int count = service.deleteByIds(ids);
        return Result.success(count);
    }
    
    /**
    * 插入单条
    *
    * @param record 实体记录
    * @return 插入的数量
    */
    public Result<Integer> insert(T record) {
        BaseService<T> service = getService();
        int count = service.insert(record);
        return Result.success(count);
    }
    
    /**
    * 批量添加
    *
    * @param records 实体记录列表
    * @return 被插入的数量
    */
    public Result<Integer> insertList(List<T> records) {
        BaseService<T> service = getService();
        int count = service.insertList(records);
        return Result.success(count);
    }
    
    /**
    * 添加带着ID
    *
    * @param record 实体记录，实体本身的id会被赋值
    * @return 被插入的数量
    */
    public Result<T> insertWithKeys(T record) {
        BaseService<T> service = getService();
        service.insertUseGeneratedKeys(record);
        return Result.success(record);
    }
    
    /**
    * 批量添加带着ID
    *
    * @param records 实体记录列表
    * @return 被插入的数量
    */
    public Result<Integer> insertListWithKeys(List<T> records) {
        BaseService<T> service = getService();
        int count = 0;
        if (records != null) {
            for (T record : records) {
                count += service.insertUseGeneratedKeys(record);
            }
        }
        return Result.success(count);
    }
    
    /**
    * 存在检测
    *
    * @param id 指定的记录的ID
    * @return 是否存在
    */
    public Result<Boolean> exists(long id) {
        BaseService<T> service = getService();
        Boolean exists = service.existsWithPrimaryKey(id);
        return Result.success(exists);
    }
    
    /** 查询所有 @return 实体记录列表 */
    public Result<List<T>> selectAll() {
        BaseService<T> service = getService();
        List<T> list = service.selectAll();
        return Result.success(list);
    }
    
    /**
    * 查询符合条件的数量
    *
    * @param record 数据条件
    * @return 统计数量
    */
    public Result<Integer> selectCount(T record) {
        BaseService<T> service = getService();
        int count = service.selectCount(record);
        return Result.success(count);
    }
    
    /**
    * 查询指定条件的济洛路
    *
    * @param record 数据条件
    * @return 结果记录列表
    */
    public Result<List<T>> select(T record) {
        BaseService<T> service = getService();
        List<T> list = service.select(record);
        return Result.success(list);
    }
    
    /**
    * 查询第一条
    *
    * @param record 指定条件
    * @return 返回的第一条符合的记录
    */
    public Result<T> selectOne(T record) {
        BaseService<T> service = getService();
        T r = service.selectOne(record);
        return Result.success(r);
    }
    
    /**
    * 查询记录
    *
    * @param id 数据ID
    * @return 结果记录
    */
    public Result<T> select(long id) {
        BaseService<T> service = getService();
        T r = service.selectByPrimaryKey(id);
        return Result.success(r);
    }
    
    /**
    * 更新记录
    *
    * @param record 按照ID更新记录
    * @return 更新的数量
    */
    public Result<Integer> update(T record) {
        BaseService<T> service = getService();
        int count = service.updateByPrimaryKey(record);
        return Result.success(count);
    }
    
    /**
    * 批量修改或者添加数据（主键存在则修改，主键不存在则新增）
    *
    * @param records 记录列表
    * @return 成功的数量
    */
    public Result<Integer> updateList(List<T> records) {
        BaseService<T> service = getService();
        int count = 0;
        for (T record : records) {
            int i = service.updateByPrimaryKey(record);
            if (i > 0) {
                count++;
            } else {
                int insert = service.insert(record);
                count += insert;
            }
        }
        return Result.success(count);
    }
    
    /**
    * 插入的同时返回数据（要求数据不能完全可以重复）
    *
    * @param record 要插入的数据
    * @return 相同的第一条数据
    */
    public Result<T> insertWithKey(T record) {
        BaseService<T> service = getService();
        T r = service.insertWithKey(record);
        return Result.success(r);
    }
}
