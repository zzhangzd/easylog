package com.maketubo.easylog.components;

import com.maketubo.easylog.annotation.LogMethod;
import com.maketubo.easylog.provider.Provider;
import com.maketubo.easylog.utils.LogHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Aspect
@Component
public class LogAspect implements ApplicationContextAware {

    private Map<String, Provider> providerCache = new HashMap<>();

    @Around("@annotation(logMethod)")
    public Object aroundMethod(ProceedingJoinPoint pjd, LogMethod logMethod) throws Throwable {
        Long startTime = System.currentTimeMillis();
        LogHelper.appendMainLog("startTime", startTime);
        LogHelper.appendMainLog("args", pjd.getArgs());
        Object result = null;
        try {
            result = pjd.proceed();
        } catch (Exception e) {
            LogHelper.appendMainLog("errorMessage", e.getMessage());
            throw e;
        } finally {
            LogHelper.appendMainLog("result", result);
            LogHelper.appendMainLog("responseTime", System.currentTimeMillis() - startTime);
            List<Object> logs = LogHelper.getAllLogs();
            Provider provider = providerCache.get(logMethod.clazz().getTypeName());
            if (provider != null) {
                provider.saveLogs(logs);
            }
            LogHelper.cleanLogInfo();
        }
        return result;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Provider> beansOfType = applicationContext.getBeansOfType(Provider.class);
        providerCache = beansOfType.entrySet().stream().map(entry -> entry.getValue()).collect(
                Collectors.toMap(provider -> {
                    Type[] genericInterfaces = provider.getClass().getGenericInterfaces();
                    for (Type genericInterface : genericInterfaces) {
                        if (genericInterface instanceof ParameterizedType) {
                            Type[] genericTypes = ((ParameterizedType) genericInterface).getActualTypeArguments();
                            return genericTypes[0].getTypeName();
                        }
                    }
                    throw new RuntimeException("can not find provider type!");
                }, Function.identity()));
    }

}
