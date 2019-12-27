package com.maketubo.easylog.service;

import com.maketubo.easylog.provider.Provider;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author maketubo
 * @version 1.0
 * @ClassName ProviderA
 * @description
 * @date 2019/12/26 23:31
 * @since JDK 1.8
 */
@Component
public class ProviderA implements Provider<String> {
    @Override
    public List<String> loadLogs(String param) {
        return null;
    }

    @Override
    public void deleteLogs(String param) {

    }

    @Override
    public void saveLogs(List<String> logs) {

    }
}
