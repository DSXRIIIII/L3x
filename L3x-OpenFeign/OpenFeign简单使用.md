### 版本选择：
- **jdk** 8
- **SpringBoot** 2.7.12
- **SpringCloud** 2021.0.5.0
- **Openfeign** 3.1.3
### 导入Nacos+OpenFeign坐标
#### 生产者(接口提供方)
```xml
<dependencies>
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-openfeign</artifactId>
      <version>3.1.3</version>
  </dependency>
  <dependency>
      <groupId>com.alibaba.cloud</groupId>
      <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
      <version>2021.0.5.0</version>
  </dependency>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
</dependencies>
```
#### 消费者(服务接收方)
消费者比生产者多了`loadbalancer`
```xml
<dependencies>
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-openfeign</artifactId>
      <version>3.1.3</version>
  </dependency>
  <dependency>
      <groupId>com.alibaba.cloud</groupId>
      <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
      <version>2021.0.5.0</version>
  </dependency>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-loadbalancer</artifactId>
      <version>3.1.3</version>
  </dependency>
</dependencies>
```

### 实现
#### 生产者实现接口(接口提供方)
```java
@RestController
public class BusinessController {

    @RequestMapping(value = "/openfeign/test",method = RequestMethod.GET)
    public String discovery(){
        System.out.println("------- do provider getNameById method" + LocalDateTime.now());
        return "我被调用了￣へ￣";
    }
}
@SpringBootApplication
public class OpenfeignProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignProducerApplication.class,args);
    }
}
```
#### 配置文件信息
```yaml
spring:
  application:
    name: l3x-openfeign-discovery
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
        username: nacos
        password: nacos
        register-enabled: true # 生产者注册
server:
  port: 1312
```
#### 消费者消费接口(服务接收方)
```java
@FeignClient("l3x-openfeign-discovery") // 表示调用 nacos 中的 nacos-discovery 服务
public interface DiscoveryClient {
     // 调用生产者的"/openfeign/test"接口
    @RequestMapping(value = "/openfeign/test",method = RequestMethod.GET)
    String discovery();
}

@RestController
public class ConsumerController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String consumerHello() {
        return "Hello from ConsumerService! " + discoveryClient.discovery();
    }
}

@EnableFeignClients
@SpringBootApplication
public class OpenFeignConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignConsumerApplication.class,args);
    }
}

```
#### 配置文件信息
```yaml
server:
  port: 7890
spring:
  application:
    name: l3x-openfeign-consumer
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
        username: nacos
        password: nacos
        register-enabled: false #消费者不需要等级
```
### 结果
调用服务方接口可以发现成功调用
![image.png](https://cdn.nlark.com/yuque/0/2024/png/39213833/1724757870050-174991fd-87bf-42b5-b846-e2c7af5bd21a.png#averageHue=%23e9ece6&clientId=u96738aab-75f2-4&from=paste&height=349&id=u35f94a34&originHeight=436&originWidth=702&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=25606&status=done&style=none&taskId=ub1fe7a92-1e15-44bf-82bd-59d96919c54&title=&width=561.6)
