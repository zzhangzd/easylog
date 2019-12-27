package com.maketubo.easylog.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @mender maketubo
 */
public class LogHelper {

    /**
     *
     */
    private static ThreadLocal<Map<String, Object>> mainLogInfo = ThreadLocal.withInitial(() -> new HashMap<>());
    private static ThreadLocal<ArrayList<Object>> curlogInfo = ThreadLocal.withInitial(() -> {
        ArrayList<Object> logs = new ArrayList<>();
        logs.add(mainLogInfo.get());
        return logs;
    });

    /**
     * 拿出日志
     *
     * @return
     */
    public static List<Object> getAllLogs() {
        return curlogInfo.get();
    }

    /**
     *
     */
    public static void addLog(Object log) {
        ArrayList<Object> list = curlogInfo.get();
        list.add(log);
    }

    /**
     *
     */
    public static void appendMainLog(String key, Object value) {
        mainLogInfo.get().put(key, value);
    }

    /**
     *
     */
    public static void addLog(List<Object> logs) {
        ArrayList<Object> list = curlogInfo.get();
        list.addAll(logs);
    }

    public static void cleanLogInfo() {
        mainLogInfo.remove();
        curlogInfo.remove();
    }
}
