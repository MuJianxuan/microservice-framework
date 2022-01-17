```yaml
spring:
  redis:
    host: 106.14.24.156
    port: 6380
    password: dm_webapi
    database: 0
    timeout: 20s  # 连接超时时间（毫秒）默认是2000ms
    lettuce:
      pool:
        max-active: 1024  # 连接池最大连接数（使用负值表示没有限制）
        max-wait: -1s # 连接池最大阻塞等待时间（使用负值表示没有限制）
        max-idle: 200 # 连接池中的最大空闲连接
        min-idle: 5 # 连接池中的最小空闲连接
```