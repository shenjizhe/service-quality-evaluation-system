# 客服质量评估类图
``` plantuml
@startuml
'https://plantuml.com/class-diagram
namespace com.common.model #DDDDDD {
abstract class BaseController{
+selectAll()
+selectCount()
+select()
+selectOne()
+exists()
+insert()
+delete()
+update()
+selectByIds()
+deleteByIds()
+insertList()
}
note left of BaseController
控制器基类
提供服务对外的 restful接口
end note

abstract class BaseService{

}
note left of BaseService
服务基类
提供业务逻辑封装
end note

interface MyMapper{

}
note left of MyMapper
映射基类
提供
end note

interface Mapper{
select()
update()
delete()
insert()
}

interface MySqlMapper{
insertList()
insertUseGeneratedKeys()
}

interface ConditionMapper{
selectByCondition()
selectCountByCondition()
deleteByCondition()
updateByCondition()
updateByConditionSelective()
}

interface IdsMapper{
selectByIds()
deleteByIds()
}

interface ExampleMapper{
selectByExample()
selectOneByExample()
selectCountByExample()
deleteByExample()
updateByExample()
updateByExampleSelective()
}

class Result{
ErrCode errCode
String message:
T data
}
note left of Result
返回结果
---
errCode:
0是正确状态，其他都是错误码
参考 ErrorCode
message:
错误消息
data:
数据,json格式返回结果
end note

enum ErrorCode{
Success
Fail
Unknown
...
}
note left of ErrorCode
错误码定义
---
Success 正确 0
Fail 错误
Unknown 未知结果
end note

BaseController-->BaseService:使用
BaseService-->MyMapper:使用
MyMapper--|>Mapper:继承
MyMapper--|>MySqlMapper:继承
MyMapper--|>ConditionMapper:继承
MyMapper--|>IdsMapper:继承
MyMapper--|>ExampleMapper:继承
BaseController..>Result:依赖
Result..>ErrorCode:依赖
}

namespace com.bfec.servicequanlity.controller #5EFF7A {
}
namespace com.bfec.servicequanlity.service #F6A7B1 {
}
namespace com.bfec.servicequanlity.mapper #FFAF00 {
}
namespace com.bfec.servicequanlity.entity #5B8AEF {
}


class com.bfec.servicequanlity.controller.CustomerServiceRecordController << (C,#01FF14) >>{
        +batchSelect()
        +batchInsert()
        +batchDelete()
        +singleInsert()
        +singleUpdate()
        +singleDelete()
    }
note top of com.bfec.servicequanlity.controller.CustomerServiceRecordController
    客户服务记录控制器
---
            batchSelect():
        批量查询
            batchInsert():
        批量添加
            batchDelete():
        批量删除
            singleInsert():
        添加
            singleUpdate():
        修改
            singleDelete():
        删除
    end note
class com.bfec.servicequanlity.service.CustomerServiceRecordService << (S,#FF1111) >>{
}
class com.bfec.servicequanlity.mapper.CustomerServiceRecordMapper << (M,#FFDC0D) >>{
}
class com.bfec.servicequanlity.entity.CustomerServiceRecord << (E,#0074D9) >>{
            id:Long
            event_type:Integer
            session_id:Long
            create_time:Date
            connection_begin_time:Date
            connetion_end_time:Date
            from:String
            to:String
            user:String
            category:String
            staff_id:Integer
            staff_name:String
            status:String
            duration:String
            evaluation:String
            record_url:String
            mobile_area:String
            wait_duration:String
            ring_ruration:String
            sessionId_from:Long
            day:Date
    }
note bottom of com.bfec.servicequanlity.entity.CustomerServiceRecord
    客户服务记录
---
            id:
        主键
            event_type:
        事件类型
            session_id:
        会话ID
            create_time:
        创建时间
            connection_begin_time:
        连接开始时间
            connetion_end_time:
        连接结束时间
            from:
        呼叫网
            to:
        接收方
            user:
        客户名称
            category:
        资讯分类
            staff_id:
        员工id
            staff_name:
        员工姓名
            status:
        会话状态
            duration:
        通话时长
            evaluation:
        满意度
            record_url:
        通话录音文件地址
            mobile_area:
        号码归属地
            wait_duration:
        排队等待时长
            ring_ruration:
        振铃时长
            sessionId_from:
        转接的上一通会话ID
            day:
        日期(冗余 - 客服结束时间的日期)
    end note

com.bfec.servicequanlity.controller.CustomerServiceRecordController--|>com.common.model.BaseController
com.bfec.servicequanlity.service.CustomerServiceRecordService--|>com.common.model.BaseService
com.bfec.servicequanlity.mapper.CustomerServiceRecordMapper--|>com.common.model.MyMapper
com.bfec.servicequanlity.controller.CustomerServiceRecordController-->com.bfec.servicequanlity.service.CustomerServiceRecordService
com.bfec.servicequanlity.service.CustomerServiceRecordService-->com.bfec.servicequanlity.mapper.CustomerServiceRecordMapper
com.bfec.servicequanlity.mapper.CustomerServiceRecordMapper-->com.bfec.servicequanlity.entity.CustomerServiceRecord


class com.bfec.servicequanlity.controller.KeywordCheckRecordController << (C,#01FF14) >>{
        +batchSelect()
        +batchInsert()
        +batchDelete()
        +singleInsert()
        +singleUpdate()
        +singleDelete()
    }
note top of com.bfec.servicequanlity.controller.KeywordCheckRecordController
    关键词检查记录控制器
---
            batchSelect():
        批量查询
            batchInsert():
        批量添加
            batchDelete():
        批量删除
            singleInsert():
        添加
            singleUpdate():
        修改
            singleDelete():
        删除
    end note
class com.bfec.servicequanlity.service.KeywordCheckRecordService << (S,#FF1111) >>{
}
class com.bfec.servicequanlity.mapper.KeywordCheckRecordMapper << (M,#FFDC0D) >>{
}
class com.bfec.servicequanlity.entity.KeywordCheckRecord << (E,#0074D9) >>{
            id:Long
            service_record_id:Long
            result_id:Long
            check_time:Date
            check_list:String
            day:Date
    }
note bottom of com.bfec.servicequanlity.entity.KeywordCheckRecord
    关键词检查记录
---
            id:
        主键
            service_record_id:
        冗余客服记录的ID
            result_id:
        语句记录ID
            check_time:
        检查时间
            check_list:
        检查列表（关键词，结果语句位置...）
            day:
        日期(冗余 - 客服结束时间的日期)
    end note

com.bfec.servicequanlity.controller.KeywordCheckRecordController--|>com.common.model.BaseController
com.bfec.servicequanlity.service.KeywordCheckRecordService--|>com.common.model.BaseService
com.bfec.servicequanlity.mapper.KeywordCheckRecordMapper--|>com.common.model.MyMapper
com.bfec.servicequanlity.controller.KeywordCheckRecordController-->com.bfec.servicequanlity.service.KeywordCheckRecordService
com.bfec.servicequanlity.service.KeywordCheckRecordService-->com.bfec.servicequanlity.mapper.KeywordCheckRecordMapper
com.bfec.servicequanlity.mapper.KeywordCheckRecordMapper-->com.bfec.servicequanlity.entity.KeywordCheckRecord


class com.bfec.servicequanlity.controller.KeywordMapController << (C,#01FF14) >>{
        +batchSelect()
        +batchInsert()
        +batchDelete()
        +singleInsert()
        +singleUpdate()
        +singleDelete()
    }
note top of com.bfec.servicequanlity.controller.KeywordMapController
    关键词字典控制器
---
            batchSelect():
        批量查询
            batchInsert():
        批量添加
            batchDelete():
        批量删除
            singleInsert():
        添加
            singleUpdate():
        修改
            singleDelete():
        删除
    end note
class com.bfec.servicequanlity.service.KeywordMapService << (S,#FF1111) >>{
}
class com.bfec.servicequanlity.mapper.KeywordMapMapper << (M,#FFDC0D) >>{
}
class com.bfec.servicequanlity.entity.KeywordMap << (E,#0074D9) >>{
            id:Long
            keyword:String
            type:Integer
            create_time:Date
            update_time:Date
    }
note bottom of com.bfec.servicequanlity.entity.KeywordMap
    关键词字典
---
            id:
        字典ID
            keyword:
        关键词
            type:
        关键词分类（1. 敏感词 ）
            create_time:
        创建时间
            update_time:
        修改时间
    end note

com.bfec.servicequanlity.controller.KeywordMapController--|>com.common.model.BaseController
com.bfec.servicequanlity.service.KeywordMapService--|>com.common.model.BaseService
com.bfec.servicequanlity.mapper.KeywordMapMapper--|>com.common.model.MyMapper
com.bfec.servicequanlity.controller.KeywordMapController-->com.bfec.servicequanlity.service.KeywordMapService
com.bfec.servicequanlity.service.KeywordMapService-->com.bfec.servicequanlity.mapper.KeywordMapMapper
com.bfec.servicequanlity.mapper.KeywordMapMapper-->com.bfec.servicequanlity.entity.KeywordMap


class com.bfec.servicequanlity.controller.SentenceResultController << (C,#01FF14) >>{
        +batchSelect()
        +batchInsert()
        +batchDelete()
        +singleInsert()
        +singleUpdate()
        +singleDelete()
    }
note top of com.bfec.servicequanlity.controller.SentenceResultController
    语句识别结果控制器
---
            batchSelect():
        批量查询
            batchInsert():
        批量添加
            batchDelete():
        批量删除
            singleInsert():
        添加
            singleUpdate():
        修改
            singleDelete():
        删除
    end note
class com.bfec.servicequanlity.service.SentenceResultService << (S,#FF1111) >>{
}
class com.bfec.servicequanlity.mapper.SentenceResultMapper << (M,#FFDC0D) >>{
}
class com.bfec.servicequanlity.entity.SentenceResult << (E,#0074D9) >>{
            id:Long
            service_record_id:Long
            task_id:Long
            request_id:String
            sentences:String
            words:String
            biz_duration:Long
            day:Date
    }
note bottom of com.bfec.servicequanlity.entity.SentenceResult
    语句识别结果
---
            id:
        主键
            service_record_id:
        冗余客服记录的ID
            task_id:
        任务ID
            request_id:
        请求ID
            sentences:
        识别的结果数据
            words:
        词信息
            biz_duration:
        识别音频总时长（毫秒）
            day:
        日期(冗余 - 客服结束时间的日期)
    end note

com.bfec.servicequanlity.controller.SentenceResultController--|>com.common.model.BaseController
com.bfec.servicequanlity.service.SentenceResultService--|>com.common.model.BaseService
com.bfec.servicequanlity.mapper.SentenceResultMapper--|>com.common.model.MyMapper
com.bfec.servicequanlity.controller.SentenceResultController-->com.bfec.servicequanlity.service.SentenceResultService
com.bfec.servicequanlity.service.SentenceResultService-->com.bfec.servicequanlity.mapper.SentenceResultMapper
com.bfec.servicequanlity.mapper.SentenceResultMapper-->com.bfec.servicequanlity.entity.SentenceResult


class com.bfec.servicequanlity.controller.SoundToTextTaskController << (C,#01FF14) >>{
        +batchSelect()
        +batchInsert()
        +batchDelete()
        +singleInsert()
        +singleUpdate()
        +singleDelete()
    }
note top of com.bfec.servicequanlity.controller.SoundToTextTaskController
    语音识别任务表控制器
---
            batchSelect():
        批量查询
            batchInsert():
        批量添加
            batchDelete():
        批量删除
            singleInsert():
        添加
            singleUpdate():
        修改
            singleDelete():
        删除
    end note
class com.bfec.servicequanlity.service.SoundToTextTaskService << (S,#FF1111) >>{
}
class com.bfec.servicequanlity.mapper.SoundToTextTaskMapper << (M,#FFDC0D) >>{
}
class com.bfec.servicequanlity.entity.SoundToTextTask << (E,#0074D9) >>{
            id:Long
            service_record_id:Long
            task_id:String
            request_id:String
            status_code:Integer
            status_text:String
            day:Date
    }
note bottom of com.bfec.servicequanlity.entity.SoundToTextTask
    语音识别任务表
---
            id:
        主键
            service_record_id:
        冗余客服记录的ID
            task_id:
        任务ID
            request_id:
        请求ID
            status_code:
        状态码
            status_text:
        状态说明
            day:
        日期(冗余 - 客服结束时间的日期)
    end note

com.bfec.servicequanlity.controller.SoundToTextTaskController--|>com.common.model.BaseController
com.bfec.servicequanlity.service.SoundToTextTaskService--|>com.common.model.BaseService
com.bfec.servicequanlity.mapper.SoundToTextTaskMapper--|>com.common.model.MyMapper
com.bfec.servicequanlity.controller.SoundToTextTaskController-->com.bfec.servicequanlity.service.SoundToTextTaskService
com.bfec.servicequanlity.service.SoundToTextTaskService-->com.bfec.servicequanlity.mapper.SoundToTextTaskMapper
com.bfec.servicequanlity.mapper.SoundToTextTaskMapper-->com.bfec.servicequanlity.entity.SoundToTextTask


@enduml
```