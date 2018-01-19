
登陆/用户/角色/权限 接口规格
=============

[TOC]

## 1 登录模块

### 1.1 登入
* __Method__
  POST

* __URL__
  /api/login

* __Request__

 Param | Type | Description 

 username | string | 用户名

 password | string | 密码


* __Response__

> 成功

```
{
  "code": 0,
  "data": {
    "nickname": "管理员", #昵称
    "id": 1,
    "permissions": [ #权限码
      0
    ],
    "username": "admin" #用户名
  }
}
```

> 失败

```
{
  "code": 2,
  "data": "密码错误"
}
```


### 1.2 登出
* __Method__
  POST

* __URL__
  /api/logout

* __Request__

 Param | Type | Description 

 无


* __Response__

> 成功

```
{
  "code": 0,
  "data": "success"
}
```

> 失败

```
{
  "code": -1,
  "data": "XXX"
}
```


## 2 用户模块

### 2.1 创建用户
* __Method__
  POST

* __URL__
  /api/user

* __Request__

> 请求参数Json格式

```
{
	"username":"admin",
	"password":"admin",
	"nickname":"昵称",
	"sex":1, #1-男 2-女 3-未知
	"birthTime":"May 31, 2017 4:04:57 PM", #出生日期
	"phone":"123456789",
	"email":"12345@qq.com",
	"department":"部门",
	"position":"职位",
	"note":"admin",
	"roles":[1] 
}
```

* __Response__

> 成功

```
{
  "code": 0
}
```

> 失败

```
{
  "reason": "记录已存在",
  "code": 5
}
```

### 2.2 修改用户

* __Method__
  PUT

* __URL__
  /api/user

* __Request__

 Param | Type | Description 

 id | int | 用户ID

> 请求参数Json格式

```
{
     "id":9,
	"username":"admin",
	"password":"admin",
	"nickname":"昵称",
	"sex":1,
	"birthTime":"May 31, 2017 4:04:57 PM", #出生日期
	"phone":"123456789",
	"email":"12345@qq.com",
	"department":"部门",
	"position":"职位2",
	"note":"admin",
	"roles":[1] 
}
```

* __Response__

> 成功

```
{
  "code": 0
}
```

> 失败

```
{
  "reason": "记录不存在",
  "code": 4
}
```

### 2.3 获取用户列表

* __Method__
  GET

* __URL__
  /api/user

* __Request__

  Param | Type | Description 

  page | int | 页数

  length | int | 每页记录数


* __Response__

```
{
  "code": 0,
  "data": {
    "pageSize": 10,
    "currentPage": 1,
    "totalPage": 1,
    "totalCount": 1,
    "rows": [
      {
        "id": 1,
        "username": "admin",
        "nickname": "管理员",
        "sex": 1,
        "sexDesc": "男",
        "roles": [
          {
            "id": 1,
            "name": "管理员",
            "permissions": [
              {
                "id": 1,
                "name": "系统管理",
                "code": 0,
                "createBy": 1,
                "updateBy": 1,
                "createTime": "May 31, 2017 4:04:57 PM",
                "updateTime": "May 31, 2017 4:04:57 PM"
              }
            ],
            "createBy": 1,
            "updateBy": 1,
            "createTime": "May 31, 2017 4:04:56 PM",
            "updateTime": "May 31, 2017 4:04:56 PM"
          }
        ],
        "createBy": 1,
        "updateBy": 1,
        "createTime": "May 31, 2017 4:04:56 PM",
        "updateTime": "May 31, 2017 4:04:56 PM"
      }
    ]
  }
}
```

### 2.4 删除用户
* __Method__
  DELETE

* __URL__
  /api/user/{id}

* __Request__

 Param | Type | Description 

  id | int | 用户ID


* __Response__

> 成功

```
{
  "code": 0
}
```



## 3 角色权限模块
### 3.1 获取权限列表
* __Method__
  GET
* __URL__
  /api/permission
* __Request__

Param | Type | Description 

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
    "totalCount": 1,
    "rows": [
      {
        "id": 1,
        "name": "系统管理",
        "code": 0,
        "createBy": 1,
        "updateBy": 1,
        "createTime": "May 31, 2017 4:04:57 PM",
        "updateTime": "May 31, 2017 4:04:57 PM"
      }
    ]
  }
}
```

### 3.2 创建角色

* __Method__
  POST

* __URL__
  /api/role

* __Request__

> 请求参数Json格式

```
{
	"name":"角色名",
	"description":"角色描述",
	"permissions":[1] #权限ID
}
```


* __Response__

> 成功

```
{
  "code": 0
}
```
>失败
```
{
  "code": 9,
  "reason": "角色名已存在"
}
```

### 3.3 修改角色
* __Method__
  PUT

* __URL__
  /api/role

* __Request__

 Param | Type | Description 

无

> 请求参数Json格式

```
{
	"id":2,
	"name":"角色名ff",
	"description":"角色描述",
	"permissions":[1]
}
```


* __Response__

> 成功

```
{
  "code": 0
}
```


### 3.4 删除角色
* __Method__
  DELETE

* __URL__
  /api/role/{id}

* __Request__

  Param | Type | Description 

  id | int | 角色ID


* __Response__

> 成功

```
{
  "code": 0
}
```


### 3.5 获取角色列表
* __Method__
  GET

* __URL__
  /api/role

* __Request__

  param | Type | Description 

  page | int | 页数

  length | int | 每页记录数



* __Response__

```
{
  "code": 0,
  "data": {
    "pageSize": 10,
    "currentPage": 1,
    "totalPage": 1,
    "totalCount": 2,
    "rows": [
      {
        "id": 1,
        "name": "管理员",
        "permissions": [
          {
            "id": 1,
            "name": "系统管理",
            "code": 0,
            "createBy": 1,
            "updateBy": 1,
            "createTime": "Jun 2, 2017 10:53:16 PM",
            "updateTime": "Jun 2, 2017 10:53:16 PM"
          }
        ],
        "createBy": 1,
        "updateBy": 1,
        "createTime": "Jun 2, 2017 10:53:16 PM",
        "updateTime": "Jun 2, 2017 10:53:16 PM"
      }
    ]
  }
}
```

