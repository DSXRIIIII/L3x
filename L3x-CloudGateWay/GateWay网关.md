### 简单使用
创建`service`服务和`gateway`网关两个服务
`service`服务端口为`6541`
`gateway`网关为`9000`
#### 导入依赖
```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
    <version>3.1.6</version>
  </dependency>
</dependencies>
```
❗web和gateway不能放在一起
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

#### 定义一个简单的接口
```java
@RestController
@RequestMapping("/user")
public class Controller {
    @RequestMapping("/name")
    public String getName(){
        return "华硕我求你别蓝屏了";
    }
}
```

#### 网关配置文件
```yaml
server:
  port: 9000 # 指定网关服务的端口
spring:
  application:
    name: api-gateway
  cloud:
    gateway:
      routes: # 路由数组[路由 就是指定当请求满足什么条件的时候转到哪个微服务]
        - id: product_route # 当前路由的标识, 要求唯一
          uri: http://127.0.0.1:6541 # 请求要转发到的地址
          order: 1 # 路由的优先级,数字越小级别越高
          predicates: # 断言(就是路由转发要满足的条件)
            - Path=/gateway/user/** # 当请求路径满足Path指定的规则时,才进行路由转发
          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改
            - StripPrefix=1 # 转发之前去掉1层路径
      enabled: true
```
#### 访问网关
![image.png](https://cdn.nlark.com/yuque/0/2024/png/39213833/1724145776297-f47f3ec7-d274-4e0a-8964-4b7eae8a317a.png#averageHue=%23fdfdfd&clientId=u78946195-8ad6-4&from=paste&height=252&id=udc6420c7&originHeight=315&originWidth=956&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=10426&status=done&style=none&taskId=udfe2e784-e20d-4d8e-a28a-3ca2d9ddb82&title=&width=764.8)
#### 直接访问接口
![image.png](https://cdn.nlark.com/yuque/0/2024/png/39213833/1724145824150-0f32d61a-58bb-4166-9710-6f484fadae94.png#averageHue=%23fdfdfd&clientId=u78946195-8ad6-4&from=paste&height=230&id=u4bc079e3&originHeight=287&originWidth=732&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=8856&status=done&style=none&taskId=ube0465f7-c816-4f7e-b307-cad71c11192&title=&width=585.6)
发现结果是相同的
