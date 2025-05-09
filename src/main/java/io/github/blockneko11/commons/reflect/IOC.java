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
    private final Map<Class<?>, Object> instances;

    /**
     * 获取实例。
     * @param clazz 类
     * @return 实例
     * @param <T> 实例类型
     */
    public <T> T getInstance(Class<T> clazz) {
        if (hasInstance(clazz)) {
            return (T) this.instances.get(clazz);
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
    public <T> void registerInstance(Class<T> clazz, T instance) {
        this.instances.put(clazz, instance);
    }

    /**
     * 判断是否存在实例。
     * @param clazz 类
     * @return 是否存在实例
     */
    public boolean hasInstance(Class<?> clazz) {
        return this.instances.containsKey(clazz);
    }

    /**
     * 创建 IOC 容器。
     * @since 0.1.1
     */
    public IOC() {
        this.instances = Collections.synchronizedMap(new HashMap<>());
    }
}
