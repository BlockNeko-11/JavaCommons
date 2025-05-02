package io.github.blockneko11.commons.reflect;

/**
 * @since 0.1.0
 */
public final class ConstructorUtils {
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }
}
