/*
 * Copyright 2021-2099 the original author or authors.
 *
 *  @Project: service-quality-evaluation-system
 *  @File: QiyuPushCheckSum.java
 *  @Author: Json Shen
 *  @Date: 2022/3/23 下午4:47
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

package com.bfec.servicequality.utils;

import cn.hutool.crypto.digest.DigestUtil;
import io.undertow.security.idm.DigestAlgorithm;

import java.security.MessageDigest;

/**
 *
 * 七鱼推送校验和工具
 *
 * @author Jason Shen
 * @version 1.0
 * @date 2022/3/23 16:33
 */
public class QiyuPushCheckSum {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 计算md5值的校验和
     *
     * @param appSecret app秘钥
     * @param md5 json正文的MD5值
     * @param time 推送事件（NTP同步，有效期是5分钟）
     * @return 校验和
     */
    public static String encode(String appSecret, String md5, String time) {
        String content = appSecret + md5 + time;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha1");
            messageDigest.update(content.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 16进制转码
     *
     * @param bytes 二进制数据
     * @return 转码文本字符串
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    /**
     * 计算原文的校验和
     *
     * @param appSecret app秘钥
     * @param text 要加密的数据原文
     * @param time 推送事件（NTP同步，有效期是5分钟）
     * @return 校验和
     */
    public static String checksum(String appSecret, String text, String time) {
        String md5 = DigestUtil.md5Hex(text);
        return encode(appSecret,md5,time);
    }
}
