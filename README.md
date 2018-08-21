# CRM

## 数据库需要调整的非空约束
* Customer --> customer_service_id
* Bill --> order_id,contract_id,customer_id
## 数据库需要删除的字段
* Info --> customer_id
## 数据库设置Unique属性
* User --> account
* Customer --> account
