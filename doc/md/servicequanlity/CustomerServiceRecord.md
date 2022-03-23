                 
# 客服质量评估 服务说明文档

## 1. 接口列表

### swagger 地址
http://localhost:8099/doc.html

名称|接口|方法
---|---|---
<a href="#batchSelect">客户服务记录-批量查询</a>|http://localhost:8099/customer-service-records/batch/|GET
<a href="#batchInsert">客户服务记录-批量添加</a>|http://localhost:8099/customer-service-records/batch/|POST
<a href="#batchDelete">客户服务记录-批量删除</a>|http://localhost:8099/customer-service-records/batch/|DELETE
<a href="#singleInsert">客户服务记录-添加</a>|http://localhost:8099/customer-service-records/|POST
<a href="#singleUpdate">客户服务记录-修改</a>|http://localhost:8099/customer-service-records/|PUT
<a href="#singleDelete">客户服务记录-删除</a>|http://localhost:8099/customer-service-records/{id}/|DELETE

## 2. 接口说明

### <A NAME="batchSelect">客户服务记录-批量查询</A>

- [GET] http://localhost:8099/customer-service-records/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
ids|String|false|逗号分隔的id(非必填)

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|List&lt;<a href="#CustomerServiceRecord">CustomerServiceRecord</a>&gt;||-

### <A NAME="batchInsert">客户服务记录-批量添加</A>

- [POST] http://localhost:8099/customer-service-records/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
records|List&lt;<a href="#CustomerServiceRecord">CustomerServiceRecord</a>&gt;|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="batchDelete">客户服务记录-批量删除</A>

- [DELETE] http://localhost:8099/customer-service-records/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
ids|String|false|逗号分隔的id(非必填)

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleInsert">客户服务记录-添加</A>

- [POST] http://localhost:8099/customer-service-records/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
record|<a href="#CustomerServiceRecord">CustomerServiceRecord</a>|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleUpdate">客户服务记录-修改</A>

- [PUT] http://localhost:8099/customer-service-records/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
record|<a href="#CustomerServiceRecord">CustomerServiceRecord</a>|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleDelete">客户服务记录-删除</A>

- [DELETE] http://localhost:8099/customer-service-records/{id}/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
id|Long|true|记录ID

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-


## 3. 数据定义

### 公共返回值 <A NAME="public">public</A>

名称|类型|说明|示例
---|---|---|---
errcode|Long|错误码( 0为成功 )| 0
message|String|错误描述|成功
data|Object|数据|{"name","jason"}

### 客户服务记录 <A NAME="CustomerServiceRecord">CustomerServiceRecord</A>

名称|类型|说明|示例
---|---|---|---
id|Long|主键|
event_type|Integer|事件类型|
session_id|Long|会话ID|
create_time|Date|创建时间|
connection_begin_time|Date|连接开始时间|
connetion_end_time|Date|连接结束时间|
from|String|呼叫网|
to|String|接收方|
user|String|客户名称|
category|String|资讯分类|
staff_id|Integer|员工id|
staff_name|String|员工姓名|
status|String|会话状态|
duration|String|通话时长|
evaluation|String|满意度|
record_url|String|通话录音文件地址|
mobile_area|String|号码归属地|
wait_duration|String|排队等待时长|
ring_ruration|String|振铃时长|
sessionId_from|Long|转接的上一通会话ID|
day|Date|日期(冗余 - 客服结束时间的日期)|
