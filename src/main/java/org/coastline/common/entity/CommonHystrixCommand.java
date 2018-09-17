package org.coastline.common.entity;

import com.netflix.hystrix.*;
import org.coastline.common.handler.HystrixHandler;

/**
 * @author: Jay.H.Zou
 * @date: 2018/9/17
 */
public class CommonHystrixCommand<T> extends HystrixCommand<T> {

    private HystrixHandler<T> handler;

    public CommonHystrixCommand(HystrixHandler<T> handler, HystrixParam param) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(param.getGroupKey()))
                .andCommandKey(HystrixCommandKey.Factory.asKey(param.getCommandKey()))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                    // 超时时间，默认 1000ms
                    .withExecutionTimeoutInMilliseconds(param.getTimeoutMilliseconds())
                    // 启用断路器
                    .withCircuitBreakerEnabled(param.isCircuitBreakerEnable())
                    // 请求量阈值，fallback 数量达到 该值是会开启断路器，默认为20
                    .withCircuitBreakerRequestVolumeThreshold(param.getCircuitBreakerRequestVolumeThreshold())
                    // 断路器打开后，会直接执行fallback，此时间配置多长时间后再次尝试处理请求
                    .withCircuitBreakerSleepWindowInMilliseconds(param.getCircuitBreakerSleepWindowInMilliseconds())
                    // 错误率达到此值且请求量达到阈值，则开启断路器，默认值50%
                    .withCircuitBreakerErrorThresholdPercentage(param.getCircuitBreakerErrorThresholdPercentage())
                    // 该时间用于断路器判断健康度时需要收集信息得持续时间（滚动时间窗）
                    .withMetricsRollingStatisticalWindowInMilliseconds(param.getMetricsRollingStatisticalWindowInMilliseconds())
                    // 该属性用来设置滚动时间窗统计指标信息时划分“桶”的数量
                    .withMetricsRollingPercentileBucketSize(param.getMetricsRollingPercentileBucketSize())
                )
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(param.getThreadPoolKey()))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                    // 设置核心线程池，默认值 10
                    .withCoreSize(param.getCoreSize())
                    // 设置此项为true，最大线程池数才生效，默认false
                    .withAllowMaximumSizeToDivergeFromCoreSize(param.isAllowMaximumSizeToDivergeFromCoreSize())
                    // 最大线程池数，默认10
                    .withMaximumSize(param.getMaximumSize())
                    // 设置线程保持存活的时间，单位时分钟，默认为1
                    .withKeepAliveTimeMinutes(param.getKeepAliveTimeMinutes())
                    // 设置当前线程池的等待队列大小，默认为5
                    .withMaxQueueSize(param.getMaxQueueSize())
                    // queue 拒绝大小，即使 maxQueueSize 没有达到，达到 QueueSizeRejectionThreshold 数量，请求也会被拒绝
                    .withQueueSizeRejectionThreshold(param.getQueueSizeRejectionThreshold())
                )
        );

        if (handler == null) {
            throw new RuntimeException("HystrixHandler can't be null");
        }

        this.handler = handler;
    }

    @Override
    public T run() throws Exception {
        return handler.run();
    }

    @Override
    public T getFallback() {
        return handler.fallback();
    }
}
