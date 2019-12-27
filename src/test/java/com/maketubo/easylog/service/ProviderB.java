package com.maketubo.easylog.service;

import com.maketubo.easylog.provider.Provider;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author maketubo
 * @version 1.0
 * @ClassName ProviderB
 * @description
 * @date 2019/12/26 23:32
 * @since JDK 1.8
 */
@Component
public class ProviderB implements Provider<Integer> {
    @Override
    public List<Integer> loadLogs(Integer param) {
        return null;
    }

    @Override
    public void deleteLogs(Integer param) {

    }

    @Override
    public void saveLogs(List<Integer> logs) {

    }
}
