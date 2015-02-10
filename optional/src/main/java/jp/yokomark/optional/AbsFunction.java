package jp.yokomark.optional;

import android.support.annotation.NonNull;

/**
 * Backport for full implementation of Function interface in Java8.
 * @author KeithYokoma
 */
public abstract class AbsFunction<T, R> implements Function<T, R> {
    public static @NonNull <T> Function<T, T> identity() {
        return new AbsFunction<T, T>() {
            @Override
            public T apply(T value) {
                return value;
            }
        };
    }

    @Override
    public @NonNull <V> Function<V, R> compose(@NonNull final Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return new AbsFunction<V, R>() {
            @Override
            public R apply(V value) {
                return AbsFunction.this.apply(before.apply(value));
            }
        };
    }

    @Override
    public @NonNull <V> Function<T, V> andThen(@NonNull final Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return new AbsFunction<T, V>() {
            @Override
            public V apply(T value) {
                return after.apply(AbsFunction.this.apply(value));
            }
        };
    }
}
