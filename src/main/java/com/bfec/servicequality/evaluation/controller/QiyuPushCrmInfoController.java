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
import com.alibaba.fastjson.JSONObject;
import com.bfec.servicequality.config.Config;
import com.bfec.servicequality.utils.QiyuPushCheckSum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 请求键名称
     */
    public final static class RequestKey {
        /**
         * 七鱼推送事件类型
         * <p>
         * 1 - 获取用户信息
         * 2 - VR校验
         * 3 - 自定义IVR接口
         * 4 - 播放内容接口
         * 5 - 挂断时同步通话记录
         * 6 - 同步电话服务记录字段
         * 7 - 接起时同步通话记录
         */
        public static String EVENT_TYPE = "eventtype";

        /*
         * 	会话ID
         */
        public static String SESSION_ID = "sessionid";

        /*
         * 	呼叫方向
         */
        public static String DIRECTION = "direction";

        /*
         * 	创建时间
         */
        public static String CREATE_TIME = "createtime";

        /*
         * 	连接开始时间
         */
        public static String CONNECTION_BEGINE_TIME = "connectionbeginetime";

        /*
         * 	连接结束时间
         */
        public static String CONNECTION_END_TIME = "connectionendtime";

        /*
         * 	呼叫方
         */
        public static String FROM = "from";

        /*
         * 	接收方
         */
        public static String TO = "to";

        /*
         * 	客户名称
         */
        public static String USER = "user";

        /*
         * 	资讯分类
         */
        public static String CATEGORY = "category";

        /*
         * 	员工id
         */
        public static String STAFF_ID = "staffid";

        /*
         * 	员工姓名
         */
        public static String STAFF_NAME = "staffname";

        /*
         * 	会话状态
         */
        public static String STATUS = "status";

        /*
         * 	重复咨询次数
         */
        public static String VISIT_TIMES = "visittimes";

        /*
         * 	通话时长
         */
        public static String DURATION = "duration";

        /*
         * 	满意度
         */
        public static String EVALUATION = "evaluation";

        /*
         * 	通话录音文件地址
         */
        public static String RECORD_URL = "record_url";

        /*
         * 	溢出来源
         */
        public static String OVERFLOW_FROM = "overflowFrom";

        /*
         * 	分流客服组
         */
        public static String SHUNT_GROUP_NAME = "shuntGroupName";

        /*
         * 	ivr路径
         */
        public static String IVR_PATH = "ivrPath";

        /*
         * 	号码归属地
         */
        public static String MOBILE_AREA = "mobileArea";

        /*
         * 	排队等待时长
         */
        public static String WAIT_DURATION = "waitDuration";

        /*
         * 	振铃时长
         */
        public static String RING_DURATION = "ringDuration";

        /*
         * 	转接的上一通会话ID
         */
        public static String SESSION_ID_FROM = "sessionIdFrom";
    }

    @Autowired
    private Config config;

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

        JSONObject obj = (JSONObject) JSON.parse(json);
        obj.getInteger()

        // 2. save custom service call info to db

        // 3. upload sound record to the STT service
        return null;
    }

}
