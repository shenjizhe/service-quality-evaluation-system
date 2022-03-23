                 
# 客服质量评估 服务说明文档

## 1. 接口列表

### swagger 地址
http://localhost:8099/doc.html

名称|接口|方法
---|---|---
<a href="#batchSelect">关键词检查记录-批量查询</a>|http://localhost:8099/keyword-check-records/batch/|GET
<a href="#batchInsert">关键词检查记录-批量添加</a>|http://localhost:8099/keyword-check-records/batch/|POST
<a href="#batchDelete">关键词检查记录-批量删除</a>|http://localhost:8099/keyword-check-records/batch/|DELETE
<a href="#singleInsert">关键词检查记录-添加</a>|http://localhost:8099/keyword-check-records/|POST
<a href="#singleUpdate">关键词检查记录-修改</a>|http://localhost:8099/keyword-check-records/|PUT
<a href="#singleDelete">关键词检查记录-删除</a>|http://localhost:8099/keyword-check-records/{id}/|DELETE

## 2. 接口说明

### <A NAME="batchSelect">关键词检查记录-批量查询</A>

- [GET] http://localhost:8099/keyword-check-records/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
ids|String|false|逗号分隔的id(非必填)

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|List&lt;<a href="#KeywordCheckRecord">KeywordCheckRecord</a>&gt;||-

### <A NAME="batchInsert">关键词检查记录-批量添加</A>

- [POST] http://localhost:8099/keyword-check-records/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
records|List&lt;<a href="#KeywordCheckRecord">KeywordCheckRecord</a>&gt;|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="batchDelete">关键词检查记录-批量删除</A>

- [DELETE] http://localhost:8099/keyword-check-records/batch/
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

### <A NAME="singleInsert">关键词检查记录-添加</A>

- [POST] http://localhost:8099/keyword-check-records/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
record|<a href="#KeywordCheckRecord">KeywordCheckRecord</a>|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleUpdate">关键词检查记录-修改</A>

- [PUT] http://localhost:8099/keyword-check-records/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
record|<a href="#KeywordCheckRecord">KeywordCheckRecord</a>|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleDelete">关键词检查记录-删除</A>

- [DELETE] http://localhost:8099/keyword-check-records/{id}/
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

### 关键词检查记录 <A NAME="KeywordCheckRecord">KeywordCheckRecord</A>

名称|类型|说明|示例
---|---|---|---
id|Long|主键|
service_record_id|Long|冗余客服记录的ID|
result_id|Long|语句记录ID|
check_time|Date|检查时间|
check_list|String|检查列表（关键词，结果语句位置...）|
day|Date|日期(冗余 - 客服结束时间的日期)|
