/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: BaseServiceImpl.java
 * @Author: JasonShen
 * @Date: 2021-09-07 10:22:57
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

package com.common.model.mapper.impl;

import com.common.model.mapper.BaseService;
import com.common.model.mapper.MyMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 抽象实现服务基类
 *
 * @author Jason Shen
 * @version 1.0
 * @date 2021/9/7 10:22
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    /**
     * 取得映射
     *
     * @return 映射
     */
    protected abstract MyMapper<T> getMapper();

    @Override
    public int deleteByPrimaryKey(Object key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    @Override
    public int delete(T record) {
        return getMapper().delete(record);
    }

    @Override
    public int insert(T record) {
        return getMapper().insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return getMapper().insertSelective(record);
    }

    @Override
    public boolean existsWithPrimaryKey(Object key) {
        return getMapper().existsWithPrimaryKey(key);
    }

    @Override
    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return getMapper().selectByPrimaryKey(key);
    }

    @Override
    public int selectCount(T record) {
        return getMapper().selectCount(record);
    }

    @Override
    public List<T> select(T record) {
        return getMapper().select(record);
    }

    @Override
    public T selectOne(T record) {
        return getMapper().selectOne(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return getMapper().updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByCondition(Object condition) {
        return getMapper().deleteByCondition(condition);
    }

    @Override
    public List<T> selectByCondition(Object condition) {
        return getMapper().selectByCondition(condition);
    }

    @Override
    public int selectCountByCondition(Object condition) {
        return getMapper().selectCountByCondition(condition);
    }

    @Override
    public int updateByCondition(T record, Object condition) {
        return getMapper().updateByCondition(record, condition);
    }

    @Override
    public int updateByConditionSelective(T record, Object condition) {
        return getMapper().updateByConditionSelective(record, condition);
    }

    @Override
    public int deleteByExample(Object example) {
        return getMapper().deleteByExample(example);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return getMapper().selectByExample(example);
    }

    @Override
    public int selectCountByExample(Object example) {
        return getMapper().selectCountByExample(example);
    }

    @Override
    public T selectOneByExample(Object example) {
        return getMapper().selectOneByExample(example);
    }

    @Override
    public int updateByExample(T record, Object example) {
        return getMapper().updateByExample(record, example);
    }

    @Override
    public int updateByExampleSelective(T record, Object example) {
        return getMapper().updateByExampleSelective(record, example);
    }

    @Override
    public int deleteByIds(String ids) {
        return getMapper().deleteByIds(ids);
    }

    @Override
    public List<T> selectByIds(String ids) {
        return getMapper().selectByIds(ids);
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return getMapper().selectByExampleAndRowBounds(example, rowBounds);
    }

    @Override
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return getMapper().selectByRowBounds(record, rowBounds);
    }

    @Override
    public int insertList(List<? extends T> recordList) {
        return getMapper().insertList(recordList);
    }

    @Override
    public int insertUseGeneratedKeys(T record) {
        return getMapper().insertUseGeneratedKeys(record);
    }
}
