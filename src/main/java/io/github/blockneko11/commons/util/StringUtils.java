package io.github.blockneko11.commons.util;

import java.util.Objects;

/**
 * 字符串工具类。
 * @since 0.1.1
 */
public final class StringUtils {
    /**
     * 判断字符串是否为空。
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * 判断字符串是否为空。
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * 首字母大写。
     * @param str 字符串
     * @return 首字母大写的字符串
     */
    public static String capitalize(String str) {
        if (isEmpty(str)) {
            return str;
        }

        if (str.length() == 1) {
            return str.toUpperCase();
        }

        if (Character.isUpperCase(str.charAt(0))) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * 首字母小写。
     * @param str 字符串
     * @return 首字母小写的字符串
     */
    public static String uncapitalize(String str) {
        if (isEmpty(str)) {
            return str;
        }

        if (str.length() == 1) {
            return str.toLowerCase();
        }

        if (Character.isLowerCase(str.charAt(0))) {
            return str;
        }

        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /**
     * 格式化字符串。
     * @param str 字符串
     * @param args 参数
     * @return 格式化后的字符串
     */
    public static String format(String str, Object... args) {
        if (isEmpty(str)) {
            return str;
        }

        for (int i = 0; i < args.length; i++) {
            String s = Objects.requireNonNull(args[i]).toString();
            str = str.replaceFirst("\\{}", s)
                    .replace("{" + i + "}", s);
        }

        return str;
    }
}
