
项目模块 接口规格
=============

[TOC]


## 1 项目模块

### 1.1 新建项目
* __Method__
  POST

* __URL__
  /api/project

* __Request__

> 请求参数Json格式

```
{
"name":"测试", #项目名称
"contractNo":"合同编号",
"contractName":"合同名称",
"subContractNo":"子合同编号",
"subContractName":"子合同合同名称",
"businessNo":"商机编号",
"tempContract":"临时合同",
"customerRepresentative":"客户代表",
"contractNote":"合同备注",
"customerNo":"客户编号",
"customerUnit":"客户单位",
"customerName":"客户姓名",
"customerPhone":"客户电话", 
"customerEmail":"客户邮箱",
"projectType":1, #项目类型
"priority":3, #优先级
"planCompleteTime":"May 31, 2017 4:04:57 PM", #计划完成时间
"specialRequire":"特殊要求",
"summaryNote":"概要备注",
"sampleCategory":1, #样本类别
"species":1, #物种分类
"jobs":[ #工作内容 勾选的选项
	{
		"type":1, #样本提取
		"params":{
			"extractContent":1, #提取内容
			"extractMethod":1 #提取方法
		}
	},
	{
		"type":2, #样本检测
		"params":{
			"checkMethods":[1,2] #检测方法
		}
	},
	{
		"type":3, #文库构建
		"params":{
			"seqPlatform":1, #测序平台
			"libraryType":1 #文库类型
		}
	},
	{
		"type":4, #文库检测
		"params":{
			"checkMethods":[1,2] #检测方法
		}
	},
	{
		"type":5, #文库定量
		"params":{
			"seqPlatform":1, #测序平台
			"kit":1 #试剂盒
		}
	},
	{
		"type":6, #测序
		"params":{
			"seqPlatform":1, #测序平台
			"seqStrategy":1, #测序策略
			"dataAmount":1, #数据量
			"dataAmountUnit":1 #数据量单位
		}
	},
	{
		"type":7, #测序QC
		"params":{}
	},
	{
		"type":8, #生信分析
		"params":{}
	},
	{
		"type":9, #其他
		"params":{
			"description":"说明"
		}
	}
		]
}
```

* __Response__

> 成功

```
{
    "code": 0,
    "data": 1 //生成的项目ID
}
```


### 1.2 修改项目

* __Method__
  PUT

* __URL__
  /api/project

* __Request__

> 请求参数Json格式

```
{
"id":1,
"no":"001", #项目编号
"name":"测试", #项目名称
"contractNo":"合同编号",
"contractName":"合同名称",
"subContractNo":"子合同编号",
"subContractName":"子合同合同名称",
"businessNo":"商机编号",
"tempContract":"临时合同",
"customerRepresentative":"客户代表",
"contractNote":"合同备注",
"customerNo":"客户编号",
"customerUnit":"客户单位",
"customerName":"客户姓名",
"customerPhone":"客户电话", 
"customerEmail":"客户邮箱",
"projectType":1, #项目类型
"priority":3, #优先级
"projectStatus":1, #项目状态
"planCompleteTime":"May 31, 2017 4:04:57 PM", #计划完成时间
"specialRequire":"特殊要求",
"summaryNote":"概要备注",
"sampleCategory":1, #样本类别
"species":1, #物种分类
"jobs":[ #工作内容 勾选的选项
	{
		"id":1,
		"type":1, #样本提取
		"params":{
			"extractContent":1, #提取内容
			"extractMethod":1 #提取方法
		}
	},
	{
		"type":2, #样本检测
		"params":{
			"checkMethods":[1,2] #检测方法
		}
	},
	{
		"type":3, #文库构建
		"params":{
			"seqPlatform":1, #测序平台
			"libraryType":1 #文库类型
		}
	},
	{
		"type":4, #文库检测
		"params":{
			"checkMethods":[1,2] #检测方法
		}
	},
	{
		"type":5, #文库定量
		"params":{
			"seqPlatform":1, #测序平台
			"kit":1 #试剂盒
		}
	},
	{
		"type":6, #测序
		"params":{
			"seqPlatform":1, #测序平台
			"seqStrategy":1, #测序策略
			"dataAmount":1, #数据量
			"dataAmountUnit":1 #数据量单位
		}
	},
	{
		"type":7, #测序QC
		"params":{}
	},
	{
		"type":8, #生信分析
		"params":{}
	},
	{
		"type":9, #其他
		"params":{
			"description":"说明"
		}
	}
		]
}
```

* __Response__

> 成功

```
{
  "code": 0
}
```


### 1.3 添加样本批次信息
* __Method__
  POST

* __URL__
  /api/project/sampleLot

* __Request__

> 请求参数Json格式

```
{ 
	"projectId":1, #项目ID
	"no":"000f", #批次号
	"sampleCategory":1, #样本类别
	"sampleType":1, #样本类型
	"species":1, #物种分类
	"saveWay":1, #保存形式
	"sampleSource":0, 0-原始样本
	"projectRef":1, #项目引用数
	"sampleNote":"样本备注",
	"libraryIndex":1, #文库Index位置
	"librarySize":1, #文库片段大小
	"libraryStructure":"文库结构示例",
	"libraryFragment":"文库片段示例",
	"affix":"附件",
	"description":"描述",
	"sampleCount":1, #样本总数,
	"status":1 #状态 1-活动 2-删除
}	
```

* __Response__

> 成功

```
{
    "code": 0,
    "data": 3 #样本批次ID
}
```

### 1.4 修改样本批次信息
* __Method__
  PUT

* __URL__
  /api/project/sampleLot

* __Request__

> 请求参数Json格式

```
{ 
	"id":1, #样本批次ID
	"no":"000f", #批次号
	"sampleType":1, #样本类型
	"saveWay":1, #保存形式
	"projectRef":1, #项目引用数
	"sampleNote":"样本备注",
	"libraryIndex":1, #文库Index位置
	"librarySize":1, #文库片段大小
	"libraryStructure":"文库结构示例",
	"libraryFragment":"文库片段示例",
	"affix":"附件",
	"description":"描述",
	"sampleCount":1, #样本总数,
	"status":1 #状态 1-活动 2-删除
}	
```

* __Response__

> 成功

```
{
    "code": 0
}
```

### 1.5 添加样本信息
* __Method__
  POST

* __URL__
  /api/project/sample

* __Request__

> 请求参数Json格式

```
{ 
	"id":1, #样本批次ID
	"samples":[
		{
			"name":"样本1", #样本名称
			"deliverConcentration":"送样浓度",
			"deliverQuality":"送样质量",
			"actualConcentration":"实测浓度",
			"initVolume":"原始体积",
			"surplusVolume":"剩余体积",
			"productTime":"May 31, 2017 4:04:57 PM", #生产时间
			"limitTime":"保质期",
			"storageLocation":"库位",
			"note":"备注",
			"qualified":true, #是否合格
			"disqualifiedReason":"不合格原因"
		}
	]
}	
```

* __Response__

> 成功

```
{
  "code": 0
}
```

### 1.6 编辑样本信息
* __Method__
  PUT

* __URL__
  /api/project/sample

* __Request__

> 请求参数Json格式

```

		{
		    "id":1, #样本ID
			"name":"样本1", #样本名称
			"deliverConcentration":"送样浓度",
			"deliverQuality":"送样质量",
			"actualConcentration":"实测浓度",
			"initVolume":"原始体积",
			"surplusVolume":"剩余体积",
			"productTime":"May 31, 2017 4:04:57 PM", #生产时间
			"limitTime":"保质期",
			"storageLocation":"库位",
			"note":"备注",
			"qualified":true, #是否合格
			"disqualifiedReason":"不合格原因"
		}

```

* __Response__

> 成功

```
{
  "code": 0
}
```

### 1.7 删除样本
* __Method__
  DELETE

* __URL__
  /api/project/sample/{id}

* __Request__

Param | Type | Description 

id | long | 样本ID

* __Response__

> 成功

```
{
  "code": 0
}
```

### 1.8 获取项目列表

* __Method__
  GET

* __URL__
  /api/project

* __Request__

 Param | Type | Description 

 projectStatus | int | 项目状态 1-新建项目  2-样本送达  3-交付生产  4-生产进行中  5-项目完成  6-项目终止

projectNo | String | 项目编号

projectName | String | 项目名称

createTime| String | 创建日期

productStatus| int | 生产状态 1-样本提取 2-样本检测  3-文库构建  4-文库检测  5-文库定量  6-测序  7-测序QC结果  8-生信分析  9-其他

page | int | 页数

length | int | 每页记录数


* __Response__

> 成功

```
{
    "code": 0,
    "data": {
        "pageSize": 10, #每页记录数
        "currentPage": 1, #当前页数
        "totalPage": 1, #总页数
        "totalCount": 1, #总记录数
        "rows": [
            {
                "id": 1,
                "no": "001", #项目编号
                "name": "测试", #项目名称
                "projectType": 1,
                "projectTypeDesc": "免费", #项目类型
                "planCompleteTime": "Jul 31, 2017 4:04:57 PM", #计划完成时间
                "species": 1, 
                "speciesDesc": "植物", #物种分类
                "sampleCategory": 1,
                "sampleCategoryDesc": "DNA", #样本类别
                "projectStatus": 1,
                "projectStatusDesc": "新建项目", #项目状态
                "sampleCount": 0, #样本总数
                "createTime": "Jun 19, 2017 12:36:59 PM" #创建时间
            }
        ]
    }
}
```

### 1.9 根据ID获取项目详情

* __Method__
  GET

* __URL__
  /api/project/{id}

* __Request__

 Param | Type | Description 

 id | long | 项目ID


* __Response__

> 成功

```
{
    "code": 0,
    "data": {
        "id": 1,
        "jobs": [
            {
                "id": 1,
                "type": 1,
                "typeDesc": "样本提取",
                "params": {
                    "extractContent": 1,
                    "extractMethod": 1
                }
            }
        ],
        "sampleLot": {
            "id": 2,
            "no": "ff",
            "sampleCategory": 1,
            "sampleType": 1,
            "species": 1,
            "saveWay": 1,
            "sampleSource": 1,
            "projectRef": 1,
            "operator": 1,
            "sampleNote": "样本备注",
            "libraryIndex": 1,
            "librarySize": 1,
            "libraryStructure": "文库结构示例",
            "libraryFragment": "文库片段示例",
            "affix": "附件",
            "description": "描述",
            "sampleCount": 1,
            "status": 1,
            "createBy": 1,
            "updateBy": 1,
            "createTime": "Jun 19, 2017 4:50:31 PM",
            "updateTime": "Jun 19, 2017 4:50:31 PM"
        },
        "no": "001",
        "name": "测试",
        "contractNo": "合同编号",
        "contractName": "合同名称",
        "subContractNo": "子合同编号",
        "subContractName": "子合同合同名称",
        "businessNo": "商机编号",
        "tempContract": "临时合同",
        "customerRepresentative": "客户代表",
        "contractNote": "合同备注",
        "customerNo": "客户编号",
        "customerUnit": "客户单位",
        "customerName": "客户姓名",
        "customerPhone": "客户电话",
        "customerEmail": "客户邮箱",
        "projectType": 1,
        "projectTypeDesc": "免费",
        "priority": 3,
        "priorityDesc": "3-中等",
        "planCompleteTime": "Jul 31, 2017 4:04:57 PM",
        "specialRequire": "特殊要求",
        "summaryNote": "概要备注",
        "sampleCategory": 1,
        "sampleCategoryDesc": "DNA",
        "species": 1,
        "speciesDesc": "植物",
        "projectStatus": 1,
        "projectStatusDesc": "新建项目",
        "createBy": 1,
        "updateBy": 1,
        "createTime": "Jun 19, 2017 12:36:59 PM",
        "updateTime": "Jun 19, 2017 12:36:59 PM"
    }
}
```

### 1.10 获取项目样本批次信息

* __Method__
  GET
* __URL__
  /api/project/sampleLot/{projectId}
* __Request__

 Param | Type | Description 

 projectId | long | 项目ID


* __Response__

> 成功

```
{
    "code": 0,
    "data": {
        "id": 2,
        "no": "ff",
        "sampleCategory": 1,
        "sampleCategoryDesc": "DNA",
        "sampleType": 1,
        "sampleTypeDesc": "",
        "species": 1,
        "speciesDesc": "植物",
        "saveWay": 1,
        "saveWayDesc": "",
        "sampleSource": 1,
        "projectRef": 1,
        "operator": 1,
        "sampleNote": "样本备注",
        "libraryIndex": 1,
        "libraryIndexDesc": "P5--Index--DNA--P7",
        "librarySize": 1,
        "librarySizeDesc": "插入片段<600bp",
        "libraryStructure": "文库结构示例",
        "libraryFragment": "文库片段示例",
        "affix": "附件",
        "description": "描述",
        "sampleCount": 1,
        "status": 1,
        "statusDesc": "有效",
        "createBy": 1,
        "updateBy": 1,
        "createTime": "Jun 19, 2017 4:50:31 PM",
        "updateTime": "Jun 19, 2017 4:50:31 PM"
    }
}
```

### 1.11 获取样本列表信息

* __Method__
  GET
* __URL__
  /api/project/sample
* __Request__

 Param | Type | Description 

 sampleLotId | long | 样本批次ID

 filter | string | 编号或名称

page | int | 页数

length | int | 每页记录数


* __Response__

> 成功

```
{
    "code": 0,
    "data": {
        "pageSize": 10,
        "currentPage": 1,
        "totalPage": 1,
        "totalCount": 3,
        "rows": [
            {
                "id": 1,
                "no": "170623001", #编号
                "name": "样本1", #样本名称
                "deliverConcentration": "送样浓度",
                "actualConcentration": "实测浓度",
                "initVolume": "原始体积",
                "surplusVolume": "剩余体积",
                "productTime": "May 31, 2017 4:04:57 PM",
                "sampleStatus": 1,
                "limitTime": "保质期",
                "storageLocation": "库位",
                "note": "备注",
                "qualified": true, #是否合格
                "disqualifiedReason": "不合格原因",
                "createBy": 1,
                "updateBy": 1,
                "createTime": "Jun 19, 2017 3:51:21 PM",
                "updateTime": "Jun 19, 2017 3:51:21 PM"
            }
        ]
    }
}
```

### 1.12 获取项目样本批次列表信息

* __Method__
  GET
* __URL__
  /api/project/sampleLotBar/{projectId}
* __Request__

 Param | Type | Description 

 projectId | long | 项目ID


* __Response__

> 成功

```
{
    "code": 0,
    "data": {
        "originalSampleLot": { #原始样本
            "id": 1, 
            "no": "000f", #批次编号
            "sampleCategory": 12,
            "sampleCategoryDesc": "DNA", #样本类别
            "saveWay": 69,
            "saveWayDesc": "干粉" #保存形式
        }
    }
}
```


## 2 数据字典

### 2.1 获取数据字典
* __Method__
  GET
* __URL__
  /api/data
* __Request__

 Param | Type | Description 

type | int | 类型

```
(1, "项目类型"),
(2, "项目优先级"),
(3, "物种分类"),
(4, "样本类别"),
(5, "样本类型"),
(6, "样本保存形式"),
(7, "样本提取内容"),
(8, "样本提取方法"),
(9, "样本检测方法"),
(10, "文库检测方法"),
(11, "文库Index位置"),
(12, "文库片段大小"),
(13, "测序平台"),
(14, "测序策略"),
(15, "数据量单位"),
```

parentId | int | 父ID
secondParentId | int | 第二父ID

8-样本提取方法
父Id为提取内容ID
第二父ID为物种ID

* __Response__

> 成功

```
{
    "code": 0,
    "data": [
        {
            "id": 1,
            "type": 1,
            "typeDesc": "项目类型",
            "code": 1,
            "description": "免费"
        },
        {
            "id": 2,
            "type": 1,
            "typeDesc": "项目类型",
            "code": 2,
            "description": "收费"
        }
    ]
}
```



