package com.snake19870227.stiger.context;

import cn.hutool.core.util.ArrayUtil;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.env.Environment;

/**
 * @author Bu HuaYang
 */
public class StarTigerContext {

    private static final Logger logger = LoggerFactory.getLogger(StarTigerContext.class);

    private static String[] activeProfiles;
    private static String applicationName;

    private static ApplicationContext springContext;

    protected static ApplicationContext getSpringContext() {
        return springContext;
    }

    public static Environment getEnvironment() {
        return getSpringContext().getEnvironment();
    }

    public static String getApplicationName() {
        return applicationName;
    }

    public static String getApplicationId() {
        return applicationName + "-" + springContext.getId();
    }

    public static String[] getActiveProfiles() {
        return activeProfiles;
    }

    public static boolean isProfileActived(String... profileNames) {
        if (ArrayUtil.isEmpty(activeProfiles)) {
            return false;
        }
        return ArrayUtil.containsAny(activeProfiles, profileNames);
    }

    public static String getMessage(String code) {
        return springContext.getMessage(code, null, Locale.CHINA);
    }

    public static String getMessage(String code, Object... args) {
        return springContext.getMessage(code, args, Locale.CHINA);
    }

    public static <T> T getBean(Class<? extends T> beanClass) throws BeansException {
        return springContext.getBean(beanClass);
    }

    public static <T> T getBean(String beanName, Class<? extends T> beanClass) throws BeansException {
        return springContext.getBean(beanName, beanClass);
    }

    public static void setApplicationName(String applicationName) {
        StarTigerContext.applicationName = applicationName;
    }

    public static void setSpringContext(ApplicationContext springContext) {
        StarTigerContext.springContext = springContext;
        StarTigerContext.activeProfiles = springContext.getEnvironment().getActiveProfiles();
    }

    public static void publishEvent(ApplicationEvent event) {
        if (springContext == null) {
            return;
        }
        springContext.publishEvent(event);
    }

    public static void clearContext() {
        logger.debug("清除StarTigerContext中的springContext:{}", springContext);
        springContext = null;
    }
}
