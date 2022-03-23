# 呼叫系统
使用七鱼呼叫系统

参考： http://qiyukf.com/docs/guide/server/7-%E5%91%BC%E5%8F%AB%E7%B3%BB%E7%BB%9F.html

##  呼叫事件对接
- 呼叫中心用户电话呼入的时候，七鱼系统通过该接口向第三方系统获取用户信息，包括访客VIP级别、外接IVR路由、crm信息，根据获取到的信息进行访客分配，及访客信息更新；IVR过程中，IVR校验以及导航项动作自定义IVR接口和播放内容接口也使用该接口对接；通话结束后，同步通话记录使用该接口对接。通过参数eventtype进行区分。
- 对接URL配置在七鱼系统中：系统管理》扩展与集成》CRM信息对接》呼叫对接接口URL
  
### 参数eventtype类型说明：
  
  参数值 |	参数说明
  ---|---
  1 | 获取用户信息
  2 | IVR校验
  3 | 自定义IVR接口
  4 | 播放内容接口
  5 | 挂断时同步通话记录
  6 | 同步电话服务记录字段
  7 | 接起时同步通话记录

七鱼服务器向第三方接口请求信息时，采用密钥安全认证机制，保证第三方系统的信息安全。

### 数据校验
七鱼服务器和您的服务器进行数据传递时，POST请求会带以下这些参数：

参数 	|参数说明
---|---
appKey 	|你的企业的appKey (仅在您的服务器向七鱼服务器发送数据时需要，七鱼服务器向您的服务器发送数据时无此参数)
time 	|当前 UTC 时间戳，从 1970 年 1 月 1 日 0 点 0 分 0 秒开始到现在的秒数
checksum 	|SHA1(appSecret + md5 + time), 三个参数拼接的字符串，进行SHA1哈希计算，转化成16进制字符(String，小写)
eventType 	|七鱼服务器向开发者服务器推送事件时的事件类型。（开发者服务器向七鱼服务器发送请求时无此参数）

```aidl
其中，checksum 用于校验数据的完整性，其计算规则中，
AppSecret 可在七鱼管理后台->「系统」->「扩展与集成」页面找到，
md5 为整个请求 json 字符串的 md5 哈希值（小写形式），
即 md5 = MD5(content).toLowwerCase()，如果是上传文件，则是整个文件内容的 md5，
time 就是请求参数中的 time。处于安全性考虑，每个 checksum 的有效期为 5 分钟，
请确认发起请求的服务器是与标准时间同步的，比如有NTP服务。
```

计算 checksum 的 Java 示例代码如下：

```aidl
 public class QiyuPushCheckSum {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String encode(String appSecret, String nonce, String time) {
        String content = appSecret + nonce + time;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha1");
            messageDigest.update(content.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
}
```

重要提示: 本文档中提供的所有接口均面向开发者服务器端调用，用于计算 checksum 的 AppSecret 开发者应妥善保管,可在应用的服务器端存储和使用，但不应存储或传递到客户端，也不应在网页等前端代码中嵌入

### 通用错误码列表

错误码 	|含义
---|---
200 	|OK
14001 	|参数 appKey 错误
14002 	|参数 checksum 错误，请重新检查 checksum 计算方式
14003 	|参数 time 错误，请确保 time 参数与当前时间差小于 5 分钟，或检查服务的时间是否与标准时间同步
14004 	|内容格式校验错误，请参加详细错误信息，并对照对应的接口文档修正
14008 	|请求来源 IP 不在被允许的范围内
14009 	|请求频率过快，超出接口限制
14500 	|服务器内部错误，请反馈给我们具体场景
14501 	|数据量过大，超出接口限制
14515 	|权限不足

## 服务端登录

服务端登录功能可以达到七鱼免登的效果，用于将七鱼客服端作为工具条嵌入第三方网站或者实现第三方认证之后对七鱼进行免登。 功能使用步骤拆解:
```aidl
步骤1: 向自己服务器端发起异步请求，获取`SDK`地址；
步骤2: 将SDK地址作为Ifram工具条嵌入第三方页面或者直接跳转新页签实现免登
```

### 获取SDK接入地址

第三方向七鱼请求SDK接入地址的时候，七鱼会执行客服在七鱼的登录事件，并生成含动态口令的SDK接入地址返回给第三方
接口调用及数据校验规则参考上面数据校验

curl请求样例如下：

```aidl
curl -X POST \
  'http://qiyukf.com/openapi/staff/login?appKey=1c088a89de51d0af457616605f28390f&checksum=f570a5eb049eb803b086e45829b07e48&time=1511832531' \
  -H 'content-type: application/json;charset=utf-8' \
  -d '{"staffName": "admin"}'

```
请求参数说明

参数 	|是否必须 	|数据类型 	|参数说明
---|---|---|---
staffName 	|是 	|String 	|客服在七鱼这边对应的客服名(此处对应的参数值为客服账号)

接口返回数据为JSON格式，最外层参数如下：

参数 	|参数说明
---|---
code 	|错误码。200表示设置成功。
result 	|code为200时，返回值有效。
message 	|请求错误时，填错误提示信息

如果code等于200表示客服登录成功，result内容为json数据，返回样例如下：

```aidl
{
    "code": 200,
    "message": "",
    "result": {
        "sdk_url": "https://xxx.qiyukf.com/toolbar/script/get?token=cb1ec3c43089493eb4039945685ebf51",
        "corp_code": "xxx",
        "token": "cb1ec3c43089493eb4039945685ebf51"
    }
}
```
result内的参数说明如下：

参数 	|数据类型 	|参数说明
---|---|---
sdk_url 	|String 	|生成的含动态登录口令的SDK接入地址
corp_code 	|String 	|登录客服对应的七鱼企业域名
token 	|String 	|动态登录口令

调用说明

    本接口只支持POST请求；

    本接口请求Content-Type类型为：application/json;charset=utf-8;

    本接口返回类型为JSON，同时进行UTF-8编码。

## curl请求样例如下

### 1.电话呼入时获取用户信息，包括访客VIP级别、外接IVR路由、crm信息

```aidl
curl -X POST \
  'http://www.xxx.com/api/ivr/crminfo?checksum=f570a5eb049eb803b086e45829b07e48&time=1511832531' \
  -H 'content-type: application/json;charset=utf-8' \
  -d '{
    "eventtype": 1,
    "phone": "15854582215",
    "staffphone": "05718669163"
  }'
```

### 2.IVR校验请求

IVR(Interactive Voice Response)即互动式语音应答

```aidl
curl -X POST \
  'http://www.xxx.com/api/ivr/crminfo?checksum=f570a5eb049eb803b086e45829b07e48&time=1511832531' \
  -H 'content-type: application/json;charset=utf-8' \
  -d '{
    "eventtype": 2,
    "phone": "15854582215",
    "staffphone": "05718669163",
    "sessionid": 216629286,
    "ivrid": 3545,
    "keyrecord": "2-1-0",
    "input": "110226198501272116"
  }'
```

### 3.IVR过程中自定义IVR接口事件通知


```aidl
curl -X POST \
  'http://www.xxx.com/api/ivr/crminfo?checksum=f570a5eb049eb803b086e45829b07e48&time=1511832531' \
  -H 'content-type: application/json;charset=utf-8' \
  -d '{
    "eventtype": 3,
    "phone": "15854582215",
    "staffphone": "05718669163",
    "sessionid": 216629286,
    "ivrid": 3545,
    "keyrecord": "1-3"
  }'
```

### 4.IVR过程中播放内容接口请求播放内容

```aidl
curl -X POST \
  'http://www.xxx.com/api/ivr/crminfo?checksum=f570a5eb049eb803b086e45829b07e48&time=1511832531' \
  -H 'content-type: application/json;charset=utf-8' \
  -d '{
    "eventtype": 4,
    "phone": "15854582215",
    "staffphone": "05718669163",
    "sessionid": 216629286,
    "ivrid": 3545,
    "keyrecord": "1-2"
  }'
```

### 5.通话结束后同步通话记录请求

```aidl
curl -X POST \
  'http://www.xxx.com/api/ivr/crminfo?checksum=f570a5eb049eb803b086e45829b07e48&time=1511832531' \
  -H 'content-type: application/json;charset=utf-8' \
  -d '{
    "eventtype": 5,
    "sessionid": 216629286,
    "direction": "呼入",
    "createtime": 1511832411968,
    "connectionbeginetime": 1511832413992,
    "connectionendtime": 1511832432183,
    "from": "15854582215",
    "to": "05718690766",
    "user": "客户名称",
    "category": "售后问题/退货", //咨询分类
    "staffid": 642656,
    "staffname": "丽娜",
    "status": "接通", //会话状态
    "visittimes": 1, //重复咨询次数
    "duration": "10:15", //通话时长
    "evaluation": "满意", //满意度评价
    "recordurl": "https://ysf.nosdn.127.net/9f670ff01dae290ad4bf83401d291069.wav", //通话录音文件地址
    "overflowFrom": "溢出来源",
    "shuntGroupName"："分流客服组",
    "ivrPath":"ivr路径",
    "mobileArea":"号码归属地",
    "waitDuration":"5分10秒",  //排队等待时长
    "ringDuration":"1小时10分",   //振铃时长
    "sessionIdFrom": 216629286,   //转接至该会话的上一通会话id
  }'
```

### 6.通话结束后同步电话服务记录字段请求

```aidl
curl -X POST \
  'http://www.xxx.com/api/ivr/crminfo?checksum=f570a5eb049eb803b086e45829b07e48&time=1511832531' \
  -H 'content-type: application/json;charset=utf-8' \
  -d '{
    "eventtype": 6,
    "sessionid": 216629286,
    "from": "15854582215",
    "to": "05718690766",
    "counselCategory":"咨询分类1/咨询分析2/咨询分类3",
    "remarks":"咨询小计",
    "customValueArray":[
        {
            "key":"自定义字段1",
            "value":"自定义value1"
        },
        {
            "key":"自定义字段2",
            "value":"自定义value2"
        }
    ]

  }'
```

### 7.通话接起时同步通话记录请求

```aidl
curl -X POST \
  'http://www.xxx.com/api/ivr/crminfo?checksum=f570a5eb049eb803b086e45829b07e48&time=1511832531' \
  -H 'content-type: application/json;charset=utf-8' \
  -d '{
    "eventtype": 7,
    "sessionid": 216629286,
    "direction": "呼入",
    "createtime": 1511832411968,
    "connectionbeginetime": 1511832413992,
    "from": "15854582215",
    "to": "05718690766",
    "user": "客户名称",
    "staffid": 642656,
    "staffname": "丽娜",
    "status": "接通", //会话状态
    "visittimes": 1, //重复咨询次数
    "overflowFrom": "溢出来源",
    "shuntGroupName"："分流客服组",
    "ivrPath":"ivr路径",
    "mobileArea":"号码归属地",
    "sessionIdFrom": 216629286, //转接至该会话的上一通会话id
  }'
```

## 第三方接口需返回的数据的说明

接口返回数据为JSON格式，最外层参数如下：

参数 	|是否必须 	|参数说明
---|---|---
code 	|是 	|返回码,200表示成功。如eventtype=2时,200就表示校验通过;eventtype=3时,200表示动作执行成功等。
result 	|否 	|code为200时，该返回值有效。eventtype=1时返回访客信息，为JSON格式数据；eventtype=4时返回播放的文本内容，为String格式数据；其他该值可以为空。
message 	|否 	|请求错误时，填错误提示信息。

- 当eventtype=1时result 数据格式如下

参数	|	是否必须	|	数据类型	|	参数说明
---	|	---	|	---	|	---
name	|	否	|	String	|	访客姓名
level	|	否	|	Int	|	访客VIP级别，值为0到10
groupId	|	否	|	Int	|	IVR分流客服组ID
staffId	|	否	|	Int	|	IVR分流客服ID
ivrId	|	否	|	Int	|	IVR分流到指定IVR

- 非VIP用户level等于0，VIP级别等级为1到10数值

- groupId和staffId值对应七鱼系统中的客服组ID和客服ID，从七鱼管理后台「在线系统」->「设置」->「会话流程」->「访客分配」->「分配规则」->「ID查询」中查找获取。ivrId对应七鱼系统中的ivrId，从七鱼管理系统「呼叫系统」->「设置」->「路由策略」->「IVR语音导航」中查找获取。三种ID的优先级为：staffId->groupId->ivrId。
  
- 如果只设置了 staffId，七鱼会查找staffId对应的呼叫客服，如果该客服正好空闲的话，电话将优先分配给他。

        如果设置了staffId和groupId，七鱼会优先查找staffId对应的呼叫客服，如果该客服正好空闲，电话将优先分配给他，否则系统判断是否有返回groupId值。如果有groupId值，系统再优先查找groupId对应的呼叫客服组进行分配。

        如果只设置了groupId，七鱼会优先查找groupId对应的呼叫客服组，如果该客服组内正好有空闲客服，电话将随机分配给空闲的客服。如果该客服组内没有空闲客服，若有溢出规则，则按溢出规则走。

        如果只设置了ivrId,七鱼会优先按照ivrId来进行分配,会忽略ivr会员等级分配策略。

        如果没有返回staffId、groupId和ivrId三种中的任意一种，或者返回的值不存在，则七鱼将执行一般IVR分流。

返回的完整参数格式如下：

```aidl
{
    "code": 200,
    "message": "",
    "result": {
        "level": 0,
        "groupId": 415451,
        "staffId": 2164623,
        ...
    }
}
```

### 第三方接口样例

以SpringMVC框架为例，第三方系统提供的接口如下

```aidl
@RequestMapping(value = "/crminfo", method = RequestMethod.POST)
@ResponseBody
public String getClientCrmInfoByPhone(
        @RequestParam(value = "checksum", required = true) String checksum,
        @RequestParam(value = "time", required = true) String time,
        @RequestBody(required = true) String jsonStr
) {
    // 此处省略业务代码
}
```
