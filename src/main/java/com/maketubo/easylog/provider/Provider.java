package com.maketubo.easylog.provider;

import java.util.List;

public interface Provider<T> {

    List<T> loadLogs(T param);

    void deleteLogs(T param);

    void saveLogs(List<T> logs);

}
