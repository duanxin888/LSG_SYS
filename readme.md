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
      "categoryId": 1,
      "price": 38.00,
      "picUrl": "//img12.360buyimg.com/n1/g10/M00/11/05/rBEQWVFbj0IIAAAAAAJBBvGVL3AAADWyAALYMYAAkEe119.jpg",
      "details": "一个声势显赫的康巴藏族土司，在酒后和汉族太太生了一个傻瓜儿子。这个人人都认定的傻子与现实生活格格不入，却有着超时代的预感和举止，成为土司制度兴衰的见证人。小说故事精彩曲折动人，以饱含激情的笔墨，超然物外的审视目光，展现了浓郁的民族风情和土司制度的浪漫神秘。",
      "sorted": 4
  }],
  "msg": "operator success"
}
```  