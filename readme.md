# MyNoteBook-V01 微服务项目重构文档

1.nginx

网关，登录拦截

2.Eureka

注册中心，用户模块，笔记本模块，注册进去

3.openFeign

通过用户模块去调用笔记本模块的表单信息

4.redis

缓存，生成临时登录用户，过期时间3天

5.mysql

存储单词数据，和持久话用户

6.springboot+springmvc+mybatis+jdbc

7.html+css+js



1.登录模块

登录之后，显示笔记本模块，查询笔记本

2.笔记本模块

crud+导入导出

3.ChatGpt模块

弹出聊天窗口

4.外部服务模块

对接外部页面

5.写作模块

TODO 待实现



