# 微服务框架
##版本说明
TODO



## 模块说明

> framework-core  核心包 (独立的，聚合的)
```text

```
> framework-parent  顶层依赖定义包
```text

```
> framework-support 框架支持包 
```text
（redis、nacos、redisson、gateway、mongodb）
```
> framework-generator
```text
框架代码生成器
```
> business-component 可复用的业务组件
```text
排行榜、（抽象的最小单元定义） TODO
```
> design-component 设计组件 (抽象的设计模式复用设计) 
```text
快速接入设计模式，避免重复的编写设计模式代码。 TODO 
```

## 集成设计思想

关于集成的一些设计想法，首先集成一个功能，我们做一些定义，比如自定义的配置类，当我们项目需要集成功能回互相组合时，可以通过判断来决定，比如，openFeign + 熔断，（hystirx or sentinal ） ，此时我们的hystrix 和 sentinal 都有自己的 配置，此时可以在 openFeign中判断是否存在我们定义的 配置类，利用@ConditionalXX 来判断，这样可以很快的组合好各类依赖。













