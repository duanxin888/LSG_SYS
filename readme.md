### 理书阁后端系统  

  
通用响应体：  
```json
{
  "code": 200,
  "data": {},
  "msg": ""
}
```  
说明：  
1、request success --> code = 200, data --> 为下面的response, msg --> "operator success!"  
2、request fail --> code and msg 见[ResultEnum](https://github.com/duanxin888/LSG_SYS/blob/master/lsg-core/src/main/java/com/duanxin/lsg/core/exception/ResultEnum.java)
  
#### 微信登陆  
api: /lsg/api/v1/users/login  
method: post  
param: wxLoginRequestDto  
```json
{
  "code": 200,
  "data": {
     "code": "",
     "userInfo": {
         "userId": 1,
         "nickName": "",
         "avatarUrl": "",
         "country": "",
         "province": "",
         "city": "",
         "language": "",
         "gender": 0
     }},
  "msg": "operator success"
}
```  
说明：gender 0女 1男  
  
response:  
```json
{
  "code": 200,
  "data": {
      "thirdSession": "",
      "userBalance": 0.00,
      "userInfo": {
          "nickName": "",
          "avatarUrl": "",
          "country": "",
          "province": "",
          "city": "",
          "language": "",
          "gender": 0
      }
  },
  "msg": "operator success"
}
```  

  
#### 获取书籍分类信息  
api: /lsg/api/v1/books/categories  
method: get  
request:  
response:  
```json
{
    "code": 200,
    "data": [
        {
            "id": 1,
            "categoryName": "小说",
            "sorted": 1
        },
        {
            "id": 2,
            "categoryName": "文学",
            "sorted": 2
        },
        {
            "id": 3,
            "categoryName": "科幻",
            "sorted": 3
        },
        {
            "id": 4,
            "categoryName": "动漫",
            "sorted": 4
        },
        {
            "id": 5,
            "categoryName": "传记",
            "sorted": 5
        },
        {
            "id": 6,
            "categoryName": "经济管理",
            "sorted": 6
        },
        {
            "id": 7,
            "categoryName": "计算机类",
            "sorted": 7
        },
        {
            "id": 8,
            "categoryName": "科技类",
            "sorted": 8
        }
    ],
    "msg": "operator success!"
}
```    
  
#### 获取书籍详细信息  
api: /lsg/api/v1/books/{id}  
request: bookId   
method: get  
response:  
```json
{
    "code": 200,
    "data": {
        "id": 1,
        "bookName": "东野圭吾·沉默的巡游",
        "author": "东野奎吾",
        "categoryId": 1,
        "price": 59.00,
        "picUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
        "details": "这是一桩众目睽睽下的凶杀案：巡游盛典，人声鼎沸，一群失去挚爱的人为复仇走上街头。然而，计划意外中止了，但目标却真的被杀了。他们成了嫌疑人。四起案件层层递进，打破经典推理模式，全程高能反转，难度之大令东野圭吾都直呼难写。“神探伽利略”系列新作：这一次，东野圭吾用“嫌疑人们的献身”，试图改写《嫌疑人X的献身》的结局。这是一个悲伤的故事，却会给你一整年的温暖",
        "sorted": 1,
        "bookStocks": []
    },
    "msg": "operator success!"
}
```   
  
#### 根据分类ID查询书籍  
api: lsg/api/v1/books/categories/{id}  
request: categoryId  
method: get  
response:  
```json
{
    "code": 200,
    "data": [
        {
            "id": 4,
            "bookName": "尘埃落定",
            "author": "阿来",
            "categoryId": 1,
            "price": 38.00,
            "picUrl": "//img12.360buyimg.com/n1/g10/M00/11/05/rBEQWVFbj0IIAAAAAAJBBvGVL3AAADWyAALYMYAAkEe119.jpg",
            "details": "一个声势显赫的康巴藏族土司，在酒后和汉族太太生了一个傻瓜儿子。这个人人都认定的傻子与现实生活格格不入，却有着超时代的预感和举止，成为土司制度兴衰的见证人。小说故事精彩曲折动人，以饱含激情的笔墨，超然物外的审视目光，展现了浓郁的民族风情和土司制度的浪漫神秘。",
            "sorted": 4,
            "bookStocks": []
        },
        {
            "id": 3,
            "bookName": "猴杯",
            "author": "张贵兴",
            "categoryId": 1,
            "price": 28.00,
            "picUrl": "//img11.360buyimg.com/n1/jfs/t1/134049/20/653/470470/5ed07735E135de930/884edba391a4d376.jpg",
            "details": "被开除教职的雉从台湾回到故乡马来西亚砂拉越，追踪抱着刚生下婴儿不知去向的妹妹丽妹进入雨林，受到当地土著达雅克人的热情款待，并与达雅克女孩亚妮妮之间产生了情感纠葛……在作者华丽奇诡的文字下，一段段牵涉到殖民者、开拓者、侵略者、土著，持续了家族四代，血腥阴暗、摄人心魄的恩怨情仇逐渐浮现。",
            "sorted": 3,
            "bookStocks": []
        },
        {
            "id": 2,
            "bookName": "夜晚的潜水艇",
            "author": "陈春成",
            "categoryId": 1,
            "price": 59.00,
            "picUrl": "//img13.360buyimg.com/n1/jfs/t1/134042/31/10150/217224/5f62d914E45e7d0f9/68a94a9554390896.jpg",
            "details": "仿佛鸟栖树，鱼潜渊，一切稳妥又安宁，夜晚这才真正地降临。《夜晚的潜水艇》是作家陈春成的首部短篇小说集。九个故事，笔锋游走于旧山河与未知宇宙间，以瑰奇飘扬的想象、温厚清幽的笔法，在现实与幻境间辟开若干条秘密的通道：海底漫游的少年、深山遗落的古碑、弥散入万物的字句、云彩修剪站、铸剑与酿酒、铁幕下的萨克斯、蓝鲸内的演奏厅……潜入故事深处，感知体内的星云旋动、草木蔓发；以词语的微光，探照记忆的海沟。关于藏匿与寻找、追捕与逃遁，种种无常中的一点确凿，烈日与深渊间的一小片清凉。陈春成的小说世界，是可供藏身的洞窟，悬浮于纸上的宫殿，航向往昔的潜艇，呈现汉语小说的一种风度与新的可能性。",
            "sorted": 2,
            "bookStocks": []
        },
        {
            "id": 1,
            "bookName": "东野圭吾·沉默的巡游",
            "author": "东野奎吾",
            "categoryId": 1,
            "price": 59.00,
            "picUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
            "details": "这是一桩众目睽睽下的凶杀案：巡游盛典，人声鼎沸，一群失去挚爱的人为复仇走上街头。然而，计划意外中止了，但目标却真的被杀了。他们成了嫌疑人。四起案件层层递进，打破经典推理模式，全程高能反转，难度之大令东野圭吾都直呼难写。“神探伽利略”系列新作：这一次，东野圭吾用“嫌疑人们的献身”，试图改写《嫌疑人X的献身》的结局。这是一个悲伤的故事，却会给你一整年的温暖",
            "sorted": 1,
            "bookStocks": []
        }
    ],
    "msg": "operator success!"
}
```    
  
#### 根据书籍ID获取具体的详细等级和库存价格信息  
api: lsg/api/v1/books/levels/{id}  
request: 1  
method: get  
response:  
```json
{
    "code": 200,
    "data": {
        "id": 1,
        "bookName": "东野圭吾·沉默的巡游",
        "author": "东野奎吾",
        "categoryId": 1,
        "price": 59.00,
        "picUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
        "details": "这是一桩众目睽睽下的凶杀案：巡游盛典，人声鼎沸，一群失去挚爱的人为复仇走上街头。然而，计划意外中止了，但目标却真的被杀了。他们成了嫌疑人。四起案件层层递进，打破经典推理模式，全程高能反转，难度之大令东野圭吾都直呼难写。“神探伽利略”系列新作：这一次，东野圭吾用“嫌疑人们的献身”，试图改写《嫌疑人X的献身》的结局。这是一个悲伤的故事，却会给你一整年的温暖",
        "sorted": 1,
        "bookStocks": [
            {
                "id": 1,
                "bookId": 1,
                "bookLevelName": "全新",
                "bookLevelId": 1,
                "stock": 10,
                "price": 53.1000
            },
            {
                "id": 2,
                "bookId": 1,
                "bookLevelName": "优良",
                "bookLevelId": 2,
                "stock": 100,
                "price": 35.4000
            },
            {
                "id": 3,
                "bookId": 1,
                "bookLevelName": "普通",
                "bookLevelId": 3,
                "stock": 20,
                "price": 11.8000
            }
        ]
    },
    "msg": "operator success!"
}
```  
  
#### 添加书籍到购物车  
api: /lsg/api/v1/carts  
method: post  
request:  
添加书籍  
```json
{
    "userId": 6,
    "bookId": 1,
    "bookName":"东野圭吾·沉默的巡游",
    "bookPicUrl":"//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
    "bookLevelName": "普通",
    "quantity":1,
    "price":11.80
}
```      
删除书籍  
```json
{
    "userId": 6,
    "bookId": 1,
    "bookName":"东野圭吾·沉默的巡游",
    "bookPicUrl":"//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
    "bookLevelName": "普通",
    "quantity":-1,
    "price":11.80
}
```  
response:   
1、request success： 
```json
{
    "code": 200,
    "data": null,
    "msg": "operator success!"
}
```   
2、request failed: 
```json
{
    "code": 401,
    "data": null,
    "msg": "user not exist"
}
```    
```json
{
    "code": 401,
    "data": null,
    "msg": "when add book to cart, cart request info is empty"
}
```  
```json
{
    "code": 404,
    "data": null,
    "msg": "this kind of book is out of stock"
}
```   
#### 查看购物车详情  
api: /lsg/api/v1/carts  
method: get  
request: 6 (userId)  
response:  
```json
{
    "code": 200,
    "data": [
        {
            "userId": 6,
            "bookId": 6,
            "bookName": "东野圭吾·沉默的巡游",
            "bookPicUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
            "bookLevelName": "普通",
            "price": 11.80,
            "quantity": 4
        }
    ],
    "msg": "operator success!"
}
```  
#### 删除用户购物车  
api: /lsg/api/v1/carts  
method: delete  
request:   
```json
{
    "userId": 6,
    "bookId": 1,
    "bookLevelName": "普通"
}
```  
response:  
```json
{
    "code": 200,
    "data": null,
    "msg": "operator success!"
}
```   
#### 添加用户收货地址  
api: /lsg/api/v1/users/address  
method: post  
request:  
```json
{
    "name":"",
    "userId":5,
    "province":"",
    "city":"",
    "county":"",
    "addressDetails":"",
    "phone":"13323234444",
    "acquiescence":"DEFAULT"
}
```  
备注：默认地址 --》 ("acquiescence":"DEFAULT"), 不是默认地址 --》 ("acquiescence":"DENY")  
response:  
```json
{
    "code": 200,
    "data": null,
    "msg": "operator success!"
}
```