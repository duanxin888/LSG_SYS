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

  
#### 获取首页信息  
api: /lsg/api/v1/books/index  
method: get  
request:  
response:  
```json
{
  "code": 200,
  "data": {
      "bookCategories": [
            {
               "id": 1,
               "categoryName": "小说",
               "sorted": 1
            }
      ],
      "books": [
          {
              "id": 4,
              "bookName": "尘埃落定",
              "author": "阿来",
              "categoryId": 1,
              "price": 38.00,
              "picUrl": "//img12.360buyimg.com/n1/g10/M00/11/05/rBEQWVFbj0IIAAAAAAJBBvGVL3AAADWyAALYMYAAkEe119.jpg",
              "details": "一个声势显赫的康巴藏族土司，在酒后和汉族太太生了一个傻瓜儿子。这个人人都认定的傻子与现实生活格格不入，却有着超时代的预感和举止，成为土司制度兴衰的见证人。小说故事精彩曲折动人，以饱含激情的笔墨，超然物外的审视目光，展现了浓郁的民族风情和土司制度的浪漫神秘。",
              "sorted": 4
          }
      ]},
  "msg": "operator success"
}
```    
  
#### 获取书籍详细信息  
api: /lsg/api/v1/books/{id}  
request:   
method: get  
response:  
```json
{
  "code": 200,
  "data": {
      "id": 4,
      "bookName": "尘埃落定",
      "author": "阿来",
      "price": 38.00,
      "picUrl": "//img12.360buyimg.com/n1/g10/M00/11/05/rBEQWVFbj0IIAAAAAAJBBvGVL3AAADWyAALYMYAAkEe119.jpg",
      "details": "一个声势显赫的康巴藏族土司，在酒后和汉族太太生了一个傻瓜儿子。这个人人都认定的傻子与现实生活格格不入，却有着超时代的预感和举止，成为土司制度兴衰的见证人。小说故事精彩曲折动人，以饱含激情的笔墨，超然物外的审视目光，展现了浓郁的民族风情和土司制度的浪漫神秘。"
  },
  "msg": "operator success"
}
```   
  
#### 根据分类ID查询书籍  
api: lsg/api/v1/books/categories/{id}  
request:  
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
      "sorted": 4
  }],
  "msg": "operator success"
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
        "bookId": 1,
        "bookName": "东野圭吾·沉默的巡游",
        "picUrl": "//img13.360buyimg.com/n1/jfs/t1/102681/37/15355/229270/5e708291E88e39fdd/c00b26e445e830dc.jpg",
        "bookLevelsDtos": [
            {
                "levelId": 1,
                "levelName": "全新",
                "details": "非二手书籍，理书阁从出版社采购的未拆分新书",
                "stock": 10,
                "price": 53.10
            },
            {
                "levelId": 2,
                "levelName": "优良",
                "details": "八九成新，有不明显的使用痕迹或瑕疵（扉页/衬页、可能存在少量文字或盖章）",
                "stock": 100,
                "price": 35.40
            },
            {
                "levelId": 3,
                "levelName": "普通",
                "details": "有较明显的使用痕迹和折痕、标注、磨损等轻微瑕疵问题，但不影响正常阅读",
                "stock": 20,
                "price": 11.80
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
```json
{
    "userId": 5,
    "cartInfos": [
        {
            "bookId": 1,
            "bookLevelId": 1,
            "quantity":1
        }
    ]
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