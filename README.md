
# Clean Architecture

A starting point for Clean Architecture with Java. 
Clean Architecture is just the latest in a series of names for the same loosely-coupled, 
dependency-inverted architecture. You will also find it named hexagonal, ports-and-adapters, or onion architecture.

This project is inspired from [Clean Architecture][cleanarchitecture] and [COLA][cloa].

## 准备测试数据库

```sql
CREATE DATABASE IF NOT EXISTS clean_architecture DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
GRANT ALL PRIVILEGES ON clean_architecture.* TO deploy@'192.168.1.%' IDENTIFIED BY 'Hello@123456' WITH GRANT OPTION;
```

```sql
USE `clean_architecture`;
START TRANSACTION;
CREATE TABLE `todo_items`
(
    `id`          BIGINT(20) AUTO_INCREMENT NOT NULL COMMENT '主键',
    `title`       VARCHAR(256)              NOT NULL COMMENT '任务名称',
    `description` TEXT                      NOT NULL COMMENT '任务描述',
    `is_done`     TINYINT                   NOT NULL DEFAULT 0 COMMENT '状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO todo_items
VALUES (1, 'Get Sample Working', 'Try to get the sample to build.', 0);
INSERT INTO todo_items
VALUES (2, 'Review Solution', 'Review the different projects in the solution and how they relate to one another.', 0);
INSERT INTO todo_items
VALUES (3, 'Run and Review Tests', 'Make sure all the tests run and review what they are doing.', 0);
COMMIT;
```

## 启用 Swagger2

```bash
$ open http://localhost:8080/swagger-ui.html
$ open http://localhost:8080/v2/api-docs
```


[cleanarchitecture]:    https://github.com/ardalis/CleanArchitecture      "Clean Architecture"
[cloa]:                 https://github.com/alibaba/COLA                   "Clean Object-Oriented and Layered Architecture"
