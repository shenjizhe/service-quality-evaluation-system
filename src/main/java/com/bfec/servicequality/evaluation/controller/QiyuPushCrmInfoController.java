/*
 * Copyright 2021-2099 the original author or authors.
 *
 *  @Project: service-quality-evaluation-system
 *  @File: QiyuPushCrmInfoController.java
 *  @Author: Json Shen
 *  @Date: 2022/3/23 下午4:56
 *  @Email: thirdlucky@126.com
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

import com.alibaba.fastjson.JSON;
import com.bfec.servicequality.config.Config;
import com.bfec.servicequality.evaluation.entity.CustomerServiceRecord;
import com.bfec.servicequality.evaluation.service.CustomerServiceRecordService;
import com.bfec.servicequality.utils.QiyuPushCheckSum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.bfec.servicequality.enums.EventType.RecordAfterHungUp;

/**
 * 客户服务信息 控制器
 *
 * @author shenjizhe
 * @date 2022-03-23 13:41:10
 */
@Slf4j
@RestController
@RequestMapping("/")
@Api(tags = "客户服务信息")
public class QiyuPushCrmInfoController {
    /**
     * 七鱼推送接口结果错误枚举
     */
    public enum ErrorCode {
        /**
         * 正确
         */
        Success(200, ""),
        /**
         * 校验和错误
         */
        CheckSumFail(14002, "校验和错误"),
        /**
         * 时间不正确
         */
        TimeFail(14003, "时间错误"),
        /**
         * 内容格式错误
         */
        ContentFormatFail(14004, "内容格式校验错误"),
        /**
         * 服务器内部错误
         */
        ServiceFail(14500, "服务器内部错误"),
        ;

        /**
         * 七鱼错误枚举
         *
         * @param code    错误码
         * @param message 错误消息
         */
        ErrorCode(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * 返回码,200表示成功
         */
        Integer code;

        /**
         * 请求错误时，填错误提示信息。
         */
        String message;
    }

    /**
     * 七鱼推送接口返回结果
     */
    @Data
    @AllArgsConstructor
    public final class Result {
        /**
         * 七鱼推送结果构造器
         *
         * @param code 结果错误枚举
         */
        public Result(ErrorCode code) {
            this.code = code.code;
            this.message = code.message;
        }

        /**
         * 返回码,200表示成功
         */
        Integer code;

        /**
         * 请求错误时，填错误提示信息。
         */
        String message;

        /**
         * code为200时，该返回值有效。
         * eventtype=1时返回访客信息，为JSON格式数据；
         * eventtype=4时返回播放的文本内容，为String格式数据；其他该值可以为空。
         */
        String result;
    }

    @Autowired
    private Config config;

    @Autowired
    private CustomerServiceRecordService customerServiceRecordService;

    /**
     * 七鱼客服推送信息回调接口
     */
    @ApiOperation(value = "七鱼客服推送信息回调接口", notes = "")
    @RequestMapping(value = "/crminfo", method = RequestMethod.POST)
    @ResponseBody
    public Result pushCustomeServiceCallRecord(
            @RequestParam(value = "checksum", required = true) String checksum,
            @RequestParam(value = "time", required = true) String time,
            @RequestBody(required = true) String json
    ) {
        // TODO: 没完成，需要七鱼账户提供 App Security Key
        // 1. check the params
        String sum = QiyuPushCheckSum.checksum(config.getQiyuAppSecret(), json, time);
        if (!sum.equals(checksum)) {
            return new Result(ErrorCode.CheckSumFail);
        }

        // 2. save custom service call info to db
        CustomerServiceRecord record = JSON.parseObject(json, CustomerServiceRecord.class);
        customerServiceRecordService.insert(record);

        // 3. check event type (it with be deal when its event type equals 5)
        if (!RecordAfterHungUp.check(record.getEventType())) {
            return new Result(ErrorCode.Success);
        }


        // TODO: whether it need be asynchronized?
        // 4. upload sound record to the STT service
        return null;
    }

}
