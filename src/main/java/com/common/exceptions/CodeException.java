/*
* Copyright 2021-2099 the original author or authors.
*
* @File: CodeException.java
* @Author: JasonShen
* @Date: 2021-09-15 13:37:10
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

package com.common.exceptions;

import com.common.model.IErrorCode;

/**
 * 代码异常
 *
 * @Author: JasonShen
 * @Date: 2021/8/17
 */
public abstract class CodeException extends Exception implements IErrorCode {

    public CodeException(Exception e) {
        super(e);
    }

    public CodeException() {
    }
}

