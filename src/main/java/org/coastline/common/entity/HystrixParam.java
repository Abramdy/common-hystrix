package org.coastline.common.entity;

/**
 * @author: Jay.H.Zou
 * @date: 2018/9/17
 */
public class HystrixParam {

    private String groupKey = "defaultGroupKey";

    private String commandKey = "defaultCommandKey";

    private int timeoutMilliseconds = 500;

    private boolean circuitBreakerEnable = true;

    private int circuitBreakerRequestVolumeThreshold = 20;

    private int circuitBreakerSleepWindowInMilliseconds = 10000;

    private int circuitBreakerErrorThresholdPercentage = 50;

    private int metricsRollingStatisticalWindowInMilliseconds = 60000;

    private int metricsRollingPercentileBucketSize = 20;

    private String threadPoolKey = "defaultThreadPoolKey";

    private int coreSize = 30;

    private boolean allowMaximumSizeToDivergeFromCoreSize = true;

    private int maximumSize = 30;

    private int keepAliveTimeMinutes = 1;

    private int maxQueueSize = 10;

    private int queueSizeRejectionThreshold = 10;

    public HystrixParam() {}

    public HystrixParam(String groupKey, String commandKey, String threadPoolKey, int timeoutMilliseconds, int coreSize, int maximumSize, int maxQueueSize, int queueSizeRejectionThreshold) {
        this.groupKey = groupKey;
        this.commandKey = commandKey;
        this.threadPoolKey = threadPoolKey;
        this.timeoutMilliseconds = timeoutMilliseconds;
        this.coreSize = coreSize;
        this.maximumSize = maximumSize;
        this.maxQueueSize = maxQueueSize;
        this.queueSizeRejectionThreshold = queueSizeRejectionThreshold;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getCommandKey() {
        return commandKey;
    }

    public void setCommandKey(String commandKey) {
        this.commandKey = commandKey;
    }

    public int getTimeoutMilliseconds() {
        return timeoutMilliseconds;
    }

    public void setTimeoutMilliseconds(int timeoutMilliseconds) {
        this.timeoutMilliseconds = timeoutMilliseconds;
    }

    public boolean isCircuitBreakerEnable() {
        return circuitBreakerEnable;
    }

    public void setCircuitBreakerEnable(boolean circuitBreakerEnable) {
        this.circuitBreakerEnable = circuitBreakerEnable;
    }

    public int getCircuitBreakerRequestVolumeThreshold() {
        return circuitBreakerRequestVolumeThreshold;
    }

    public void setCircuitBreakerRequestVolumeThreshold(int circuitBreakerRequestVolumeThreshold) {
        this.circuitBreakerRequestVolumeThreshold = circuitBreakerRequestVolumeThreshold;
    }

    public int getCircuitBreakerSleepWindowInMilliseconds() {
        return circuitBreakerSleepWindowInMilliseconds;
    }

    public void setCircuitBreakerSleepWindowInMilliseconds(int circuitBreakerSleepWindowInMilliseconds) {
        this.circuitBreakerSleepWindowInMilliseconds = circuitBreakerSleepWindowInMilliseconds;
    }

    public int getCircuitBreakerErrorThresholdPercentage() {
        return circuitBreakerErrorThresholdPercentage;
    }

    public void setCircuitBreakerErrorThresholdPercentage(int circuitBreakerErrorThresholdPercentage) {
        this.circuitBreakerErrorThresholdPercentage = circuitBreakerErrorThresholdPercentage;
    }

    public int getMetricsRollingStatisticalWindowInMilliseconds() {
        return metricsRollingStatisticalWindowInMilliseconds;
    }

    public void setMetricsRollingStatisticalWindowInMilliseconds(int metricsRollingStatisticalWindowInMilliseconds) {
        this.metricsRollingStatisticalWindowInMilliseconds = metricsRollingStatisticalWindowInMilliseconds;
    }

    public int getMetricsRollingPercentileBucketSize() {
        return metricsRollingPercentileBucketSize;
    }

    public void setMetricsRollingPercentileBucketSize(int metricsRollingPercentileBucketSize) {
        this.metricsRollingPercentileBucketSize = metricsRollingPercentileBucketSize;
    }

    public String getThreadPoolKey() {
        return threadPoolKey;
    }

    public void setThreadPoolKey(String threadPoolKey) {
        this.threadPoolKey = threadPoolKey;
    }

    public int getCoreSize() {
        return coreSize;
    }

    public void setCoreSize(int coreSize) {
        this.coreSize = coreSize;
    }

    public boolean isAllowMaximumSizeToDivergeFromCoreSize() {
        return allowMaximumSizeToDivergeFromCoreSize;
    }

    public void setAllowMaximumSizeToDivergeFromCoreSize(boolean allowMaximumSizeToDivergeFromCoreSize) {
        this.allowMaximumSizeToDivergeFromCoreSize = allowMaximumSizeToDivergeFromCoreSize;
    }

    public int getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(int maximumSize) {
        this.maximumSize = maximumSize;
    }

    public int getKeepAliveTimeMinutes() {
        return keepAliveTimeMinutes;
    }

    public void setKeepAliveTimeMinutes(int keepAliveTimeMinutes) {
        this.keepAliveTimeMinutes = keepAliveTimeMinutes;
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public void setMaxQueueSize(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
    }

    public int getQueueSizeRejectionThreshold() {
        return queueSizeRejectionThreshold;
    }

    public void setQueueSizeRejectionThreshold(int queueSizeRejectionThreshold) {
        this.queueSizeRejectionThreshold = queueSizeRejectionThreshold;
    }
}
