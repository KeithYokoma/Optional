package jp.yokomark.optional;

import android.support.annotation.NonNull;

/**
 * Backport of Function interface in Java8.
 * @author KeithYokoma
 */
public interface Function<T, R> {
    R apply(T value);
    @NonNull <V> Function<V, R> compose(@NonNull Function<? super V, ? extends T> before);
    @NonNull <V> Function<T, V> andThen(@NonNull Function<? super R, ? extends V> after);
}
