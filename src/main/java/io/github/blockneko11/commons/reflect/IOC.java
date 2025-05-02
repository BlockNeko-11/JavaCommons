package io.github.blockneko11.commons.reflect;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单的 IOC 容器。
 * @since 0.1.0
 */
public final class IOC {
    /**
     * 实例缓存。
     */
    private static final Map<Class<?>, Object> INSTANCES;

    /**
     * 获取实例。
     * @param clazz 类
     * @return 实例
     * @param <T> 实例类型
     */
    public static <T> T getInstance(Class<T> clazz) {
        if (hasInstance(clazz)) {
            return (T) INSTANCES.get(clazz);
        }

        T instance = ConstructorUtils.newInstance(clazz);
        if (instance == null) {
            return null;
        }

        registerInstance(clazz, instance);
        return instance;
    }

    /**
     * 注册实例。
     * @param clazz 类
     * @param instance 实例
     * @param <T> 实例类型
     */
    public static <T> void registerInstance(Class<T> clazz, T instance) {
        INSTANCES.put(clazz, instance);
    }

    /**
     * 判断是否存在实例。
     * @param clazz 类
     * @return 是否存在实例
     */
    public static boolean hasInstance(Class<?> clazz) {
        return INSTANCES.containsKey(clazz);
    }

    private IOC() {
        throw new UnsupportedOperationException();
    }

    static {
        INSTANCES = Collections.synchronizedMap(new HashMap<>());
    }
}
