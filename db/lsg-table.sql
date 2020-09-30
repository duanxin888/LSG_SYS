# create database lsg_sys;
# use lsg_sys;

## 用户表
create table T_USER
(
    ID             INT(11) primary key auto_increment COMMENT '用户主键ID',
    USER_NAME      VARCHAR(22) NOT NULL COMMENT '用户名',
    PASSWORD       VARCHAR(30) COMMENT '密码',
    PHONE          VARCHAR(30) COMMENT '用户手机号',
    USER_IMG_URL   VARCHAR(255) COMMENT '用户头像',
    ACCOUNT_SN     VARCHAR(64) NOT NULL COMMENT '账户编号',
    NICKNAME       VARCHAR(64) NOT NULL COMMENT '用户昵称',
    WX_OPENID      VARCHAR(64) NOT NULL COMMENT '微信登陆openid',
    WX_SESSION_KEY VARCHAR(64) NOT NULL COMMENT '微信登陆会话key',
    STATUS         INT(1)      NOT NULL DEFAULT 0 COMMENT '用户状态，0可用，1禁用，2注销',
    DELETED        INT(1)      NOT NULL DEFAULT 0 COMMENT '逻辑删除，0不删除，1逻辑删除',
    CDATE          DATETIME    NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR        VARCHAR(22) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE          DATETIME    NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR         VARCHAR(22) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '用户表';

## 用户账户信息表
create table T_USER_ACCOUNT
(
    ID         INT(11) primary key auto_increment COMMENT '用户账户ID',
    ACCOUNT_SN VARCHAR(64)    NOT NULL COMMENT '账户编号',
    BALANCE    DECIMAL(10, 2) NOT NULL DEFAULT 0.00 COMMENT '用户账户余额',
    DELETED    INT(1)         NOT NULL DEFAULT 0 COMMENT '逻辑删除，0不删除，1逻辑删除',
    CDATE      DATETIME       NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR    VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE      DATETIME       NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR     VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '用户账户信息表';

## 虚拟货币兑换信息表
create table T_VIRTUAL_CURRENCY_EXCHANGE_INFO
(
    ID                      INT(11) primary key auto_increment COMMENT '虚拟货币兑换信息ID',
    USER_ID                 INT(11)        NOT NULL COMMENT '用户ID',
    ACCOUNT_SN              VARCHAR(64)    NOT NULL COMMENT '用户账户编号',
    TRADING_SN              VARCHAR(64)    NOT NULL COMMENT '交易编号',
    TRADING_CHANNEL         VARCHAR(24)    NOT NULL COMMENT '交易渠道',
    CHANNEL_CURRENCY_AMOUNT DECIMAL(10, 2) NOT NULL DEFAULT 0.00 COMMENT '渠道货币金额',
    VIRTUAL_CURRENCY_AMOUNT DECIMAL(10, 2) NOT NULL DEFAULT 0.00 COMMENT '虚拟货币金额',
    CDATE                   DATETIME       NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR                 VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE                   DATETIME       NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR                  VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '虚拟货币兑换信息表';

## 用户地址表
create table T_USER_ADDRESS
(
    ID              INT(11) primary key auto_increment COMMENT '用户地址ID',
    NAME            VARCHAR(64)  NOT NULL COMMENT '收货人名称',
    USER_ID         INT(11)      NOT NULL COMMENT '用户ID',
    PROVINCE        VARCHAR(48)  NOT NULL COMMENT '省级行政区域',
    CITY            VARCHAR(48)  NOT NULL COMMENT '市级行政区域',
    COUNTY          VARCHAR(48)  NOT NULL COMMENT '县级行政区域',
    ADDRESS_DETAILS VARCHAR(255) NOT NULL COMMENT '收货详细地址',
    POSTAL_CODE     CHAR(6) COMMENT '邮政编码',
    PHONE           VARCHAR(30)  NOT NULL COMMENT '收货手机号',
    ACQUIESCENCE    INT(1)       NOT NULL DEFAULT 0 COMMENT '是否默认地址，0默认，1非默认',
    DELETED         INT(1)       NOT NULL DEFAULT 0 COMMENT '逻辑删除，0不删除，1删除',
    CDATE           DATETIME     NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR         VARCHAR(22)  NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE           DATETIME     NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR          VARCHAR(22)  NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '用户地址表';

## 行政区域表
create table T_REGION
(
    ID   INT(11) primary key auto_increment COMMENT '行政区域ID',
    PID  INT(11)     NOT NULL COMMENT '行政区域父ID，例如区县的pid指向市，市的pid指向省，省的pid则是0',
    NAME VARCHAR(64) NOT NULL COMMENT '行政区域名称',
    TYPE INT(3)      NOT NULL COMMENT '行政区域类型，如如1则是省， 如果是2则是市，如果是3则是区县',
    CODE INT(11)     NOT NULL COMMENT '行政区域编号'
) COMMENT '行政区域表';

## 用户购物车信息表
create table T_USER_SHOPPING_CART
(
    ID              INT(11) primary key auto_increment COMMENT '购物车ID',
    USER_ID         INT(11)        NOT NULL COMMENT '用户ID',
    BOOK_ID         INT(11)        NOT NULL COMMENT '书籍ID',
    BOOK_NAME       VARCHAR(64)    NOT NULL COMMENT '书籍名称',
    BOOK_PIC_URL    VARCHAR(255)   NOT NULL COMMENT '书籍图片',
    QUANTITY        INT(3)         NOT NULL COMMENT '购买数量',
    BOOK_LEVEL_NAME VARCHAR(24)    NOT NULL COMMENT '书籍等级名称',
    PRICE           DECIMAL(10, 2) NOT NULL COMMENT '加入购物车价格（单价）',
    DELETED         INT(1)         NOT NULL DEFAULT 0 COMMENT '逻辑删除，0不删除，1删除',
    CDATE           DATETIME       NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR         VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE           DATETIME       NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR          VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '用户购物车信息表';

## 用户订单表
create table T_USER_ORDER
(
    ID               INT(11) primary key auto_increment COMMENT '订单ID',
    USER_ID          INT(11)        NOT NULL COMMENT '用户ID',
    ORDER_SN         VARCHAR(64)    NOT NULL COMMENT '订单编号',
    TOTAL_PRICE      DECIMAL(10, 2) NOT NULL COMMENT '购买书籍总价格',
    TOTAL_QUANTITY   INT(3)         NOT NULL COMMENT '购买书籍总数',
    ORDER_STATUS_ID  INT(2)         NOT NULL COMMENT '订单状态',
    CONSIGNEE        VARCHAR(64)    NOT NULL COMMENT '收货人名称',
    PHONE            VARCHAR(24)    NOT NULL COMMENT '收货人手机号',
    ADDRESS          VARCHAR(255)   NOT NULL COMMENT '收货人具体地址',
    MESSAGE          VARCHAR(512) COMMENT '用户订单留言',
    FREIGHT_PRICE    DECIMAL(10, 2)          DEFAULT 0.00 COMMENT '配送费用',
    PAY_SN           VARCHAR(64) COMMENT '支付编号',
    PAY_TYPE         VARCHAR(24) COMMENT '支付方式',
    PAY_TIME         DATETIME COMMENT '支付时间',
    SHIP_SN          VARCHAR(64) COMMENT '发货编号',
    SHIP_CHANNEL     VARCHAR(64) COMMENT '发货快递公司',
    SHIP_TIME        DATETIME COMMENT '发货开始时间',
    REFUND_TIME      DATETIME COMMENT '退款时间',
    CONFIRM_TIME     DATETIME COMMENT '退款时间',
    ORDER_CLOSE_TIME DATETIME COMMENT '订单关闭时间',
    DELETED          INT(1)                  DEFAULT 0 COMMENT '逻辑删除，0不删除，1删除',
    CDATE            DATETIME       NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR          VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE            DATETIME       NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR           VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '用户订单表';

## 订单详情表
create table T_ORDER_DETAILS
(
    ID            INT(11) primary key auto_increment COMMENT '订单详情ID',
    ORDER_ID      INT(11)        NOT NULL COMMENT '订单ID',
    BOOK_ID       INT(11)        NOT NULL COMMENT '书籍ID',
    BOOK_NAME     VARCHAR(64)    NOT NULL COMMENT '书籍名称',
    BOOK_LEVEL_ID INT(3)         NOT NULL COMMENT '书籍等级ID',
    QUANTITY      INT(3)         NOT NULL COMMENT '购买数量',
    PRICE         DECIMAL(10, 2) NOT NULL COMMENT '书籍价格',
    BOOK_PIC_URL  VARCHAR(64)    NOT NULL COMMENT '书籍图片',
    DELETED       INT(1)         NOT NULL DEFAULT 0 COMMENT '逻辑删除，0不删除，1删除',
    CDATE         DATETIME       NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR       VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE         DATETIME       NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR        VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '订单详情表';

## 书籍详情表
create table T_BOOK
(
    ID          INT(11) primary key auto_increment COMMENT '书籍ID',
    BOOK_NAME   VARCHAR(128)   NOT NULL COMMENT '书籍名称',
    CATEGORY_ID INT(11)        NOT NULL COMMENT '书籍分类ID',
    PRICE       DECIMAL(10, 2) NOT NULL COMMENT '书籍价格',
    PIC_URL     VARCHAR(255)   NOT NULL COMMENT '书籍图片',
    DEDTALS     VARCHAR(255)   NOT NULL COMMENT '书籍简介',
    SORTED      INT(11)        NOT NULL COMMENT '书籍排序',
    DELETED     INT(1)         NOT NULL DEFAULT 0 COMMENT '逻辑删除，0不删除，1删除',
    CDATE       DATETIME       NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR     VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE       DATETIME       NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR      VARCHAR(22)    NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '书籍详情表';

## 书籍等级表
create table T_BOOK_LEVEL
(
    ID               INT(11) primary key auto_increment COMMENT '书籍等级表',
    LEVEL_NAME       VARCHAR(64)   NOT NULL COMMENT '书籍等级名称',
    CONDITION_FACTOR DECIMAL(2, 2) NOT NULL DEFAULT 0.90 COMMENT '书籍的品相系数，用于得出折算价',
    DETAILS          VARCHAR(255) COMMENT '书籍等级详情描述',
    CDATE            DATETIME      NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR          VARCHAR(22)   NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE            DATETIME      NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR           VARCHAR(22)   NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '书籍等级表';

## 书籍分类表
create table T_BOOK_CATEGORY
(
    ID                  INT(11) primary key auto_increment COMMENT '书籍分类ID',
    CATEGORY_NAME       VARCHAR(64) NOT NULL COMMENT '分类名称',
    PID                 INT(11)     NOT NULL COMMENT '父级分类ID，顶级分类为0',
    CATEGORY_LEVEL_NAME VARCHAR(3)  NOT NULL DEFAULT 'L0' COMMENT '分类等级，默认L1',
    SORTED              INT(11)     NOT NULL COMMENT '分类排序',
    DELETED             INT(1)      NOT NULL DEFAULT 0 COMMENT '逻辑删除，0不删除，1删除',
    CDATE               DATETIME    NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR             VARCHAR(22) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE               DATETIME    NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR              VARCHAR(22) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '书籍分类表';

## 书籍库存表
create table T_BOOK_STOCK
(
    ID            INT(11) primary key auto_increment COMMENT '书籍库存ID',
    BOOK_ID       INT(11)     NOT NULL COMMENT '书籍ID',
    BOOK_LEVEL_ID INT(11)     NOT NULL COMMENT '书籍等级ID',
    STOCK         INT(11)     NOT NULL DEFAULT 0 COMMENT '书籍库存',
    SALE          INT(11)     NOT NULL DEFAULT 0 COMMENT '书籍销量',
    CDATE         DATETIME    NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR       VARCHAR(22) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE         DATETIME    NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR        VARCHAR(22) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
) COMMENT '书籍库存表';

## 订单状态表
create table T_ORDER_STATUS
(
    ID          INT(11) primary key auto_increment COMMENT '订单状态ID',
    STATUS_NAME VARCHAR(48) NOT NULL COMMENT '订单状态名称',
    DETAILS     VARCHAR(255) COMMENT '订单状态描述',
    CDATE       DATETIME    NOT NULL DEFAULT NOW() COMMENT '创建时间',
    CREATOR     VARCHAR(22) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
    EDATE       DATETIME    NOT NULL DEFAULT NOW() COMMENT '更新时间',
    EDITOR      VARCHAR(22) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新者'
)