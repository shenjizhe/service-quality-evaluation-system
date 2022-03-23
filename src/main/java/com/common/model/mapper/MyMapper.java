/*
 * Copyright 2021-2099 the original author or authors.
 *
 * @File: MyMapper.java
 * @Author: JasonShen
 * @Date: 2021-09-06 13:13:02
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

import tk.mybatis.mapper.common.*;

/**
 * 自定义 mapper 基接口
 *
 * @author Jason Shen
 * @version 1.0
 * @date 2021/9/6 9:54
 */
public interface MyMapper<T>
        extends Mapper<T>,
        MySqlMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        ExampleMapper<T> {
 /**
 * 插入并返回生成的主键
 *
 * @param record 插入的对象
 * @return
 */
 default T insertWithKey(T record) {
  try {
   int insert = insert(record);
   if (insert == 0) {
    return null;
   } else {
    T t = selectOne(record);
    return t;
   }
  } catch (Exception e) {
   e.printStackTrace();
   return null;
  }
 }
}
