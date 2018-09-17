package org.coastline.common.handler;

/**
 * @author: Jay.H.Zou
 * @date: 2018/9/17
 */
public interface HystrixHandler<T> {

    T run();

    T fallback();

}
