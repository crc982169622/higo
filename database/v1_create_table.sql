
CREATE TABLE comments (
id VARCHAR2(32 BYTE) NOT NULL ,
order_id VARCHAR2(32 BYTE) NULL ,
item_id VARCHAR2(32 BYTE) NULL ,
content VARCHAR2(500 BYTE) NULL ,
create_user VARCHAR2(32 BYTE) NULL ,
create_date DATE NULL ,
update_user VARCHAR2(32 BYTE) NULL ,
update_date DATE NULL ,
del_flag NUMBER NULL 
);

COMMENT ON COLUMN comments.order_id IS '订单号id';
COMMENT ON COLUMN comments.item_id IS '商品id';
COMMENT ON COLUMN comments.content IS '评论内容';

ALTER TABLE comments ADD PRIMARY KEY (id);


CREATE TABLE first_item_category (
id VARCHAR2(32 BYTE) NOT NULL ,
name VARCHAR2(32 BYTE) NULL ,
create_user VARCHAR2(32 BYTE) NULL ,
create_date DATE NULL ,
update_user VARCHAR2(32 BYTE) NULL ,
update_date DATE NULL ,
del_flag NUMBER NULL 
);
COMMENT ON COLUMN first_item_category.name IS '类别名称';

ALTER TABLE first_item_category ADD PRIMARY KEY (id);


CREATE TABLE item (
id VARCHAR2(255 BYTE) NOT NULL ,
item_name VARCHAR2(255 BYTE) NULL ,
item_price NUMBER NULL ,
item_inventory NUMBER NULL ,
item_category VARCHAR2(255 BYTE) NULL ,
item_img VARCHAR2(255 BYTE) NULL ,
item_describe VARCHAR2(300 BYTE) NULL ,
saled_count NUMBER NULL ,
create_user VARCHAR2(255 BYTE) NULL ,
create_date DATE NULL ,
update_user VARCHAR2(255 BYTE) NULL ,
update_date DATE NULL ,
del_flag NUMBER NULL 
);

COMMENT ON COLUMN item.item_name IS '商品名称';
COMMENT ON COLUMN item.item_price IS '商品单价';
COMMENT ON COLUMN item.item_inventory IS '商品库存';
COMMENT ON COLUMN item.item_category IS '商品类别（小类）';
COMMENT ON COLUMN item.item_img IS '商品图片地址';
COMMENT ON COLUMN item.item_describe IS '商品描述';
COMMENT ON COLUMN item.saled_count IS '已售出数量';

ALTER TABLE item ADD PRIMARY KEY (id);


CREATE TABLE item_like (
id VARCHAR2(32 BYTE) NOT NULL ,
comment_id VARCHAR2(32 BYTE) NULL ,
like_count NUMBER(10) NULL ,
del_flag NUMBER NULL 
);

COMMENT ON COLUMN item_like.comment_id IS '评论id';
COMMENT ON COLUMN item_like.like_count IS '点赞数';

ALTER TABLE item_like ADD PRIMARY KEY (id);


CREATE TABLE order_item (
id VARCHAR2(32 BYTE) NOT NULL ,
order_id VARCHAR2(32 BYTE) NULL ,
item_id VARCHAR2(32 BYTE) NULL ,
item_count NUMBER NULL ,
create_user VARCHAR2(32 BYTE) NULL ,
create_date DATE NULL ,
update_user VARCHAR2(32 BYTE) NULL ,
update_date DATE NULL ,
del_flag NUMBER NULL 
);

COMMENT ON COLUMN order_item.order_id IS '所属订单号';
COMMENT ON COLUMN order_item.item_id IS '商品id';
COMMENT ON COLUMN order_item.item_count IS '数量';

ALTER TABLE order_item ADD PRIMARY KEY (id);


CREATE TABLE orders (
id VARCHAR2(32 BYTE) NOT NULL ,
user_id VARCHAR2(32 BYTE) NULL ,
price_count NUMBER NULL ,
start_place VARCHAR2(255 BYTE) NULL ,
end_place VARCHAR2(255 BYTE) NULL ,
create_user VARCHAR2(32 BYTE) NULL ,
create_date DATE NULL ,
update_user VARCHAR2(32 BYTE) NULL ,
update_date DATE NULL ,
del_flag NUMBER NULL 
);

COMMENT ON COLUMN orders.price_count IS '订单总价';
COMMENT ON COLUMN orders.start_place IS '起始地址';
COMMENT ON COLUMN orders.end_place IS '目标地址';

ALTER TABLE orders ADD PRIMARY KEY (id);


CREATE TABLE second_item_category (
id VARCHAR2(32 BYTE) NOT NULL ,
name VARCHAR2(32 BYTE) NULL ,
first_category_id VARCHAR2(32 BYTE) NULL ,
create_user VARCHAR2(32 BYTE) NULL ,
create_date DATE NULL ,
update_user VARCHAR2(32 BYTE) NULL ,
update_date DATE NULL ,
del_flag NUMBER NULL 
);

COMMENT ON COLUMN second_item_category.name IS '类别名称';
COMMENT ON COLUMN second_item_category.first_category_id IS '所属类别（大类）';

ALTER TABLE second_item_category ADD PRIMARY KEY (id);




CREATE TABLE users (
id VARCHAR2(32 BYTE) NOT NULL ,
user_name VARCHAR2(255 BYTE) NULL ,
password VARCHAR2(255 BYTE) NULL ,
nick VARCHAR2(255 BYTE) NULL ,
mobile NUMBER NULL ,
create_user VARCHAR2(255 BYTE) NULL ,
create_date DATE NULL ,
update_user VARCHAR2(255 BYTE) NULL ,
update_date DATE NULL ,
del_flag NUMBER NULL ,
head_img VARCHAR2(255 BYTE) NULL ,
type NUMBER NULL 
);

COMMENT ON COLUMN users.user_name IS '用户名';
COMMENT ON COLUMN users.password IS '密码';
COMMENT ON COLUMN users.nick IS '昵称';
COMMENT ON COLUMN users.mobile IS '手机号码';
COMMENT ON COLUMN users.del_flag IS '逻辑删除（0：正常  1：已删除）';
COMMENT ON COLUMN users.head_img IS '用户头像图片';
COMMENT ON COLUMN users.type IS '用户类型（0：管理员  1：普通用户）';

ALTER TABLE users ADD PRIMARY KEY (id);

insert into users values(SYS_GUID(),'admin','11111111','超级管理员','18787878787',null,SYSDATE,NULL,NULL,0,NULL,0);

CREATE TABLE item_category (
id VARCHAR2(32 BYTE) NOT NULL ,
category_name VARCHAR2(255 BYTE) NULL ,
category_level NUMBER NULL ,
parent_id VARCHAR2(32 BYTE) NULL ,
create_user VARCHAR2(32 BYTE) NULL ,
create_date DATE NULL ,
update_user VARCHAR2(32 BYTE) NULL ,
update_date DATE NULL ,
del_flag NUMBER NULL
);

COMMENT ON COLUMN item_category.category_name IS '类别名称';
COMMENT ON COLUMN item_category.category_level IS '类别级别';
COMMENT ON COLUMN item_category.parent_id IS '父级类别';

ALTER TABLE item_category ADD PRIMARY KEY (id);


CREATE TABLE BRAND (
ID VARCHAR2(32 BYTE) NOT NULL ,
BRANDNAME VARCHAR2(150 BYTE) NULL ,
APPLICANT VARCHAR2(32 BYTE) NULL ,
MOBILE NUMBER(30) NULL ,
CREATE_USER VARCHAR2(32 BYTE) NULL ,
CREATE_DATE DATE NULL ,
UPDATE_USER VARCHAR2(32 BYTE) NULL ,
UPDATE_DATE DATE NULL ,
DEL_FLAG NUMBER NULL
);

COMMENT ON COLUMN BRAND IS '品牌表';
COMMENT ON COLUMN BRAND.BRANDNAME IS '商品名称';
COMMENT ON COLUMN BRAND.APPLICANT IS '申请人';
COMMENT ON COLUMN BRAND.MOBILE IS '联系方式';

ALTER TABLE BRAND ADD PRIMARY KEY (ID);


CREATE TABLE SPECIFICATION (
ID VARCHAR2(32 BYTE) NOT NULL ,
CATEGORY_ID VARCHAR2(32 BYTE) NULL ,
SPECIFICATIONS VARCHAR2(300 BYTE) NULL ,
CREATE_USER VARCHAR2(32 BYTE) NULL ,
CREATE_DATE DATE NULL ,
UPDATE_USER VARCHAR2(32 BYTE) NULL ,
UPDATE_DATE DATE NULL ,
DEL_FLAG NUMBER NULL
);

COMMENT ON COLUMN SPECIFICATION IS '规格参数表';
COMMENT ON COLUMN SPECIFICATION.CATEGORY_ID IS '所属类别id';
COMMENT ON COLUMN SPECIFICATION.SPECIFICATIONS IS '规格参数模板（json格式）';

ALTER TABLE SPECIFICATION ADD PRIMARY KEY (ID);
