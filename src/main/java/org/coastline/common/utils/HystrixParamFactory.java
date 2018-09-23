package org.coastline.common.utils;

import org.coastline.common.entity.HystrixParam;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jay.H.Zou
 * @date 2018/9/17
 */
public class HystrixParamFactory {

    private HystrixParam oneParam;

    private static final Lock lock = new ReentrantLock();

    private HystrixParamFactory() {}

    public HystrixParam getOneParam() {
        if (oneParam == null) {
            lock.lock();
            try {
                if (oneParam == null) {
                    oneParam = new HystrixParam("oneGroup", "oneCommand", "oneThreadPool", 500, 50, 50, 10, 10);
                }
            } finally {
                lock.unlock();
            }
        }
        return oneParam;
    }
}
