# common-hystrix

### Dependency

``` xml
<dependency>
    <groupId>com.netflix.hystrix</groupId>
    <artifactId>hystrix-core</artifactId>
    <version>1.5.12</version>
</dependency>
```

### CommonHystrixCommand Example:

```java

String result = new CommonHystrixCommand<String>(new HystrixHandler<String>() {

    public String run() throws Exception {
        Thread.sleep(500);
        return "firstService";
    }

    public String fallback() {
        logger.error("First service error, go to second service.");
        return "secondService";
    }
}, HystrixParamFactory.getDefaultParam()).queue().get(2000, TimeUnit.MILLISECONDS);

```


