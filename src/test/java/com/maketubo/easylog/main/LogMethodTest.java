package com.maketubo.easylog.main;

import com.maketubo.easylog.service.ServiceA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author maketubo
 * @version 1.0
 * @ClassName LogMethodTest
 * @description
 * @date 2019/12/26 18:17
 * @since JDK 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Rollback
public class LogMethodTest {

    @Autowired
    private ServiceA serviceA;

    @Test
    public void logMethod(){
        serviceA.testA();
    }
}
