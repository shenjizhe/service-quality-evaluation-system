                 
# 客服质量评估 服务说明文档

## 1. 接口列表

### swagger 地址
http://localhost:8099/doc.html

名称|接口|方法
---|---|---
<a href="#batchSelect">语音识别任务表-批量查询</a>|http://localhost:8099/sound-to-text-tasks/batch/|GET
<a href="#batchInsert">语音识别任务表-批量添加</a>|http://localhost:8099/sound-to-text-tasks/batch/|POST
<a href="#batchDelete">语音识别任务表-批量删除</a>|http://localhost:8099/sound-to-text-tasks/batch/|DELETE
<a href="#singleInsert">语音识别任务表-添加</a>|http://localhost:8099/sound-to-text-tasks/|POST
<a href="#singleUpdate">语音识别任务表-修改</a>|http://localhost:8099/sound-to-text-tasks/|PUT
<a href="#singleDelete">语音识别任务表-删除</a>|http://localhost:8099/sound-to-text-tasks/{id}/|DELETE

## 2. 接口说明

### <A NAME="batchSelect">语音识别任务表-批量查询</A>

- [GET] http://localhost:8099/sound-to-text-tasks/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
ids|String|false|逗号分隔的id(非必填)

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|List&lt;<a href="#SoundToTextTask">SoundToTextTask</a>&gt;||-

### <A NAME="batchInsert">语音识别任务表-批量添加</A>

- [POST] http://localhost:8099/sound-to-text-tasks/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
records|List&lt;<a href="#SoundToTextTask">SoundToTextTask</a>&gt;|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="batchDelete">语音识别任务表-批量删除</A>

- [DELETE] http://localhost:8099/sound-to-text-tasks/batch/
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

### <A NAME="singleInsert">语音识别任务表-添加</A>

- [POST] http://localhost:8099/sound-to-text-tasks/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
record|<a href="#SoundToTextTask">SoundToTextTask</a>|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleUpdate">语音识别任务表-修改</A>

- [PUT] http://localhost:8099/sound-to-text-tasks/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
record|<a href="#SoundToTextTask">SoundToTextTask</a>|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleDelete">语音识别任务表-删除</A>

- [DELETE] http://localhost:8099/sound-to-text-tasks/{id}/
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

### 语音识别任务表 <A NAME="SoundToTextTask">SoundToTextTask</A>

名称|类型|说明|示例
---|---|---|---
id|Long|主键|
service_record_id|Long|冗余客服记录的ID|
task_id|String|任务ID|
request_id|String|请求ID|
status_code|Integer|状态码|
status_text|String|状态说明|
day|Date|日期(冗余 - 客服结束时间的日期)|
