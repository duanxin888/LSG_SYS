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
2、request fail --> code and msg 见[!ResultEnum](https://github.com/duanxin888/LSG_SYS/blob/master/lsg-core/src/main/java/com/duanxin/lsg/core/exception/ResultEnum.java)
  
#### 微信登陆  
api: /lsg/api/v1/users/login  
param: wxLoginRequest  
```json
{
  "code": "",
  "userInfo": {
      "nickName": "",
      "avatarUrl": "",
      "country": "",
      "province": "",
      "city": "",
      "language": "",
      "gender": 0
  }
}
```  
说明：gender 0男 1女  
  
response:  
```json
{
  "thirdSession": "",
  "userInfo": {
      "nickName": "",
      "avatarUrl": "",
      "country": "",
      "province": "",
      "city": "",
      "language": "",
      "gender": 0
  }
}
```