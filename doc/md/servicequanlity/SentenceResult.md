                 
# 客服质量评估 服务说明文档

## 1. 接口列表

### swagger 地址
http://localhost:8099/doc.html

名称|接口|方法
---|---|---
<a href="#batchSelect">语句识别结果-批量查询</a>|http://localhost:8099/sentence-results/batch/|GET
<a href="#batchInsert">语句识别结果-批量添加</a>|http://localhost:8099/sentence-results/batch/|POST
<a href="#batchDelete">语句识别结果-批量删除</a>|http://localhost:8099/sentence-results/batch/|DELETE
<a href="#singleInsert">语句识别结果-添加</a>|http://localhost:8099/sentence-results/|POST
<a href="#singleUpdate">语句识别结果-修改</a>|http://localhost:8099/sentence-results/|PUT
<a href="#singleDelete">语句识别结果-删除</a>|http://localhost:8099/sentence-results/{id}/|DELETE

## 2. 接口说明

### <A NAME="batchSelect">语句识别结果-批量查询</A>

- [GET] http://localhost:8099/sentence-results/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
ids|String|false|逗号分隔的id(非必填)

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|List&lt;<a href="#SentenceResult">SentenceResult</a>&gt;||-

### <A NAME="batchInsert">语句识别结果-批量添加</A>

- [POST] http://localhost:8099/sentence-results/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
records|List&lt;<a href="#SentenceResult">SentenceResult</a>&gt;|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="batchDelete">语句识别结果-批量删除</A>

- [DELETE] http://localhost:8099/sentence-results/batch/
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

### <A NAME="singleInsert">语句识别结果-添加</A>

- [POST] http://localhost:8099/sentence-results/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
record|<a href="#SentenceResult">SentenceResult</a>|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleUpdate">语句识别结果-修改</A>

- [PUT] http://localhost:8099/sentence-results/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
record|<a href="#SentenceResult">SentenceResult</a>|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleDelete">语句识别结果-删除</A>

- [DELETE] http://localhost:8099/sentence-results/{id}/
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

### 语句识别结果 <A NAME="SentenceResult">SentenceResult</A>

名称|类型|说明|示例
---|---|---|---
id|Long|主键|
service_record_id|Long|冗余客服记录的ID|
task_id|Long|任务ID|
request_id|String|请求ID|
sentences|String|识别的结果数据|
words|String|词信息|
biz_duration|Long|识别音频总时长（毫秒）|
day|Date|日期(冗余 - 客服结束时间的日期)|
