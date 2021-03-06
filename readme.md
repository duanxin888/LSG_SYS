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
#### 获取用户默认地址  
api: /lsg/api/v1/users/address/default/5  
method: get  
request: 5 (userId)  
response:  
```json
{
    "code": 200,
    "data": {
        "name": "Chris",
        "userId": 5,
        "province": "江西省",
        "city": "赣州市",
        "county": "石城县",
        "addressDetails": "幸福里333栋999室",
        "postalCode": null,
        "phone": "13323234444",
        "acquiescence": "DEFAULT"
    },
    "msg": "operator success!"
}
```  
#### 获取用户收货地址集合  
api: /lsg/api/v1/users/address/{5}  
method: get  
request: 5 (userId)  
response:  
```json
{
    "code": 200,
    "data": [
        {
            "name": "Chris",
            "userId": 5,
            "province": "江西省",
            "city": "赣州市",
            "county": "石城县",
            "addressDetails": "幸福里333栋999室",
            "postalCode": null,
            "phone": "13323234444",
            "acquiescence": "DEFAULT"
        },
        {
            "name": "Chris2",
            "userId": 5,
            "province": "天津市",
            "city": "天津市",
            "county": "和平区",
            "addressDetails": "滨江道333楼22室",
            "postalCode": null,
            "phone": "13323234443",
            "acquiescence": "DENY"
        }
    ],
    "msg": "operator success!"
}
```  
#### 更改用户默认收货地址  
api: /lsg/api/v1/users/address/default  
method: put  
request:  
```json
{
    "id":2,
    "userId":5,
    "acquiescence":"DEFAULT"
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
#### 用户下单  
api: /lsg/api/v1/orders  
method: post  
request:  
```json
{
    "userId":5,
    "totalPrice":177.00,
    "totalQuantity":4,
    "consignee":"Chris2",
    "phone":"13323234443",
    "address":"天津市 天津市 和平区 滨江道333楼22室",
    "orderDetailsDtos":[
        {
            "bookId":1,
            "bookName":"东野圭吾·沉默的巡游",
            "bookPicUrl":"//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
            "bookLevelName":"全新",
            "quantity":2,
            "price":53.10
        },{
            "bookId": 1,
            "bookName": "东野圭吾·沉默的巡游",
            "bookPicUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
            "bookLevelName": "优良",
            "price": 35.40,
            "quantity": 2
        }
    ]
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
#### 查询用户账户信息  
api: /lsg/api/v1/users/accounts/{userId}  
method: get     
request: 5 (userId)   
response:  
```json
{
    "code": 200,
    "data": {
        "id": 6,
        "userId": 5,
        "accountSn": "012020101221385401",
        "balance": 0.00
    },
    "msg": "operator success!"
}
```  
#### 用户付款  
api: /lsg/api/v1/orders/pay  
method: put  
request:  
```json
{
    "userId":5,
    "orderSn":"000000000052020111816335902",
    "orderStatusName":"提交成功"
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
#### 获取用户订单列表  
api: /lsg/api/v1/orders/users/{userId}  
method: get  
request: 5 (userId)  
response:  
```json
{
    "code": 200,
    "data": [
        {
            "id": 2,
            "userId": 5,
            "orderSn": "000000000052020111810001502",
            "totalPrice": 177.00,
            "totalQuantity": 4,
            "orderStatusName": "提交成功",
            "consignee": "Chris2",
            "phone": "13323234443",
            "address": "天津市 天津市 和平区 滨江道333楼22室",
            "orderDetailsDtos": [
                {
                    "id": 1,
                    "orderId": 2,
                    "bookId": 1,
                    "bookName": "东野圭吾·沉默的巡游",
                    "bookPicUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
                    "bookLevelName": "全新",
                    "quantity": 2,
                    "price": 53.10
                },
                {
                    "id": 2,
                    "orderId": 2,
                    "bookId": 1,
                    "bookName": "东野圭吾·沉默的巡游",
                    "bookPicUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
                    "bookLevelName": "优良",
                    "quantity": 2,
                    "price": 35.40
                }
            ]
        },
        {
            "id": 3,
            "userId": 5,
            "orderSn": "000000000052020111810123802",
            "totalPrice": 177.00,
            "totalQuantity": 0,
            "orderStatusName": "提交成功",
            "consignee": "Chris2",
            "phone": "13323234443",
            "address": "天津市 天津市 和平区 滨江道333楼22室",
            "orderDetailsDtos": [
                {
                    "id": 3,
                    "orderId": 3,
                    "bookId": 1,
                    "bookName": "东野圭吾·沉默的巡游",
                    "bookPicUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
                    "bookLevelName": "全新",
                    "quantity": 2,
                    "price": 53.10
                },
                {
                    "id": 4,
                    "orderId": 3,
                    "bookId": 1,
                    "bookName": "东野圭吾·沉默的巡游",
                    "bookPicUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
                    "bookLevelName": "优良",
                    "quantity": 2,
                    "price": 35.40
                }
            ]
        },
        {
            "id": 4,
            "userId": 5,
            "orderSn": "000000000052020111810141302",
            "totalPrice": 177.00,
            "totalQuantity": 4,
            "orderStatusName": "提交成功",
            "consignee": "Chris2",
            "phone": "13323234443",
            "address": "天津市 天津市 和平区 滨江道333楼22室",
            "orderDetailsDtos": [
                {
                    "id": 5,
                    "orderId": 4,
                    "bookId": 1,
                    "bookName": "东野圭吾·沉默的巡游",
                    "bookPicUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
                    "bookLevelName": "全新",
                    "quantity": 2,
                    "price": 53.10
                },
                {
                    "id": 6,
                    "orderId": 4,
                    "bookId": 1,
                    "bookName": "东野圭吾·沉默的巡游",
                    "bookPicUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
                    "bookLevelName": "优良",
                    "quantity": 2,
                    "price": 35.40
                }
            ]
        },
        {
            "id": 7,
            "userId": 5,
            "orderSn": "000000000052020111816335902",
            "totalPrice": 23.60,
            "totalQuantity": 2,
            "orderStatusName": "支付成功",
            "consignee": "Chris2",
            "phone": "13323234443",
            "address": "天津市 天津市 和平区 滨江道333楼22室",
            "message": null,
            "freightPrice": null,
            "paySn": "000000000052020112110305803",
            "payType": "BOOK_CURRENCY_PAY",
            "payTime": "2020-11-21T10:30:58",
            "orderDetailsDtos": [
                {
                    "id": 10,
                    "orderId": 7,
                    "bookId": 1,
                    "bookName": "东野圭吾·沉默的巡游",
                    "bookPicUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
                    "bookLevelName": "普通",
                    "quantity": 2,
                    "price": 11.80
                }
            ]
        }
    ],
    "msg": "operator success!"
}
```  
#### 获取用户订单详情  
api: /lsg/api/v1/orders/users/{userId}/orderSn/{orderSn}  
method: get  
request: 5 (userId), 000000000052020111816335902 (orderSn)  
response:  
```json
{
    "code": 200,
    "data": {
        "id": 7,
        "userId": 5,
        "orderSn": "000000000052020111816335902",
        "totalPrice": 23.60,
        "totalQuantity": 2,
        "orderStatusName": "支付成功",
        "consignee": "Chris2",
        "phone": "13323234443",
        "address": "天津市 天津市 和平区 滨江道333楼22室",
        "paySn": "000000000052020112110305803",
        "payType": "BOOK_CURRENCY_PAY",
        "payTime": "2020-11-21T10:30:58",
        "orderDetailsDtos": [
            {
                "id": 10,
                "orderId": 7,
                "bookId": 1,
                "bookName": "东野圭吾·沉默的巡游",
                "bookPicUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
                "bookLevelName": "普通",
                "quantity": 2,
                "price": 11.80
            }
        ]
    },
    "msg": "operator success!"
}
```  
#### 用户添加回收书籍  
api: /lsg/api/v1/books/users/{userId}/recycle/{isbn}
method: post    
request: 5 (userId), 9787115357618 (isbn)  
response:   
```json
{
    "code": 200,
    "data": {
        "id": 0,
        "recycleOrderId": 10,
        "bookName": "编程珠玑（第2版•修订版）",
        "bookAuthor": "[美] Jon Bentley 乔恩•本特利",
        "bookPic": "http://open.liupai.net/lpic/s27984539.jpg",
        "bookDetails": "历史上最伟大的计算机科学著作之一\n融深邃思想、实战技术与趣味轶事于一炉的奇书\n带你真正领略计算机科学之美\n多年以来，当程序员们推选出最心爱的计算机图书时，《编程珠玑》总是位于前列。正如自然界里珍珠出自细沙对牡蛎的磨砺，计算机科学大师Jon Bentley以其独有的洞察力和创造力，从磨砺程序员的实际问题中凝结出一篇篇不朽的编程“珠玑”，成为世界计算机界名刊《ACM通讯》历史上最受欢迎的专栏，最终结集为两部不朽的计算机科学经典名著，影响和激励着一代又一代程序员和计算机科学工作者。本书为第一卷，主要讨论计算机科学中最本质的问题：如何正确选择和高效地实现算法。\n在书中，作者选取许多具有典型意义的复杂编程和算法问题，生动描绘了历史上众大师们在探索解决方案中发生的轶事、走过的弯路和不断精益求精的历程，引导读者像真正的程序员和软件工程师那样富于创新性地思考，并透彻阐述和总结了许多独特而精妙的设计原则、思考和解决问题的方法以及实用程序设计技巧。解决方案的代码均以C/C++语言编写，不仅有趣，而且有很大的实战示范意义。每章后所附习题极具挑战性和启发性，书末给出了简洁的解答。\n本书是计算机科学方面的经典名著。书的内容围绕程序设计人员面对的一系列实际问题展开。作者Jon Bentley 以其独有的洞察力和创造力，引导读者理解这些问题并学会解决方法，而这些正是程序员实际编程生涯中至关重要的。本书的特色是通过一些精心设计的有趣而又颇具指导意义的程序，对实用程序设计技巧及基本设计原则进行了透彻而睿智的描述，为复杂的编程问题提供了清晰而完备的解决思路。本书对各个层次的程序员都具有很高的阅读价值。\n书评\n“《编程珠玑》是对我职业生涯早期影响最大的书之一，其中的许多真知灼见多年之后仍然使我受益匪浅。”\n——Steve McConnell，软件工程大师，IEEE Software前主编，《代码大全》作者",
        "bookPrice": 39.00,
        "bookISBN10": "7115357617",
        "bookISBN13": "9787115357618",
        "bookLevelId": 0
    },
    "msg": "operator success!"
}
```  
#### 获取用户未回收的订单  
api: /lsg/api/v1/books/users/{userId}/recycling  
method: get  
request: 5 (userId)  
response:  
```json
{
    "code": 200,
    "data": {
        "id": 10,
        "recycleOrderSn": "000000000052020112320594504",
        "userId": 5,
        "recycleOrderStatusName": "回收中",
        "recycleOrderDetailsDtos": [
            {
                "id": 1,
                "recycleOrderId": 10,
                "bookName": "编程珠玑（第2版•修订版）",
                "bookAuthor": "[美] Jon Bentley 乔恩•本特利",
                "bookPic": "http://open.liupai.net/lpic/s27984539.jpg",
                "bookDetails": "历史上最伟大的计算机科学著作之一\n融深邃思想、实战技术与趣味轶事于一炉的奇书\n带你真正领略计算机科学之美\n多年以来，当程序员们推选出最心爱的计算机图书时，《编程珠玑》总是位于前列。正如自然界里珍珠出自细沙对牡蛎的磨砺，计算机科学大师Jon Bentley以其独有的洞察力和创造力，从磨砺程序员的实际问题中凝结出一篇篇不朽的编程“珠玑”，成为世界计算机界名刊《ACM通讯》历史上最受欢迎的专栏，最终结集为两部不朽的计算机科学经典名著，影响和激励着一代又一代程序员和计算机科学工作者。本书为第一卷，主要讨论计算机科学中最本质的问题：如何正确选择和高效地实现算法。\n在书中，作者选取许多具有典型意义的复杂编程和算法问题，生动描绘了历史上众大师们在探索解决方案中发生的轶事、走过的弯路和不断精益求精的历程，引导读者像真正的程序员和软件工程师那样富于创新性地思考，并透彻阐述和总结了许多独特而精妙的设计原则、思考和解决问题的方法以及实用程序设计技巧。解决方案的代码均以C/C++语言编写，不仅有趣，而且有很大的实战示范意义。每章后所附习题极具挑战性和启发性，书末给出了简洁的解答。\n本书是计算机科学方面的经典名著。书的内容围绕程序设计人员面对的一系列实际问题展开。作者Jon Bentley 以其独有的洞察力和创造力，引导读者理解这些问题并学会解决方法，而这些正是程序员实际编程生涯中至关重要的。本书的特色是通过一些精心设计的有趣而又颇具指导意义的程序，对实用程序设计技巧及基本设计原则进行了透彻而睿智的描述，为复杂的编程问题提供了清晰而完备的解决思路。本书对各个层次的程序员都具有很高的阅读价值。\n书评\n“《编程珠玑》是对我职业生涯早期影响最大的书之一，其中的许多真知灼见多年之后仍然使我受益匪浅。”\n——Steve McConnell，软件工程大师，IEEE Software前主编，《代码大全》作者",
                "bookPrice": 39.00,
                "bookISBN10": "7115357617",
                "bookISBN13": "9787115357618",
                "bookLevelId": 0
            }
        ]
    },
    "msg": "operator success!"
}
```  
#### 查询用户已完成和已取消的回收订单  
api: /lsg/api/v1/books/users/{userId}/recycled  
method: get  
request: 5 (userId)  
response:  
```json
{
    "code": 200,
    "data": [
        {
            "id": 10,
            "recycleOrderSn": "000000000052020112320594504",
            "userId": 5,
            "recycleOrderStatusName": "已取消",
            "recycleOrderDetailsDtos": [
                {
                    "id": 1,
                    "recycleOrderId": 10,
                    "bookName": "编程珠玑（第2版•修订版）",
                    "bookAuthor": "[美] Jon Bentley 乔恩•本特利",
                    "bookPic": "http://open.liupai.net/lpic/s27984539.jpg",
                    "bookDetails": "历史上最伟大的计算机科学著作之一\n融深邃思想、实战技术与趣味轶事于一炉的奇书\n带你真正领略计算机科学之美\n多年以来，当程序员们推选出最心爱的计算机图书时，《编程珠玑》总是位于前列。正如自然界里珍珠出自细沙对牡蛎的磨砺，计算机科学大师Jon Bentley以其独有的洞察力和创造力，从磨砺程序员的实际问题中凝结出一篇篇不朽的编程“珠玑”，成为世界计算机界名刊《ACM通讯》历史上最受欢迎的专栏，最终结集为两部不朽的计算机科学经典名著，影响和激励着一代又一代程序员和计算机科学工作者。本书为第一卷，主要讨论计算机科学中最本质的问题：如何正确选择和高效地实现算法。\n在书中，作者选取许多具有典型意义的复杂编程和算法问题，生动描绘了历史上众大师们在探索解决方案中发生的轶事、走过的弯路和不断精益求精的历程，引导读者像真正的程序员和软件工程师那样富于创新性地思考，并透彻阐述和总结了许多独特而精妙的设计原则、思考和解决问题的方法以及实用程序设计技巧。解决方案的代码均以C/C++语言编写，不仅有趣，而且有很大的实战示范意义。每章后所附习题极具挑战性和启发性，书末给出了简洁的解答。\n本书是计算机科学方面的经典名著。书的内容围绕程序设计人员面对的一系列实际问题展开。作者Jon Bentley 以其独有的洞察力和创造力，引导读者理解这些问题并学会解决方法，而这些正是程序员实际编程生涯中至关重要的。本书的特色是通过一些精心设计的有趣而又颇具指导意义的程序，对实用程序设计技巧及基本设计原则进行了透彻而睿智的描述，为复杂的编程问题提供了清晰而完备的解决思路。本书对各个层次的程序员都具有很高的阅读价值。\n书评\n“《编程珠玑》是对我职业生涯早期影响最大的书之一，其中的许多真知灼见多年之后仍然使我受益匪浅。”\n——Steve McConnell，软件工程大师，IEEE Software前主编，《代码大全》作者",
                    "bookPrice": 39.00,
                    "bookISBN10": "7115357617",
                    "bookISBN13": "9787115357618",
                    "bookLevelId": 0
                }
            ]
        }
    ],
    "msg": "operator success!"
}
```  
#### 移除回收书籍单项  
api: /lsg/api/v1/books/recycle/details/{detailsId}  
method:  delete  
request: 2 (detailsId)  
response:   
```json
{
    "code": 200,
    "data": null,
    "msg": "operator success!"
}
```   
#### 用户回收订单下单  
api: /lsg/api/v1/books/users/{userId}/recycling  
method: put  
request: 5 (userId)  
response:  
```json
{
    "code": 200,
    "data": null,
    "msg": "operator success!"
}
```   
#### 书籍搜索  
api: /lsg/api/v1/books/search/{searchContent}/type/{searchType}  
method: get  
request: 的 (searchContent) NAME (searchType) --> (NAME/AUTHOR)  
response:  
```json
{
    "code": 200,
    "data": [
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
            "id": 7,
            "bookName": "一只特立独行的猪",
            "author": "王小波",
            "categoryId": 2,
            "price": 24.10,
            "picUrl": "//img11.360buyimg.com/n1/jfs/t4558/327/1779717072/386346/568d5425/58e60bb0Nf5fc33c8.jpg",
            "details": "本书为王小波杂文代表作，王小波终其一生思考着并快乐着，他以独有的调侃的笔调完成了对自由与理性的反思与书写。书中对女权主义、科学与迷信、同性恋、小说创作、知识分子等话题进行剖解，展现了一座智性的迷宫，让读者从他那里学会如何独立而自由地思考，真切地体会到作为一个独立个体，应有的尊严与自由。这种观点在上世界九十年代点爆了一代人的青春，放在当下，依然具有鲜活的感染力",
            "sorted": 3,
            "bookStocks": []
        }
    ],
    "msg": "operator success!"
}
```