package com.maketubo.easylog.service;


import com.maketubo.easylog.annotation.LogMethod;
import com.maketubo.easylog.utils.LogHelper;
import org.springframework.stereotype.Component;

/**
 * @author maketubo
 * @version 1.0
 * @ClassName ServiceAImpl
 * @description
 * @date 2019/12/26 18:03
 * @since JDK 1.8
 */
@Component
public class ServiceAImpl implements ServiceA {

    @Override
    @LogMethod
    public int testA() {
        LogHelper.appendMainLog("logMessage","HelloWorld");
        return 0;
    }

}
