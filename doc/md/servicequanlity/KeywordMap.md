                 
# 客服质量评估 服务说明文档

## 1. 接口列表

### swagger 地址
http://localhost:8099/doc.html

名称|接口|方法
---|---|---
<a href="#batchSelect">关键词字典-批量查询</a>|http://localhost:8099/keyword-maps/batch/|GET
<a href="#batchInsert">关键词字典-批量添加</a>|http://localhost:8099/keyword-maps/batch/|POST
<a href="#batchDelete">关键词字典-批量删除</a>|http://localhost:8099/keyword-maps/batch/|DELETE
<a href="#singleInsert">关键词字典-添加</a>|http://localhost:8099/keyword-maps/|POST
<a href="#singleUpdate">关键词字典-修改</a>|http://localhost:8099/keyword-maps/|PUT
<a href="#singleDelete">关键词字典-删除</a>|http://localhost:8099/keyword-maps/{id}/|DELETE

## 2. 接口说明

### <A NAME="batchSelect">关键词字典-批量查询</A>

- [GET] http://localhost:8099/keyword-maps/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
ids|String|false|逗号分隔的id(非必填)

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|List&lt;<a href="#KeywordMap">KeywordMap</a>&gt;||-

### <A NAME="batchInsert">关键词字典-批量添加</A>

- [POST] http://localhost:8099/keyword-maps/batch/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
records|List&lt;<a href="#KeywordMap">KeywordMap</a>&gt;|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="batchDelete">关键词字典-批量删除</A>

- [DELETE] http://localhost:8099/keyword-maps/batch/
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

### <A NAME="singleInsert">关键词字典-添加</A>

- [POST] http://localhost:8099/keyword-maps/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
record|<a href="#KeywordMap">KeywordMap</a>|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleUpdate">关键词字典-修改</A>

- [PUT] http://localhost:8099/keyword-maps/
- 请求格式

名称|类型|必填|说明
---|---|---|---
<a href="#public">公共参数</a>|-|-|-
record|<a href="#KeywordMap">KeywordMap</a>|true|

- 响应格式

名称|类型|说明|示例
---|---|---|---
<a href="#public">公共参数</a>|-|-|-|-
-|Integer||-

### <A NAME="singleDelete">关键词字典-删除</A>

- [DELETE] http://localhost:8099/keyword-maps/{id}/
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

### 关键词字典 <A NAME="KeywordMap">KeywordMap</A>

名称|类型|说明|示例
---|---|---|---
id|Long|字典ID|
keyword|String|关键词|
type|Integer|关键词分类（1. 敏感词 ）|
create_time|Date|创建时间|
update_time|Date|修改时间|
