package io.github.blockneko11.commons.util;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 不可变的键值对。
 * @param <L> 键类型
 * @param <R> 值类型
 * @since 0.1.0
 */
@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public final class Pair<L, R> {
    private final L left;
    private final R right;

    /**
     * 判断键是否为空。
     * @return 是否为空
     */
    public boolean isLeftPresent() {
        return this.left != null;
    }

    /**
     * 判断值是否为空。
     * @return 是否为空
     */
    public boolean isRightPresent() {
        return this.right != null;
    }

    /**
     * 将键值对转换为 {@link Map.Entry}。
     * @return {@link Map.Entry}
     */
    public Map.Entry<L, R> toMapEntry() {
        return new AbstractMap.SimpleImmutableEntry<>(this.left, this.right);
    }

    /**
     * 将键值对映射为另一个键值对，此方法只改变键。
     * @param mapper 键的映射函数
     * @return 新的键值对
     * @param <A> 新键的类型
     */
    public <A> Pair<A, R> mapLeft(Function<L, A> mapper) {
        return new Pair<>(mapper.apply(this.left), this.right);
    }

    /**
     * 将键值对映射为另一个键值对，此方法只改变值。
     * @param mapper 值的映射函数
     * @return 新的键值对
     * @param <B> 新值的类型
     */
    public <B> Pair<L, B> mapRight(Function<R, B> mapper) {
        return new Pair<>(this.left, mapper.apply(this.right));
    }

    /**
     * 将键值对映射为另一个键值对，此方法同时改变键值。
     * @param leftMapper 键的映射函数
     * @param rightMapper 值的映射函数
     * @return 新的键值对
     * @param <A> 新键的类型
     * @param <B> 新值的类型
     */
    public <A, B> Pair<A, B> map(Function<L, A> leftMapper, Function<R, B> rightMapper) {
        return new Pair<>(leftMapper.apply(this.left), rightMapper.apply(this.right));
    }
}
