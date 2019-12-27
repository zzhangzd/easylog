package com.maketubo.easylog.service;

import com.maketubo.easylog.provider.Provider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author maketubo
 * @version 1.0
 * @ClassName ProviderMap
 * @description
 * @date 2019/12/27 14:48
 * @since JDK 1.8
 */
@Component
public class ProviderMap implements Provider<Map> {
    @Override
    public List<Map> loadLogs(Map param) {
        return null;
    }

    @Override
    public void deleteLogs(Map param) {

    }

    @Override
    public void saveLogs(List<Map> logs) {

    }
}
