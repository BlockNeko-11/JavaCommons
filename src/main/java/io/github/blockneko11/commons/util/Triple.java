package io.github.blockneko11.commons.util;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.function.Function;

/**
 * @since 0.1.0
 */
@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public final class Triple<L, M, R> {
    private final L left;
    private final M middle;
    private final R right;

    public boolean isLeftPresent() {
        return left != null;
    }

    public boolean isMiddlePresent() {
        return middle != null;
    }

    public boolean isRightPresent() {
        return right != null;
    }

    public <A> Triple<A, M, R> mapLeft(Function<L, A> mapper) {
        return new Triple<>(mapper.apply(left), middle, right);
    }

    public <B> Triple<L, B, R> mapMiddle(Function<M, B> mapper) {
        return new Triple<>(left, mapper.apply(middle), right);
    }

    public <C> Triple<L, M, C> mapRight(Function<R, C> mapper) {
        return new Triple<>(left, middle, mapper.apply(right));
    }

    public <A, B, C> Triple<A, B, C> map(Function<L, A> leftMapper, Function<M, B> middleMapper, Function<R, C> rightMapper) {
        return new Triple<>(leftMapper.apply(left), middleMapper.apply(middle), rightMapper.apply(right));
    }
}
