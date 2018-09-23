package org.coastline.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.coastline.common.entity.CommonHystrixCommand;
import org.coastline.common.handler.HystrixHandler;
import org.coastline.common.utils.HystrixParamFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Jay.H.Zou
 * @date 2018/9/23
 */
public class CommonHystrixCommandDemo {

    private static final Log logger = LogFactory.getLog(CommonHystrixCommandDemo.class);

    public static void main(String[] args) throws Exception {

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

        System.out.println("result: " + result);
    }
}
