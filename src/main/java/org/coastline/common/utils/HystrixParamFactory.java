package org.coastline.common.utils;

import org.coastline.common.entity.HystrixParam;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jay.H.Zou
 * @date 2018/9/17
 */
public class HystrixParamFactory {

    private static HystrixParam defaultParam;

    private static final Lock lock = new ReentrantLock();

    private HystrixParamFactory() {}

    public static HystrixParam getDefaultParam() {
        if (defaultParam == null) {
            lock.lock();
            try {
                if (defaultParam == null) {
                    defaultParam = new HystrixParam("defaultGroup", "defaultCommand", "defaultThreadPool", 500, 50, 50, 10, 10);
                }
            } finally {
                lock.unlock();
            }
        }
        return defaultParam;
    }
}
